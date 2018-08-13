/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.ProductMidPlmDao;
import com.zhiyun.dto.ProductMidPlmDto;
import com.zhiyun.entity.ProductMidPlm;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ProductMidPlmDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("productMidPlmDao")
public class ProductMidPlmDaoImpl extends BaseDaoImpl<ProductMidPlm, Long> implements ProductMidPlmDao {

    @Override
    public DataGrid<ProductMidPlmDto> customPage(Params params, Pager pager) {
    	Long companyId = UserHolder.getCompanyId();
        params.add("companyId",companyId);
        return this.selectPage(getMethodName(), params, pager);
    }

    @Override
    public List<ProductMidPlmDto> customeFind(ProductMidPlm pam) {
        return this.selectList(getMethodName(), pam);
    }

    @Override
    public void updateProdNameByProdNo(String prodName, String prodNo) {
        Params params = Params.create();
        params.add("prodName",prodName);
        params.add("prodNo",prodNo);
        this.update(getMethodName(),params);
    }


}
