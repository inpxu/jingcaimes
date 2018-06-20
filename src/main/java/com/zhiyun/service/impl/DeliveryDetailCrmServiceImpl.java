/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.DeliveryDetailCrmDao;
import com.zhiyun.entity.DeliveryDetailCrm;
import com.zhiyun.service.DeliveryDetailCrmService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("deliveryDetailCrmService")
public class DeliveryDetailCrmServiceImpl extends BaseServiceImpl<DeliveryDetailCrm, Long> implements DeliveryDetailCrmService {

	@Resource
	private DeliveryDetailCrmDao deliveryDetailCrmDao;

	@Override
	protected BaseDao<DeliveryDetailCrm, Long> getBaseDao() {
		return this.deliveryDetailCrmDao;
	}
}
