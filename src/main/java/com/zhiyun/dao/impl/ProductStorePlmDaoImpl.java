/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.ProductStorePlmDao;
import com.zhiyun.dto.ProductStorePlmDto;
import com.zhiyun.entity.ProductStorePlm;
import org.springframework.stereotype.Repository;

/**
 * ProductStorePlmDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("productStorePlmDao")
public class ProductStorePlmDaoImpl extends BaseDaoImpl<ProductStorePlm, Long> implements ProductStorePlmDao {

    @Override
    public DataGrid<ProductStorePlmDto> customPage(Params params, Page page) {
        return this.selectPage(getMethodName(), params, page);
    }
}
