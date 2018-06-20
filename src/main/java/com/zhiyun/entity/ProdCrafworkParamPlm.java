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
public class ProdCrafworkParamPlm extends BaseEntity<Long> {

	private static final long serialVersionUID = 6576409559770039344L;

	// ~~~~实体属性
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,40}", message="产品编码字段过长")
	private String productNo;
	// 半成品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="半成品编码字段过长")
	private String midProdNo;
	// 工艺id
	@Max(value=9223372036854775807L,message="工艺id字段过长")
	private Long craftworkId;
	// 参数名
	@Max(value=9223372036854775807L,message="参数名字段过长")
	private Long paramId;
	// 参数值1
	@Pattern(regexp="[\\s\\S]{0,20}", message="参数值1字段过长")
	private String value1;
	// 参数值2
	@Pattern(regexp="[\\s\\S]{0,20}", message="参数值2字段过长")
	private String value2;
	// 参数值3
	@Pattern(regexp="[\\s\\S]{0,20}", message="参数值3字段过长")
	private String value3;
	// 参数值4
	@Pattern(regexp="[\\s\\S]{0,20}", message="参数值4字段过长")
	private String value4;
	// 参数值5
	@Pattern(regexp="[\\s\\S]{0,20}", message="参数值5字段过长")
	private String value5;
	// 参数值6
	@Pattern(regexp="[\\s\\S]{0,20}", message="参数值6字段过长")
	private String value6;
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
	 * 产品编码
	 */
	public String getProductNo() {
		return this.productNo;
	}

	/**
	 * 产品编码
	 */
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	
	/**
	 * 半成品编码
	 */
	public String getMidProdNo() {
		return this.midProdNo;
	}

	/**
	 * 半成品编码
	 */
	public void setMidProdNo(String midProdNo) {
		this.midProdNo = midProdNo;
	}
	
	/**
	 * 工艺id
	 */
	public Long getCraftworkId() {
		return this.craftworkId;
	}

	/**
	 * 工艺id
	 */
	public void setCraftworkId(Long craftworkId) {
		this.craftworkId = craftworkId;
	}
	
	/**
	 * 参数名
	 */
	public Long getParamId() {
		return this.paramId;
	}

	/**
	 * 参数名
	 */
	public void setParamId(Long paramId) {
		this.paramId = paramId;
	}
	
	/**
	 * 参数值1
	 */
	public String getValue1() {
		return this.value1;
	}

	/**
	 * 参数值1
	 */
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	
	/**
	 * 参数值2
	 */
	public String getValue2() {
		return this.value2;
	}

	/**
	 * 参数值2
	 */
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	
	/**
	 * 参数值3
	 */
	public String getValue3() {
		return this.value3;
	}

	/**
	 * 参数值3
	 */
	public void setValue3(String value3) {
		this.value3 = value3;
	}
	
	/**
	 * 参数值4
	 */
	public String getValue4() {
		return this.value4;
	}

	/**
	 * 参数值4
	 */
	public void setValue4(String value4) {
		this.value4 = value4;
	}
	
	/**
	 * 参数值5
	 */
	public String getValue5() {
		return this.value5;
	}

	/**
	 * 参数值5
	 */
	public void setValue5(String value5) {
		this.value5 = value5;
	}
	
	/**
	 * 参数值6
	 */
	public String getValue6() {
		return this.value6;
	}

	/**
	 * 参数值6
	 */
	public void setValue6(String value6) {
		this.value6 = value6;
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
