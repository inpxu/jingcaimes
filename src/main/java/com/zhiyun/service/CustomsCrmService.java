/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.CustomsCrmDto;
import com.zhiyun.entity.CustomsCrm;

import java.util.List;

/**
 * 客户信息表(客户公海)Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CustomsCrmService extends BaseService<CustomsCrm, Long> {

    List<CustomsCrm> listInCrm();
    
    // 模糊查询客户信息
    List<CustomsCrmDto> findCus(CustomsCrmDto customsCrmDto);

}
