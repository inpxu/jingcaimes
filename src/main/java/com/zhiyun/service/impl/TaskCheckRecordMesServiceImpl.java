/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.TaskCheckRecordMesDao;
import com.zhiyun.dto.TaskCheckRecordMesDto;
import com.zhiyun.entity.TaskCheckRecordMes;
import com.zhiyun.service.TaskCheckRecordMesService;
import org.springframework.stereotype.Service;

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

	@Resource
	private TaskCheckRecordMesDao taskCheckRecordMesDao;

	@Override
	protected BaseDao<TaskCheckRecordMes, Long> getBaseDao() {
		return this.taskCheckRecordMesDao;
	}

    @Override
    public List<TaskCheckRecordMesDto> findAllProd(TaskCheckRecordMes taskCheckRecordMes) {
        return taskCheckRecordMesDao.findAllProd(taskCheckRecordMes);
    }
}
