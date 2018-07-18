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
public class DeliveryProdCrm extends BaseEntity<Long> {

	private static final long serialVersionUID = 1521848090683691046L;

	// ~~~~实体属性
	// 单据号
	@Pattern(regexp="[\\S]{0,20}", message="单据号字段过长")
	private String voucherNo;
	// 交图日期
	private java.util.Date deliveryDate;
	// 寄件地址
	@Pattern(regexp="[\\S]{0,255}", message="寄件地址字段过长")
	private String sendAddress;
	// 发票号码
	@Pattern(regexp="[\\S]{0,30}", message="发票号码字段过长")
	private String invoiceNo;
	// 客户编码
	@Pattern(regexp="[\\S]{0,30}", message="客户编码字段过长")
	private String customNo;
	//  交图人
	@Pattern(regexp="[\\S]{0,30}", message=" 交图人字段过长")
	private String empNo;
	// 总价
	private java.math.BigDecimal total;
	// 备注
	@Pattern(regexp="[\\S]{0,40}", message="备注字段过长")
	private String remark;
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
	 * 交图日期
	 */
	public java.util.Date getDeliveryDate() {
		return this.deliveryDate;
	}

	/**
	 * 交图日期
	 */
	public void setDeliveryDate(java.util.Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	/**
	 * 寄件地址
	 */
	public String getSendAddress() {
		return this.sendAddress;
	}

	/**
	 * 寄件地址
	 */
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	
	/**
	 * 发票号码
	 */
	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	/**
	 * 发票号码
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
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
	 *  交图人
	 */
	public String getEmpNo() {
		return this.empNo;
	}

	/**
	 *  交图人
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	/**
	 * 总价
	 */
	public java.math.BigDecimal getTotal() {
		return this.total;
	}

	/**
	 * 总价
	 */
	public void setTotal(java.math.BigDecimal total) {
		this.total = total;
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
