/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 盘点准备实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class InventoryReadyIos extends BaseEntity<Long> {

	private static final long serialVersionUID = 7926049575258814668L;

	// ~~~~实体属性
	// 期数
	@Pattern(regexp="[\\s\\S]{0,30}", message="期数字段过长")
	private String periods;
	// 仓库id
	@Max(value=9223372036854775807L,message="仓库id字段过长")
	private Long storeSetId;
	// 开始日期
	private java.util.Date startdate;
	// 结束日期
	private java.util.Date enddate;
	// 负责人
	@Pattern(regexp="[\\s\\S]{0,30}", message="负责人字段过长")
	private String leader;
	// 执行人
	@Pattern(regexp="[\\s\\S]{0,120}", message="执行人字段过长")
	private String doEmp;
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
	 * 期数
	 */
	public String getPeriods() {
		return this.periods;
	}

	/**
	 * 期数
	 */
	public void setPeriods(String periods) {
		this.periods = periods;
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
	 * 开始日期
	 */
	public java.util.Date getStartdate() {
		return this.startdate;
	}

	/**
	 * 开始日期
	 */
	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}
	
	/**
	 * 结束日期
	 */
	public java.util.Date getEnddate() {
		return this.enddate;
	}

	/**
	 * 结束日期
	 */
	public void setEnddate(java.util.Date enddate) {
		this.enddate = enddate;
	}
	
	/**
	 * 负责人
	 */
	public String getLeader() {
		return this.leader;
	}

	/**
	 * 负责人
	 */
	public void setLeader(String leader) {
		this.leader = leader;
	}
	
	/**
	 * 执行人
	 */
	public String getDoEmp() {
		return this.doEmp;
	}

	/**
	 * 执行人
	 */
	public void setDoEmp(String doEmp) {
		this.doEmp = doEmp;
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
