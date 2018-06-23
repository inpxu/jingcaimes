/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-20 14:58
 */
@ApiModel
public class QuartersHcmDto {
    private static final long serialVersionUID = -1899879214780161879L;
    @ApiModelProperty(required = true,name = "companyId" ,value = "公司id")
    private Long companyId;
    @ApiModelProperty(hidden = true)
    private String deleted;
    private String quartersDesc;
    private String Id;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getQuartersDesc() {
        return quartersDesc;
    }

    public void setQuartersDesc(String quartersDesc) {
        this.quartersDesc = quartersDesc;
    }
}
