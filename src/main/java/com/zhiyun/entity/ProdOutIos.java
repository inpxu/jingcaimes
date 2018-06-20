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
public class ProdOutIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 5034274559898446195L;

	// ~~~~实体属性
	// 领用单号
	@Pattern(regexp="[\\s\\S]{0,30}", message="领用单号字段过长")
	private String voucherNo;
	// 领用日期
	private java.util.Date inDate;
	// 领用部门
	@Max(value=9223372036854775807L,message="领用部门字段过长")
	private Long casOrgId;
	// 领用人
	@Pattern(regexp="[\\s\\S]{0,60}", message="领用人字段过长")
	private String useEmpNo;
	// 仓库id
	@Max(value=9223372036854775807L,message="仓库id字段过长")
	private Long stroeSetId;
	// 仓储员
	@Pattern(regexp="[\\s\\S]{0,30}", message="仓储员字段过长")
	private String stroeEmp;
	// 出库类型
	@Pattern(regexp="[\\s\\S]{0,10}", message="出库类型字段过长")
	private String outType;
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
	 * 领用单号
	 */
	public String getVoucherNo() {
		return this.voucherNo;
	}

	/**
	 * 领用单号
	 */
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	
	/**
	 * 领用日期
	 */
	public java.util.Date getInDate() {
		return this.inDate;
	}

	/**
	 * 领用日期
	 */
	public void setInDate(java.util.Date inDate) {
		this.inDate = inDate;
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
	 * 领用人
	 */
	public String getUseEmpNo() {
		return this.useEmpNo;
	}

	/**
	 * 领用人
	 */
	public void setUseEmpNo(String useEmpNo) {
		this.useEmpNo = useEmpNo;
	}
	
	/**
	 * 仓库id
	 */
	public Long getStroeSetId() {
		return this.stroeSetId;
	}

	/**
	 * 仓库id
	 */
	public void setStroeSetId(Long stroeSetId) {
		this.stroeSetId = stroeSetId;
	}
	
	/**
	 * 仓储员
	 */
	public String getStroeEmp() {
		return this.stroeEmp;
	}

	/**
	 * 仓储员
	 */
	public void setStroeEmp(String stroeEmp) {
		this.stroeEmp = stroeEmp;
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
