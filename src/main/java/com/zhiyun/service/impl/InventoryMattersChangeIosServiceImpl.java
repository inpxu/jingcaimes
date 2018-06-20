/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.InventoryMattersChangeIosDao;
import com.zhiyun.entity.InventoryMattersChangeIos;
import com.zhiyun.service.InventoryMattersChangeIosService;

/**
 * 盘点盈亏调整_物料Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("inventoryMattersChangeIosService")
public class InventoryMattersChangeIosServiceImpl extends BaseServiceImpl<InventoryMattersChangeIos, Long> implements InventoryMattersChangeIosService {

	@Resource
	private InventoryMattersChangeIosDao inventoryMattersChangeIosDao;

	@Override
	protected BaseDao<InventoryMattersChangeIos, Long> getBaseDao() {
		return this.inventoryMattersChangeIosDao;
	}
}
