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
import java.util.Date;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class TaskCheckRecordMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 7940276199109491225L;

	// ~~~~实体属性
	// 内部订单号
	@Pattern(regexp="[\\S]{0,30}", message="内部订单号字段过长")
	private String insideOrder;
	// 工艺id
	@Max(value=9223372036854775807L,message="工艺id字段过长")
	private Long crafworkId;
	// 客户是否通过1 待评审 2 通过 3 未通过
	@Pattern(regexp="[\\S]{0,1}", message="客户是否通过1 待评审 2 通过 3 未通过字段过长")
	private String cusIsOk;
	// 检查人
	@Pattern(regexp="[\\S]{0,30}", message="检查人字段过长")
	private String checkEmpNo;
	// 检查日期
	private java.util.Date checkDate;
	// 描述
	@Pattern(regexp="[\\S]{0,50}", message="描述字段过长")
	private String desc;
	// 
	@Pattern(regexp="[\\S]{0,255}", message="字段过长")
	private String prodNo;
	// 
	@Max(value=9223372036854775807L,message="字段过长")
	private Long companyId;

	@JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date getTime;

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

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
	 * 客户是否通过1 待评审 2 通过 3 未通过
	 */
	public String getCusIsOk() {
		return this.cusIsOk;
	}

	/**
	 * 客户是否通过1 待评审 2 通过 3 未通过
	 */
	public void setCusIsOk(String cusIsOk) {
		this.cusIsOk = cusIsOk;
	}
	
	/**
	 * 检查人
	 */
	public String getCheckEmpNo() {
		return this.checkEmpNo;
	}

	/**
	 * 检查人
	 */
	public void setCheckEmpNo(String checkEmpNo) {
		this.checkEmpNo = checkEmpNo;
	}
	
	/**
	 * 检查日期
	 */
	public java.util.Date getCheckDate() {
		return this.checkDate;
	}

	/**
	 * 检查日期
	 */
	public void setCheckDate(java.util.Date checkDate) {
		this.checkDate = checkDate;
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
	 * 
	 */
	public String getProdNo() {
		return this.prodNo;
	}

	/**
	 * 
	 */
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
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
