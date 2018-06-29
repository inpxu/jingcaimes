/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.dto.QuartersHcmDto;
import com.zhiyun.entity.CasOrg;

import java.util.List;

/**
 * CasOrgDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CasOrgDao extends BaseDao<CasOrg, Long> {

    List<CasOrg> listInHcm(Long companyId);

    List<QuartersHcmDto> findByQuarter(QuartersHcmDto quartersHcmDto);

    List<CasOrg> listByUserIdInHcm(Long userId, Long companyId);


}
