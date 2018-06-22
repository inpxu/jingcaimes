/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;

/**
 * 物料库实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class MattersStoreIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 2846319878325374636L;

	// ~~~~实体属性
	// 物料编码
	@Pattern(regexp="[\\s\\S]{0,20}", message="物料编码字段过长")
	private String mattersNo;
	// 物料名称
	@Pattern(regexp="[\\s\\S]{0,30}", message="物料名称字段过长")
	private String mattersName;
	// 物料分类
	@Max(value=9223372036854775807L,message="物料分类字段过长")
	private Long mattersTypeId;
	// 规格
	@Pattern(regexp="[\\s\\S]{0,40}", message="规格字段过长")
	private String norms;
	// 参数
	@Pattern(regexp="[\\s\\S]{0,40}", message="参数字段过长")
	private String param;
	// 型号
	@Pattern(regexp="[\\s\\S]{0,30}", message="型号字段过长")
	private String modelDesc;
	// 品牌
	@Pattern(regexp="[\\s\\S]{0,30}", message="品牌字段过长")
	private String brand;
	// 材质
	@Pattern(regexp="[\\s\\S]{0,20}", message="材质字段过长")
	private String material;
	// 等级
	@Pattern(regexp="[\\s\\S]{0,30}", message="等级字段过长")
	private String level;
	// 生产厂商
	@Pattern(regexp="[\\s\\S]{0,30}", message="生产厂商字段过长")
	private String factory;
	// 单位
	@Pattern(regexp="[\\s\\S]{0,8}", message="单位字段过长")
	private String unit;
	// 仓库id
	@Max(value=9223372036854775807L,message="仓库id字段过长")
	private Long storeSetId;
	// 库存数量
	private java.math.BigDecimal curAmount;
	// 生产预付数量
	private java.math.BigDecimal advAmount;
	// 采购预进数量
	private java.math.BigDecimal purAmount;
	// 描述
	@Pattern(regexp="[\\s\\S]{0,65535}", message="描述字段过长")
	private String desc;
	// 版本号
	@Pattern(regexp="[\\s\\S]{0,18}", message="版本号字段过长")
	private String versions;
	// 状态
	@Pattern(regexp="[\\s\\S]{0,10}", message="状态字段过长")
	private String status;
	// 安全库存
	private java.math.BigDecimal secureStock;
	// 采购提前期
	@Max(value=9223372036854775807L,message="采购提前期字段过长")
	private Long befDate;
	// 创建时间
	private java.util.Date buliddate;
	// 废弃时间
	private java.util.Date losedate;
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
	 * 物料名称
	 */
	public String getMattersName() {
		return this.mattersName;
	}

	/**
	 * 物料名称
	 */
	public void setMattersName(String mattersName) {
		this.mattersName = mattersName;
	}
	
	/**
	 * 物料分类
	 */
	public Long getMattersTypeId() {
		return this.mattersTypeId;
	}

	/**
	 * 物料分类
	 */
	public void setMattersTypeId(Long mattersTypeId) {
		this.mattersTypeId = mattersTypeId;
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
	 * 材质
	 */
	public String getMaterial() {
		return this.material;
	}

	/**
	 * 材质
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	
	/**
	 * 等级
	 */
	public String getLevel() {
		return this.level;
	}

	/**
	 * 等级
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
	/**
	 * 生产厂商
	 */
	public String getFactory() {
		return this.factory;
	}

	/**
	 * 生产厂商
	 */
	public void setFactory(String factory) {
		this.factory = factory;
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
	 * 库存数量
	 */
	public java.math.BigDecimal getCurAmount() {
		return this.curAmount;
	}

	/**
	 * 库存数量
	 */
	public void setCurAmount(java.math.BigDecimal curAmount) {
		this.curAmount = curAmount;
	}
	
	/**
	 * 生产预付数量
	 */
	public java.math.BigDecimal getAdvAmount() {
		return this.advAmount;
	}

	/**
	 * 生产预付数量
	 */
	public void setAdvAmount(java.math.BigDecimal advAmount) {
		this.advAmount = advAmount;
	}
	
	/**
	 * 采购预进数量
	 */
	public java.math.BigDecimal getPurAmount() {
		return this.purAmount;
	}

	/**
	 * 采购预进数量
	 */
	public void setPurAmount(java.math.BigDecimal purAmount) {
		this.purAmount = purAmount;
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
	 * 版本号
	 */
	public String getVersions() {
		return this.versions;
	}

	/**
	 * 版本号
	 */
	public void setVersions(String versions) {
		this.versions = versions;
	}
	
	/**
	 * 状态
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 安全库存
	 */
	public java.math.BigDecimal getSecureStock() {
		return this.secureStock;
	}

	/**
	 * 安全库存
	 */
	public void setSecureStock(java.math.BigDecimal secureStock) {
		this.secureStock = secureStock;
	}
	
	/**
	 * 采购提前期
	 */
	public Long getBefDate() {
		return this.befDate;
	}

	/**
	 * 采购提前期
	 */
	public void setBefDate(Long befDate) {
		this.befDate = befDate;
	}
	
	/**
	 * 创建时间
	 */
	public java.util.Date getBuliddate() {
		return this.buliddate;
	}

	/**
	 * 创建时间
	 */
	public void setBuliddate(java.util.Date buliddate) {
		this.buliddate = buliddate;
	}
	
	/**
	 * 废弃时间
	 */
	public java.util.Date getLosedate() {
		return this.losedate;
	}

	/**
	 * 废弃时间
	 */
	public void setLosedate(java.util.Date losedate) {
		this.losedate = losedate;
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
