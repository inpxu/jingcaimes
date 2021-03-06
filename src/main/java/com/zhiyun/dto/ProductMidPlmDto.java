/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dto;

import com.zhiyun.entity.ProductMidPlm;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-20 13:59
 */
public class ProductMidPlmDto extends ProductMidPlm implements Serializable {

    private static final long serialVersionUID = -3017787972260387868L;
    private String prodName;
    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String getProdName() {
        return prodName;
    }

    @Override
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
}
