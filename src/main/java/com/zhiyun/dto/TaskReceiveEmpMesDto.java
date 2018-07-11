/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import java.math.BigDecimal;

import com.zhiyun.entity.TaskReceiveEmpMes;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-3下午2:15:07
 */
public class TaskReceiveEmpMesDto extends TaskReceiveEmpMes {

	private static final long serialVersionUID = 4254088267667818725L;
	
	// 产品价格
	private BigDecimal prodPrice;
	
	// 外部订单号
	private String orderNo;
	
	// 商品编号
	private String waresNo;

	
	
	
	public String getWaresNo() {
		return waresNo;
	}

	public void setWaresNo(String waresNo) {
		this.waresNo = waresNo;
	}

	public BigDecimal getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(BigDecimal prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}


	
	

}
