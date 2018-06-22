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
public class CoiledOutputRecordMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 4433731014359460187L;

	// ~~~~实体属性
	// 设备编号
	@Pattern(regexp="[\\s\\S]{0,30}", message="设备编号字段过长")
	private String macNo;
	// 时间戳
	private java.util.Date flagTime;
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 半成品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="半成品编码字段过长")
	private String midProdNo;
	// 数量
	private java.math.BigDecimal amount;
	// 单位
	@Pattern(regexp="[\\s\\S]{0,10}", message="单位字段过长")
	private String unit;
	// 半成品信息
	private String param;
	// 品检通过
	@Pattern(regexp="[\\s\\S]{0,30}", message="品检通过字段过长")
	private String checkOk;
	// 
	@Pattern(regexp="[\\s\\S]{0,30}", message="字段过长")
	private String coiledNo;
	// 生产批次
	@Pattern(regexp="[\\s\\S]{0,30}", message="生产批次字段过长")
	private String batch;
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
	 * 设备编号
	 */
	public String getMacNo() {
		return this.macNo;
	}

	/**
	 * 设备编号
	 */
	public void setMacNo(String macNo) {
		this.macNo = macNo;
	}
	
	/**
	 * 时间戳
	 */
	public java.util.Date getFlagTime() {
		return this.flagTime;
	}

	/**
	 * 时间戳
	 */
	public void setFlagTime(java.util.Date flagTime) {
		this.flagTime = flagTime;
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
	 * 半成品信息
	 */
	public String getParam() {
		return this.param;
	}

	/**
	 * 半成品信息
	 */
	public void setParam(String param) {
		this.param = param;
	}
	
	/**
	 * 品检通过
	 */
	public String getCheckOk() {
		return this.checkOk;
	}

	/**
	 * 品检通过
	 */
	public void setCheckOk(String checkOk) {
		this.checkOk = checkOk;
	}
	
	/**
	 * 
	 */
	public String getCoiledNo() {
		return this.coiledNo;
	}

	/**
	 * 
	 */
	public void setCoiledNo(String coiledNo) {
		this.coiledNo = coiledNo;
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
