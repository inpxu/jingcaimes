/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.InventoryChangeMainIosDao;
import com.zhiyun.entity.InventoryChangeMainIos;
import com.zhiyun.service.InventoryChangeMainIosService;

/**
 * 盘点盈亏调整主表Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("inventoryChangeMainIosService")
public class InventoryChangeMainIosServiceImpl extends BaseServiceImpl<InventoryChangeMainIos, Long> implements InventoryChangeMainIosService {

	@Resource
	private InventoryChangeMainIosDao inventoryChangeMainIosDao;

	@Override
	protected BaseDao<InventoryChangeMainIos, Long> getBaseDao() {
		return this.inventoryChangeMainIosDao;
	}
}
