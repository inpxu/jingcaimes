/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.TaskReceiveEmpMesDao;
import com.zhiyun.entity.TaskReceiveEmpMes;
import com.zhiyun.service.TaskReceiveEmpMesService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("taskReceiveEmpMesService")
public class TaskReceiveEmpMesServiceImpl extends BaseServiceImpl<TaskReceiveEmpMes, Long> implements TaskReceiveEmpMesService {

	@Resource
	private TaskReceiveEmpMesDao taskReceiveEmpMesDao;


	@Override
	protected BaseDao<TaskReceiveEmpMes, Long> getBaseDao() {
		return this.taskReceiveEmpMesDao;
	}


}
