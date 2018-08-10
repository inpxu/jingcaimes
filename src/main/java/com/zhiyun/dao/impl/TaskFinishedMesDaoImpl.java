/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.constant.ProcessStateEnum;
import com.zhiyun.constant.TaskMesStateEnmu;
import com.zhiyun.dao.TaskFinishedMesDao;
import com.zhiyun.dto.TaskFinishedMesDto;
import com.zhiyun.entity.TaskFinishedMes;

/**
 * TaskFinishedMesDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("taskFinishedMesDao")
public class TaskFinishedMesDaoImpl extends BaseDaoImpl<TaskFinishedMes, Long> implements TaskFinishedMesDao {

	@Override
	public DataGrid<TaskFinishedMesDto> findByMes(Params params, Page page) {
		return this.selectPage(getMethodName(), params, page);
	}

	@Override
	public DataGrid<TaskFinishedMesDto> cusReview(Params params, Page page) {
		return this.selectPage(getMethodName(), params, page);
	}

	@Override
	public String findEmp(Long userId) {
		return this.selectOne(getMethodName(), userId);
	}

	@Override
	public int findFinishNum(TaskFinishedMesDto taskFinishedMesDto) {
		return this.selectOne(getMethodName(),taskFinishedMesDto);
	}

	@Override
	public int findAllNum(TaskFinishedMesDto taskFinishedMesDto) {
		return this.selectOne(getMethodName(),taskFinishedMesDto);
	}

	@Override
	public List<String> findOrder(TaskFinishedMesDto taskFinishedMesDto) {
		return this.selectList(getMethodName(),taskFinishedMesDto);
	}

	@Override
	public List<Long> findCrafworkId(TaskFinishedMesDto taskFinishedMesDto) {
		return this.selectList(getMethodName(), taskFinishedMesDto);
	}

	@Override
	public List<TaskFinishedMesDto> findOrderProd(TaskFinishedMesDto taskFinishedMesDto) {
		return this.selectList(getMethodName(), taskFinishedMesDto);
	}

	@Override
	public int updateIsCheck(TaskFinishedMes taskFinishedMes) {
		taskFinishedMes.setCompanyId(UserHolder.getCompanyId());
		taskFinishedMes.setIsCheck(true);
		return this.update(getMethodName(), taskFinishedMes);
	}

	@Override
	public int findGetNum(TaskFinishedMesDto taskFinishedMesDto) {
		taskFinishedMesDto.setStatus(TaskMesStateEnmu.UNPASS.getId());
		return this.selectOne(getMethodName(),taskFinishedMesDto);
	}

	@Override
	public int findAllGetNum(TaskFinishedMesDto taskFinishedMesDto) {
		return this.selectOne(getMethodName(),taskFinishedMesDto);
	}

	@Override
	public TaskFinishedMesDto getOkTime(TaskFinishedMesDto taskFinishedMesDto) {
		return this.selectOne(getMethodName(), taskFinishedMesDto);
	}

}
