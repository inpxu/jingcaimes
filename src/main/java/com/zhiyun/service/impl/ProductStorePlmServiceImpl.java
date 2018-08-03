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
import com.zhiyun.dao.ProduceOrderDetailApsDao;
import com.zhiyun.dao.ProductMidPlmDao;
import com.zhiyun.dao.ProductStorePlmDao;
import com.zhiyun.dto.ProductStorePlmDto;
import com.zhiyun.entity.ProduceOrderDetailAps;
import com.zhiyun.entity.ProductMidPlm;
import com.zhiyun.entity.ProductStorePlm;
import com.zhiyun.service.ProductStorePlmService;
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
@Service("productStorePlmService")
public class ProductStorePlmServiceImpl extends BaseServiceImpl<ProductStorePlm, Long> implements ProductStorePlmService {

    @Resource
    private ProductStorePlmDao productStorePlmDao;
    @Resource
    private ProduceOrderDetailApsDao produceOrderDetailApsDao;
    @Resource
    private ProductMidPlmDao productMidPlmDao;

    @Override
    protected BaseDao<ProductStorePlm, Long> getBaseDao() {
        return this.productStorePlmDao;
    }

    @Override
    public DataGrid<ProductStorePlmDto> customPage(Params params, Pager pager) {
        return productStorePlmDao.customPage(params, pager);
    }

    @Override
    public List<ProductStorePlm> list(ProductStorePlm productStorePlm) {
        return productStorePlmDao.list(productStorePlm);
    }

    @Override
    public int findTypeNum(Long typeId) {
        ProductStorePlm productStorePlm = new ProductStorePlm();
        productStorePlm.setTypeId(typeId);
        return productStorePlmDao.findTypeNum(productStorePlm);
    }

    @Override
    public void relationWithOrder(Long id) {
        //删除之前判断产品是否被订单关联
        ProduceOrderDetailAps param = new ProduceOrderDetailAps();
        param.setCompanyId(UserHolder.getCompanyId());
        param.setDeleted("F");
        //查询产品编码
        ProductStorePlm productStorePlm = productStorePlmDao.get(id);
        if (productStorePlm == null) {
            throw new BusinessException("产品不存在");
        }
        param.setProdNo(productStorePlm.getProdNo());
        List<ProduceOrderDetailAps> produceOrderDetailAps = produceOrderDetailApsDao.find(param);
        if (CollectionUtils.isNotEmpty(produceOrderDetailAps)) {
            throw new BusinessException("产品被订单关联，不能删除");
        }
    }

    @Override
    public void usedByMidProduct(Long id) {
        ProductStorePlm productStorePlm = productStorePlmDao.get(id);
        if (productStorePlm == null) {
            throw new BusinessException("产品不存在");
        }
        ProductMidPlm param = new ProductMidPlm();
        param.setProdNo(productStorePlm.getProdNo());
        param.setCompanyId(UserHolder.getCompanyId());
        param.setDeleted("F");
        List<ProductMidPlm> productMidPlms = productMidPlmDao.find(param);
        if (CollectionUtils.isNotEmpty(productMidPlms)) {
            //被使用
            throw new BusinessException("产品被半成品使用中，不能删除");
        }
    }
}
