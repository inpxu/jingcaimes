/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
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
}
