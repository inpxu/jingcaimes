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
public class CasOrg extends BaseEntity<Long> {

	private static final long serialVersionUID = 4905210578153229873L;

	// ~~~~实体属性
	// 部门编码
	@Pattern(regexp="[\\s\\S]{0,40}", message="部门编码字段过长")
	private String orgCode;
	// 部门名称
	@Pattern(regexp="[\\s\\S]{0,20}", message="部门名称字段过长")
	private String orgName;
	// 父主键
	@Max(value=9223372036854775807L,message="父主键字段过长")
	private Long parentId;
	// 是否叶节点
	private Boolean isLeaf;
	// 部门树
	@Pattern(regexp="[\\s\\S]{0,100}", message="部门树字段过长")
	private String orgPath;
	// 排序
	@Max(value=99999999999L,message="排序字段过长")
	private Integer orders;
	// 企业标识
	@Max(value=9223372036854775807L,message="企业标识字段过长")
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
	 * 部门编码
	 */
	public String getOrgCode() {
		return this.orgCode;
	}

	/**
	 * 部门编码
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	/**
	 * 部门名称
	 */
	public String getOrgName() {
		return this.orgName;
	}

	/**
	 * 部门名称
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	/**
	 * 父主键
	 */
	public Long getParentId() {
		return this.parentId;
	}

	/**
	 * 父主键
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * 是否叶节点
	 */
	public Boolean getIsLeaf() {
		return this.isLeaf;
	}

	/**
	 * 是否叶节点
	 */
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	/**
	 * 部门树
	 */
	public String getOrgPath() {
		return this.orgPath;
	}

	/**
	 * 部门树
	 */
	public void setOrgPath(String orgPath) {
		this.orgPath = orgPath;
	}
	
	/**
	 * 排序
	 */
	public Integer getOrders() {
		return this.orders;
	}

	/**
	 * 排序
	 */
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	
	/**
	 * 企业标识
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 企业标识
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
