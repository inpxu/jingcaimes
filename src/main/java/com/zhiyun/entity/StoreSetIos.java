/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 仓储设置实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class StoreSetIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 7827347867097461506L;

	// ~~~~实体属性
	// 仓库名
	@Pattern(regexp="[\\s\\S]{0,30}", message="仓库名字段过长")
	private String storeName;
	// 场地id
	@Max(value=9223372036854775807L,message="场地id字段过长")
	private Long factorySetId;
	// 仓储属性
	@Pattern(regexp="[\\s\\S]{0,30}", message="仓储属性字段过长")
	private String stoProtery;
	// 货架数量
	@Max(value=99999999999L,message="货架数量字段过长")
	private Integer rackAmount;
	// 仓储方式
	@Pattern(regexp="[\\s\\S]{0,10}", message="仓储方式字段过长")
	private String storeType;
	// 成本核算方式
	@Pattern(regexp="[\\s\\S]{0,1}", message="成本核算方式字段过长")
	private String countType;
	// 仓库状态
	@Pattern(regexp="[\\s\\S]{0,10}", message="仓库状态字段过长")
	private String status;
	// 备注
	@Pattern(regexp="[\\s\\S]{0,40}", message="备注字段过长")
	private String remark;
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
	 * 仓库名
	 */
	public String getStoreName() {
		return this.storeName;
	}

	/**
	 * 仓库名
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	/**
	 * 场地id
	 */
	public Long getFactorySetId() {
		return this.factorySetId;
	}

	/**
	 * 场地id
	 */
	public void setFactorySetId(Long factorySetId) {
		this.factorySetId = factorySetId;
	}
	
	/**
	 * 仓储属性
	 */
	public String getStoProtery() {
		return this.stoProtery;
	}

	/**
	 * 仓储属性
	 */
	public void setStoProtery(String stoProtery) {
		this.stoProtery = stoProtery;
	}
	
	/**
	 * 货架数量
	 */
	public Integer getRackAmount() {
		return this.rackAmount;
	}

	/**
	 * 货架数量
	 */
	public void setRackAmount(Integer rackAmount) {
		this.rackAmount = rackAmount;
	}
	
	/**
	 * 仓储方式
	 */
	public String getStoreType() {
		return this.storeType;
	}

	/**
	 * 仓储方式
	 */
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	
	/**
	 * 成本核算方式
	 */
	public String getCountType() {
		return this.countType;
	}

	/**
	 * 成本核算方式
	 */
	public void setCountType(String countType) {
		this.countType = countType;
	}
	
	/**
	 * 仓库状态
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 仓库状态
	 */
	public void setStatus(String status) {
		this.status = status;
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
}
