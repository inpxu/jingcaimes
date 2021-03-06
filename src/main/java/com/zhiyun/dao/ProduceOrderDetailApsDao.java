/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.dto.DeliveryDetailCrmDto;
import com.zhiyun.dto.ProduceOrderDetailDto;
import com.zhiyun.entity.ProduceOrderDetailAps;

import java.util.Date;
import java.util.List;

/**
 * ProduceOrderDetailApsDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ProduceOrderDetailApsDao extends BaseDao<ProduceOrderDetailAps, Long> {

    void deleteProduceOrderDetailAps(List<String> ids, String modifyBy, Date modifyTime);
    
    // 查询商品数据
    ProduceOrderDetailDto findWares(ProduceOrderDetailDto produceOrderDetailDto);
    
    void updateOkAmount(DeliveryDetailCrmDto deliveryDetailCrmDto);

    // 获取完成数量
    ProduceOrderDetailDto getOkAmount(DeliveryDetailCrmDto deliveryDetailCrmDto);

}
