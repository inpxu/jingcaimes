/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.ProductMidPlmDto;
import com.zhiyun.entity.ProductMidPlm;

import java.util.List;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ProductMidPlmService extends BaseService<ProductMidPlm, Long> {

    DataGrid<ProductMidPlmDto> customPage(Params params, Pager pager);

    /**
     * 自定义查询（将字段封装成制定的）
     *
     * @param pam
     * @return java.util.List<com.zhiyun.entity.ProductMidPlm>
     * @author 邓艺
     * @date 2018/8/2 0002 下午 2:41
     */
    List<ProductMidPlmDto> customeFind(ProductMidPlm pam);
}
