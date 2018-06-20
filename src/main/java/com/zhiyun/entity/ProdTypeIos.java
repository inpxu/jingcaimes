/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 产品分类实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class ProdTypeIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 6025515638463033099L;

	// ~~~~实体属性
	// 分类编码
	@Pattern(regexp="[\\s\\S]{0,20}", message="分类编码字段过长")
	private String typeNo;
	// 分类名称
	@Pattern(regexp="[\\s\\S]{0,30}", message="分类名称字段过长")
	private String typeDesc;
	// 企业表示
	@Max(value=9223372036854775807L,message="企业表示字段过长")
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
	 * 分类编码
	 */
	public String getTypeNo() {
		return this.typeNo;
	}

	/**
	 * 分类编码
	 */
	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
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
	 * 企业表示
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 企业表示
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
