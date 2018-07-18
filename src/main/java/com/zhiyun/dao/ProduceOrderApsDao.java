/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.ProduceOrderApsDto;
import com.zhiyun.entity.ProduceOrderAps;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * ProduceOrderApsDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ProduceOrderApsDao extends BaseDao<ProduceOrderAps, Long> {

    void deleteProduceOrderAps(List<String>voucherNos, String modifyBy,Date modifyTime);

    DataGrid<ProduceOrderApsDto> myPage(Params params, Page page);

    ProduceOrderApsDto getDetailByVoucherNo(String voucherNo,Long companyId);

    List<ProduceOrderAps>list(ProduceOrderAps produceOrderAps);

    List<ProduceOrderAps>listByUserId(Long userId,Long companyId);
    
    // 查询内部订单,销售订单, 单据号
    ProduceOrderAps findOrderNo(ProduceOrderAps produceOrderAps);
    
    // 模糊查询订单
    List<ProduceOrderAps> getOrder(ProduceOrderAps produceOrderAps);

}
