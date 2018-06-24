/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 盘点盈亏调整主表实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class InventoryChangeMainIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 5132284746306829404L;

	// ~~~~实体属性
	// 单据号
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据号字段过长")
	private String voucherNo;
	// 仓库id
	@Max(value=9223372036854775807L,message="仓库id字段过长")
	private Long storeSetId;
	// 盘点日期
	private java.util.Date inventoryDate;
	// 是否物料 1:物料 2:成品
	@Pattern(regexp="[\\s\\S]{0,1}", message="是否物料 1:物料 2:成品字段过长")
	private String isMatters;
	// 期数
	@Pattern(regexp="[\\s\\S]{0,30}", message="期数字段过长")
	private String periods;
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
	 * 盘点日期
	 */
	public java.util.Date getInventoryDate() {
		return this.inventoryDate;
	}

	/**
	 * 盘点日期
	 */
	public void setInventoryDate(java.util.Date inventoryDate) {
		this.inventoryDate = inventoryDate;
	}
	
	/**
	 * 是否物料 1:物料 2:成品
	 */
	public String getIsMatters() {
		return this.isMatters;
	}

	/**
	 * 是否物料 1:物料 2:成品
	 */
	public void setIsMatters(String isMatters) {
		this.isMatters = isMatters;
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
