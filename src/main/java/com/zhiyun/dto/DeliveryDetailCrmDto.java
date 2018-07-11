/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import java.math.BigDecimal;
import java.util.List;

import com.zhiyun.entity.DeliveryDetailCrm;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-10上午9:43:32
 */
public class DeliveryDetailCrmDto extends DeliveryDetailCrm {

	private static final long serialVersionUID = 4254088267267818725L;
	
	// 工艺详情
	private List<OrderPictMesDto> pictMess;
	// 总数量
	private BigDecimal sumAmount;
	// 总单位
	private String sumUnit;

	
	
	public BigDecimal getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(BigDecimal sumAmount) {
		this.sumAmount = sumAmount;
	}

	public String getSumUnit() {
		return sumUnit;
	}

	public void setSumUnit(String sumUnit) {
		this.sumUnit = sumUnit;
	}

	public List<OrderPictMesDto> getPictMess() {
		return pictMess;
	}

	public void setPictMess(List<OrderPictMesDto> pictMess) {
		this.pictMess = pictMess;
	}
	
	

}
