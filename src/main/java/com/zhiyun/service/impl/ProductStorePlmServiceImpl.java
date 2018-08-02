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
import com.zhiyun.dao.ProductStorePlmDao;
import com.zhiyun.dto.ProductStorePlmDto;
import com.zhiyun.entity.ProductStorePlm;
import com.zhiyun.service.ProductStorePlmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("productStorePlmService")
public class ProductStorePlmServiceImpl extends BaseServiceImpl<ProductStorePlm, Long> implements ProductStorePlmService {

    @Resource
    private ProductStorePlmDao productStorePlmDao;

    @Override
    protected BaseDao<ProductStorePlm, Long> getBaseDao() {
        return this.productStorePlmDao;
    }

    @Override
    public DataGrid<ProductStorePlmDto> customPage(Params params, Pager pager) {
        return productStorePlmDao.customPage(params, pager);
    }

    @Override
    public List<ProductStorePlm> list(ProductStorePlm productStorePlm){
        return productStorePlmDao.list(productStorePlm);
    }

    @Override
    public int findTypeNum(Long typeId) {
        ProductStorePlm productStorePlm = new ProductStorePlm();
        productStorePlm.setTypeId(typeId);
        return productStorePlmDao.findTypeNum(productStorePlm);
    }
}
