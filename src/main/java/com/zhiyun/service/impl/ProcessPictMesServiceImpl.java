/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProcessPictMesDao;
import com.zhiyun.entity.ProcessPictMes;
import com.zhiyun.service.ProcessPictMesService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("processPictMesService")
public class ProcessPictMesServiceImpl extends BaseServiceImpl<ProcessPictMes, Long> implements ProcessPictMesService {

	@Resource
	private ProcessPictMesDao processPictMesDao;

	@Override
	protected BaseDao<ProcessPictMes, Long> getBaseDao() {
		return this.processPictMesDao;
	}
}
