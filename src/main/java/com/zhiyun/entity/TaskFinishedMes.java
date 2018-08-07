/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class TaskFinishedMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 3584202350835261428L;

	// ~~~~实体属性
	// 内部订单号
	@Pattern(regexp="[\\S]{0,30}", message="内部订单号字段过长")
	private String insideOrder;
	// 产品编码
	@Pattern(regexp="[\\S]{0,255}", message="产品编码字段过长")
	private String prodNo;
	// 工艺id
	@Max(value=9223372036854775807L,message="工艺id字段过长")
	private Long crafworkId;
	// 领取任务时间
	@JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date getTime;
	// 工艺执行人
	@Pattern(regexp="[\\S]{0,255}", message="工艺执行人字段过长")
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
	 * 内部订单号
	 */
	public String getInsideOrder() {
		return this.insideOrder;
	}

	/**
	 * 内部订单号
	 */
	public void setInsideOrder(String insideOrder) {
		this.insideOrder = insideOrder;
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
	 * 领取任务时间
	 */
	public java.util.Date getGetTime() {
		return this.getTime;
	}

	/**
	 * 领取任务时间
	 */
	public void setGetTime(java.util.Date getTime) {
		this.getTime = getTime;
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
