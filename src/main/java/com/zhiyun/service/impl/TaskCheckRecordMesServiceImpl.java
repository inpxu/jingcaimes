/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.constant.TaskMesStateEnmu;
import com.zhiyun.dao.TaskCheckRecordMesDao;
import com.zhiyun.dao.TaskPondMesDao;
import com.zhiyun.dto.TaskCheckRecordMesDto;
import com.zhiyun.dto.TaskPondMesDto;
import com.zhiyun.entity.TaskCheckRecordMes;
import com.zhiyun.entity.TaskPondMes;
import com.zhiyun.service.TaskCheckRecordMesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("taskCheckRecordMesService")
public class TaskCheckRecordMesServiceImpl extends BaseServiceImpl<TaskCheckRecordMes, Long> implements TaskCheckRecordMesService {

    private static final String UNPASS = "3";

    @Resource
    private TaskCheckRecordMesDao taskCheckRecordMesDao;

    @Resource
    private TaskPondMesDao taskPondMesDao;

    @Override
    protected BaseDao<TaskCheckRecordMes, Long> getBaseDao() {
        return this.taskCheckRecordMesDao;
    }

    @Override
    public List<TaskCheckRecordMesDto> findAllProd(TaskCheckRecordMes taskCheckRecordMes) {
        return taskCheckRecordMesDao.findAllProd(taskCheckRecordMes);
    }

    @Override
    public DataGrid<TaskCheckRecordMesDto> customPage(Params entity, Pager pager) {
        return taskCheckRecordMesDao.customPage(entity, pager);
    }

    @Override
    public List<TaskCheckRecordMesDto> findAllPics(TaskCheckRecordMesDto taskCheckRecordMesDto) {
        return taskCheckRecordMesDao.findAllPics(taskCheckRecordMesDto);
    }

    @Transactional
    @Override
    public void approveStatus(TaskCheckRecordMes taskCheckRecordMes){
        if(UNPASS.equals(taskCheckRecordMes.getCusIsOk())){
            TaskPondMes taskPondMes = new TaskPondMes();
            taskPondMes.setInsideOrder(taskCheckRecordMes.getInsideOrder());
            taskPondMes.setCrafworkId(taskCheckRecordMes.getCrafworkId());
            taskPondMes.setProdNo(taskCheckRecordMes.getProdNo());
            taskPondMes.setCompanyId(taskCheckRecordMes.getCompanyId());
            taskPondMes.setStatus(TaskMesStateEnmu.UNPASS.getId());
            taskPondMesDao.updateStatus(taskPondMes);
        }
        this.update(taskCheckRecordMes);
    }
}
