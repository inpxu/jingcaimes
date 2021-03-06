/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class EmpMacRecordMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 7510690919140791750L;

	// ~~~~实体属性
	// 员工姓名
	@Pattern(regexp="[\\s\\S]{0,30}", message="员工姓名字段过长")
	private String empNo;
	// 设备编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="设备编码字段过长")
	private String macNo;
	// 开始时间
	private java.util.Date startTime;
	// 结束时间
	private java.util.Date endTime;
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
	 * 员工姓名
	 */
	public String getEmpNo() {
		return this.empNo;
	}

	/**
	 * 员工姓名
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
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
	 * 开始时间
	 */
	public java.util.Date getStartTime() {
		return this.startTime;
	}

	/**
	 * 开始时间
	 */
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * 结束时间
	 */
	public java.util.Date getEndTime() {
		return this.endTime;
	}

	/**
	 * 结束时间
	 */
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
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
