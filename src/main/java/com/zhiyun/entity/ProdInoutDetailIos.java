/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 成品进出记录实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class ProdInoutDetailIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 5780212527865854390L;

	// ~~~~实体属性
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 仓库id
	@Max(value=9223372036854775807L,message="仓库id字段过长")
	private Long storeSetId;
	// 作业日期
	private java.util.Date opDate;
	// 数量
	private java.math.BigDecimal amount;
	// 单据号
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据号字段过长")
	private String voucherNo;
	// 作业员
	@Pattern(regexp="[\\s\\S]{0,30}", message="作业员字段过长")
	private String opEmp;
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
	 * 仓库id
	 */
	public Long getStoreSetId() {
		return this.storeSetId;
	}

	/**
	 * 仓库id
	 */
	public void setStoreSetId(Long storeSetId) {
		this.storeSetId = storeSetId;
	}
	
	/**
	 * 作业日期
	 */
	public java.util.Date getOpDate() {
		return this.opDate;
	}

	/**
	 * 作业日期
	 */
	public void setOpDate(java.util.Date opDate) {
		this.opDate = opDate;
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
	 * 作业员
	 */
	public String getOpEmp() {
		return this.opEmp;
	}

	/**
	 * 作业员
	 */
	public void setOpEmp(String opEmp) {
		this.opEmp = opEmp;
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
