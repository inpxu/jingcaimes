/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.TaskCheckRecordMesDao;
import com.zhiyun.dto.TaskCheckRecordMesDto;
import com.zhiyun.entity.TaskCheckRecordMes;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TaskCheckRecordMesDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("taskCheckRecordMesDao")
public class TaskCheckRecordMesDaoImpl extends BaseDaoImpl<TaskCheckRecordMes, Long> implements TaskCheckRecordMesDao {

    @Override
    public List<TaskCheckRecordMesDto> findAllProd(TaskCheckRecordMes taskCheckRecordMes) {
        return this.selectList(getMethodName(), taskCheckRecordMes);
    }

    @Override
    public DataGrid<TaskCheckRecordMesDto> customPage(Params entity, Pager pager) {
        return this.selectPage(getMethodName(), entity, pager);
    }

    @Override
    public List<TaskCheckRecordMesDto> findAllPics(TaskCheckRecordMesDto taskCheckRecordMesDto) {
        return this.selectList(getMethodName(), taskCheckRecordMesDto);
    }
}
