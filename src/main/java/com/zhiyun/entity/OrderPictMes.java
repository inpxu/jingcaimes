/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhiyun.base.entity.BaseEntity;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
public class OrderPictMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 2976048127897032404L;

	// ~~~~实体属性
	// 内部订单
	@Pattern(regexp="[\\S]{0,30}", message="内部订单字段过长")
	private String insideOrder;
	// 产品编码
	@Pattern(regexp="[\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 工艺id
	@Max(value=9223372036854775807L,message="工艺id字段过长")
	private Long crafworkId;
	// 领取任务时间
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date getTime;
	// 序号
	@Max(value=99999999999L,message="序号字段过长")
	private Integer serial;
	// 图片
	private byte[] pictures;
	// 本地路径
	@Pattern(regexp="[\\S]{0,100}", message="本地路径字段过长")
	private String filePath;
	// 链接地址
	@Pattern(regexp="[\\S]{0,256}", message="链接地址字段过长")
	private String linkPath;
	// 说明
	@Pattern(regexp="[\\S]{0,256}", message="说明字段过长")
	private String desc;
	// 上传人
	@Pattern(regexp="[\\S]{0,30}", message="上传人字段过长")
	private String sendEmp;
	// 上传时间
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date sendDate;
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
	 * 内部订单
	 */
	public String getInsideOrder() {
		return this.insideOrder;
	}

	/**
	 * 内部订单
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
	 * 图片
	 */
	public byte[] getPictures() {
		return this.pictures;
	}

	/**
	 * 图片
	 */
	public void setPictures(byte[] pictures) {
		this.pictures = pictures;
	}
	
	/**
	 * 本地路径
	 */
	public String getFilePath() {
		return this.filePath;
	}

	/**
	 * 本地路径
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * 链接地址
	 */
	public String getLinkPath() {
		return this.linkPath;
	}

	/**
	 * 链接地址
	 */
	public void setLinkPath(String linkPath) {
		this.linkPath = linkPath;
	}
	
	/**
	 * 说明
	 */
	public String getDesc() {
		return this.desc;
	}

	/**
	 * 说明
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	 * 上传人
	 */
	public String getSendEmp() {
		return this.sendEmp;
	}

	/**
	 * 上传人
	 */
	public void setSendEmp(String sendEmp) {
		this.sendEmp = sendEmp;
	}
	
	/**
	 * 上传时间
	 */
	public java.util.Date getSendDate() {
		return this.sendDate;
	}

	/**
	 * 上传时间
	 */
	public void setSendDate(java.util.Date sendDate) {
		this.sendDate = sendDate;
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
