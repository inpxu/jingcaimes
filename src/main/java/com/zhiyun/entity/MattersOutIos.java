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
public class MattersOutIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 3402646640547303015L;

	// ~~~~实体属性
	// 单据号
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据号字段过长")
	private String voucherNo;
	// 领用日期
	private java.util.Date outDate;
	// 领用部门
	@Max(value=9223372036854775807L,message="领用部门字段过长")
	private Long casOrgId;
	// 仓库id
	@Max(value=9223372036854775807L,message="仓库id字段过长")
	private Long storeSetId;
	// 计划id
	@Max(value=9223372036854775807L,message="计划id字段过长")
	private Long makePlanId;
	// 出库类型
	@Pattern(regexp="[\\s\\S]{0,10}", message="出库类型字段过长")
	private String outType;
	// 仓储员
	@Pattern(regexp="[\\s\\S]{0,30}", message="仓储员字段过长")
	private String storeEmpNo;
	// 物料员
	@Pattern(regexp="[\\s\\S]{0,30}", message="物料员字段过长")
	private String mattersEmpNo;
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
	 * 领用日期
	 */
	public java.util.Date getOutDate() {
		return this.outDate;
	}

	/**
	 * 领用日期
	 */
	public void setOutDate(java.util.Date outDate) {
		this.outDate = outDate;
	}
	
	/**
	 * 领用部门
	 */
	public Long getCasOrgId() {
		return this.casOrgId;
	}

	/**
	 * 领用部门
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
	 * 计划id
	 */
	public Long getMakePlanId() {
		return this.makePlanId;
	}

	/**
	 * 计划id
	 */
	public void setMakePlanId(Long makePlanId) {
		this.makePlanId = makePlanId;
	}
	
	/**
	 * 出库类型
	 */
	public String getOutType() {
		return this.outType;
	}

	/**
	 * 出库类型
	 */
	public void setOutType(String outType) {
		this.outType = outType;
	}
	
	/**
	 * 仓储员
	 */
	public String getStoreEmpNo() {
		return this.storeEmpNo;
	}

	/**
	 * 仓储员
	 */
	public void setStoreEmpNo(String storeEmpNo) {
		this.storeEmpNo = storeEmpNo;
	}
	
	/**
	 * 物料员
	 */
	public String getMattersEmpNo() {
		return this.mattersEmpNo;
	}

	/**
	 * 物料员
	 */
	public void setMattersEmpNo(String mattersEmpNo) {
		this.mattersEmpNo = mattersEmpNo;
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
    @Override
    public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 企业主键
	 */
    @Override
    public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
