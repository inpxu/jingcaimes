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
public class TaskEmpAps extends BaseEntity<Long> {

	private static final long serialVersionUID = 1339065741278810749L;

	// ~~~~实体属性
	// 设备编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="设备编码字段过长")
	private String macNo;
	// 班组编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="班组编码字段过长")
	private String groupNo;
	// 作业时间
	private java.util.Date taskDate;
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 半产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="半产品编码字段过长")
	private String midProdNo;
	// 生产批次
	@Pattern(regexp="[\\s\\S]{0,30}", message="生产批次字段过长")
	private String prodBatch;
	// 开始时间
	private java.util.Date starTime;
	// 结束时间
	private java.util.Date endTime;
	// 工艺id
	@Pattern(regexp="[\\s\\S]{0,20}", message="工艺id字段过长")
	private String crafworkId;
	// 数量
	@Max(value=9223372036854775807L,message="数量字段过长")
	private Long amount;
	// 工艺要求
	@Pattern(regexp="[\\s\\S]{0,100}", message="工艺要求字段过长")
	private String require;
	// 备注
	@Pattern(regexp="[\\s\\S]{0,100}", message="备注字段过长")
	private String remark;
	// 工作状态
	@Pattern(regexp="[\\s\\S]{0,20}", message="工作状态字段过长")
	private String workStatus;
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
	 * 班组编码
	 */
	public String getGroupNo() {
		return this.groupNo;
	}

	/**
	 * 班组编码
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	
	/**
	 * 作业时间
	 */
	public java.util.Date getTaskDate() {
		return this.taskDate;
	}

	/**
	 * 作业时间
	 */
	public void setTaskDate(java.util.Date taskDate) {
		this.taskDate = taskDate;
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
	 * 生产批次
	 */
	public String getProdBatch() {
		return this.prodBatch;
	}

	/**
	 * 生产批次
	 */
	public void setProdBatch(String prodBatch) {
		this.prodBatch = prodBatch;
	}
	
	/**
	 * 开始时间
	 */
	public java.util.Date getStarTime() {
		return this.starTime;
	}

	/**
	 * 开始时间
	 */
	public void setStarTime(java.util.Date starTime) {
		this.starTime = starTime;
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
	 * 工艺id
	 */
	public String getCrafworkId() {
		return this.crafworkId;
	}

	/**
	 * 工艺id
	 */
	public void setCrafworkId(String crafworkId) {
		this.crafworkId = crafworkId;
	}
	
	/**
	 * 数量
	 */
	public Long getAmount() {
		return this.amount;
	}

	/**
	 * 数量
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	/**
	 * 工艺要求
	 */
	public String getRequire() {
		return this.require;
	}

	/**
	 * 工艺要求
	 */
	public void setRequire(String require) {
		this.require = require;
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
	 * 工作状态
	 */
	public String getWorkStatus() {
		return this.workStatus;
	}

	/**
	 * 工作状态
	 */
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
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
