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
public class TaskReceiveEmpMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 3796132919619626405L;

	// ~~~~实体属性
	// 内部订单号
	@Pattern(regexp="[\\s\\S]{0,20}", message="内部订单号字段过长")
	private String insideOrder;
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 工艺id
	@Max(value=9223372036854775807L,message="工艺id字段过长")
	private Long crafworkId;
	// 执行人
	@Pattern(regexp="[\\s\\S]{0,30}", message="执行人字段过长")
	private String doEmpNo;
	// 实际日期
	private java.util.Date actDate;
	// 计划开始日期
	private java.util.Date planDate;
	// 实际工时
	private java.math.BigDecimal actHours;
	// 数量
	private java.math.BigDecimal amount;
	// 任务状态
	@Pattern(regexp="[\\s\\S]{0,1}", message="任务状态字段过长")
	private String status;
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
}
