/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.TaskEmpApsDao;
import com.zhiyun.entity.TaskEmpAps;
import com.zhiyun.service.TaskEmpApsService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("taskEmpApsService")
public class TaskEmpApsServiceImpl extends BaseServiceImpl<TaskEmpAps, Long> implements TaskEmpApsService {

	@Resource
	private TaskEmpApsDao taskEmpApsDao;

	@Override
	protected BaseDao<TaskEmpAps, Long> getBaseDao() {
		return this.taskEmpApsDao;
	}
}
