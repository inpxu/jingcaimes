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
public class LoadingRecMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 2115183100715361825L;

	// ~~~~实体属性
	// 设备编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="设备编码字段过长")
	private String macNo;
	// 上料位置
	@Pattern(regexp="[\\s\\S]{0,30}", message="上料位置字段过长")
	private String loadPosition;
	// 上料时间
	private java.util.Date loadTime;
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 半产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="半产品编码字段过长")
	private String midProdNo;
	// 数量
	private java.math.BigDecimal amount;
	// 上料人
	@Pattern(regexp="[\\s\\S]{0,30}", message="上料人字段过长")
	private String doEmp;
	// 描述
	@Pattern(regexp="[\\s\\S]{0,60}", message="描述字段过长")
	private String remark;
	// 企业标识
	@Max(value=9223372036854775807L,message="企业标识字段过长")
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
	 * 上料位置
	 */
	public String getLoadPosition() {
		return this.loadPosition;
	}

	/**
	 * 上料位置
	 */
	public void setLoadPosition(String loadPosition) {
		this.loadPosition = loadPosition;
	}
	
	/**
	 * 上料时间
	 */
	public java.util.Date getLoadTime() {
		return this.loadTime;
	}

	/**
	 * 上料时间
	 */
	public void setLoadTime(java.util.Date loadTime) {
		this.loadTime = loadTime;
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
	 * 上料人
	 */
	public String getDoEmp() {
		return this.doEmp;
	}

	/**
	 * 上料人
	 */
	public void setDoEmp(String doEmp) {
		this.doEmp = doEmp;
	}
	
	/**
	 * 描述
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 描述
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
}
