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
import com.zhiyun.dao.ProdCrafworkPlmDao;
import com.zhiyun.dto.ProdCrafworkPlmDto;
import com.zhiyun.entity.ProdCrafworkPlm;
import com.zhiyun.service.ProdCrafworkPlmService;
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
@Service("prodCrafworkPlmService")
public class ProdCrafworkPlmServiceImpl extends BaseServiceImpl<ProdCrafworkPlm, Long> implements ProdCrafworkPlmService {

    @Resource
    private ProdCrafworkPlmDao prodCrafworkPlmDao;

    @Override
    protected BaseDao<ProdCrafworkPlm, Long> getBaseDao() {
        return this.prodCrafworkPlmDao;
    }

    @Override
    public DataGrid<ProdCrafworkPlmDto> cutomePage(Params entity, Pager pager) {
        return prodCrafworkPlmDao.cutomePage(entity, pager);

    }

    @Override
    public List<ProdCrafworkPlmDto> findAllByDesc(ProdCrafworkPlmDto prodCrafworkPlmDto) {
        return prodCrafworkPlmDao.findAllByDesc(prodCrafworkPlmDto);
    }

    @Override
    public List<ProdCrafworkPlmDto> findAllLeftBig(ProdCrafworkPlm pm) {
        return prodCrafworkPlmDao.findAllLeftBig(pm);
    }

    @Override
    public void customUpdate(ProdCrafworkPlmDto prodCrafworkPlmDto) {
       prodCrafworkPlmDao.customUpdate(prodCrafworkPlmDto);
    }
}
