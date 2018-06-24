/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 成品入库明细实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class ProdInDetailIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 7111279176489270623L;

	// ~~~~实体属性
	// 单据号
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据号字段过长")
	private String voucherNo;
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 生产日期
	private java.util.Date makeDate;
	// 生产批次
	@Pattern(regexp="[\\s\\S]{0,30}", message="生产批次字段过长")
	private String batch;
	// 计划id
	@Max(value=9223372036854775807L,message="计划id字段过长")
	private Long makePlanId;
	// 单件成本
	private java.math.BigDecimal inCost;
	// 货架位置
	@Pattern(regexp="[\\s\\S]{0,30}", message="货架位置字段过长")
	private String rackPosition;
	// 生产数量
	private java.math.BigDecimal makeAmount;
	// 入库数量
	private java.math.BigDecimal amount;
	// 单位
	@Pattern(regexp="[\\s\\S]{0,10}", message="单位字段过长")
	private String unit;
	// 备注
	@Pattern(regexp="[\\s\\S]{0,50}", message="备注字段过长")
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
	 * 产品编码
	 */
	public String getProdNo() {
		return this.prodNo;
	}

	/**
	 * 产品编码
	 */
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	
	/**
	 * 生产日期
	 */
	public java.util.Date getMakeDate() {
		return this.makeDate;
	}

	/**
	 * 生产日期
	 */
	public void setMakeDate(java.util.Date makeDate) {
		this.makeDate = makeDate;
	}
	
	/**
	 * 生产批次
	 */
	public String getBatch() {
		return this.batch;
	}

	/**
	 * 生产批次
	 */
	public void setBatch(String batch) {
		this.batch = batch;
	}
	
	/**
	 * 计划id
	 */
	public Long getMakePlanId() {
		return this.makePlanId;
	}

	/**
	 * 计划id
	 */
	public void setMakePlanId(Long makePlanId) {
		this.makePlanId = makePlanId;
	}
	
	/**
	 * 单件成本
	 */
	public java.math.BigDecimal getInCost() {
		return this.inCost;
	}

	/**
	 * 单件成本
	 */
	public void setInCost(java.math.BigDecimal inCost) {
		this.inCost = inCost;
	}
	
	/**
	 * 货架位置
	 */
	public String getRackPosition() {
		return this.rackPosition;
	}

	/**
	 * 货架位置
	 */
	public void setRackPosition(String rackPosition) {
		this.rackPosition = rackPosition;
	}
	
	/**
	 * 生产数量
	 */
	public java.math.BigDecimal getMakeAmount() {
		return this.makeAmount;
	}

	/**
	 * 生产数量
	 */
	public void setMakeAmount(java.math.BigDecimal makeAmount) {
		this.makeAmount = makeAmount;
	}
	
	/**
	 * 入库数量
	 */
	public java.math.BigDecimal getAmount() {
		return this.amount;
	}

	/**
	 * 入库数量
	 */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
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
