/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.DeliveryProdCrmDao;
import com.zhiyun.dto.DeliveryProdCrmDto;
import com.zhiyun.entity.DeliveryProdCrm;
import com.zhiyun.service.DeliveryProdCrmService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("deliveryProdCrmService")
public class DeliveryProdCrmServiceImpl extends BaseServiceImpl<DeliveryProdCrm, Long> implements DeliveryProdCrmService {

	@Resource
	private DeliveryProdCrmDao deliveryProdCrmDao;

	@Override
	protected BaseDao<DeliveryProdCrm, Long> getBaseDao() {
		return this.deliveryProdCrmDao;
	}

	@Override
	public DataGrid<DeliveryProdCrmDto> deliPage(DeliveryProdCrm deliveryProdCrm, Page page) {
		return deliveryProdCrmDao.deliPage(deliveryProdCrm, page);
	}
}
