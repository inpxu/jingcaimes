/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.QuartersHcmDto;
import com.zhiyun.entity.CasOrg;

import java.util.List;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CasOrgService extends BaseService<CasOrg, Long> {

    List<QuartersHcmDto> findByQuarter(QuartersHcmDto quartersHcmDto);
}
