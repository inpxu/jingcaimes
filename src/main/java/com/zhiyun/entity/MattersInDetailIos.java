/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 物料入库明细实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class MattersInDetailIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 2150617361599487974L;

	// ~~~~实体属性
	// 单据号
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据号字段过长")
	private String voucherNo;
	// 物料编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="物料编码字段过长")
	private String mattersNo;
	// 生产日期
	private java.util.Date makeDate;
	// 生产批次
	@Pattern(regexp="[\\s\\S]{0,30}", message="生产批次字段过长")
	private String batch;
	// 保质期
	private java.util.Date termDate;
	// 货架位置
	@Pattern(regexp="[\\s\\S]{0,30}", message="货架位置字段过长")
	private String rackPosition;
	// 进仓单价
	private java.math.BigDecimal price;
	// 数量
	private java.math.BigDecimal amount;
	// 单位
	@Pattern(regexp="[\\s\\S]{0,10}", message="单位字段过长")
	private String unit;
	// 采购单号
	@Pattern(regexp="[\\s\\S]{0,30}", message="采购单号字段过长")
	private String purchaseNo;
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
	 * 物料编码
	 */
	public String getMattersNo() {
		return this.mattersNo;
	}

	/**
	 * 物料编码
	 */
	public void setMattersNo(String mattersNo) {
		this.mattersNo = mattersNo;
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
	 * 保质期
	 */
	public java.util.Date getTermDate() {
		return this.termDate;
	}

	/**
	 * 保质期
	 */
	public void setTermDate(java.util.Date termDate) {
		this.termDate = termDate;
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
	 * 进仓单价
	 */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * 进仓单价
	 */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
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
	 * 采购单号
	 */
	public String getPurchaseNo() {
		return this.purchaseNo;
	}

	/**
	 * 采购单号
	 */
	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
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
