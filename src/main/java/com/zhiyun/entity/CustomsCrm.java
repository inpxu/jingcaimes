/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 客户信息表(客户公海)实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class CustomsCrm extends BaseEntity<Long> {

	private static final long serialVersionUID = 3874355736033916086L;

	// ~~~~实体属性
	// 客户编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="客户编码字段过长")
	private String customNo;
	// 客户名称
	@Pattern(regexp="[\\s\\S]{0,40}", message="客户名称字段过长")
	private String customName;
	// 分销类型id
	@Max(value=9223372036854775807L,message="分销类型id字段过长")
	private Long pipingTypeId;
	// 合作类型
	@Pattern(regexp="[\\s\\S]{0,20}", message="合作类型字段过长")
	private String customType;
	// 行业
	@Pattern(regexp="[\\s\\S]{0,10}", message="行业字段过长")
	private String trade;
	// 经营地址
	@Pattern(regexp="[\\s\\S]{0,40}", message="经营地址字段过长")
	private String address;
	// 投资规模
	@Pattern(regexp="[\\s\\S]{0,16}", message="投资规模字段过长")
	private String scale;
	// 投资类型
	@Pattern(regexp="[\\s\\S]{0,16}", message="投资类型字段过长")
	private String investStruct;
	// 雇员数
	@Max(value=99999999999L,message="雇员数字段过长")
	private Integer employees;
	// 工商登记日期
	private java.util.Date regisiterDate;
	// 法人代表
	@Pattern(regexp="[\\s\\S]{0,30}", message="法人代表字段过长")
	private String bossName;
	// 实际控制人
	@Pattern(regexp="[\\s\\S]{0,30}", message="实际控制人字段过长")
	private String actPower;
	// 工商登记号
	@Pattern(regexp="[\\s\\S]{0,30}", message="工商登记号字段过长")
	private String licenseNo;
	// 税号
	@Pattern(regexp="[\\s\\S]{0,30}", message="税号字段过长")
	private String taxationNo;
	// 经营范围
	@Pattern(regexp="[\\s\\S]{0,160}", message="经营范围字段过长")
	private String dealRange;
	// 是否信用加权
	private Boolean isCredit;
	// 预警周期
	@Max(value=99999999999L,message="预警周期字段过长")
	private Integer waringTime;
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
	 * 客户编码
	 */
	public String getCustomNo() {
		return this.customNo;
	}

	/**
	 * 客户编码
	 */
	public void setCustomNo(String customNo) {
		this.customNo = customNo;
	}
	
	/**
	 * 客户名称
	 */
	public String getCustomName() {
		return this.customName;
	}

	/**
	 * 客户名称
	 */
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	
	/**
	 * 分销类型id
	 */
	public Long getPipingTypeId() {
		return this.pipingTypeId;
	}

	/**
	 * 分销类型id
	 */
	public void setPipingTypeId(Long pipingTypeId) {
		this.pipingTypeId = pipingTypeId;
	}
	
	/**
	 * 合作类型
	 */
	public String getCustomType() {
		return this.customType;
	}

	/**
	 * 合作类型
	 */
	public void setCustomType(String customType) {
		this.customType = customType;
	}
	
	/**
	 * 行业
	 */
	public String getTrade() {
		return this.trade;
	}

	/**
	 * 行业
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * 经营地址
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * 经营地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 投资规模
	 */
	public String getScale() {
		return this.scale;
	}

	/**
	 * 投资规模
	 */
	public void setScale(String scale) {
		this.scale = scale;
	}
	
	/**
	 * 投资类型
	 */
	public String getInvestStruct() {
		return this.investStruct;
	}

	/**
	 * 投资类型
	 */
	public void setInvestStruct(String investStruct) {
		this.investStruct = investStruct;
	}
	
	/**
	 * 雇员数
	 */
	public Integer getEmployees() {
		return this.employees;
	}

	/**
	 * 雇员数
	 */
	public void setEmployees(Integer employees) {
		this.employees = employees;
	}
	
	/**
	 * 工商登记日期
	 */
	public java.util.Date getRegisiterDate() {
		return this.regisiterDate;
	}

	/**
	 * 工商登记日期
	 */
	public void setRegisiterDate(java.util.Date regisiterDate) {
		this.regisiterDate = regisiterDate;
	}
	
	/**
	 * 法人代表
	 */
	public String getBossName() {
		return this.bossName;
	}

	/**
	 * 法人代表
	 */
	public void setBossName(String bossName) {
		this.bossName = bossName;
	}
	
	/**
	 * 实际控制人
	 */
	public String getActPower() {
		return this.actPower;
	}

	/**
	 * 实际控制人
	 */
	public void setActPower(String actPower) {
		this.actPower = actPower;
	}
	
	/**
	 * 工商登记号
	 */
	public String getLicenseNo() {
		return this.licenseNo;
	}

	/**
	 * 工商登记号
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	/**
	 * 税号
	 */
	public String getTaxationNo() {
		return this.taxationNo;
	}

	/**
	 * 税号
	 */
	public void setTaxationNo(String taxationNo) {
		this.taxationNo = taxationNo;
	}
	
	/**
	 * 经营范围
	 */
	public String getDealRange() {
		return this.dealRange;
	}

	/**
	 * 经营范围
	 */
	public void setDealRange(String dealRange) {
		this.dealRange = dealRange;
	}
	
	/**
	 * 是否信用加权
	 */
	public Boolean getIsCredit() {
		return this.isCredit;
	}

	/**
	 * 是否信用加权
	 */
	public void setIsCredit(Boolean isCredit) {
		this.isCredit = isCredit;
	}
	
	/**
	 * 预警周期
	 */
	public Integer getWaringTime() {
		return this.waringTime;
	}

	/**
	 * 预警周期
	 */
	public void setWaringTime(Integer waringTime) {
		this.waringTime = waringTime;
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
