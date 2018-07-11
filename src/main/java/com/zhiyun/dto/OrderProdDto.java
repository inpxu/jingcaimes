/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import java.util.List;

import com.zhiyun.base.entity.BaseEntity;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-5下午3:28:00
 */
public class OrderProdDto extends BaseEntity<Long>  {

	private static final long serialVersionUID = 5284384675276835206L;
	
	// 小计
	private String subtotal;
	// 数量
	private java.math.BigDecimal amount;
	
	private List<OrderProdDetailDto> details;

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public java.math.BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	public List<OrderProdDetailDto> getDetails() {
		return details;
	}

	public void setDetails(List<OrderProdDetailDto> details) {
		this.details = details;
	}
	
	
	
	

}
