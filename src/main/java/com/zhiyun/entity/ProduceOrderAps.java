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
public class ProduceOrderAps extends BaseEntity<Long> {

	private static final long serialVersionUID = 1857915680073809674L;

	// ~~~~实体属性
	// 订单号
	@Pattern(regexp="[\\s\\S]{0,30}", message="订单号字段过长")
	private String voucherNo;
	// 内部订单号
	@Pattern(regexp="[\\s\\S]{0,30}", message="内部订单号字段过长")
	private String insideOrder;
	// 下单日期
	private java.util.Date voucherDate;
	// 生产部门
	@Max(value=9223372036854775807L,message="生产部门字段过长")
	private Long orgId;
	// 企业主键
	@Max(value=9223372036854775807L,message="企业主键字段过长")
	private Long companyId;
	// 订单来源/0销售订单\1销售预测\2库存要求
	@Pattern(regexp="[\\s\\S]{0,10}", message="订单来源/0销售订单\1销售预测\2库存要求字段过长")
	private String orderSource;
	// 
	@Pattern(regexp="[\\s\\S]{0,30}", message="字段过长")
	private String customNo;
	// 销售订单号
	@Pattern(regexp="[\\s\\S]{0,30}", message="销售订单号字段过长")
	private String orderNo;



	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	/**
	 * 订单号
	 */
	public String getVoucherNo() {
		return this.voucherNo;
	}

	/**
	 * 订单号
	 */
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
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
	 * 下单日期
	 */
	public java.util.Date getVoucherDate() {
		return this.voucherDate;
	}

	/**
	 * 下单日期
	 */
	public void setVoucherDate(java.util.Date voucherDate) {
		this.voucherDate = voucherDate;
	}
	
	/**
	 * 生产部门
	 */
	public Long getOrgId() {
		return this.orgId;
	}

	/**
	 * 生产部门
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
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
	
	/**
	 * 订单来源/0销售订单\1销售预测\2库存要求
	 */
	public String getOrderSource() {
		return this.orderSource;
	}

	/**
	 * 订单来源/0销售订单\1销售预测\2库存要求
	 */
	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}
	
	/**
	 * 
	 */
	public String getCustomNo() {
		return this.customNo;
	}

	/**
	 * 
	 */
	public void setCustomNo(String customNo) {
		this.customNo = customNo;
	}
	
	/**
	 * 销售订单号
	 */
	public String getOrderNo() {
		return this.orderNo;
	}

	/**
	 * 销售订单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
}
