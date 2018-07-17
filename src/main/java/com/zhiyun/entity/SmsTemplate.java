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
public class SmsTemplate extends BaseEntity<Long> {

	private static final long serialVersionUID = 3998864008522090590L;

	// ~~~~实体属性
	// 信息内容
	@Pattern(regexp="[\\S]{0,4294967295}", message="信息内容字段过长")
	private String messageContent;
	// 参数
	private String params;
	// 模板名称
	@Pattern(regexp="[\\S]{0,20}", message="模板名称字段过长")
	private String templateName;
	// 模板编码
	@Pattern(regexp="[\\S]{0,40}", message="模板编码字段过长")
	private String templateCode;
	// 是否启用
	private Boolean isAble;
	// 模板类型 1：短信 2：email
	@Max(value=99999999999L,message="模板类型 1：短信 2：email字段过长")
	private Integer type;
	// 是否系统模板
	private Boolean isSystem;
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
	 * 信息内容
	 */
	public String getMessageContent() {
		return this.messageContent;
	}

	/**
	 * 信息内容
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	/**
	 * 参数
	 */
	public String getParams() {
		return this.params;
	}

	/**
	 * 参数
	 */
	public void setParams(String params) {
		this.params = params;
	}
	
	/**
	 * 模板名称
	 */
	public String getTemplateName() {
		return this.templateName;
	}

	/**
	 * 模板名称
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	/**
	 * 模板编码
	 */
	public String getTemplateCode() {
		return this.templateCode;
	}

	/**
	 * 模板编码
	 */
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	
	/**
	 * 是否启用
	 */
	public Boolean getIsAble() {
		return this.isAble;
	}

	/**
	 * 是否启用
	 */
	public void setIsAble(Boolean isAble) {
		this.isAble = isAble;
	}
	
	/**
	 * 模板类型 1：短信 2：email
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * 模板类型 1：短信 2：email
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	
	/**
	 * 是否系统模板
	 */
	public Boolean getIsSystem() {
		return this.isSystem;
	}

	/**
	 * 是否系统模板
	 */
	public void setIsSystem(Boolean isSystem) {
		this.isSystem = isSystem;
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
