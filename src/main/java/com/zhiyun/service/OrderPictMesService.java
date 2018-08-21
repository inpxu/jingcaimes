/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.OrderPictMesDto;
import com.zhiyun.entity.OrderPictMes;

import java.util.Map;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface OrderPictMesService extends BaseService<OrderPictMes, Long> {

    // 查看详情
    OrderPictMesDto pictPage(OrderPictMes orderPictMes);

    // 添加实际工时
    int updateTime(OrderPictMesDto orderPictMesDto);

    // 完工修改任务池状态
    int updatePondStatus(OrderPictMesDto orderPictMesDto);

    // 完工修改任务分配记录状态
    int updateReceiveStatus(OrderPictMesDto orderPictMesDto);

    // 确认完工
    int add(OrderPictMesDto orderPictMesDto);

    /**
     * 判断是否提交当前登录人的任务，true表示正常提交，false表示提交别人的
     *
     * @param params
     * @return boolean
     * @author 邓艺
     * @date 2018/8/21 11:19
     */
    boolean isCommitLoginUserWork(Map<String, Object> params);
}
