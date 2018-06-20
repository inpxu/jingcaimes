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
public class JudgeOnlycodeIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 2040154169402488121L;

	// ~~~~实体属性
	// 编号类型
	@Pattern(regexp="[\\s\\S]{0,128}", message="编号类型字段过长")
	private String codeType;
	// 当前编号值
	@Pattern(regexp="[\\s\\S]{0,255}", message="当前编号值字段过长")
	private String nowValue;
	// 企业编号
	@Max(value=9223372036854775807L,message="企业编号字段过长")
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
	 * 编号类型
	 */
	public String getCodeType() {
		return this.codeType;
	}

	/**
	 * 编号类型
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
	/**
	 * 当前编号值
	 */
	public String getNowValue() {
		return this.nowValue;
	}

	/**
	 * 当前编号值
	 */
	public void setNowValue(String nowValue) {
		this.nowValue = nowValue;
	}
	
	/**
	 * 企业编号
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 企业编号
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
