/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.TaskPondMesDto;
import com.zhiyun.entity.TaskReceiveEmpMes;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface TaskReceiveEmpMesService extends BaseService<TaskReceiveEmpMes, Long> {

    DataGrid<TaskPondMesDto> myPage(TaskPondMesDto TaskPondMesDto, Pager pager);

}
