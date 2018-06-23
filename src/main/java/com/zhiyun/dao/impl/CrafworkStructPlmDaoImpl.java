/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.CrafworkStructPlmDto;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.CrafworkStructPlmDao;
import com.zhiyun.entity.CrafworkStructPlm;

/**
 * CrafworkStructPlmDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("crafworkStructPlmDao")
public class CrafworkStructPlmDaoImpl extends BaseDaoImpl<CrafworkStructPlm, Long> implements CrafworkStructPlmDao {

    @Override
    public DataGrid<CrafworkStructPlmDto> customPage(Params parmas, Pager pager) {
        return this.selectPage(getMethodName(), parmas, pager);
    }
}
