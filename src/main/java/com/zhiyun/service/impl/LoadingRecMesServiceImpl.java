/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.LoadingRecMesDao;
import com.zhiyun.entity.LoadingRecMes;
import com.zhiyun.service.LoadingRecMesService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("loadingRecMesService")
public class LoadingRecMesServiceImpl extends BaseServiceImpl<LoadingRecMes, Long> implements LoadingRecMesService {

	@Resource
	private LoadingRecMesDao loadingRecMesDao;

	@Override
	protected BaseDao<LoadingRecMes, Long> getBaseDao() {
		return this.loadingRecMesDao;
	}
}
