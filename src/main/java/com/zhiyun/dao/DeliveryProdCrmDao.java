/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import java.util.List;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.dto.DeliveryProdCrmDto;
import com.zhiyun.entity.DeliveryProdCrm;

/**
 * DeliveryProdCrmDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface DeliveryProdCrmDao extends BaseDao<DeliveryProdCrm, Long> {
	
	// 交货单分页查看
	DataGrid<DeliveryProdCrmDto> deliPage(DeliveryProdCrm deliveryProdCrm, Page page);
	
	// 客户查询
	List<String> findCustom(DeliveryProdCrmDto deliveryProdCrmDto);
	
	// 客户查询
	List<String> findOrderNo(DeliveryProdCrmDto deliveryProdCrmDto);
	// 查询订单是否已发送邮件
	int getOrderNum(String orderNo);
	
	
}
