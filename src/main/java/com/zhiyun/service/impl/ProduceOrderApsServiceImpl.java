/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.constant.ProcessStateEnum;
import com.zhiyun.constant.VoucherConsts;
import com.zhiyun.dao.ProduceOrderApsDao;
import com.zhiyun.dao.ProduceOrderDetailApsDao;
import com.zhiyun.dao.VoucherMainOaDao;
import com.zhiyun.dto.ProduceOrderApsDto;
import com.zhiyun.dto.ProduceOrderDetailApsDto;
import com.zhiyun.entity.ProduceOrderAps;
import com.zhiyun.entity.ProduceOrderDetailAps;
import com.zhiyun.entity.VoucherMainOa;
import com.zhiyun.internal.uniqueid.UniqueIdService;
import com.zhiyun.service.ProduceOrderApsService;
import com.zhiyun.workflow.ProcessService;
import com.zhiyun.workflow.constant.ResponseStatusConsts;
import com.zhiyun.workflow.dto.ProcessDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
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

	private final static String UNIQUE_ID_HEAD = "produce";

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

	@Override
	protected BaseDao<ProduceOrderAps, Long> getBaseDao() {
		return this.produceOrderApsDao;
	}

	@Override
	public void save(ProduceOrderApsDto produceOrderApsDto) {

		String insideOrder = produceOrderApsDto.getInsideOrder();

		List<ProduceOrderAps> poas = listByInsideOrder(insideOrder);
		if(!CollectionUtils.isEmpty(poas)){
			throw new BusinessException("内部编号已存在!");
		}

		//创建流程
		ProcessDto processDto = processService.startProcess(processKey,String.valueOf(UserHolder.getId()));
		if(!ResponseStatusConsts.OK.equals(processDto.getStatus())){
			throw new BusinessException("审核流程创建失败！");
		}

		//生成单据号
		String voucherNo = uniqueIdService.mixedId(UNIQUE_ID_HEAD,30,UserHolder.getCompanyId());

		//保存订单
		ProduceOrderAps produceOrderAps = convertToProduceOrderAps(produceOrderApsDto,voucherNo);
		produceOrderApsDao.insert(produceOrderAps);
		if(!CollectionUtils.isEmpty(produceOrderApsDto.getProduceOrderDetailApsDtos())){
			List<ProduceOrderDetailAps>  podas = convertToProduceOrderDetailApses(produceOrderApsDto,voucherNo);
			produceOrderDetailApsDao.insert(podas);
		}

		//插入审核信息
		VoucherMainOa voucherMainOa = new VoucherMainOa();
		voucherMainOa.setVoucherNo(produceOrderApsDto.getVoucherNo());
		voucherMainOa.setIsFinished(VoucherConsts.APPROVAL_STATUS_PROCESS);
		voucherMainOa.setCompanyId(UserHolder.getCompanyId());
		voucherMainOa.setApproverUserId(Long.valueOf(processDto.getData().getTasks().get(0).getAssignee()));
		voucherMainOa.setRaiserUserId(UserHolder.getId());
		voucherMainOaDao.insert(voucherMainOa);

	}

	@Override
	public void update(ProduceOrderApsDto produceOrderApsDto) {


	}

	@Override
	public void delete(List<Long> voucherNos) {



	}

	@Override
	public List<ProduceOrderApsDto> list(ProduceOrderApsDto produceOrderApsDto) {



		return null;
	}

	@Override
	public List<ProduceOrderAps> listByInsideOrder(String insideOrder) {

		ProduceOrderAps produceOrderAps = new ProduceOrderAps();
		produceOrderAps.setInsideOrder(insideOrder);
		produceOrderAps.setCompanyId(UserHolder.getCompanyId());

		List<ProduceOrderAps> poas = produceOrderApsDao.find(produceOrderAps);

		return poas;
	}

	private List<ProduceOrderDetailAps> convertToProduceOrderDetailApses(ProduceOrderApsDto produceOrderApsDto,String voucherNo){
		List<ProduceOrderDetailApsDto> podaDtos= produceOrderApsDto.getProduceOrderDetailApsDtos();
		List<ProduceOrderDetailAps> podas = new ArrayList<>();
		for(ProduceOrderDetailApsDto podaDto:podaDtos){
			ProduceOrderDetailAps poda = new ProduceOrderDetailAps();
			poda.setAmount(podaDto.getAmount());
			poda.setFirstDate(produceOrderApsDto.getFirstDate());
			poda.setVoucherDate(produceOrderApsDto.getVoucherDate());
			poda.setVoucherNo(produceOrderApsDto.getVoucherNo());
			poda.setCompanyId(UserHolder.getCompanyId());
			poda.setInsideOrder(produceOrderApsDto.getInsideOrder());
			poda.setProdNo(podaDto.getProdNo());
			poda.setOkAmount(new BigDecimal(0));
			poda.setStatus(ProcessStateEnum.DISPATCHING.getId());
			podas.add(poda);
		}
		return podas;
	}

	private ProduceOrderAps convertToProduceOrderAps(ProduceOrderApsDto produceOrderApsDto,String voucherNo){
		ProduceOrderAps produceOrderAps = new ProduceOrderAps();
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
}
