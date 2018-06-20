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
public class EmpBarcodeMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 5288825155544540049L;

	// ~~~~实体属性
	// 员工工号
	@Pattern(regexp="[\\s\\S]{0,30}", message="员工工号字段过长")
	private String empNo;
	// 条形码
	@Pattern(regexp="[\\s\\S]{0,30}", message="条形码字段过长")
	private String barcode;
	// 二维码
	@Pattern(regexp="[\\s\\S]{0,100}", message="二维码字段过长")
	private String qrcode;
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
	 * 员工工号
	 */
	public String getEmpNo() {
		return this.empNo;
	}

	/**
	 * 员工工号
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	/**
	 * 条形码
	 */
	public String getBarcode() {
		return this.barcode;
	}

	/**
	 * 条形码
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	/**
	 * 二维码
	 */
	public String getQrcode() {
		return this.qrcode;
	}

	/**
	 * 二维码
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
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
