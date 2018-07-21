/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.constant.TaskMesStateEnmu;
import com.zhiyun.dto.TaskPondMesDto;
import com.zhiyun.service.TaskPondMesService;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.TaskReceiveEmpMesDao;
import com.zhiyun.entity.TaskReceiveEmpMes;
import com.zhiyun.service.TaskReceiveEmpMesService;

import java.util.ArrayList;
import java.util.List;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("taskReceiveEmpMesService")
public class TaskReceiveEmpMesServiceImpl extends BaseServiceImpl<TaskReceiveEmpMes, Long> implements TaskReceiveEmpMesService {

	@Resource
	private TaskReceiveEmpMesDao taskReceiveEmpMesDao;

	@Resource
    private TaskPondMesService taskPondMesService;


	@Override
	protected BaseDao<TaskReceiveEmpMes, Long> getBaseDao() {
		return this.taskReceiveEmpMesDao;
	}


    @Override
    public DataGrid<TaskPondMesDto> myPage(TaskPondMesDto taskPondMesDto, Pager pager) {

        List<String> statuses = new ArrayList<>();
        statuses.add(TaskMesStateEnmu.PROCESSING.getId());
        statuses.add(TaskMesStateEnmu.DONE.getId());

        return taskPondMesService.myPage(taskPondMesDto,statuses,pager);
    }
}
