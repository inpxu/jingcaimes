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
public class WasteRecordMidMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 3613124057310628029L;

	// ~~~~实体属性
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 半成品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="半成品编码字段过长")
	private String midProdNo;
	// 生产日期
	private java.util.Date makeDate;
	// 设备编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="设备编码字段过长")
	private String macNo;
	// 数量
	private java.math.BigDecimal amount;
	// 单位
	private java.math.BigDecimal unit;
	// 生产人
	@Pattern(regexp="[\\s\\S]{0,30}", message="生产人字段过长")
	private String doEmp;
	// 品检员
	@Pattern(regexp="[\\s\\S]{0,30}", message="品检员字段过长")
	private String checkEmp;
	// 描述
	@Pattern(regexp="[\\s\\S]{0,60}", message="描述字段过长")
	private String descr;
	// 公司id
	@Max(value=9223372036854775807L,message="公司id字段过长")
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
	 * 半成品编码
	 */
	public String getMidProdNo() {
		return this.midProdNo;
	}

	/**
	 * 半成品编码
	 */
	public void setMidProdNo(String midProdNo) {
		this.midProdNo = midProdNo;
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
	 * 设备编码
	 */
	public String getMacNo() {
		return this.macNo;
	}

	/**
	 * 设备编码
	 */
	public void setMacNo(String macNo) {
		this.macNo = macNo;
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
	public java.math.BigDecimal getUnit() {
		return this.unit;
	}

	/**
	 * 单位
	 */
	public void setUnit(java.math.BigDecimal unit) {
		this.unit = unit;
	}
	
	/**
	 * 生产人
	 */
	public String getDoEmp() {
		return this.doEmp;
	}

	/**
	 * 生产人
	 */
	public void setDoEmp(String doEmp) {
		this.doEmp = doEmp;
	}
	
	/**
	 * 品检员
	 */
	public String getCheckEmp() {
		return this.checkEmp;
	}

	/**
	 * 品检员
	 */
	public void setCheckEmp(String checkEmp) {
		this.checkEmp = checkEmp;
	}
	
	/**
	 * 描述
	 */
	public String getDescr() {
		return this.descr;
	}

	/**
	 * 描述
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	/**
	 * 公司id
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 公司id
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
