/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import java.util.List;

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
	String findEmp(Long userId);
	
	// 订单任务完成数
	int findFinishNum(TaskFinishedMesDto taskFinishedMesDto);
	
	// 未驳回领取任务数
	int findGetNum(TaskFinishedMesDto taskFinishedMesDto);
		
	// 所有领取的任务数
	int findAllGetNum(TaskFinishedMesDto taskFinishedMesDto);
	
	// 订单任务数量
	int findAllNum(TaskFinishedMesDto taskFinishedMesDto);
	
	// 通过客户编号获取订单编码
	List<String> findOrder(TaskFinishedMesDto taskFinishedMesDto);
	
	// 通过外部订号, 商品编码 查询下属的所有工艺
	List<Long> findCrafworkId(TaskFinishedMesDto taskFinishedMesDto);
	
	// 查询订单下所有商品的信息
	List<TaskFinishedMesDto> findOrderProd(TaskFinishedMesDto taskFinishedMesDto);
	
	// 确认完工 修改状态
	int updateIsCheck(TaskFinishedMes taskFinishedMes);
	
	

}
