/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.model.Params;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.TaskReceiveEmpMesDao;
import com.zhiyun.dto.TaskReceiveEmpMesDto;
import com.zhiyun.entity.TaskReceiveEmpMes;

import java.math.BigDecimal;
import java.util.List;

/**
 * TaskReceiveEmpMesDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("taskReceiveEmpMesDao")
public class TaskReceiveEmpMesDaoImpl extends BaseDaoImpl<TaskReceiveEmpMes, Long> implements TaskReceiveEmpMesDao {

    @Override
    public void updatePriceByTaskPondIds(List<Long> taskPondIds, BigDecimal price){
        Params params = Params.create();
        params.add("taskPondIds",taskPondIds);
        params.add("price",price);
        this.update(getMethodName(),params);
    }

	@Override
	public TaskReceiveEmpMesDto getProdPrice(TaskReceiveEmpMesDto taskReceiveEmpMesDto) {
		return this.selectOne(getMethodName(), taskReceiveEmpMesDto);
	}

}
