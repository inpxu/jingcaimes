/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 物料领用明细实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class MattersOutDetailIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 7419669307950225700L;

	// ~~~~实体属性
	// 单据号
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据号字段过长")
	private String voucherNo;
	// 物料编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="物料编码字段过长")
	private String mattersNo;
	// 生产批次
	@Pattern(regexp="[\\s\\S]{0,30}", message="生产批次字段过长")
	private String batch;
	// 规格
	@Pattern(regexp="[\\s\\S]{0,30}", message="规格字段过长")
	private String norms;
	// 参数
	@Pattern(regexp="[\\s\\S]{0,30}", message="参数字段过长")
	private String param;
	// 型号
	@Pattern(regexp="[\\s\\S]{0,30}", message="型号字段过长")
	private String modelDesc;
	// 物料版本号
	@Pattern(regexp="[\\s\\S]{0,30}", message="物料版本号字段过长")
	private String versions;
	// 出库单价
	private java.math.BigDecimal price;
	// 申请数量
	private java.math.BigDecimal applyAmount;
	// 实发数量
	private java.math.BigDecimal amount;
	// 单位
	@Pattern(regexp="[\\s\\S]{0,10}", message="单位字段过长")
	private String unit;
	// 备注
	@Pattern(regexp="[\\s\\S]{0,30}", message="备注字段过长")
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
	 * 规格
	 */
	public String getNorms() {
		return this.norms;
	}

	/**
	 * 规格
	 */
	public void setNorms(String norms) {
		this.norms = norms;
	}
	
	/**
	 * 参数
	 */
	public String getParam() {
		return this.param;
	}

	/**
	 * 参数
	 */
	public void setParam(String param) {
		this.param = param;
	}
	
	/**
	 * 型号
	 */
	public String getModelDesc() {
		return this.modelDesc;
	}

	/**
	 * 型号
	 */
	public void setModelDesc(String modelDesc) {
		this.modelDesc = modelDesc;
	}
	
	/**
	 * 物料版本号
	 */
	public String getVersions() {
		return this.versions;
	}

	/**
	 * 物料版本号
	 */
	public void setVersions(String versions) {
		this.versions = versions;
	}
	
	/**
	 * 出库单价
	 */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * 出库单价
	 */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	
	/**
	 * 申请数量
	 */
	public java.math.BigDecimal getApplyAmount() {
		return this.applyAmount;
	}

	/**
	 * 申请数量
	 */
	public void setApplyAmount(java.math.BigDecimal applyAmount) {
		this.applyAmount = applyAmount;
	}
	
	/**
	 * 实发数量
	 */
	public java.math.BigDecimal getAmount() {
		return this.amount;
	}

	/**
	 * 实发数量
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
