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
public class ProductMidIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 4900712843262849841L;

	// ~~~~实体属性
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 产品名称
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品名称字段过长")
	private String prodName;
	// 半成品编码
	@Pattern(regexp="[\\s\\S]{0,40}", message="半成品编码字段过长")
	private String midProdNo;
	// 
	@Pattern(regexp="[\\s\\S]{0,40}", message="字段过长")
	private String parentNo;
	// 数量
	private java.math.BigDecimal amount;
	// 规格
	@Pattern(regexp="[\\s\\S]{0,40}", message="规格字段过长")
	private String norms;
	// 参数
	@Pattern(regexp="[\\s\\S]{0,400}", message="参数字段过长")
	private String param;
	// 型号
	@Pattern(regexp="[\\s\\S]{0,30}", message="型号字段过长")
	private String modelDesc;
	// 所属工艺
	@Pattern(regexp="[\\s\\S]{0,20}", message="所属工艺字段过长")
	private String crafworkStructId;
	// 计量单位
	@Pattern(regexp="[\\s\\S]{0,20}", message="计量单位字段过长")
	private String unit;
	// 仓储位置
	@Pattern(regexp="[\\s\\S]{0,30}", message="仓储位置字段过长")
	private String rockPosition;
	// 仓库id
	@Max(value=9223372036854775807L,message="仓库id字段过长")
	private Long storeSetId;
	// 生产场地
	@Max(value=9223372036854775807L,message="生产场地字段过长")
	private Long factorySetId;
	// 来源
	@Pattern(regexp="[\\s\\S]{0,20}", message="来源字段过长")
	private String source;
	// 备注
	@Pattern(regexp="[\\s\\S]{0,40}", message="备注字段过长")
	private String remark;
	// 企业主键
	@Max(value=9223372036854775807L,message="企业主键字段过长")
	private Long companyId;
	// 数字格式编码
	@Pattern(regexp="[\\s\\S]{0,255}", message="数字格式编码字段过长")
	private String midProdNoMark;

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
	public String getProdNo() {
		return this.prodNo;
	}

	/**
	 * 产品编码
	 */
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	
	/**
	 * 产品名称
	 */
	public String getProdName() {
		return this.prodName;
	}

	/**
	 * 产品名称
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
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
	 * 
	 */
	public String getParentNo() {
		return this.parentNo;
	}

	/**
	 * 
	 */
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}
	
	/**
	 * 数量
	 */
	public java.math.BigDecimal getAmount() {
		return this.amount;
	}

	/**
	 * 数量
	 */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}
	
	/**
	 * 规格
	 */
	public String getNorms() {
		return this.norms;
	}

	/**
	 * 规格
	 */
	public void setNorms(String norms) {
		this.norms = norms;
	}
	
	/**
	 * 参数
	 */
	public String getParam() {
		return this.param;
	}

	/**
	 * 参数
	 */
	public void setParam(String param) {
		this.param = param;
	}
	
	/**
	 * 型号
	 */
	public String getModelDesc() {
		return this.modelDesc;
	}

	/**
	 * 型号
	 */
	public void setModelDesc(String modelDesc) {
		this.modelDesc = modelDesc;
	}
	
	/**
	 * 所属工艺
	 */
	public String getCrafworkStructId() {
		return this.crafworkStructId;
	}

	/**
	 * 所属工艺
	 */
	public void setCrafworkStructId(String crafworkStructId) {
		this.crafworkStructId = crafworkStructId;
	}
	
	/**
	 * 计量单位
	 */
	public String getUnit() {
		return this.unit;
	}

	/**
	 * 计量单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * 仓储位置
	 */
	public String getRockPosition() {
		return this.rockPosition;
	}

	/**
	 * 仓储位置
	 */
	public void setRockPosition(String rockPosition) {
		this.rockPosition = rockPosition;
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
	 * 生产场地
	 */
	public Long getFactorySetId() {
		return this.factorySetId;
	}

	/**
	 * 生产场地
	 */
	public void setFactorySetId(Long factorySetId) {
		this.factorySetId = factorySetId;
	}
	
	/**
	 * 来源
	 */
	public String getSource() {
		return this.source;
	}

	/**
	 * 来源
	 */
	public void setSource(String source) {
		this.source = source;
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
	
	/**
	 * 数字格式编码
	 */
	public String getMidProdNoMark() {
		return this.midProdNoMark;
	}

	/**
	 * 数字格式编码
	 */
	public void setMidProdNoMark(String midProdNoMark) {
		this.midProdNoMark = midProdNoMark;
	}
}
