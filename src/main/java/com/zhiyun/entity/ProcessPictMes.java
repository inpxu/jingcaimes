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
public class ProcessPictMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 4907700900040370466L;

	// ~~~~实体属性
	// 内部订单编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="内部订单编码字段过长")
	private String insideOrder;
	// 客户编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="客户编码字段过长")
	private String customNo;
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 工艺id
	@Max(value=9223372036854775807L,message="工艺id字段过长")
	private Long crafworkId;
	// 序号
	@Max(value=99999999999L,message="序号字段过长")
	private Integer serial;
	// 图片地址
	@Pattern(regexp="[\\s\\S]{0,250}", message="图片地址字段过长")
	private String pictures;
	// 文件名
	@Pattern(regexp="[\\s\\S]{0,40}", message="文件名字段过长")
	private String fileName;
	// 图片提交人
	@Pattern(regexp="[\\s\\S]{0,30}", message="图片提交人字段过长")
	private String sendEmp;
	// 上传图片
	private java.util.Date sentDate;
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
	 * 内部订单编码
	 */
	public String getInsideOrder() {
		return this.insideOrder;
	}

	/**
	 * 内部订单编码
	 */
	public void setInsideOrder(String insideOrder) {
		this.insideOrder = insideOrder;
	}
	
	/**
	 * 客户编码
	 */
	public String getCustomNo() {
		return this.customNo;
	}

	/**
	 * 客户编码
	 */
	public void setCustomNo(String customNo) {
		this.customNo = customNo;
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
	 * 序号
	 */
	public Integer getSerial() {
		return this.serial;
	}

	/**
	 * 序号
	 */
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	
	/**
	 * 图片地址
	 */
	public String getPictures() {
		return this.pictures;
	}

	/**
	 * 图片地址
	 */
	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
	
	/**
	 * 文件名
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * 文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * 图片提交人
	 */
	public String getSendEmp() {
		return this.sendEmp;
	}

	/**
	 * 图片提交人
	 */
	public void setSendEmp(String sendEmp) {
		this.sendEmp = sendEmp;
	}
	
	/**
	 * 上传图片
	 */
	public java.util.Date getSentDate() {
		return this.sentDate;
	}

	/**
	 * 上传图片
	 */
	public void setSentDate(java.util.Date sentDate) {
		this.sentDate = sentDate;
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
