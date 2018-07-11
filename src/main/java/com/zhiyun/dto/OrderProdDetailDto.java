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
 * @date 2018-7-5下午3:36:37
 */
public class OrderProdDetailDto extends BaseEntity<Long> {

	private static final long serialVersionUID = 5284384675216835206L;
	
	// 价格
	private String price; 
	// 数量
	private java.math.BigDecimal amount;
	// 工艺名称
	private String crafworkName;
	// 工艺id
	private Long crafworkId;
	// 图片库	
	private List<String> linkPaths;
	
	public Long getCrafworkId() {
		return crafworkId;
	}
	public void setCrafworkId(Long crafworkId) {
		this.crafworkId = crafworkId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public java.math.BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}
	public String getCrafworkName() {
		return crafworkName;
	}
	public void setCrafworkName(String crafworkName) {
		this.crafworkName = crafworkName;
	}
	public List<String> getLinkPaths() {
		return linkPaths;
	}
	public void setLinkPaths(List<String> linkPaths) {
		this.linkPaths = linkPaths;
	}
	

}
