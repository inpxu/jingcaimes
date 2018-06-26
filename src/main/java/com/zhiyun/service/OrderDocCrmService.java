/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.entity.OrderDocCrm;

import java.util.List;

/**
 * 订单库Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface OrderDocCrmService extends BaseService<OrderDocCrm, Long> {

    List<OrderDocCrm> listByCustomIdInCrm(Long customId);

    OrderDocCrm getByIdInCrm(Long id);

}
