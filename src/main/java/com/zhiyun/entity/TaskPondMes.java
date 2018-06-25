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
public class TaskPondMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 6157262498549783742L;

	// ~~~~实体属性
	// 内部订单号
	@Pattern(regexp="[\\s\\S]{0,30}", message="内部订单号字段过长")
	private String insideOrder;
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 工艺id
	@Max(value=9223372036854775807L,message="工艺id字段过长")
	private Long crafworkId;
	// 数量
	private java.math.BigDecimal amount;
	// 计划开始日期
	private java.util.Date planStartdate;
	// 计划工时
	private java.math.BigDecimal planHours;
	// 工艺工价
	private java.math.BigDecimal price;
	// 
	@Pattern(regexp="[\\s\\S]{0,10}", message="字段过长")
	private String status;
	// 描述
	@Pattern(regexp="[\\s\\S]{0,40}", message="描述字段过长")
	private String desc;
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
	 * 计划开始日期
	 */
	public java.util.Date getPlanStartdate() {
		return this.planStartdate;
	}

	/**
	 * 计划开始日期
	 */
	public void setPlanStartdate(java.util.Date planStartdate) {
		this.planStartdate = planStartdate;
	}
	
	/**
	 * 计划工时
	 */
	public java.math.BigDecimal getPlanHours() {
		return this.planHours;
	}

	/**
	 * 计划工时
	 */
	public void setPlanHours(java.math.BigDecimal planHours) {
		this.planHours = planHours;
	}
	
	/**
	 * 工艺工价
	 */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * 工艺工价
	 */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	
	/**
	 * 
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 描述
	 */
	public String getDesc() {
		return this.desc;
	}

	/**
	 * 描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
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
