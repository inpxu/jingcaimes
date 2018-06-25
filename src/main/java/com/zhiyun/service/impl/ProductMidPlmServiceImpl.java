/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProductMidPlmDao;
import com.zhiyun.dto.ProductMidPlmDto;
import com.zhiyun.entity.ProductMidPlm;
import com.zhiyun.service.ProductMidPlmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("productMidPlmService")
public class ProductMidPlmServiceImpl extends BaseServiceImpl<ProductMidPlm, Long> implements ProductMidPlmService {

    @Resource
    private ProductMidPlmDao productMidPlmDao;

    @Override
    protected BaseDao<ProductMidPlm, Long> getBaseDao() {
        return this.productMidPlmDao;
    }

    @Override
    public DataGrid<ProductMidPlmDto> customPage(Params params, Pager pager) {
        return productMidPlmDao.customPage(params, pager);
    }


}
