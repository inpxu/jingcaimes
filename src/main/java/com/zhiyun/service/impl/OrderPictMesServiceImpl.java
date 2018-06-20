/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.OrderPictMesDao;
import com.zhiyun.entity.OrderPictMes;
import com.zhiyun.service.OrderPictMesService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("orderPictMesService")
public class OrderPictMesServiceImpl extends BaseServiceImpl<OrderPictMes, Long> implements OrderPictMesService {

	@Resource
	private OrderPictMesDao orderPictMesDao;

	@Override
	protected BaseDao<OrderPictMes, Long> getBaseDao() {
		return this.orderPictMesDao;
	}
}
