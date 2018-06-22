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
public class ProdCrafworkPathPlm extends BaseEntity<Long> {

	private static final long serialVersionUID = 2720764335173835111L;

	// ~~~~实体属性
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 半成品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="半成品编码字段过长")
	private String midProdNo;
	// 工艺ID
	@Max(value=9223372036854775807L,message="工艺ID字段过长")
	private Long crafworkId;
	// 工艺要求
	@Pattern(regexp="[\\s\\S]{0,65535}", message="工艺要求字段过长")
	private String crafworkDesc;
	// 工艺工价
	private java.math.BigDecimal price;
	// 工艺岗位
	@Pattern(regexp="[\\s\\S]{0,30}", message="工艺岗位字段过长")
	private String quartersEmp;
	// 模具号
	@Pattern(regexp="[\\s\\S]{0,40}", message="模具号字段过长")
	private String modelNo;
	// 前置工艺
	@Pattern(regexp="[\\s\\S]{0,80}", message="前置工艺字段过长")
	private String befCrafwork;
	// 工艺顺序
	@Max(value=99999999999L,message="工艺顺序字段过长")
	private Integer carfSeq;
	// 构成数量
	private java.math.BigDecimal amount;
	// 计量单位
	@Pattern(regexp="[\\s\\S]{0,10}", message="计量单位字段过长")
	private String unit;
	// 设备单耗标准工时
	@Max(value=99999999999L,message="设备单耗标准工时字段过长")
	private Integer macMinutes;
	// 人员单耗标准工时
	@Max(value=99999999999L,message="人员单耗标准工时字段过长")
	private Integer empMinutes;
	// 是否需要品检
	private Boolean isCheck;
	// 每班标准产量
	private java.math.BigDecimal dayAmount;
	// 备注
	@Pattern(regexp="[\\s\\S]{0,40}", message="备注字段过长")
	private String remark;
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
	 * 工艺要求
	 */
	public String getCrafworkDesc() {
		return this.crafworkDesc;
	}

	/**
	 * 工艺要求
	 */
	public void setCrafworkDesc(String crafworkDesc) {
		this.crafworkDesc = crafworkDesc;
	}
	
	/**
	 * 工艺工价
	 */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * 工艺工价
	 */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	
	/**
	 * 工艺岗位
	 */
	public String getQuartersEmp() {
		return this.quartersEmp;
	}

	/**
	 * 工艺岗位
	 */
	public void setQuartersEmp(String quartersEmp) {
		this.quartersEmp = quartersEmp;
	}
	
	/**
	 * 模具号
	 */
	public String getModelNo() {
		return this.modelNo;
	}

	/**
	 * 模具号
	 */
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	
	/**
	 * 前置工艺
	 */
	public String getBefCrafwork() {
		return this.befCrafwork;
	}

	/**
	 * 前置工艺
	 */
	public void setBefCrafwork(String befCrafwork) {
		this.befCrafwork = befCrafwork;
	}
	
	/**
	 * 工艺顺序
	 */
	public Integer getCarfSeq() {
		return this.carfSeq;
	}

	/**
	 * 工艺顺序
	 */
	public void setCarfSeq(Integer carfSeq) {
		this.carfSeq = carfSeq;
	}
	
	/**
	 * 构成数量
	 */
	public java.math.BigDecimal getAmount() {
		return this.amount;
	}

	/**
	 * 构成数量
	 */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
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
	 * 设备单耗标准工时
	 */
	public Integer getMacMinutes() {
		return this.macMinutes;
	}

	/**
	 * 设备单耗标准工时
	 */
	public void setMacMinutes(Integer macMinutes) {
		this.macMinutes = macMinutes;
	}
	
	/**
	 * 人员单耗标准工时
	 */
	public Integer getEmpMinutes() {
		return this.empMinutes;
	}

	/**
	 * 人员单耗标准工时
	 */
	public void setEmpMinutes(Integer empMinutes) {
		this.empMinutes = empMinutes;
	}
	
	/**
	 * 是否需要品检
	 */
	public Boolean getIsCheck() {
		return this.isCheck;
	}

	/**
	 * 是否需要品检
	 */
	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
	}
	
	/**
	 * 每班标准产量
	 */
	public java.math.BigDecimal getDayAmount() {
		return this.dayAmount;
	}

	/**
	 * 每班标准产量
	 */
	public void setDayAmount(java.math.BigDecimal dayAmount) {
		this.dayAmount = dayAmount;
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
