/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.OrderPictMesDao;
import com.zhiyun.entity.OrderPictMes;
import com.zhiyun.entity.TaskReceiveEmpMes;

/**
 * OrderPictMesDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("orderPictMesDao")
public class OrderPictMesDaoImpl extends BaseDaoImpl<OrderPictMes, Long> implements OrderPictMesDao {

	@Override
	public int updateTime(TaskReceiveEmpMes taskReceiveEmpMes) {
		return this.update(getMethodName(), taskReceiveEmpMes);
	}

}
