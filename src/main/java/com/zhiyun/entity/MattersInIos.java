/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 物料入库单实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class MattersInIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 1556373261523496138L;

	// ~~~~实体属性
	// 单据号
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据号字段过长")
	private String voucherNo;
	// 入库日期
	private java.util.Date inDate;
	// 仓库id
	@Max(value=9223372036854775807L,message="仓库id字段过长")
	private Long storeSetId;
	// 入库类型
	@Pattern(regexp="[\\s\\S]{0,10}", message="入库类型字段过长")
	private String inType;
	// 仓储员
	@Pattern(regexp="[\\s\\S]{0,30}", message="仓储员字段过长")
	private String storeEmp;
	// 品检员
	@Pattern(regexp="[\\s\\S]{0,30}", message="品检员字段过长")
	private String checkEmp;
	// 备注
	@Pattern(regexp="[\\s\\S]{0,255}", message="备注字段过长")
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
	 * 入库日期
	 */
	public java.util.Date getInDate() {
		return this.inDate;
	}

	/**
	 * 入库日期
	 */
	public void setInDate(java.util.Date inDate) {
		this.inDate = inDate;
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
	 * 入库类型
	 */
	public String getInType() {
		return this.inType;
	}

	/**
	 * 入库类型
	 */
	public void setInType(String inType) {
		this.inType = inType;
	}
	
	/**
	 * 仓储员
	 */
	public String getStoreEmp() {
		return this.storeEmp;
	}

	/**
	 * 仓储员
	 */
	public void setStoreEmp(String storeEmp) {
		this.storeEmp = storeEmp;
	}
	
	/**
	 * 品检员
	 */
	public String getCheckEmp() {
		return this.checkEmp;
	}

	/**
	 * 品检员
	 */
	public void setCheckEmp(String checkEmp) {
		this.checkEmp = checkEmp;
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
