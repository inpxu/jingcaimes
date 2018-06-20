/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 盘点表_物料_应存实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class InventoryMattersIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 1702615641818039827L;

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
	// 开始日期
	private java.util.Date startDate;
	// 结束日期
	private java.util.Date endDate;
	// 表显数量
	private java.math.BigDecimal theAmount;
	// 理论数量
	private java.math.BigDecimal shoAmount;
	// 单位
	@Pattern(regexp="[\\s\\S]{0,10}", message="单位字段过长")
	private String unit;
	// 描述
	@Pattern(regexp="[\\s\\S]{0,80}", message="描述字段过长")
	private String desc;
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
	 * 开始日期
	 */
	public java.util.Date getStartDate() {
		return this.startDate;
	}

	/**
	 * 开始日期
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * 结束日期
	 */
	public java.util.Date getEndDate() {
		return this.endDate;
	}

	/**
	 * 结束日期
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
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
	 * 描述
	 */
	public String getDesc() {
		return this.desc;
	}

	/**
	 * 描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
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
