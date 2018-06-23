/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.dto.QuartersHcmDto;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.CasOrgDao;
import com.zhiyun.entity.CasOrg;

import java.util.List;

/**
 * CasOrgDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("casOrgDao")
public class CasOrgDaoImpl extends BaseDaoImpl<CasOrg, Long> implements CasOrgDao {

    @Override
    public List<QuartersHcmDto> findByQuarter(QuartersHcmDto quartersHcmDto) {
        return this.selectList(this.getMethodName(),quartersHcmDto);
    }
}
