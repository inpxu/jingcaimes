/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.DeliveryProdCrmDto;
import com.zhiyun.entity.DeliveryProdCrm;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface DeliveryProdCrmService extends BaseService<DeliveryProdCrm, Long> {
	
	// 交货单分页查看
	DataGrid<DeliveryProdCrmDto> deliPage(DeliveryProdCrm deliveryProdCrm, Page page);
	
	// 发送邮件
	BaseResult<DeliveryProdCrmDto> sendMess(DeliveryProdCrmDto deliveryProdCrmDto);
	
}
