/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.entity.ProdTypeCrm;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ProdTypeCrmService extends BaseService<ProdTypeCrm, Long> {
    /**
     * 产品库分类名称唯一性校验，唯一返回true，否则返回false
     *
     * @param prodTypeCrm
     * @return java.lang.Boolean
     * @author 邓艺
     * @date 2018/8/21 8:41
     */
    Boolean typeDescIsUnique(ProdTypeCrm prodTypeCrm);
}
