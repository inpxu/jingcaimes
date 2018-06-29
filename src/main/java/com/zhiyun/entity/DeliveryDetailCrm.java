/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class DeliveryDetailCrm extends BaseEntity<Long> {

	private static final long serialVersionUID = 7498569668322976816L;

	// ~~~~实体属性
	// 交货单id
	@Max(value=9223372036854775807L,message="交货单id字段过长")
	private Long deliveryId;
	// 单据号
	@Pattern(regexp="[\\S]{0,30}", message="单据号字段过长")
	private String voucherNo;
	// 订单号
	@Pattern(regexp="[\\S]{0,30}", message="订单号字段过长")
	private String orderNo;
	// 产品编码
	@Pattern(regexp="[\\S]{0,30}", message="产品编码字段过长")
	private String waresNo;
	// 数量
	private java.math.BigDecimal amount;
	// 单价
	private java.math.BigDecimal price;
	// 单位
	@Pattern(regexp="[\\S]{0,10}", message="单位字段过长")
	private String unit;
	// 小计
	private java.math.BigDecimal total;
	// 备注
	@Pattern(regexp="[\\S]{0,30}", message="备注字段过长")
	private String remark;
	// 企业主键
	@Max(value=9223372036854775807L,message="企业主键字段过长")
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
	 * 交货单id
	 */
	public Long getDeliveryId() {
		return this.deliveryId;
	}

	/**
	 * 交货单id
	 */
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	/**
	 * 单据号
	 */
	public String getVoucherNo() {
		return this.voucherNo;
	}

	/**
	 * 单据号
	 */
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	
	/**
	 * 订单号
	 */
	public String getOrderNo() {
		return this.orderNo;
	}

	/**
	 * 订单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	/**
	 * 产品编码
	 */
	public String getWaresNo() {
		return this.waresNo;
	}

	/**
	 * 产品编码
	 */
	public void setWaresNo(String waresNo) {
		this.waresNo = waresNo;
	}
	
	/**
	 * 数量
	 */
	public java.math.BigDecimal getAmount() {
		return this.amount;
	}

	/**
	 * 数量
	 */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}
	
	/**
	 * 单价
	 */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * 单价
	 */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	
	/**
	 * 单位
	 */
	public String getUnit() {
		return this.unit;
	}

	/**
	 * 单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * 小计
	 */
	public java.math.BigDecimal getTotal() {
		return this.total;
	}

	/**
	 * 小计
	 */
	public void setTotal(java.math.BigDecimal total) {
		this.total = total;
	}
	
	/**
	 * 备注
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 企业主键
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 企业主键
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
