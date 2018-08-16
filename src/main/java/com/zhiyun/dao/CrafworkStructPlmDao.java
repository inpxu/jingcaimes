/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import java.util.List;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.CrafworkStructPlmDto;
import com.zhiyun.entity.CrafworkStructPlm;

/**
 * CrafworkStructPlmDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CrafworkStructPlmDao extends BaseDao<CrafworkStructPlm, Long> {

    DataGrid<CrafworkStructPlmDto> customPage(Params parmas, Pager pager);
    
    List<String> findCrafName(CrafworkStructPlm crafworkStructPlm);
}
