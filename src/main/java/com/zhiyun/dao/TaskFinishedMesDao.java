/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.TaskFinishedMesDto;
import com.zhiyun.entity.TaskFinishedMes;

/**
 * TaskFinishedMesDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface TaskFinishedMesDao extends BaseDao<TaskFinishedMes, Long> {
	
	// 任务交工查询分页
	DataGrid<TaskFinishedMesDto> findByMes(Params params, Page page);
	
	// 发起评审查询分页
	DataGrid<TaskFinishedMesDto> cusReview(Params params, Page page);
	
	// 获取当前登录人的工号
	String findEmp(int userId);
	
	// 订单任务完成数
	int findFinishNum(String insideOrder);
	
	// 订单任务数量
	int findAllNum(String insideOrder);

}
