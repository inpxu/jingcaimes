/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.StoreSetIosDao;
import com.zhiyun.entity.StoreSetIos;
import com.zhiyun.service.StoreSetIosService;

/**
 * 仓储设置Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("storeSetIosService")
public class StoreSetIosServiceImpl extends BaseServiceImpl<StoreSetIos, Long> implements StoreSetIosService {

	@Resource
	private StoreSetIosDao storeSetIosDao;

	@Override
	protected BaseDao<StoreSetIos, Long> getBaseDao() {
		return this.storeSetIosDao;
	}
}
