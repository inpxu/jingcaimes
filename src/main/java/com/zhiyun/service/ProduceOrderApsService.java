/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.ProduceOrderApsDto;
import com.zhiyun.dto.ProduceOrderApsQueryDto;
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

    void delete(List<String> voucherNos);

    List<ProduceOrderAps> listByInsideOrder(String insideOrder);

    DataGrid<ProduceOrderApsDto> myPage(ProduceOrderApsQueryDto produceOrderApsQueryDto, Pager pager);

    ProduceOrderApsDto getDetailByVoucherNo(String voucherNo);

    void audit(String voucherNo,boolean isPass);

    List<ProduceOrderAps> list(ProduceOrderAps produceOrderAps);

    List<ProduceOrderAps> listOnPrivilege();
    
    // 模糊查询订单
    List<ProduceOrderAps> getOrder(ProduceOrderAps produceOrderAps);
}
