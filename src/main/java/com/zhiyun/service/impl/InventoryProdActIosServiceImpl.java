/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.InventoryProdActIosDao;
import com.zhiyun.entity.InventoryProdActIos;
import com.zhiyun.service.InventoryProdActIosService;

/**
 * 盘点表_成品_实际Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("inventoryProdActIosService")
public class InventoryProdActIosServiceImpl extends BaseServiceImpl<InventoryProdActIos, Long> implements InventoryProdActIosService {

	@Resource
	private InventoryProdActIosDao inventoryProdActIosDao;

	@Override
	protected BaseDao<InventoryProdActIos, Long> getBaseDao() {
		return this.inventoryProdActIosDao;
	}
}
