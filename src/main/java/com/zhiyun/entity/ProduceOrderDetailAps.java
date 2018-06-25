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
public class ProduceOrderDetailAps extends BaseEntity<Long> {

	private static final long serialVersionUID = 5326834152174949190L;

	// ~~~~实体属性
	// 单据号
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据号字段过长")
	private String voucherNo;
	// 内部订单号
	@Pattern(regexp="[\\s\\S]{0,30}", message="内部订单号字段过长")
	private String insideOrder;
	// 产品编号
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编号字段过长")
	private String prodNo;
	// 生产方式
	@Pattern(regexp="[\\s\\S]{0,1}", message="生产方式字段过长")
	private String produceStyle;
	// 数量
	private java.math.BigDecimal amount;
	// 内部单价
	private java.math.BigDecimal price;
	// 下单日期
	private java.util.Date voucherDate;
	// 最早交货日期
	private java.util.Date firstDate;
	// 最晚交互日期
	private java.util.Date needDate;
	// 状态0待派中\1进行中\2已完成
	@Pattern(regexp="[\\s\\S]{0,1}", message="状态0待派中\1进行中\2已完成字段过长")
	private String status;
	// 已计划数量
	private java.math.BigDecimal alPlanamount;
	// 已交货数量
	private java.math.BigDecimal okAmount;
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
	 * 单据号
	 */
	public String getVoucherNo() {
		return this.voucherNo;
	}

	/**
	 * 单据号
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
	 * 产品编号
	 */
	public String getProdNo() {
		return this.prodNo;
	}

	/**
	 * 产品编号
	 */
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	
	/**
	 * 生产方式
	 */
	public String getProduceStyle() {
		return this.produceStyle;
	}

	/**
	 * 生产方式
	 */
	public void setProduceStyle(String produceStyle) {
		this.produceStyle = produceStyle;
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
	 * 内部单价
	 */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * 内部单价
	 */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
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
	 * 最早交货日期
	 */
	public java.util.Date getFirstDate() {
		return this.firstDate;
	}

	/**
	 * 最早交货日期
	 */
	public void setFirstDate(java.util.Date firstDate) {
		this.firstDate = firstDate;
	}
	
	/**
	 * 最晚交互日期
	 */
	public java.util.Date getNeedDate() {
		return this.needDate;
	}

	/**
	 * 最晚交互日期
	 */
	public void setNeedDate(java.util.Date needDate) {
		this.needDate = needDate;
	}
	
	/**
	 * 状态0待派中\1进行中\2已完成
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 状态0待派中\1进行中\2已完成
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 已计划数量
	 */
	public java.math.BigDecimal getAlPlanamount() {
		return this.alPlanamount;
	}

	/**
	 * 已计划数量
	 */
	public void setAlPlanamount(java.math.BigDecimal alPlanamount) {
		this.alPlanamount = alPlanamount;
	}
	
	/**
	 * 已交货数量
	 */
	public java.math.BigDecimal getOkAmount() {
		return this.okAmount;
	}

	/**
	 * 已交货数量
	 */
	public void setOkAmount(java.math.BigDecimal okAmount) {
		this.okAmount = okAmount;
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
