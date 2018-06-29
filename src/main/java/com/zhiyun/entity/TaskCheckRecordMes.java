/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.entity;

import com.zhiyun.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

/**
 * 实体类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@ApiModel
public class TaskCheckRecordMes extends BaseEntity<Long> {

    private static final long serialVersionUID = 3418465896977688891L;

    // ~~~~实体属性
    // 内部订单号
    @ApiModelProperty
    @Pattern(regexp = "[\\S]{0,30}", message = "内部订单号字段过长")
    private String insideOrder;
    // 工艺id
    @Max(value = 9223372036854775807L, message = "工艺id字段过长")
    private Long crafworkId;
    // 客户是否通过
    @Pattern(regexp = "[\\S]{0,1}", message = "客户是否通过字段过长")
    private String cusIsOk;
    // 检查人
    @Pattern(regexp = "[\\S]{0,30}", message = "检查人字段过长")
    private String checkEmpNo;
    // 检查日期
    private java.util.Date checkDate;
    // 描述
    @Pattern(regexp = "[\\S]{0,50}", message = "描述字段过长")
    private String desc;
    //产品编码
    private String prodNo;
    //
    @Max(value = 9223372036854775807L, message = "字段过长")
    private Long companyId;
    //
    private java.math.BigDecimal standHours;

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
     * 客户是否通过
     */
    public String getCusIsOk() {
        return this.cusIsOk;
    }

    /**
     * 客户是否通过
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

    /**
     *
     */
    public java.math.BigDecimal getStandHours() {
        return this.standHours;
    }

    /**
     *
     */
    public void setStandHours(java.math.BigDecimal standHours) {
        this.standHours = standHours;
    }
}