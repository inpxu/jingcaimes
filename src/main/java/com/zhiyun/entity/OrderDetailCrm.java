/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 客户订单产品明细实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class OrderDetailCrm extends BaseEntity<Long> {

	private static final long serialVersionUID = 5284384675276832506L;

	// ~~~~实体属性
	// 订单号
	@Max(value=9223372036854775807L,message="订单号字段过长")
	private Long orderId;
	// 商品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="商品编码字段过长")
	private String waresNo;
	// 价格策略
	@Max(value=9223372036854775807L,message="价格策略字段过长")
	private Long priceId;
	// 最终成交价
	private java.math.BigDecimal passPrice;
	// 成交数量
	private java.math.BigDecimal amount;
	// 税率
	private java.math.BigDecimal tax;
	// 计量单位
	@Pattern(regexp="[\\s\\S]{0,20}", message="计量单位字段过长")
	private String unit;
	// 优惠id
	private java.math.BigDecimal favourJudge;
	// 会员id
	private java.math.BigDecimal memberId;
	// 已交货数量
	private java.math.BigDecimal alreadyAmount;
	// 
	@Max(value=9223372036854775807L,message="字段过长")
	private Long companyId;

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	/**
	 * 订单号
	 */
	public Long getOrderId() {
		return this.orderId;
	}

	/**
	 * 订单号
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * 商品编码
	 */
	public String getWaresNo() {
		return this.waresNo;
	}

	/**
	 * 商品编码
	 */
	public void setWaresNo(String waresNo) {
		this.waresNo = waresNo;
	}
	
	/**
	 * 价格策略
	 */
	public Long getPriceId() {
		return this.priceId;
	}

	/**
	 * 价格策略
	 */
	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}
	
	/**
	 * 最终成交价
	 */
	public java.math.BigDecimal getPassPrice() {
		return this.passPrice;
	}

	/**
	 * 最终成交价
	 */
	public void setPassPrice(java.math.BigDecimal passPrice) {
		this.passPrice = passPrice;
	}
	
	/**
	 * 成交数量
	 */
	public java.math.BigDecimal getAmount() {
		return this.amount;
	}

	/**
	 * 成交数量
	 */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}
	
	/**
	 * 税率
	 */
	public java.math.BigDecimal getTax() {
		return this.tax;
	}

	/**
	 * 税率
	 */
	public void setTax(java.math.BigDecimal tax) {
		this.tax = tax;
	}
	
	/**
	 * 计量单位
	 */
	public String getUnit() {
		return this.unit;
	}

	/**
	 * 计量单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * 优惠id
	 */
	public java.math.BigDecimal getFavourJudge() {
		return this.favourJudge;
	}

	/**
	 * 优惠id
	 */
	public void setFavourJudge(java.math.BigDecimal favourJudge) {
		this.favourJudge = favourJudge;
	}
	
	/**
	 * 会员id
	 */
	public java.math.BigDecimal getMemberId() {
		return this.memberId;
	}

	/**
	 * 会员id
	 */
	public void setMemberId(java.math.BigDecimal memberId) {
		this.memberId = memberId;
	}
	
	/**
	 * 已交货数量
	 */
	public java.math.BigDecimal getAlreadyAmount() {
		return this.alreadyAmount;
	}

	/**
	 * 已交货数量
	 */
	public void setAlreadyAmount(java.math.BigDecimal alreadyAmount) {
		this.alreadyAmount = alreadyAmount;
	}
	
	/**
	 * 
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
