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
public class VoucherMainOa extends BaseEntity<Long> {

	private static final long serialVersionUID = 6536971560469693806L;

	// ~~~~实体属性
	// 单据号
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据号字段过长")
	private String voucherNo;
	// 单据填写人
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据填写人字段过长")
	private String raiser;
	// 申请部门
	@Max(value=9223372036854775807L,message="申请部门字段过长")
	private Long orgId;
	// 申请日期
	private java.util.Date raiseDate;
	// 希望审批日期
	private java.util.Date hopeDate;
	// 事件描述
	@Pattern(regexp="[\\s\\S]{0,100}", message="事件描述字段过长")
	private String eventDesc;
	// 所属菜单
	@Max(value=9223372036854775807L,message="所属菜单字段过长")
	private Long menuId;
	// 所属流程
	@Max(value=9223372036854775807L,message="所属流程字段过长")
	private Long wkflowId;
	// 审批意见
	@Pattern(regexp="[\\s\\S]{0,200}", message="审批意见字段过长")
	private String checkAdvice;
	// 审批进度
	@Pattern(regexp="[\\s\\S]{0,100}", message="审批进度字段过长")
	private String checks;
	// 单据状态
	@Pattern(regexp="[\\s\\S]{0,30}", message="单据状态字段过长")
	private String isFinished;
	// 备注
	@Pattern(regexp="[\\s\\S]{0,100}", message="备注字段过长")
	private String remark;
	// 公司id
	@Max(value=9223372036854775807L,message="公司id字段过长")
	private Long companyId;
	// 单据审批者
	@Max(value=9223372036854775807L,message="单据审批者字段过长")
	private Long approverUserId;
	// 单据填写人userId
	@Max(value=9223372036854775807L,message="单据填写人userId字段过长")
	private Long raiserUserId;

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	/**
	 * 单据号
	 */
	public String getVoucherNo() {
		return this.voucherNo;
	}

	/**
	 * 单据号
	 */
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	
	/**
	 * 单据填写人
	 */
	public String getRaiser() {
		return this.raiser;
	}

	/**
	 * 单据填写人
	 */
	public void setRaiser(String raiser) {
		this.raiser = raiser;
	}
	
	/**
	 * 申请部门
	 */
	public Long getOrgId() {
		return this.orgId;
	}

	/**
	 * 申请部门
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	
	/**
	 * 申请日期
	 */
	public java.util.Date getRaiseDate() {
		return this.raiseDate;
	}

	/**
	 * 申请日期
	 */
	public void setRaiseDate(java.util.Date raiseDate) {
		this.raiseDate = raiseDate;
	}
	
	/**
	 * 希望审批日期
	 */
	public java.util.Date getHopeDate() {
		return this.hopeDate;
	}

	/**
	 * 希望审批日期
	 */
	public void setHopeDate(java.util.Date hopeDate) {
		this.hopeDate = hopeDate;
	}
	
	/**
	 * 事件描述
	 */
	public String getEventDesc() {
		return this.eventDesc;
	}

	/**
	 * 事件描述
	 */
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	
	/**
	 * 所属菜单
	 */
	public Long getMenuId() {
		return this.menuId;
	}

	/**
	 * 所属菜单
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	
	/**
	 * 所属流程
	 */
	public Long getWkflowId() {
		return this.wkflowId;
	}

	/**
	 * 所属流程
	 */
	public void setWkflowId(Long wkflowId) {
		this.wkflowId = wkflowId;
	}
	
	/**
	 * 审批意见
	 */
	public String getCheckAdvice() {
		return this.checkAdvice;
	}

	/**
	 * 审批意见
	 */
	public void setCheckAdvice(String checkAdvice) {
		this.checkAdvice = checkAdvice;
	}
	
	/**
	 * 审批进度
	 */
	public String getChecks() {
		return this.checks;
	}

	/**
	 * 审批进度
	 */
	public void setChecks(String checks) {
		this.checks = checks;
	}
	
	/**
	 * 单据状态
	 */
	public String getIsFinished() {
		return this.isFinished;
	}

	/**
	 * 单据状态
	 */
	public void setIsFinished(String isFinished) {
		this.isFinished = isFinished;
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
	 * 公司id
	 */
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 公司id
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	/**
	 * 单据审批者
	 */
	public Long getApproverUserId() {
		return this.approverUserId;
	}

	/**
	 * 单据审批者
	 */
	public void setApproverUserId(Long approverUserId) {
		this.approverUserId = approverUserId;
	}
	
	/**
	 * 单据填写人userId
	 */
	public Long getRaiserUserId() {
		return this.raiserUserId;
	}

	/**
	 * 单据填写人userId
	 */
	public void setRaiserUserId(Long raiserUserId) {
		this.raiserUserId = raiserUserId;
	}
}
