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
public class ProdBomDetailPlm extends BaseEntity<Long> {

	private static final long serialVersionUID = 7098603859987999093L;

	// ~~~~实体属性
	// bom号
	@Pattern(regexp="[\\s\\S]{0,30}", message="bom号字段过长")
	private String bomNo;
	// 项号
	@Max(value=9223372036854775807L,message="项号字段过长")
	private Long serial;
	// 物料号
	@Pattern(regexp="[\\s\\S]{0,30}", message="物料号字段过长")
	private String mattersNo;
	// 半成品编号
	@Pattern(regexp="[\\s\\S]{0,10}", message="半成品编号字段过长")
	private String parentNo;
	// 规格
	@Pattern(regexp="[\\s\\S]{0,30}", message="规格字段过长")
	private String norms;
	// 参数
	@Pattern(regexp="[\\s\\S]{0,30}", message="参数字段过长")
	private String param;
	// 型号
	@Pattern(regexp="[\\s\\S]{0,20}", message="型号字段过长")
	private String modelDesc;
	// 物料版本号
	@Pattern(regexp="[\\s\\S]{0,30}", message="物料版本号字段过长")
	private String matVersions;
	// 数量
	private java.math.BigDecimal amount;
	// 单位
	@Pattern(regexp="[\\s\\S]{0,10}", message="单位字段过长")
	private String unit;
	// 工艺
	@Max(value=9223372036854775807L,message="工艺字段过长")
	private Long crafworkId;
	// 品牌
	@Pattern(regexp="[\\s\\S]{0,50}", message="品牌字段过长")
	private String brand;
	// 产品
	@Max(value=9223372036854775807L,message="产品字段过长")
	private Long prodId;
	// 备用物料号
	@Pattern(regexp="[\\s\\S]{0,180}", message="备用物料号字段过长")
	private String backupMatter;
	// 描述
	@Pattern(regexp="[\\s\\S]{0,65535}", message="描述字段过长")
	private String descr;
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
	 * bom号
	 */
	public String getBomNo() {
		return this.bomNo;
	}

	/**
	 * bom号
	 */
	public void setBomNo(String bomNo) {
		this.bomNo = bomNo;
	}
	
	/**
	 * 项号
	 */
	public Long getSerial() {
		return this.serial;
	}

	/**
	 * 项号
	 */
	public void setSerial(Long serial) {
		this.serial = serial;
	}
	
	/**
	 * 物料号
	 */
	public String getMattersNo() {
		return this.mattersNo;
	}

	/**
	 * 物料号
	 */
	public void setMattersNo(String mattersNo) {
		this.mattersNo = mattersNo;
	}
	
	/**
	 * 半成品编号
	 */
	public String getParentNo() {
		return this.parentNo;
	}

	/**
	 * 半成品编号
	 */
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
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
	 * 物料版本号
	 */
	public String getMatVersions() {
		return this.matVersions;
	}

	/**
	 * 物料版本号
	 */
	public void setMatVersions(String matVersions) {
		this.matVersions = matVersions;
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
	 * 工艺
	 */
	public Long getCrafworkId() {
		return this.crafworkId;
	}

	/**
	 * 工艺
	 */
	public void setCrafworkId(Long crafworkId) {
		this.crafworkId = crafworkId;
	}
	
	/**
	 * 品牌
	 */
	public String getBrand() {
		return this.brand;
	}

	/**
	 * 品牌
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * 产品
	 */
	public Long getProdId() {
		return this.prodId;
	}

	/**
	 * 产品
	 */
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	
	/**
	 * 备用物料号
	 */
	public String getBackupMatter() {
		return this.backupMatter;
	}

	/**
	 * 备用物料号
	 */
	public void setBackupMatter(String backupMatter) {
		this.backupMatter = backupMatter;
	}
	
	/**
	 * 描述
	 */
	public String getDescr() {
		return this.descr;
	}

	/**
	 * 描述
	 */
	public void setDescr(String descr) {
		this.descr = descr;
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
