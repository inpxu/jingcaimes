/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

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
import com.zhiyun.service.TaskReceiveEmpMesService;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.TaskPondMesDao;
import com.zhiyun.service.TaskPondMesService;
import org.springframework.util.CollectionUtils;

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

	@Override
	protected BaseDao<TaskPondMes, Long> getBaseDao() {
		return this.taskPondMesDao;
	}

	@Override
	public DataGrid<TaskPondMesDto> myPage(TaskPondMesDto taskPondMesDto, Pager pager){
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

		return taskPondMesDao.myPage(params,pager);
	}

	@Override
	public TaskPondMesDto getById(Long id){
		return taskPondMesDao.getById(id,UserHolder.getCompanyId());
	}

	@Override
	public void drawTask(TaskPondMesDto taskPondMesDto) {

		EmpFolderHcm empFolderHcm =empFolderHcmService.getByUserId(UserHolder.getId(),UserHolder.getCompanyId());

		taskPondMesDto.setDoEmpName(empFolderHcm.getEmpName());
		taskPondMesDto.setDoEmpNo(empFolderHcm.getEmpNo());
		taskPondMesDto.setStatus(TaskMesStateEnmu.PROCESSING.getId());

		//任务分配记录
		TaskReceiveEmpMes taskReceiveEmpMes = convertToTaskReceiveEmpMes(taskPondMesDto);
		taskReceiveEmpMesDao.insert(taskReceiveEmpMes);

		//工艺任务池
		TaskPondMes taskPondMes = convertToTaskPondMes(taskPondMesDto);
		taskPondMesDao.update(taskPondMes);

	}

	@Override
	public void distributeTask(TaskPondMesDto taskPondMesDto) {

		//任务分配记录
		TaskReceiveEmpMes taskReceiveEmpMes = convertToTaskReceiveEmpMes(taskPondMesDto);
		taskReceiveEmpMesDao.insert(taskReceiveEmpMes);

		//工艺任务池
		TaskPondMes taskPondMes = convertToTaskPondMes(taskPondMesDto);
		taskPondMesDao.update(taskPondMes);
	}

	@Override
	public void setTaskPrice(List<String> insiderOrders, BigDecimal price){
		taskReceiveEmpMesDao.updatePriceByInsiderOrders(insiderOrders,price);
	}

	private TaskPondMes convertToTaskPondMes(TaskPondMesDto taskPondMesDto){
		TaskPondMes taskPondMes =new TaskPondMes();
		taskPondMes.setId(taskPondMesDto.getId());
		taskPondMes.setInsideOrder(taskPondMesDto.getInsideOrder());
		taskPondMes.setProdNo(taskPondMesDto.getProdNo());
		taskPondMes.setCrafworkId(taskPondMesDto.getCrafworkId());
		taskPondMes.setAmount(taskPondMesDto.getAmount());
		taskPondMes.setPlanStartdate(taskPondMesDto.getPlanStartdate());
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
		taskReceiveEmpMes.setPlanDate(taskPondMesDto.getPlanDate());
		taskReceiveEmpMes.setActHours(taskPondMesDto.getActHours());
		taskReceiveEmpMes.setAmount(taskPondMesDto.getAmount());
		taskReceiveEmpMes.setPrice(taskPondMesDto.getPrice());
		taskReceiveEmpMes.setStatus(taskPondMesDto.getStatus());
		return  taskReceiveEmpMes;
	}


}
