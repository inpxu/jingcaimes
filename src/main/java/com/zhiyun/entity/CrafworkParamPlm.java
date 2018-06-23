/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@ApiModel
public class CrafworkParamPlm extends BaseEntity<Long> {

	private static final long serialVersionUID = 4172265043718938056L;

	// ~~~~实体属性
	// 工艺ID
	@Max(value=9223372036854775807L,message="工艺ID字段过长")
	private Long crafworkId;
	// 工艺名称参数
    @Pattern(regexp="[\\s\\S]{0,20}", message="工艺名称参数字段过长")
    private String param;
	// 
	@Max(value=9223372036854775807L,message="字段过长")
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
	 * 工艺ID
	 */
	public Long getCrafworkId() {
		return this.crafworkId;
	}

	/**
	 * 工艺ID
	 */
	public void setCrafworkId(Long crafworkId) {
		this.crafworkId = crafworkId;
	}
	
	/**
	 * 工艺名称参数
	 */
	public String getParam() {
		return this.param;
	}

	/**
	 * 工艺名称参数
	 */
	public void setParam(String param) {
		this.param = param;
	}
	
	/**
	 * 
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
