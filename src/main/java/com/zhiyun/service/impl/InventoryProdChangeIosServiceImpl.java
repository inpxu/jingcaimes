/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.InventoryProdChangeIosDao;
import com.zhiyun.entity.InventoryProdChangeIos;
import com.zhiyun.service.InventoryProdChangeIosService;

/**
 * 盘点盈亏调整_成品Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("inventoryProdChangeIosService")
public class InventoryProdChangeIosServiceImpl extends BaseServiceImpl<InventoryProdChangeIos, Long> implements InventoryProdChangeIosService {

	@Resource
	private InventoryProdChangeIosDao inventoryProdChangeIosDao;

	@Override
	protected BaseDao<InventoryProdChangeIos, Long> getBaseDao() {
		return this.inventoryProdChangeIosDao;
	}
}
