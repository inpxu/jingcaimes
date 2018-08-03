/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.ProdCrafworkPlmDao;
import com.zhiyun.dao.ProductMidPlmDao;
import com.zhiyun.dto.ProductMidPlmDto;
import com.zhiyun.entity.ProdCrafworkPlm;
import com.zhiyun.entity.ProductMidPlm;
import com.zhiyun.service.ProductMidPlmService;
import org.apache.commons.collections.CollectionUtils;
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
@Service("productMidPlmService")
public class ProductMidPlmServiceImpl extends BaseServiceImpl<ProductMidPlm, Long> implements ProductMidPlmService {

    @Resource
    private ProductMidPlmDao productMidPlmDao;
    @Resource
    private ProdCrafworkPlmDao prodCrafworkPlmDao;

    @Override
    protected BaseDao<ProductMidPlm, Long> getBaseDao() {
        return this.productMidPlmDao;
    }

    @Override
    public DataGrid<ProductMidPlmDto> customPage(Params params, Pager pager) {
        return productMidPlmDao.customPage(params, pager);
    }

    @Override
    public List<ProductMidPlmDto> customeFind(ProductMidPlm pam) {
        return productMidPlmDao.customeFind(pam);
    }

    @Override
    public void relationWithCrafwork(Long id) {
        ProductMidPlm productMidPlm = productMidPlmDao.get(id);
        if (productMidPlm != null) {
            //判断是否关联，有关联就直接抛异常
            ProdCrafworkPlm param = new ProdCrafworkPlm();
            param.setDeleted("F");
            param.setCompanyId(UserHolder.getCompanyId());
            param.setProdNo(productMidPlm.getProdNo());
            List<ProdCrafworkPlm> prodCrafworkPlms = prodCrafworkPlmDao.find(param);
            if (CollectionUtils.isNotEmpty(prodCrafworkPlms)) {
                throw new BusinessException("半成品已经和工艺关联，不能删除");
            }

        } else {
            throw new BusinessException("数据错误");
        }

    }

}
