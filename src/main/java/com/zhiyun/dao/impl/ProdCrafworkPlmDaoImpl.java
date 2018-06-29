/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.ProdCrafworkPlmDao;
import com.zhiyun.dto.ProdCrafworkPlmDto;
import com.zhiyun.entity.ProdCrafworkPlm;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ProdCrafworkPlmDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("prodCrafworkPlmDao")
public class ProdCrafworkPlmDaoImpl extends BaseDaoImpl<ProdCrafworkPlm, Long> implements ProdCrafworkPlmDao {

    @Override
    public DataGrid<ProdCrafworkPlmDto> cutomePage(Params entity, Pager pager) {
        return selectPage(getMethodName(), entity, pager);
    }

    @Override
    public List<ProdCrafworkPlmDto> findAllByDesc(ProdCrafworkPlmDto prodCrafworkPlmDto) {
        return this.selectList(getMethodName(), prodCrafworkPlmDto);
    }

    @Override
    public List<ProdCrafworkPlmDto> findAllLeftBig(ProdCrafworkPlm pm) {
        return this.selectList(getMethodName(), pm);
    }

    @Override
    public void customUpdate(ProdCrafworkPlmDto prodCrafworkPlmDto) {
        this.update(getMethodName(), prodCrafworkPlmDto);
    }

    @Override
    public List<ProdCrafworkPlm> listByProdNos(List<String> prodNos){
        return this.selectList(getMethodName(),Params.create().add("prodNos",prodNos));
    }
}
