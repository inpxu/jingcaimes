/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-20 21:21
 */
public class CrafworkStructParamDto implements Serializable {

    private static final long serialVersionUID = -8909800390938375610L;
    private Long id;
    private List<String> params;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
