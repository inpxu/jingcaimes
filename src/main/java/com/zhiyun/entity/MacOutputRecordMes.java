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
public class MacOutputRecordMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 3299978080191639463L;

	// ~~~~实体属性
	// 设备编号
	@Pattern(regexp="[\\s\\S]{0,20}", message="设备编号字段过长")
	private String macNo;
	// 时间戳
	private java.util.Date flagTime;
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 半产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="半产品编码字段过长")
	private String midProdNo;
	// 数量
	private java.math.BigDecimal amount;
	// 单位
	@Pattern(regexp="[\\s\\S]{0,10}", message="单位字段过长")
	private String unit;
	// 品检通过
	@Pattern(regexp="[\\s\\S]{0,30}", message="品检通过字段过长")
	private String checkOk;
	// 指定设备
	@Pattern(regexp="[\\s\\S]{0,30}", message="指定设备字段过长")
	private String spcMac;
	// 已用数量
	private java.math.BigDecimal alReady;
	// 生产批次
	@Pattern(regexp="[\\s\\S]{0,30}", message="生产批次字段过长")
	private String batch;
	// 企业标识
	@Max(value=9223372036854775807L,message="企业标识字段过长")
	private Long companyId;
	// 半成品信息
	private String param;

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
	 * 半产品编码
	 */
	public String getMidProdNo() {
		return this.midProdNo;
	}

	/**
	 * 半产品编码
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
	 * 指定设备
	 */
	public String getSpcMac() {
		return this.spcMac;
	}

	/**
	 * 指定设备
	 */
	public void setSpcMac(String spcMac) {
		this.spcMac = spcMac;
	}
	
	/**
	 * 已用数量
	 */
	public java.math.BigDecimal getAlReady() {
		return this.alReady;
	}

	/**
	 * 已用数量
	 */
	public void setAlReady(java.math.BigDecimal alReady) {
		this.alReady = alReady;
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
	 * 企业标识
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 企业标识
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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
}
