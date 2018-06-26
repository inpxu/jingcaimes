/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.OrderDetailCrmDao;
import com.zhiyun.entity.OrderDetailCrm;
import com.zhiyun.service.OrderDetailCrmService;

/**
 * 客户订单产品明细Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("orderDetailCrmService")
public class OrderDetailCrmServiceImpl extends BaseServiceImpl<OrderDetailCrm, Long> implements OrderDetailCrmService {

	@Resource
	private OrderDetailCrmDao orderDetailCrmDao;

	@Override
	protected BaseDao<OrderDetailCrm, Long> getBaseDao() {
		return this.orderDetailCrmDao;
	}
}
