/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.constant.TaskMesStateEnmu;
import com.zhiyun.dao.CasOrgDao;
import com.zhiyun.dao.TaskReceiveEmpMesDao;
import com.zhiyun.dto.TaskPondMesDto;
import com.zhiyun.entity.*;
import com.zhiyun.service.EmpFolderHcmService;
import com.zhiyun.service.TaskFinishedMesService;
import com.zhiyun.service.TaskReceiveEmpMesService;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.TaskPondMesDao;
import com.zhiyun.service.TaskPondMesService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
@Service("taskPondMesService")
public class TaskPondMesServiceImpl extends BaseServiceImpl<TaskPondMes, Long> implements TaskPondMesService {

	@Resource
	private TaskPondMesDao taskPondMesDao;

	@Resource
	private CasOrgDao casOrgDao;

	@Resource
	private TaskReceiveEmpMesDao taskReceiveEmpMesDao;

	@Resource
	private EmpFolderHcmService empFolderHcmService;

	@Resource
	private TaskPondMesService taskPondMesService;

	@Resource
    private TaskFinishedMesService taskFinishedMesService;

	@Override
	protected BaseDao<TaskPondMes, Long> getBaseDao() {
		return this.taskPondMesDao;
	}


    @Override
    public DataGrid<TaskPondMesDto> myPageForDrawTask(TaskPondMesDto taskPondMesDto, Pager pager) {
        List<CasOrg>userOrgs = casOrgDao.listByUserIdInHcm(UserHolder.getId(),UserHolder.getCompanyId());

        if(CollectionUtils.isEmpty(userOrgs)){
            return null;
        }

        List<Long> orgIds = new ArrayList<>();
        for(CasOrg casOrg:userOrgs){
            orgIds.add(casOrg.getId());
        }

        Params params = Params.create();
        params.add("entity",taskPondMesDto);
        params.add("orgIds",orgIds);
        params.add("deleted","F");

        DataGrid<TaskPondMesDto> dataGrid= taskPondMesDao.myPage(params,pager);

        if(dataGrid != null && !CollectionUtils.isEmpty(dataGrid.getItems())){
            for(TaskPondMesDto tpmd:dataGrid.getItems()){
                tpmd.setStatusName(TaskMesStateEnmu.getNameById(tpmd.getStatus()));
            }
        }

        return dataGrid;
    }

    @Override
    public DataGrid<TaskPondMesDto> myPageForDistributeTask(TaskPondMesDto taskPondMesDto, Pager pager) {

        Params params = Params.create();
        params.add("entity",taskPondMesDto);
        params.add("deleted","F");

        DataGrid<TaskPondMesDto> dataGrid= taskPondMesDao.myPage(params,pager);

        if(dataGrid != null && !CollectionUtils.isEmpty(dataGrid.getItems())){
            for(TaskPondMesDto tpmd:dataGrid.getItems()){
                tpmd.setStatusName(TaskMesStateEnmu.getNameById(tpmd.getStatus()));
            }
        }

        return dataGrid;
    }

    @Override
    public DataGrid<TaskPondMesDto> myPage(TaskPondMesDto taskPondMesDto, List<String> statuses,Pager pager){

        Params params = Params.create();
        params.add("entity",taskPondMesDto);
        params.add("statuses",statuses);
        params.add("deleted","F");

        DataGrid<TaskPondMesDto> dataGrid= taskPondMesDao.myPage(params,pager);

        if(dataGrid != null && !CollectionUtils.isEmpty(dataGrid.getItems())){
            for(TaskPondMesDto tpmd:dataGrid.getItems()){
                tpmd.setStatusName(TaskMesStateEnmu.getNameById(tpmd.getStatus()));
            }
        }

        return dataGrid;

    }


	@Override
	public TaskPondMesDto getById(Long id){

	    TaskPondMesDto taskPondMesDto = taskPondMesDao.getById(id,UserHolder.getCompanyId());
		return taskPondMesDto;
	}

	@Transactional
	@Override
	public void drawTask(TaskPondMesDto taskPondMesDto) {

	    if(taskPondMesDto.getId() == null){
	        throw new BusinessException("任务ID不能为空！");
        }

        TaskPondMesDto dbTaskPondMesDto = getById(taskPondMesDto.getId());
	    if(!TaskMesStateEnmu.DISPATCHING.getId().equals(dbTaskPondMesDto.getStatus())){
	        throw new BusinessException("任务已分配，请勿重复分配！");
        }

		EmpFolderHcm empFolderHcm =empFolderHcmService.getByUserId(UserHolder.getId(),UserHolder.getCompanyId());

		taskPondMesDto.setDoEmpName(empFolderHcm.getEmpName());
		taskPondMesDto.setDoEmpNo(empFolderHcm.getEmpNo());
		taskPondMesDto.setStatus(TaskMesStateEnmu.PROCESSING.getId());

		//任务分配记录
		TaskReceiveEmpMes taskReceiveEmpMes = convertToTaskReceiveEmpMes(taskPondMesDto);
		taskReceiveEmpMes.setTaskPondId(taskPondMesDto.getId());
		taskReceiveEmpMesDao.insert(taskReceiveEmpMes);

		//工艺任务池
		TaskPondMes taskPondMes = convertToTaskPondMes(taskPondMesDto);
		taskPondMesDao.update(taskPondMes);



	}


	@Transactional
	@Override
	public void distributeTask(TaskPondMesDto taskPondMesDto) {

        if(taskPondMesDto.getId() == null){
            throw new BusinessException("任务ID不能为空！");
        }

        TaskPondMesDto dbTaskPondMesDto = getById(taskPondMesDto.getId());
        if(!TaskMesStateEnmu.DISPATCHING.getId().equals(dbTaskPondMesDto.getStatus())){
            throw new BusinessException("任务已分配，请勿重复分配！");
        }

        taskPondMesDto.setStatus(TaskMesStateEnmu.PROCESSING.getId());

		//任务分配记录
		TaskReceiveEmpMes taskReceiveEmpMes = convertToTaskReceiveEmpMes(taskPondMesDto);
		taskReceiveEmpMes.setTaskPondId(taskPondMesDto.getId());
		taskReceiveEmpMesDao.insert(taskReceiveEmpMes);

		//工艺任务池
		TaskPondMes taskPondMes = convertToTaskPondMes(taskPondMesDto);
		taskPondMesDao.update(taskPondMes);
	}

	@Override
	public void setTaskPrice(List<Long> taskPondIds, BigDecimal price){

        int receiveEmp =  taskReceiveEmpMesDao.countByTaskPondIds(taskPondIds);

        if(receiveEmp != taskPondIds.size()){
            throw new BusinessException("请先分配工艺任务！");
      }

		taskReceiveEmpMesDao.updatePriceByTaskPondIds(taskPondIds,price);
	}

	private TaskPondMes convertToTaskPondMes(TaskPondMesDto taskPondMesDto){
		TaskPondMes taskPondMes =new TaskPondMes();
		taskPondMes.setId(taskPondMesDto.getId());
		taskPondMes.setInsideOrder(taskPondMesDto.getInsideOrder());
		taskPondMes.setProdNo(taskPondMesDto.getProdNo());
		taskPondMes.setCrafworkId(taskPondMesDto.getCrafworkId());
		taskPondMes.setAmount(taskPondMesDto.getAmount());
		if(taskPondMesDto.getPlanStartdate()!= null){
            taskPondMes.setPlanStartdate(taskPondMesDto.getPlanStartdate());
        }else if(taskPondMesDto.getPlanDate() != null){
            taskPondMes.setPlanStartdate(taskPondMesDto.getPlanDate());
        }
		taskPondMes.setPlanHours(taskPondMesDto.getPlanHours());
		taskPondMes.setStatus(taskPondMesDto.getStatus());
		taskPondMes.setDesc(taskPondMes.getDesc());
		return taskPondMes;
	}

	private TaskReceiveEmpMes convertToTaskReceiveEmpMes(TaskPondMesDto taskPondMesDto){
		TaskReceiveEmpMes taskReceiveEmpMes = new TaskReceiveEmpMes();
		taskReceiveEmpMes.setInsideOrder(taskPondMesDto.getInsideOrder());
		taskReceiveEmpMes.setProdNo(taskPondMesDto.getProdNo());
		taskReceiveEmpMes.setCrafworkId(taskPondMesDto.getCrafworkId());
		taskReceiveEmpMes.setDoEmpNo(taskPondMesDto.getDoEmpNo());
		taskReceiveEmpMes.setActDate(taskPondMesDto.getActDate());
        if(taskPondMesDto.getPlanStartdate()!= null){
            taskReceiveEmpMes.setPlanDate(taskPondMesDto.getPlanStartdate());
        }else if(taskPondMesDto.getPlanDate() != null){
            taskReceiveEmpMes.setPlanDate(taskPondMesDto.getPlanDate());
        }
		taskReceiveEmpMes.setActHours(taskPondMesDto.getActHours());
		taskReceiveEmpMes.setAmount(taskPondMesDto.getAmount());
		taskReceiveEmpMes.setPrice(taskPondMesDto.getPrice());
		taskReceiveEmpMes.setStatus(taskPondMesDto.getStatus());
		return  taskReceiveEmpMes;
	}


}
