/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.TaskPondMesDto;
import com.zhiyun.entity.TaskPondMes;

import java.awt.*;
import java.util.List;

/**
 * TaskPondMesDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface TaskPondMesDao extends BaseDao<TaskPondMes, Long> {

    DataGrid<TaskPondMesDto> myPage(Params params, Page page);

    TaskPondMesDto getById(Long id,Long companyId);

    // 完工修改状态
    int updateStatus(TaskPondMes taskPondMes);

    // 内部订单下拉查询
    List<TaskPondMes> getInsideOrder(TaskPondMes taskPondMes);

    // 产品信息下拉查询
    List<TaskPondMesDto> getProdName(TaskPondMesDto taskPondMes);


}
