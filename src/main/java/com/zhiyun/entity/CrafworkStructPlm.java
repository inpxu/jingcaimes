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
@ApiModel(value = "工艺实体类")
public class CrafworkStructPlm extends BaseEntity<Long> {

    private static final long serialVersionUID = 7181522492939645651L;

    // ~~~~实体属性
    // 工艺名称
    @ApiModelProperty(value = "工艺名称", required = true)
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "工艺名称字段过长")
    private String crafworkName;
    // 主生产设备
    @Pattern(regexp = "[\\s\\S]{0,60}", message = "主生产设备字段过长")
    private String macType;
    // 是否需要品检
    private Boolean isCheck;
    // 工艺岗位
    @ApiModelProperty(value = "工艺岗位", required = true)
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "工艺岗位字段过长")
    private String quartersEmp;
    // 单位
    @ApiModelProperty(value = "单位", required = true)
    @Pattern(regexp = "[\\s\\S]{0,10}", message = "单位字段过长")
    private String unit;
    //
    @ApiModelProperty(value = "公司id", required = false)
    @Max(value = 9223372036854775807L, message = "字段过长")
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
     * 工艺名称
     */
    public String getCrafworkName() {
        return this.crafworkName;
    }

    /**
     * 工艺名称
     */
    public void setCrafworkName(String crafworkName) {
        this.crafworkName = crafworkName;
    }

    /**
     * 主生产设备
     */
    public String getMacType() {
        return this.macType;
    }

    /**
     * 主生产设备
     */
    public void setMacType(String macType) {
        this.macType = macType;
    }

    /**
     * 是否需要品检
     */
    public Boolean getIsCheck() {
        return this.isCheck;
    }

    /**
     * 是否需要品检
     */
    public void setIsCheck(Boolean isCheck) {
        this.isCheck = isCheck;
    }

    /**
     * 工艺岗位
     */
    public String getQuartersEmp() {
        return this.quartersEmp;
    }

    /**
     * 工艺岗位
     */
    public void setQuartersEmp(String quartersEmp) {
        this.quartersEmp = quartersEmp;
    }

    /**
     * 单位
     */
    public String getUnit() {
        return this.unit;
    }

    /**
     * 单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     *
     */
    @Override
    public Long getCompanyId() {
        return this.companyId;
    }

    /**
     *
     */
    @Override
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
