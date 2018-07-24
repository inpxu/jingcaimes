/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.DeliveryProdCrmDao;
import com.zhiyun.dto.DeliveryProdCrmDto;
import com.zhiyun.entity.DeliveryProdCrm;

/**
 * DeliveryProdCrmDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("deliveryProdCrmDao")
public class DeliveryProdCrmDaoImpl extends BaseDaoImpl<DeliveryProdCrm, Long> implements DeliveryProdCrmDao {

	@Override
	public DataGrid<DeliveryProdCrmDto> deliPage(DeliveryProdCrm deliveryProdCrm, Page page) {
		Params params = Params.create();
		params.add("entity", deliveryProdCrm);
		params.add("companyId", UserHolder.getCompanyId());
		return this.selectPage(getMethodName(), params, page);
	}

	@Override
	public List<String> findCustom(DeliveryProdCrmDto deliveryProdCrmDto) {
		deliveryProdCrmDto.setCompanyId(UserHolder.getCompanyId());
		return this.selectList(getMethodName(), deliveryProdCrmDto);
	}

	@Override
	public List<String> findOrderNo(DeliveryProdCrmDto deliveryProdCrmDto) {
		deliveryProdCrmDto.setCompanyId(UserHolder.getCompanyId());
		return this.selectList(getMethodName(), deliveryProdCrmDto);
	}

	@Override
	public int getOrderNum(String orderNo) {
		DeliveryProdCrmDto deliveryProdCrmDto = new DeliveryProdCrmDto();
		deliveryProdCrmDto.setOrderNo(orderNo);
		deliveryProdCrmDto.setCompanyId(UserHolder.getCompanyId());
		return this.selectOne(getMethodName(), deliveryProdCrmDto);
	}

}
