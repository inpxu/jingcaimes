/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class TaskReceiveEmpMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 1852443165512999787L;

	// ~~~~实体属性
	// 内部订单号
	@Pattern(regexp="[\\S]{0,20}", message="内部订单号字段过长")
	private String insideOrder;
	// 产品编码
	@Pattern(regexp="[\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 工艺id
	@Max(value=9223372036854775807L,message="工艺id字段过长")
	private Long crafworkId;
	// 领取任务时间
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date getTime;
	// 执行人
	@Pattern(regexp="[\\S]{0,30}", message="执行人字段过长")
	private String doEmpNo;
	// 实际日期
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date actDate;
	// 计划开始日期
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date planDate;
	// 实际工时
	private java.math.BigDecimal actHours;
	// 数量
	private java.math.BigDecimal amount;
	// 任务状态
	@Pattern(regexp="[\\S]{0,1}", message="任务状态字段过长")
	private String status;
	// 企业标识
	@Max(value=9223372036854775807L,message="企业标识字段过长")
	private Long companyId;
	// 
	private java.math.BigDecimal price;
	// 
	@Max(value=9223372036854775807L,message="字段过长")
	private Long taskPondId;

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	/**
	 * 内部订单号
	 */
	public String getInsideOrder() {
		return this.insideOrder;
	}

	/**
	 * 内部订单号
	 */
	public void setInsideOrder(String insideOrder) {
		this.insideOrder = insideOrder;
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
	 * 工艺id
	 */
	public Long getCrafworkId() {
		return this.crafworkId;
	}

	/**
	 * 工艺id
	 */
	public void setCrafworkId(Long crafworkId) {
		this.crafworkId = crafworkId;
	}
	
	/**
	 * 领取任务时间
	 */
	public java.util.Date getGetTime() {
		return this.getTime;
	}

	/**
	 * 领取任务时间
	 */
	public void setGetTime(java.util.Date getTime) {
		this.getTime = getTime;
	}
	
	/**
	 * 执行人
	 */
	public String getDoEmpNo() {
		return this.doEmpNo;
	}

	/**
	 * 执行人
	 */
	public void setDoEmpNo(String doEmpNo) {
		this.doEmpNo = doEmpNo;
	}
	
	/**
	 * 实际日期
	 */
	public java.util.Date getActDate() {
		return this.actDate;
	}

	/**
	 * 实际日期
	 */
	public void setActDate(java.util.Date actDate) {
		this.actDate = actDate;
	}
	
	/**
	 * 计划开始日期
	 */
	public java.util.Date getPlanDate() {
		return this.planDate;
	}

	/**
	 * 计划开始日期
	 */
	public void setPlanDate(java.util.Date planDate) {
		this.planDate = planDate;
	}
	
	/**
	 * 实际工时
	 */
	public java.math.BigDecimal getActHours() {
		return this.actHours;
	}

	/**
	 * 实际工时
	 */
	public void setActHours(java.math.BigDecimal actHours) {
		this.actHours = actHours;
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
	 * 任务状态
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 任务状态
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * 
	 */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * 
	 */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	
	/**
	 * 
	 */
	public Long getTaskPondId() {
		return this.taskPondId;
	}

	/**
	 * 
	 */
	public void setTaskPondId(Long taskPondId) {
		this.taskPondId = taskPondId;
	}
}
