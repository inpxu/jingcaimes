/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dto;

import com.zhiyun.entity.ProductStorePlm;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-21 15:15
 */
public class ProductStorePlmDto extends ProductStorePlm implements Serializable {

    private static final long serialVersionUID = -2259131887186475703L;

    private String typeDesc;

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
}
