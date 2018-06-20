/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.InventoryProdIosDao;
import com.zhiyun.entity.InventoryProdIos;
import com.zhiyun.service.InventoryProdIosService;

/**
 * 盘点表_成品_应存Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("inventoryProdIosService")
public class InventoryProdIosServiceImpl extends BaseServiceImpl<InventoryProdIos, Long> implements InventoryProdIosService {

	@Resource
	private InventoryProdIosDao inventoryProdIosDao;

	@Override
	protected BaseDao<InventoryProdIos, Long> getBaseDao() {
		return this.inventoryProdIosDao;
	}
}
