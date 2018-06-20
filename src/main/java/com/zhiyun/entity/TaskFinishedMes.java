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
public class TaskFinishedMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 1539182367628020261L;

	// ~~~~实体属性
	// 订单号码
	@Pattern(regexp="[\\s\\S]{0,255}", message="订单号码字段过长")
	private String orderNo;
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,255}", message="产品编码字段过长")
	private String prodNo;
	// 工艺id
	@Max(value=9223372036854775807L,message="工艺id字段过长")
	private Long crafworkId;
	// 工艺执行人
	@Pattern(regexp="[\\s\\S]{0,255}", message="工艺执行人字段过长")
	private String doEmpNo;
	// 完成时间
	private java.util.Date okDatetime;
	// 确认状态
	private Boolean isCheck;
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
	 * 订单号码
	 */
	public String getOrderNo() {
		return this.orderNo;
	}

	/**
	 * 订单号码
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
	 * 工艺id
	 */
	public Long getCrafworkId() {
		return this.crafworkId;
	}

	/**
	 * 工艺id
	 */
	public void setCrafworkId(Long crafworkId) {
		this.crafworkId = crafworkId;
	}
	
	/**
	 * 工艺执行人
	 */
	public String getDoEmpNo() {
		return this.doEmpNo;
	}

	/**
	 * 工艺执行人
	 */
	public void setDoEmpNo(String doEmpNo) {
		this.doEmpNo = doEmpNo;
	}
	
	/**
	 * 完成时间
	 */
	public java.util.Date getOkDatetime() {
		return this.okDatetime;
	}

	/**
	 * 完成时间
	 */
	public void setOkDatetime(java.util.Date okDatetime) {
		this.okDatetime = okDatetime;
	}
	
	/**
	 * 确认状态
	 */
	public Boolean getIsCheck() {
		return this.isCheck;
	}

	/**
	 * 确认状态
	 */
	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
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
