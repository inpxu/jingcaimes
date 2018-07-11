/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.DeliveryDetailCrmDto;
import com.zhiyun.dto.DeliveryProdCrmDto;
import com.zhiyun.entity.DeliveryDetailCrm;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface DeliveryDetailCrmService extends BaseService<DeliveryDetailCrm, Long> {
	
	// 新增交货单明细
	int insertDeli(DeliveryDetailCrm deliveryDetailCrm);
	
	// 产品明细
	DeliveryDetailCrmDto prodDetail(DeliveryDetailCrm deliveryDetailCrm);
	
	// 交货单明细
	DeliveryProdCrmDto orderDetail(DeliveryDetailCrm deliveryDetailCrm); 


}
