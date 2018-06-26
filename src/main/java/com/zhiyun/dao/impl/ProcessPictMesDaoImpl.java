/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.ProcessPictMesDao;
import com.zhiyun.dto.ProcessPictMesDto;
import com.zhiyun.entity.ProcessPictMes;
import org.springframework.stereotype.Repository;

/**
 * ProcessPictMesDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("processPictMesDao")
public class ProcessPictMesDaoImpl extends BaseDaoImpl<ProcessPictMes, Long> implements ProcessPictMesDao {

    @Override
    public DataGrid<ProcessPictMesDto> customPage(Params entity, Pager pager) {
        return selectPage(getMethodName(), entity, pager);
    }

    @Override
    public DataGrid<ProcessPictMesDto> customPageBeforeUpload(Params entity, Pager pager) {
        return selectPage(getMethodName(), entity, pager);
    }
}
