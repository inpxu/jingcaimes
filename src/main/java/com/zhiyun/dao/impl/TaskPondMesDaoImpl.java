/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.ProduceOrderApsDto;
import com.zhiyun.dto.TaskPondMesDto;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.TaskPondMesDao;
import com.zhiyun.entity.TaskPondMes;

/**
 * TaskPondMesDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("taskPondMesDao")
public class TaskPondMesDaoImpl extends BaseDaoImpl<TaskPondMes, Long> implements TaskPondMesDao {

    @Override
    public DataGrid<TaskPondMesDto> myPage(Params params, Page page){
        return this.selectPage(getMethodName(), params, page);
    }

    @Override
    public TaskPondMesDto getById(Long id,Long companyId) {
        Params params = Params.create();
        params.add("id",id);
        params.add("companyId",companyId);
        return this.selectOne(getMethodName(),params);
    }

	@Override
	public int updateStatus(TaskPondMes taskPondMes) {
		taskPondMes.setCompanyId(UserHolder.getCompanyId());
		return this.update(getMethodName(), taskPondMes);
	}
}
