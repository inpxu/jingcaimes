/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.TaskPondMesDto;
import com.zhiyun.entity.TaskPondMes;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface TaskPondMesService extends BaseService<TaskPondMes, Long> {

    DataGrid<TaskPondMesDto> myPageForDrawTask(TaskPondMesDto TaskPondMesDto, Pager pager);

    DataGrid<TaskPondMesDto> myPageForDistributeTask(TaskPondMesDto TaskPondMesDto, Pager pager);

    TaskPondMesDto getById(Long id);

    void drawTask(TaskPondMesDto taskPondMesDto);

    void distributeTask(TaskPondMesDto taskPondMesDto);

    void setTaskPrice(List<Long> insiderOrder, BigDecimal price);

}
