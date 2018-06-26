/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.ProduceOrderApsDto;
import com.zhiyun.entity.ProduceOrderAps;

import java.util.List;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ProduceOrderApsService extends BaseService<ProduceOrderAps, Long> {

    void save(ProduceOrderApsDto produceOrderApsDto);

    void update(ProduceOrderApsDto produceOrderApsDto);

    void delete(List<Long> voucherNos);

    List<ProduceOrderApsDto> list(ProduceOrderApsDto produceOrderApsDto);

    List<ProduceOrderAps> listByInsideOrder(String insideOrder);
}
