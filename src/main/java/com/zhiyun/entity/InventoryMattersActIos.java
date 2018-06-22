/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 盘点表_物料_实际实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class InventoryMattersActIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 1321709764871345344L;

	// ~~~~实体属性
	// 期数
	@Pattern(regexp="[\\s\\S]{0,20}", message="期数字段过长")
	private String periods;
	// 仓库id
	@Max(value=9223372036854775807L,message="仓库id字段过长")
	private Long storeSetId;
	// 物料编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="物料编码字段过长")
	private String mattersNo;
	// 盘点数量
	private java.math.BigDecimal actAmount;
	// 在程数量
	private java.math.BigDecimal proAmount;
	// 单位
	@Pattern(regexp="[\\s\\S]{0,10}", message="单位字段过长")
	private String unit;
	// 盘点日期
	private java.util.Date invenDate;
	// 盘点人
	@Pattern(regexp="[\\s\\S]{0,30}", message="盘点人字段过长")
	private String doEmp;
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
	 * 物料编码
	 */
	public String getMattersNo() {
		return this.mattersNo;
	}

	/**
	 * 物料编码
	 */
	public void setMattersNo(String mattersNo) {
		this.mattersNo = mattersNo;
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
	 * 在程数量
	 */
	public java.math.BigDecimal getProAmount() {
		return this.proAmount;
	}

	/**
	 * 在程数量
	 */
	public void setProAmount(java.math.BigDecimal proAmount) {
		this.proAmount = proAmount;
	}
	
	/**
	 * 单位
	 */
	public String getUnit() {
		return this.unit;
	}

	/**
	 * 单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * 盘点日期
	 */
	public java.util.Date getInvenDate() {
		return this.invenDate;
	}

	/**
	 * 盘点日期
	 */
	public void setInvenDate(java.util.Date invenDate) {
		this.invenDate = invenDate;
	}
	
	/**
	 * 盘点人
	 */
	public String getDoEmp() {
		return this.doEmp;
	}

	/**
	 * 盘点人
	 */
	public void setDoEmp(String doEmp) {
		this.doEmp = doEmp;
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
