/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dto;

import com.zhiyun.entity.TaskCheckRecordMes;

import java.io.Serializable;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-25 10:04
 */
public class TaskCheckRecordMesDto extends TaskCheckRecordMes implements Serializable {

    private static final long serialVersionUID = 8061023563471406247L;

    private String prodName;

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
}
