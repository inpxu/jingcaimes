/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 盘点盈亏调整_成品实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class InventoryProdChangeIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 5956104859651765892L;

	// ~~~~实体属性
	// 单据号
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据号字段过长")
	private String voucherNo;
	// 期数
	@Pattern(regexp="[\\s\\S]{0,30}", message="期数字段过长")
	private String periods;
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 表显数量
	private java.math.BigDecimal theAmount;
	// 理论数量
	private java.math.BigDecimal shoAmount;
	// 盘点数量
	private java.math.BigDecimal actAmount;
	// 差异数量
	private java.math.BigDecimal diffAmount;
	// 盈亏说明
	@Pattern(regexp="[\\s\\S]{0,60}", message="盈亏说明字段过长")
	private String reasons;
	// 备注
	@Pattern(regexp="[\\s\\S]{0,60}", message="备注字段过长")
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
	 * 期数
	 */
	public String getPeriods() {
		return this.periods;
	}

	/**
	 * 期数
	 */
	public void setPeriods(String periods) {
		this.periods = periods;
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
	 * 表显数量
	 */
	public java.math.BigDecimal getTheAmount() {
		return this.theAmount;
	}

	/**
	 * 表显数量
	 */
	public void setTheAmount(java.math.BigDecimal theAmount) {
		this.theAmount = theAmount;
	}
	
	/**
	 * 理论数量
	 */
	public java.math.BigDecimal getShoAmount() {
		return this.shoAmount;
	}

	/**
	 * 理论数量
	 */
	public void setShoAmount(java.math.BigDecimal shoAmount) {
		this.shoAmount = shoAmount;
	}
	
	/**
	 * 盘点数量
	 */
	public java.math.BigDecimal getActAmount() {
		return this.actAmount;
	}

	/**
	 * 盘点数量
	 */
	public void setActAmount(java.math.BigDecimal actAmount) {
		this.actAmount = actAmount;
	}
	
	/**
	 * 差异数量
	 */
	public java.math.BigDecimal getDiffAmount() {
		return this.diffAmount;
	}

	/**
	 * 差异数量
	 */
	public void setDiffAmount(java.math.BigDecimal diffAmount) {
		this.diffAmount = diffAmount;
	}
	
	/**
	 * 盈亏说明
	 */
	public String getReasons() {
		return this.reasons;
	}

	/**
	 * 盈亏说明
	 */
	public void setReasons(String reasons) {
		this.reasons = reasons;
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
