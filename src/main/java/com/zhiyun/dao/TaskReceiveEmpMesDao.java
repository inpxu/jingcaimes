/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.dto.TaskReceiveEmpMesDto;
import com.zhiyun.entity.TaskReceiveEmpMes;

import java.math.BigDecimal;
import java.util.List;

/**
 * TaskReceiveEmpMesDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface TaskReceiveEmpMesDao extends BaseDao<TaskReceiveEmpMes, Long> {

    void updatePriceByTaskPondIds(List<Long> taskPondIds, BigDecimal price);
    
    // 查询商品价格
    TaskReceiveEmpMesDto getProdPrice(TaskReceiveEmpMesDto taskReceiveEmpMesDto);

    
    

}
