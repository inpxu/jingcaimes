/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.InventoryMattersIosDao;
import com.zhiyun.entity.InventoryMattersIos;
import com.zhiyun.service.InventoryMattersIosService;

/**
 * 盘点表_物料_应存Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("inventoryMattersIosService")
public class InventoryMattersIosServiceImpl extends BaseServiceImpl<InventoryMattersIos, Long> implements InventoryMattersIosService {

	@Resource
	private InventoryMattersIosDao inventoryMattersIosDao;

	@Override
	protected BaseDao<InventoryMattersIos, Long> getBaseDao() {
		return this.inventoryMattersIosDao;
	}
}
