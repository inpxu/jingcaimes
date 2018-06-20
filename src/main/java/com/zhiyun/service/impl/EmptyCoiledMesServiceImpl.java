/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.EmptyCoiledMesDao;
import com.zhiyun.entity.EmptyCoiledMes;
import com.zhiyun.service.EmptyCoiledMesService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("emptyCoiledMesService")
public class EmptyCoiledMesServiceImpl extends BaseServiceImpl<EmptyCoiledMes, Long> implements EmptyCoiledMesService {

	@Resource
	private EmptyCoiledMesDao emptyCoiledMesDao;

	@Override
	protected BaseDao<EmptyCoiledMes, Long> getBaseDao() {
		return this.emptyCoiledMesDao;
	}
}
