/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.OrderDocCrmDao;
import com.zhiyun.entity.OrderDocCrm;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OrderDocCrmDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("orderDocCrmDao")
public class OrderDocCrmDaoImpl extends BaseDaoImpl<OrderDocCrm, Long> implements OrderDocCrmDao {

    @Override
    public List<OrderDocCrm> listInCrm(OrderDocCrm orderDocCrm){
        return this.selectList(getMethodName(),orderDocCrm);
    }

}
