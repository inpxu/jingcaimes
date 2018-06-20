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
public class OrderPictMes extends BaseEntity<Long> {

	private static final long serialVersionUID = 4956099353539748633L;

	// ~~~~实体属性
	// 订单号码
	@Pattern(regexp="[\\s\\S]{0,30}", message="订单号码字段过长")
	private String orderNo;
	// 产品编码
	@Pattern(regexp="[\\s\\S]{0,30}", message="产品编码字段过长")
	private String prodNo;
	// 工艺id
	@Max(value=9223372036854775807L,message="工艺id字段过长")
	private Long crafworkId;
	// 序号
	@Max(value=99999999999L,message="序号字段过长")
	private Integer serial;
	// 图片
	private byte[] pictures;
	// 本地路径
	@Pattern(regexp="[\\s\\S]{0,100}", message="本地路径字段过长")
	private String filePath;
	// 链接地址
	@Pattern(regexp="[\\s\\S]{0,256}", message="链接地址字段过长")
	private String linkPath;
	// 说明
	@Pattern(regexp="[\\s\\S]{0,256}", message="说明字段过长")
	private String desc;
	// 上传人
	@Pattern(regexp="[\\s\\S]{0,30}", message="上传人字段过长")
	private String sendEmp;
	// 上传时间
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public byte[] getPictures() {
        return pictures;
    }

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
	@Override
	public Long getCompanyId() {
		return this.companyId;
	}

	/**
	 * 企业主键
	 */
    @Override
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
