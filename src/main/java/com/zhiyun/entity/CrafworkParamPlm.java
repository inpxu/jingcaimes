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
public class CrafworkParamPlm extends BaseEntity<Long> {

	private static final long serialVersionUID = 3866555914745518064L;

	// ~~~~实体属性
	// 工艺ID
	@Max(value=9223372036854775807L,message="工艺ID字段过长")
	private Long crafworkId;
	// 工艺名称参数
	@Pattern(regexp="[\\s\\S]{0,20}", message="工艺名称参数字段过长")
	private String paramName;
	// 
	@Max(value=9223372036854775807L,message="字段过长")
	private Long companyId;
	// 
	@Pattern(regexp="[\\s\\S]{0,30}", message="字段过长")
	private String prodNo;
	// 
	@Pattern(regexp="[\\s\\S]{0,30}", message="字段过长")
	private String midProdNo;
	// 
	@Pattern(regexp="[\\s\\S]{0,20}", message="字段过长")
	private String values1;
	// 
	@Pattern(regexp="[\\s\\S]{0,20}", message="字段过长")
	private String values2;
	// 
	@Pattern(regexp="[\\s\\S]{0,20}", message="字段过长")
	private String values3;
	// 
	@Pattern(regexp="[\\s\\S]{0,20}", message="字段过长")
	private String values4;
	// 
	@Pattern(regexp="[\\s\\S]{0,20}", message="字段过长")
	private String values5;
	// 
	@Pattern(regexp="[\\s\\S]{0,20}", message="字段过长")
	private String values6;

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
	public String getParamName() {
		return this.paramName;
	}

	/**
	 * 工艺名称参数
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
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
	
	/**
	 * 
	 */
	public String getProdNo() {
		return this.prodNo;
	}

	/**
	 * 
	 */
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	
	/**
	 * 
	 */
	public String getMidProdNo() {
		return this.midProdNo;
	}

	/**
	 * 
	 */
	public void setMidProdNo(String midProdNo) {
		this.midProdNo = midProdNo;
	}
	
	/**
	 * 
	 */
	public String getValues1() {
		return this.values1;
	}

	/**
	 * 
	 */
	public void setValues1(String values1) {
		this.values1 = values1;
	}
	
	/**
	 * 
	 */
	public String getValues2() {
		return this.values2;
	}

	/**
	 * 
	 */
	public void setValues2(String values2) {
		this.values2 = values2;
	}
	
	/**
	 * 
	 */
	public String getValues3() {
		return this.values3;
	}

	/**
	 * 
	 */
	public void setValues3(String values3) {
		this.values3 = values3;
	}
	
	/**
	 * 
	 */
	public String getValues4() {
		return this.values4;
	}

	/**
	 * 
	 */
	public void setValues4(String values4) {
		this.values4 = values4;
	}
	
	/**
	 * 
	 */
	public String getValues5() {
		return this.values5;
	}

	/**
	 * 
	 */
	public void setValues5(String values5) {
		this.values5 = values5;
	}
	
	/**
	 * 
	 */
	public String getValues6() {
		return this.values6;
	}

	/**
	 * 
	 */
	public void setValues6(String values6) {
		this.values6 = values6;
	}
}
