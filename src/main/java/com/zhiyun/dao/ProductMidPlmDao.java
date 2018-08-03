/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.ProductMidPlmDto;
import com.zhiyun.entity.ProductMidPlm;

import java.util.List;

/**
 * ProductMidPlmDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ProductMidPlmDao extends BaseDao<ProductMidPlm, Long> {

    DataGrid<ProductMidPlmDto> customPage(Params params, Pager pager);

    List<ProductMidPlmDto> customeFind(ProductMidPlm pam);
}
