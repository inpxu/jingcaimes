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
public class ProdTypeCrm extends BaseEntity<Long> {

	private static final long serialVersionUID = 4497983529611218641L;

	// ~~~~实体属性
	// 分类名称
	@Pattern(regexp="[\\s\\S]{0,30}", message="分类名称字段过长")
	private String typeDesc;
	// 开始日期
	private java.util.Date startDate;
	// 失效日期
	private java.util.Date loseDate;
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
	 * 分类名称
	 */
	public String getTypeDesc() {
		return this.typeDesc;
	}

	/**
	 * 分类名称
	 */
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
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
	 * 失效日期
	 */
	public java.util.Date getLoseDate() {
		return this.loseDate;
	}

	/**
	 * 失效日期
	 */
	public void setLoseDate(java.util.Date loseDate) {
		this.loseDate = loseDate;
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
