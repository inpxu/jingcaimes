/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.InventoryMattersActIosDao;
import com.zhiyun.entity.InventoryMattersActIos;
import com.zhiyun.service.InventoryMattersActIosService;

/**
 * 盘点表_物料_实际Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("inventoryMattersActIosService")
public class InventoryMattersActIosServiceImpl extends BaseServiceImpl<InventoryMattersActIos, Long> implements InventoryMattersActIosService {

	@Resource
	private InventoryMattersActIosDao inventoryMattersActIosDao;

	@Override
	protected BaseDao<InventoryMattersActIos, Long> getBaseDao() {
		return this.inventoryMattersActIosDao;
	}
}
