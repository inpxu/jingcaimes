/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.ProdCrafworkPlmDto;
import com.zhiyun.entity.ProdCrafworkPlm;

import java.util.List;

/**
 * ProdCrafworkPlmDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ProdCrafworkPlmDao extends BaseDao<ProdCrafworkPlm, Long> {

    DataGrid<ProdCrafworkPlmDto> cutomePage(Params entity, Pager pager);

    List<ProdCrafworkPlmDto> findAllByDesc(ProdCrafworkPlmDto prodCrafworkPlmDto);

    List<ProdCrafworkPlmDto> findAllLeftBig(ProdCrafworkPlm id);
}
