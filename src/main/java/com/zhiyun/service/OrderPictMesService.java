/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;


import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.OrderPictMesDto;
import com.zhiyun.entity.OrderPictMes;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface OrderPictMesService extends BaseService<OrderPictMes, Long> {
	
	// 查看详情
	OrderPictMesDto pictPage(OrderPictMes orderPictMes);
	
	// 添加实际工时
	int updateTime(OrderPictMesDto orderPictMesDto);

}
