/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.ProductStorePlmDto;
import com.zhiyun.entity.ProductStorePlm;

import java.util.List;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ProductStorePlmService extends BaseService<ProductStorePlm, Long> {

    DataGrid<ProductStorePlmDto> customPage(Params params, Pager pager);

    List<ProductStorePlm> list(ProductStorePlm productStorePlm);

    int findTypeNum(Long typeId);

    /**
     * 产品是否被订单关联
     *
     * @param id
     * @return void
     * @author 邓艺
     * @date 2018/8/3 0003 上午 10:06
     */
    void relationWithOrder(Long id);

    /**
     * 判断产品是否被半成品使用
     *
     * @param id
     * @return void
     * @author 邓艺
     * @date 2018/8/3 0003 上午 10:13
     */
    void usedByMidProduct(Long id);
    

    // 关闭状态
    int closeProdStatus(ProductStorePlm productStorePlm);

}
