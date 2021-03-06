/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.dto.OrderDocCrmDto;
import com.zhiyun.entity.OrderDocCrm;

import java.util.List;

/**
 * OrderDocCrmDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface OrderDocCrmDao extends BaseDao<OrderDocCrm, Long> {

    List<OrderDocCrm> listInCrm(OrderDocCrm orderDocCrm);

    List<OrderDocCrmDto> getOrderDocDtoById(Long id,Long companyId);

}
