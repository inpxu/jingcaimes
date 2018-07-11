/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import com.zhiyun.entity.ProduceOrderDetailAps;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-3下午4:20:27
 */
public class ProduceOrderDetailDto extends ProduceOrderDetailAps {
	
	private static final long serialVersionUID = 5326131452074952090L;
	
	// 单位
	private String unit;
	// 销售订单
	private String orderNo;
	// 商品编码
	private String waresNo;
	// 产品数量
	private String number;
	
	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getWaresNo() {
		return waresNo;
	}

	public void setWaresNo(String waresNo) {
		this.waresNo = waresNo;
	}
	

}
