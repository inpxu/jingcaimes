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
public class CustomLinkmanCrm extends BaseEntity<Long> {

	private static final long serialVersionUID = 2782318978992216640L;

	// ~~~~实体属性
	// 客户编码
	@Max(value=9223372036854775807L,message="客户编码字段过长")
	private Long customId;
	// 序号
	@Max(value=99999999999L,message="序号字段过长")
	private Integer serial;
	// 联系人
	@Pattern(regexp="[\\S]{0,30}", message="联系人字段过长")
	private String linkName;
	// 电话号码1
	@Pattern(regexp="[\\S]{0,16}", message="电话号码1字段过长")
	private String phoneNo;
	// 电话号码2
	@Pattern(regexp="[\\S]{0,16}", message="电话号码2字段过长")
	private String phoneNo1;
	// 部门
	@Pattern(regexp="[\\S]{0,20}", message="部门字段过长")
	private String orgId;
	// 生日
	private java.util.Date birthday;
	// 职务
	@Pattern(regexp="[\\S]{0,20}", message="职务字段过长")
	private String dutyId;
	// 爱好
	@Pattern(regexp="[\\S]{0,60}", message="爱好字段过长")
	private String hobby;
	// e_mail
	@Pattern(regexp="[\\S]{0,30}", message="e_mail字段过长")
	private String eMail;
	// 家庭地址
	@Pattern(regexp="[\\S]{0,50}", message="家庭地址字段过长")
	private String familyAddr;
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
	 * 客户编码
	 */
	public Long getCustomId() {
		return this.customId;
	}

	/**
	 * 客户编码
	 */
	public void setCustomId(Long customId) {
		this.customId = customId;
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
	 * 联系人
	 */
	public String getLinkName() {
		return this.linkName;
	}

	/**
	 * 联系人
	 */
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	
	/**
	 * 电话号码1
	 */
	public String getPhoneNo() {
		return this.phoneNo;
	}

	/**
	 * 电话号码1
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	/**
	 * 电话号码2
	 */
	public String getPhoneNo1() {
		return this.phoneNo1;
	}

	/**
	 * 电话号码2
	 */
	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}
	
	/**
	 * 部门
	 */
	public String getOrgId() {
		return this.orgId;
	}

	/**
	 * 部门
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	/**
	 * 生日
	 */
	public java.util.Date getBirthday() {
		return this.birthday;
	}

	/**
	 * 生日
	 */
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * 职务
	 */
	public String getDutyId() {
		return this.dutyId;
	}

	/**
	 * 职务
	 */
	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}
	
	/**
	 * 爱好
	 */
	public String getHobby() {
		return this.hobby;
	}

	/**
	 * 爱好
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	/**
	 * e_mail
	 */
	public String getEMail() {
		return this.eMail;
	}

	/**
	 * e_mail
	 */
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}
	
	/**
	 * 家庭地址
	 */
	public String getFamilyAddr() {
		return this.familyAddr;
	}

	/**
	 * 家庭地址
	 */
	public void setFamilyAddr(String familyAddr) {
		this.familyAddr = familyAddr;
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
