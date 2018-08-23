/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.DeliveryProdCrmDao;
import com.zhiyun.dao.TaskFinishedMesDao;
import com.zhiyun.dao.TaskReceiveEmpMesDao;
import com.zhiyun.dto.TaskFinishedMesDto;
import com.zhiyun.entity.TaskFinishedMes;
import com.zhiyun.service.TaskFinishedMesService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("taskFinishedMesService")
public class TaskFinishedMesServiceImpl extends BaseServiceImpl<TaskFinishedMes, Long> implements TaskFinishedMesService {

	@Resource
	private TaskFinishedMesDao taskFinishedMesDao;
	@Resource
	private TaskReceiveEmpMesDao taskReceiveEmpMesDao;
	@Resource
	private DeliveryProdCrmDao deliveryProdCrmDao;

	@Override
	protected BaseDao<TaskFinishedMes, Long> getBaseDao() {
		return this.taskFinishedMesDao;
	}

	@Override
	public DataGrid<TaskFinishedMesDto> findByMes(Params params, Page page) {
		return taskFinishedMesDao.findByMes(params, page);
	}

	@Override
	public DataGrid<TaskFinishedMesDto> cusReview(Params params, Page page) {
		return taskFinishedMesDao.cusReview(params, page);
	}

	@Override
	public String findEmp(Long userId) {
		return taskFinishedMesDao.findEmp(userId);
	}

	@Override
	public List<Map<String, String>>findFinishOrder(TaskFinishedMesDto taskFinishedMesDto) {
		Long companyId = UserHolder.getCompanyId();
		taskFinishedMesDto.setCompanyId(companyId);
		// 获取客户名下所有的订单
		List<String> ors = taskFinishedMesDao.findOrder(taskFinishedMesDto);
		List<Map<String, String>> orders = new ArrayList<>();
		for (String order : ors) {
			TaskFinishedMesDto taMes = new TaskFinishedMesDto();
			taMes.setOrderNo(order);
			taMes.setCompanyId(companyId);
			// 任务池任务数
			int a = taskFinishedMesDao.findAllNum(taMes);
			// 已领取任务且未驳回的任务数
//			int g = taskFinishedMesDao.findGetNum(taMes);
			// 已领取的所有任务数
//			int ga = taskFinishedMesDao.findAllGetNum(taMes);
			// 所有已完成的任务数
			int f = taskFinishedMesDao.findFinishNum(taMes);
			int n = deliveryProdCrmDao.getOrderNum(order);
			if ((a != 0 || f != 0) && f == a /*&& n == 0*/) {
//				if ((ga != 0 || f != 0 ) && ga == f && n == 0) {
					Map<String, String> e = new HashMap<>();
					e.put("orderNo", order);
					orders.add(e);
//				}
			}
		}
		return orders;
	}

	@Override
	public int updateIsCheck(TaskFinishedMes taskFinishedMes) {
		return taskFinishedMesDao.updateIsCheck(taskFinishedMes);
	}
}
