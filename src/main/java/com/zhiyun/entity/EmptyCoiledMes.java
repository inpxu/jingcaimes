/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class EmptyCoiledMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 1242377361974272093L;

	// ~~~~实体属性
	// 空盘编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="空盘编码字段过长")
	private String coiledNo;
	// 场地id
	@Max(value=9223372036854775807L,message="场地id字段过长")
	private Long factoryId;
	// 部门id
	@Max(value=9223372036854775807L,message="部门id字段过长")
	private Long deptId;
	// 状态
	@Pattern(regexp="[\\s\\S]{0,30}", message="状态字段过长")
	private String status;
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
	 * 空盘编码
	 */
	public String getCoiledNo() {
		return this.coiledNo;
	}

	/**
	 * 空盘编码
	 */
	public void setCoiledNo(String coiledNo) {
		this.coiledNo = coiledNo;
	}
	
	/**
	 * 场地id
	 */
	public Long getFactoryId() {
		return this.factoryId;
	}

	/**
	 * 场地id
	 */
	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}
	
	/**
	 * 部门id
	 */
	public Long getDeptId() {
		return this.deptId;
	}

	/**
	 * 部门id
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
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
