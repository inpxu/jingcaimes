/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 半成品入库单实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class MidProdInIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 2548809904488348057L;

	// ~~~~实体属性
	// 入库单号
	@Pattern(regexp="[\\s\\S]{0,30}", message="入库单号字段过长")
	private String voucherNo;
	// 入库日期
	private java.util.Date inDate;
	// 入库部门
	@Max(value=9223372036854775807L,message="入库部门字段过长")
	private Long casOrgId;
	// 仓库id
	@Max(value=9223372036854775807L,message="仓库id字段过长")
	private Long storeSetId;
	// 仓储员
	@Pattern(regexp="[\\s\\S]{0,30}", message="仓储员字段过长")
	private String stroeEmpNo;
	// 品检员
	@Pattern(regexp="[\\s\\S]{0,30}", message="品检员字段过长")
	private String checkEmpNo;
	// 入库类型
	@Pattern(regexp="[\\s\\S]{0,10}", message="入库类型字段过长")
	private String inType;
	// 备注
	@Pattern(regexp="[\\s\\S]{0,30}", message="备注字段过长")
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
	 * 入库单号
	 */
	public String getVoucherNo() {
		return this.voucherNo;
	}

	/**
	 * 入库单号
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
	 * 入库部门
	 */
	public Long getCasOrgId() {
		return this.casOrgId;
	}

	/**
	 * 入库部门
	 */
	public void setCasOrgId(Long casOrgId) {
		this.casOrgId = casOrgId;
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
	 * 仓储员
	 */
	public String getStroeEmpNo() {
		return this.stroeEmpNo;
	}

	/**
	 * 仓储员
	 */
	public void setStroeEmpNo(String stroeEmpNo) {
		this.stroeEmpNo = stroeEmpNo;
	}
	
	/**
	 * 品检员
	 */
	public String getCheckEmpNo() {
		return this.checkEmpNo;
	}

	/**
	 * 品检员
	 */
	public void setCheckEmpNo(String checkEmpNo) {
		this.checkEmpNo = checkEmpNo;
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
