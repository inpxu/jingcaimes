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
import com.zhiyun.client.UserHolder;
import com.zhiyun.constant.TaskMesStateEnmu;
import com.zhiyun.dao.TaskCheckRecordMesDao;
import com.zhiyun.dao.TaskPondMesDao;
import com.zhiyun.dto.TaskCheckRecordMesDto;
import com.zhiyun.dto.TaskPondMesDto;
import com.zhiyun.entity.TaskCheckRecordMes;
import com.zhiyun.entity.TaskPondMes;
import com.zhiyun.entity.TaskReceiveEmpMes;
import com.zhiyun.service.TaskCheckRecordMesService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.jdbc.Null;
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
    public List<TaskCheckRecordMesDto> findProd(TaskCheckRecordMes taskCheckRecordMes) {
        return taskCheckRecordMesDao.findProd(taskCheckRecordMes);
    }
    
    @Override
    public List<TaskCheckRecordMesDto> findOrder(TaskCheckRecordMes taskCheckRecordMes) {
        return taskCheckRecordMesDao.findOrder(taskCheckRecordMes);
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

        TaskCheckRecordMes tcrm = taskCheckRecordMesDao.get(taskCheckRecordMes.getId());

        TaskPondMes taskPondMes = new TaskPondMes();
        taskPondMes.setInsideOrder(tcrm.getInsideOrder());
        taskPondMes.setCrafworkId(tcrm.getCrafworkId());
        taskPondMes.setProdNo(tcrm.getProdNo());
        taskPondMes.setCompanyId(tcrm.getCompanyId());
        taskPondMes.setGetTime(tcrm.getGetTime());
        if(UNPASS.equals(taskCheckRecordMes.getCusIsOk())){
            //修改原来任务状态
            taskPondMes.setStatus(TaskMesStateEnmu.UNPASS.getId());
            taskPondMesDao.updateStatus(taskPondMes);

            //新增任务池任务
            List<TaskPondMes> taskPondMeses = taskPondMesDao.find(taskPondMes);
            if(CollectionUtils.isNotEmpty(taskPondMeses)){
                taskPondMes = taskPondMeses.get(0);
                taskPondMes.setStatus(TaskMesStateEnmu.DISPATCHING.getId());
                taskPondMes.setId(null);
                taskPondMes.setGetTime(null);
            }
            taskPondMesDao.insert(taskPondMes);
        }else{
            taskPondMes.setStatus(TaskMesStateEnmu.DONE.getId());
            taskPondMesDao.updateStatus(taskPondMes);
        }

        TaskReceiveEmpMes taskReceiveEmpMes = new TaskReceiveEmpMes();
        taskCheckRecordMes.setCompanyId(UserHolder.getCompanyId());
        taskCheckRecordMes.setInsideOrder(tcrm.getInsideOrder());
        taskCheckRecordMes.setCrafworkId(tcrm.getCrafworkId());
        taskCheckRecordMes.setGetTime(tcrm.getGetTime());
        taskCheckRecordMes.setProdNo(tcrm.getProdNo());

        this.update(taskCheckRecordMes);
    }
}
