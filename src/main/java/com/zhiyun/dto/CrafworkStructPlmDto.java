/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dto;

import com.zhiyun.entity.CrafworkStructPlm;

import java.math.BigDecimal;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-20 18:47
 */
public class CrafworkStructPlmDto extends CrafworkStructPlm {
    // 实际工时
    private java.math.BigDecimal actHours;

    public BigDecimal getActHours() {
        return actHours;
    }

    public void setActHours(BigDecimal actHours) {
        this.actHours = actHours;
    }
}
