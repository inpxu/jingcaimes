/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.TaskFinishedMesDao;
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
	public String findEmp(int userId) {
		return taskFinishedMesDao.findEmp(userId);
	}

	@Override
	public List<String> findFinishOrder(String customNo) {
		TaskFinishedMesDto task = new TaskFinishedMesDto();
		Long companyId = UserHolder.getCompanyId();
		task.setCustomNo(customNo);
		task.setCompanyId(companyId);
		List<String> ors = taskFinishedMesDao.findOrder(task);
		List<String> orderNos = new ArrayList<>();
		for (String order : ors) {
			TaskFinishedMesDto taMes = new TaskFinishedMesDto();
			taMes.setOrderNo(order);
			taMes.setCompanyId(companyId);
			int a = taskFinishedMesDao.findAllNum(taMes);
			int f = taskFinishedMesDao.findFinishNum(taMes);
			if ((a != 0 || f != 0 ) && a == f ) {
				orderNos.add(order);
			}
		}
		return orderNos;
	}
}
