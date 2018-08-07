/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.constant.ProcessStateEnum;
import com.zhiyun.constant.TaskMesStateEnmu;
import com.zhiyun.constant.VoucherEnum;
import com.zhiyun.dao.*;
import com.zhiyun.dto.ProduceOrderApsDto;
import com.zhiyun.dto.ProduceOrderApsQueryDto;
import com.zhiyun.dto.ProduceOrderDetailApsDto;
import com.zhiyun.entity.*;
import com.zhiyun.internal.uniqueid.UniqueIdService;
import com.zhiyun.service.ProduceOrderApsService;
import com.zhiyun.workflow.ProcessService;
import com.zhiyun.workflow.constant.ResponseStatusConsts;
import com.zhiyun.workflow.constant.WorkFlowStateConsts;
import com.zhiyun.workflow.dto.ProcessDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("produceOrderApsService")
public class ProduceOrderApsServiceImpl extends BaseServiceImpl<ProduceOrderAps, Long> implements ProduceOrderApsService {

    private final static String UNIQUE_ID_HEAD = "produce-gs";

    @Value("${workflow.processKey}")
    private String processKey;

    @Resource
    private ProduceOrderApsDao produceOrderApsDao;

    @Resource
    private ProduceOrderDetailApsDao produceOrderDetailApsDao;

    @Resource
    private VoucherMainOaDao voucherMainOaDao;

    @Autowired
    private UniqueIdService uniqueIdService;

    @Autowired
    private ProcessService processService;

    @Autowired
    private ProdCrafworkPlmDao prodCrafworkPlmDao;

    @Autowired
    private TaskPondMesDao taskPondMesDao;

    @Override
    protected BaseDao<ProduceOrderAps, Long> getBaseDao() {
        return this.produceOrderApsDao;
    }

    @Transactional
    @Override
    public void save(ProduceOrderApsDto produceOrderApsDto) {

        String insideOrder = produceOrderApsDto.getInsideOrder();

        List<ProduceOrderAps> poas = listByInsideOrder(insideOrder);
        if (!CollectionUtils.isEmpty(poas)) {
            throw new BusinessException("内部编号已存在!");
        }

        //创建流程
//        ProcessDto processDto = processService.startProcess(processKey, String.valueOf(UserHolder.getId()));
//        if (!ResponseStatusConsts.OK.equals(processDto.getStatus())) {
//            throw new BusinessException("审核流程创建失败！");
//        }
        ProcessDto processDto = processService.startProcess(processKey, String.valueOf(UserHolder.getId()));

        //生成单据号
        String voucherNo = uniqueIdService. mixedId(UNIQUE_ID_HEAD, 30, UserHolder.getCompanyId());

        //保存订单
        produceOrderApsDto.setVoucherNo(voucherNo);
        ProduceOrderAps produceOrderAps = convertToProduceOrderAps(produceOrderApsDto, voucherNo);

        //防止主键冲突
        produceOrderAps.setId(null);
        produceOrderApsDao.insert(produceOrderAps);
        if (!CollectionUtils.isEmpty(produceOrderApsDto.getProduceOrderDetailApsDtos())) {
            List<ProduceOrderDetailAps> podas = convertToProduceOrderDetailApses(produceOrderApsDto, voucherNo);
            //防止主键冲突
            for(ProduceOrderDetailAps poda:podas){
                poda.setId(null);
            }
            produceOrderDetailApsDao.insert(podas);
        }

        //插入审核信息
        VoucherMainOa voucherMainOa = new VoucherMainOa();
        voucherMainOa.setVoucherNo(voucherNo);
        voucherMainOa.setIsFinished(VoucherEnum.APPROVAL_STATUS_PROCESS.getId());
        voucherMainOa.setCompanyId(UserHolder.getCompanyId());
        if(processDto != null && ResponseStatusConsts.OK.equals(processDto.getStatus())){
            voucherMainOa.setApproverUserId(Long.valueOf(processDto.getData().getTasks().get(0).getAssignee()));
            voucherMainOa.setWkflowId(Long.valueOf(processDto.getData().getTasks().get(0).getTaskId()));
            voucherMainOa.setRaiserUserId(UserHolder.getId());
        }
        voucherMainOaDao.insert(voucherMainOa);

    }


    /**
     * 根据voucherNo判断 insideOrder全部需要
     *
     * @param produceOrderApsDto
     * @return
     */
    @Transactional
    @Override
    public void update(ProduceOrderApsDto produceOrderApsDto) {

        VoucherMainOa voucherMainOa = voucherMainOaDao.getByVoucherNo(produceOrderApsDto.getVoucherNo(), UserHolder.getCompanyId());
        if (!VoucherEnum.APPROVAL_STATUS_FAILURE.getId().equals(voucherMainOa.getIsFinished())) {
            throw new BusinessException("无法修改正在审核和审核完成的数据！");
        }

        List<ProduceOrderAps> poas = listByInsideOrder(produceOrderApsDto.getInsideOrder());
        if (!CollectionUtils.isEmpty(poas)) {
            for (ProduceOrderAps produceOrderAps : poas) {
                if ((!produceOrderApsDto.getId().equals(produceOrderAps.getId()))&& produceOrderApsDto.getVoucherNo().equals(produceOrderAps.getVoucherNo())) {
                    throw new BusinessException("内部编号已存在!");
                }
            }
        }

        //审核失败后修改信息走审核流程
//        ProcessDto processDto = processService.processTask(String.valueOf(voucherMainOa.getWkflowId()), true);
//        if (!ResponseStatusConsts.OK.equals(processDto.getStatus())) {
//            throw new BusinessException("审核流程创建失败！");
//        }
        ProcessDto processDto = processService.processTask(String.valueOf(voucherMainOa.getWkflowId()), true);


        //修改订单
        ProduceOrderAps produceOrderAps = convertToProduceOrderAps(produceOrderApsDto, produceOrderApsDto.getVoucherNo());
        produceOrderApsDao.update(produceOrderAps);
        if (!CollectionUtils.isEmpty(produceOrderApsDto.getProduceOrderDetailApsDtos())) {
            List<ProduceOrderDetailAps> podas = convertToProduceOrderDetailApses(produceOrderApsDto, produceOrderApsDto.getVoucherNo());
            for(ProduceOrderDetailAps poda:podas){
                produceOrderDetailApsDao.update(podas);
            }
        }

        //修改审核状态
        voucherMainOa = new VoucherMainOa();
        if(processDto!=null && ResponseStatusConsts.OK.equals(processDto.getStatus())){
            voucherMainOa.setApproverUserId(Long.valueOf(processDto.getData().getTasks().get(0).getAssignee()));
            voucherMainOa.setWkflowId(Long.valueOf(processDto.getData().getTasks().get(0).getTaskId()));
            voucherMainOa.setVoucherNo(produceOrderApsDto.getVoucherNo());
        }
        voucherMainOa.setIsFinished(VoucherEnum.APPROVAL_STATUS_PROCESS.getId());
        voucherMainOa.setCompanyId(UserHolder.getCompanyId());
        voucherMainOaDao.updateByVoucherNo(voucherMainOa);
    }


    @Transactional
    @Override
    public void delete(List<String> voucherNos) {

        List<VoucherMainOa> voucherMainOas = voucherMainOaDao.listByVoucherNos(voucherNos, UserHolder.getCompanyId());
        if (!CollectionUtils.isEmpty(voucherMainOas)) {
            for (VoucherMainOa voucherMainOa : voucherMainOas) {
                if (!VoucherEnum.APPROVAL_STATUS_FAILURE.getId().equals(voucherMainOa.getIsFinished())) {
                    throw new BusinessException("无法删除正在审核和审核完成的数据！");
                }
            }
        }

        produceOrderDetailApsDao.deleteProduceOrderDetailAps(voucherNos, UserHolder.getUserName(), new Date());
        produceOrderApsDao.deleteProduceOrderAps(voucherNos, UserHolder.getUserName(), new Date());
        voucherMainOaDao.deleteVoucherMainOa(voucherNos, UserHolder.getUserName(), new Date());

     }


    @Override
    public ProduceOrderApsDto getDetailByVoucherNo(String voucherNo) {
        return produceOrderApsDao.getDetailByVoucherNo(voucherNo,UserHolder.getCompanyId());
    }

    @Override
    public DataGrid<ProduceOrderApsDto> myPage(ProduceOrderApsQueryDto produceOrderApsQueryDto, Pager pager){
        return this.produceOrderApsDao.myPage(Params.create().add("entity",produceOrderApsQueryDto),pager);
    }

    @Override
    public List<ProduceOrderAps> listByInsideOrder(String insideOrder) {

        ProduceOrderAps produceOrderAps = new ProduceOrderAps();
        produceOrderAps.setInsideOrder(insideOrder);
        produceOrderAps.setCompanyId(UserHolder.getCompanyId());

        List<ProduceOrderAps> poas = produceOrderApsDao.find(produceOrderAps);

        return poas;
    }

    @Transactional
    @Override
    public void audit(String voucherNo,boolean isPass){

        VoucherMainOa voucherMainOa = voucherMainOaDao.getByVoucherNo(voucherNo,UserHolder.getCompanyId());
        if(VoucherEnum.APPROVAL_STATUS_SUCCESS.getId().equals(voucherMainOa.getIsFinished())||
                VoucherEnum.APPROVAL_STATUS_FAILURE.getId().equals(voucherMainOa.getIsFinished())){
            throw new BusinessException("请勿重复审核！");
        }

        //审核走流程
//        ProcessDto processDto = processService.processTask(String.valueOf(voucherMainOa.getWkflowId()), isPass);
//        if (!ResponseStatusConsts.OK.equals(processDto.getStatus())) {
//            throw new BusinessException("审核流程创建失败！");
//        }
        ProcessDto processDto = processService.processTask(String.valueOf(voucherMainOa.getWkflowId()), isPass);

        //修改审核状态
        voucherMainOa = new VoucherMainOa();
        voucherMainOa.setVoucherNo(voucherNo);
        voucherMainOa.setCompanyId(UserHolder.getCompanyId());

        if(processDto!=null && WorkFlowStateConsts.FINISHED.equals(processDto.getData().getFlowState())){
            voucherMainOa.setApproverUserId(voucherMainOa.getRaiserUserId());
            voucherMainOa.setIsFinished(VoucherEnum.APPROVAL_STATUS_SUCCESS.getId());
            //查询出产品明细
            ProduceOrderDetailAps produceOrderDetailAps = new ProduceOrderDetailAps();
            produceOrderDetailAps.setVoucherNo(voucherNo);
            List<ProduceOrderDetailAps> produceOrderDetailApses = produceOrderDetailApsDao.find(produceOrderDetailAps);
            //查询工艺路线
            List<ProdCrafworkPlm> prodCrafworkPlms = listByProduceOrderDetailAps(produceOrderDetailApses);
            //增加任务池
            addTaskPondMes(produceOrderDetailApses,prodCrafworkPlms);
        }else {
            if(processDto != null && ResponseStatusConsts.OK.equals(processDto.getStatus())){
                voucherMainOa.setIsFinished(VoucherEnum.APPROVAL_STATUS_FAILURE.getId());
                voucherMainOa.setWkflowId(Long.valueOf(processDto.getData().getTasks().get(0).getTaskId()));
                voucherMainOa.setApproverUserId(Long.valueOf(processDto.getData().getTasks().get(0).getAssignee()));
            }

        }

        voucherMainOaDao.updateByVoucherNo(voucherMainOa);

    }

    private List<ProdCrafworkPlm> listByProduceOrderDetailAps(List<ProduceOrderDetailAps> produceOrderDetailApses){

        if(CollectionUtils.isEmpty(produceOrderDetailApses)){
            return null;
        }

        List<String> prodNos = new ArrayList<>();
        for(ProduceOrderDetailAps p:produceOrderDetailApses){
            prodNos.add(p.getProdNo());
        }
        List<ProdCrafworkPlm> prodCrafworkPlms = prodCrafworkPlmDao.listByProdNos(prodNos,UserHolder.getCompanyId());

        return prodCrafworkPlms;
    }

    private void addTaskPondMes(List<ProduceOrderDetailAps> produceOrderDetailApses ,List<ProdCrafworkPlm> prodCrafworkPlms){
        List<TaskPondMes> taskPondMeses = new ArrayList<>();

        for(ProduceOrderDetailAps poda:produceOrderDetailApses){
            for(ProdCrafworkPlm prodCrafworkPlm:prodCrafworkPlms){
                if(poda.getProdNo().equals(prodCrafworkPlm.getProdNo())){
                    TaskPondMes taskPondMes = new TaskPondMes();
                    if(prodCrafworkPlm.getAmount()!=null){
                        taskPondMes.setAmount(poda.getAmount().multiply(prodCrafworkPlm.getAmount()));
                    }
                    taskPondMes.setProdNo(prodCrafworkPlm.getProdNo());
                    taskPondMes.setStatus(TaskMesStateEnmu.DISPATCHING.getId());
                    taskPondMes.setCrafworkId(prodCrafworkPlm.getCrafworkId());
                    taskPondMes.setInsideOrder(poda.getInsideOrder());
                    taskPondMeses.add(taskPondMes);
                }
            }
        }

        taskPondMesDao.insert(taskPondMeses);
    }


    public List<ProduceOrderAps> list(ProduceOrderAps produceOrderAps){
        return this.produceOrderApsDao.list(produceOrderAps);
    }

    public List<ProduceOrderAps> listOnPrivilege(){
        return this.produceOrderApsDao.listByUserId(UserHolder.getId(),UserHolder.getCompanyId());
    }

    private List<ProduceOrderDetailAps> convertToProduceOrderDetailApses(ProduceOrderApsDto produceOrderApsDto, String voucherNo) {
        List<ProduceOrderDetailApsDto> podaDtos = produceOrderApsDto.getProduceOrderDetailApsDtos();
        List<ProduceOrderDetailAps> podas = new ArrayList<>();
        for (ProduceOrderDetailApsDto podaDto : podaDtos) {
            ProduceOrderDetailAps poda = new ProduceOrderDetailAps();
            poda.setId(podaDto.getId());
            poda.setAmount(podaDto.getAmount());
            poda.setFirstDate(produceOrderApsDto.getFirstDate());
            poda.setVoucherDate(produceOrderApsDto.getVoucherDate());
            poda.setVoucherNo(voucherNo);
            poda.setCompanyId(UserHolder.getCompanyId());
            poda.setInsideOrder(produceOrderApsDto.getInsideOrder());
            poda.setProdNo(podaDto.getProdNo());
            poda.setOkAmount(new BigDecimal(0));
            poda.setStatus(ProcessStateEnum.DISPATCHING.getId());
            podas.add(poda);
        }
        return podas;
    }

    private ProduceOrderAps convertToProduceOrderAps(ProduceOrderApsDto produceOrderApsDto, String voucherNo) {
        ProduceOrderAps produceOrderAps = new ProduceOrderAps();
        produceOrderAps.setId(produceOrderApsDto.getId());
        produceOrderAps.setCompanyId(UserHolder.getCompanyId());
        produceOrderAps.setInsideOrder(produceOrderApsDto.getInsideOrder());
        produceOrderAps.setCustomNo(produceOrderApsDto.getCustomNo());
        produceOrderAps.setOrderNo(produceOrderApsDto.getOrderNo());
        produceOrderAps.setOrderSource(String.valueOf(produceOrderApsDto.getOrderSourceId()));
        produceOrderAps.setVoucherNo(voucherNo);
        produceOrderAps.setOrgId(produceOrderApsDto.getOrgId());
        produceOrderAps.setVoucherDate(produceOrderApsDto.getVoucherDate());
        produceOrderAps.setCustomNo(produceOrderAps.getCustomNo());
        return produceOrderAps;
    }

	@Override
	public List<ProduceOrderAps> getOrder(ProduceOrderAps produceOrderAps) {
		return produceOrderApsDao.getOrder(produceOrderAps);
	}
}
