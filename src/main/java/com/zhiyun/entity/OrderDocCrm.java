/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 订单库实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class OrderDocCrm extends BaseEntity<Long> {

	private static final long serialVersionUID = 6554732456110775227L;

	// ~~~~实体属性
	// 订单号
	@Pattern(regexp="[\\s\\S]{0,30}", message="订单号字段过长")
	private String orderNo;
	// 单据号
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据号字段过长")
	private String voucherNo;
	// 签单日期
	private java.util.Date signDate;
	// 客户id
	@Max(value=9223372036854775807L,message="客户id字段过长")
	private Long customId;
	// 签单业务员工号
	@Pattern(regexp="[\\s\\S]{0,30}", message="签单业务员工号字段过长")
	private String empNo;
	// 签单经理
	@Pattern(regexp="[\\s\\S]{0,30}", message="签单经理字段过长")
	private String manager;
	// 区域id
	@Max(value=9223372036854775807L,message="区域id字段过长")
	private Long areaSetId;
	// 出货地址
	@Pattern(regexp="[\\s\\S]{0,150}", message="出货地址字段过长")
	private String outAddress;
	// 联系电话
	@Pattern(regexp="[\\s\\S]{0,16}", message="联系电话字段过长")
	private String phone;
	// 交货日期
	private java.util.Date orderDate;
	// 订单版本号
	@Pattern(regexp="[\\s\\S]{0,10}", message="订单版本号字段过长")
	private String orderVersion;
	// 结款方式
	@Max(value=99999999999L,message="结款方式字段过长")
	private Integer payStyle;
	// 对应销售计划
	@Max(value=99999999999L,message="对应销售计划字段过长")
	private Integer salePlan;
	// 订单来源
	@Pattern(regexp="[\\s\\S]{0,20}", message="订单来源字段过长")
	private String orderSource;
	// 收货人
	@Pattern(regexp="[\\s\\S]{0,30}", message="收货人字段过长")
	private String sendee;
	// 订单状态
	@Pattern(regexp="[\\s\\S]{0,20}", message="订单状态字段过长")
	private String orderStatus;
	// 信用加权
	private java.math.BigDecimal creditJudge;
	// 业务员加权
	private java.math.BigDecimal saleJudge;
	// 总共优惠
	private java.math.BigDecimal totalFavour;
	// 税率
	private java.math.BigDecimal tax;
	// 订单总价
	private java.math.BigDecimal orderTotal;
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
	 * 订单号
	 */
	public String getOrderNo() {
		return this.orderNo;
	}

	/**
	 * 订单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
	 * 签单日期
	 */
	public java.util.Date getSignDate() {
		return this.signDate;
	}

	/**
	 * 签单日期
	 */
	public void setSignDate(java.util.Date signDate) {
		this.signDate = signDate;
	}
	
	/**
	 * 客户id
	 */
	public Long getCustomId() {
		return this.customId;
	}

	/**
	 * 客户id
	 */
	public void setCustomId(Long customId) {
		this.customId = customId;
	}
	
	/**
	 * 签单业务员工号
	 */
	public String getEmpNo() {
		return this.empNo;
	}

	/**
	 * 签单业务员工号
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	/**
	 * 签单经理
	 */
	public String getManager() {
		return this.manager;
	}

	/**
	 * 签单经理
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	/**
	 * 区域id
	 */
	public Long getAreaSetId() {
		return this.areaSetId;
	}

	/**
	 * 区域id
	 */
	public void setAreaSetId(Long areaSetId) {
		this.areaSetId = areaSetId;
	}
	
	/**
	 * 出货地址
	 */
	public String getOutAddress() {
		return this.outAddress;
	}

	/**
	 * 出货地址
	 */
	public void setOutAddress(String outAddress) {
		this.outAddress = outAddress;
	}
	
	/**
	 * 联系电话
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 交货日期
	 */
	public java.util.Date getOrderDate() {
		return this.orderDate;
	}

	/**
	 * 交货日期
	 */
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}
	
	/**
	 * 订单版本号
	 */
	public String getOrderVersion() {
		return this.orderVersion;
	}

	/**
	 * 订单版本号
	 */
	public void setOrderVersion(String orderVersion) {
		this.orderVersion = orderVersion;
	}
	
	/**
	 * 结款方式
	 */
	public Integer getPayStyle() {
		return this.payStyle;
	}

	/**
	 * 结款方式
	 */
	public void setPayStyle(Integer payStyle) {
		this.payStyle = payStyle;
	}
	
	/**
	 * 对应销售计划
	 */
	public Integer getSalePlan() {
		return this.salePlan;
	}

	/**
	 * 对应销售计划
	 */
	public void setSalePlan(Integer salePlan) {
		this.salePlan = salePlan;
	}
	
	/**
	 * 订单来源
	 */
	public String getOrderSource() {
		return this.orderSource;
	}

	/**
	 * 订单来源
	 */
	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}
	
	/**
	 * 收货人
	 */
	public String getSendee() {
		return this.sendee;
	}

	/**
	 * 收货人
	 */
	public void setSendee(String sendee) {
		this.sendee = sendee;
	}
	
	/**
	 * 订单状态
	 */
	public String getOrderStatus() {
		return this.orderStatus;
	}

	/**
	 * 订单状态
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	/**
	 * 信用加权
	 */
	public java.math.BigDecimal getCreditJudge() {
		return this.creditJudge;
	}

	/**
	 * 信用加权
	 */
	public void setCreditJudge(java.math.BigDecimal creditJudge) {
		this.creditJudge = creditJudge;
	}
	
	/**
	 * 业务员加权
	 */
	public java.math.BigDecimal getSaleJudge() {
		return this.saleJudge;
	}

	/**
	 * 业务员加权
	 */
	public void setSaleJudge(java.math.BigDecimal saleJudge) {
		this.saleJudge = saleJudge;
	}
	
	/**
	 * 总共优惠
	 */
	public java.math.BigDecimal getTotalFavour() {
		return this.totalFavour;
	}

	/**
	 * 总共优惠
	 */
	public void setTotalFavour(java.math.BigDecimal totalFavour) {
		this.totalFavour = totalFavour;
	}
	
	/**
	 * 税率
	 */
	public java.math.BigDecimal getTax() {
		return this.tax;
	}

	/**
	 * 税率
	 */
	public void setTax(java.math.BigDecimal tax) {
		this.tax = tax;
	}
	
	/**
	 * 订单总价
	 */
	public java.math.BigDecimal getOrderTotal() {
		return this.orderTotal;
	}

	/**
	 * 订单总价
	 */
	public void setOrderTotal(java.math.BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
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
