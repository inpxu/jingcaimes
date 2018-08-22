/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.ProdCrafworkPlmDto;
import com.zhiyun.entity.ProdCrafworkPlm;

import java.util.List;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ProdCrafworkPlmService extends BaseService<ProdCrafworkPlm, Long> {

    DataGrid<ProdCrafworkPlmDto> cutomePage(Params entity, Pager pager);

    List<ProdCrafworkPlmDto> findAllByDesc(ProdCrafworkPlmDto prodCrafworkPlmDto);

    List<ProdCrafworkPlmDto> findAllLeftBig(ProdCrafworkPlm id);

    void customUpdate(ProdCrafworkPlmDto prodCrafworkPlmDto);

    List<ProdCrafworkPlmDto> findAllLeftSmall(ProdCrafworkPlm pam);
}
