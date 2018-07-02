/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import java.util.List;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.TaskFinishedMesDto;
import com.zhiyun.entity.TaskFinishedMes;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface TaskFinishedMesService extends BaseService<TaskFinishedMes, Long> {
	
	// 查询分页
	DataGrid<TaskFinishedMesDto> findByMes(Params params, Page page);
	
	// 发起评审查询分页
	DataGrid<TaskFinishedMesDto> cusReview(Params params, Page page);
	
	// 获取当前登录人的工号
	String findEmp(int userId);
	
	// 查询客户已完工订单
	List<String> findFinishOrder(String customNo);

}
