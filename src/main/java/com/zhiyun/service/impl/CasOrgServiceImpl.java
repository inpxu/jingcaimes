/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CasOrgDao;
import com.zhiyun.dto.QuartersHcmDto;
import com.zhiyun.entity.CasOrg;
import com.zhiyun.service.CasOrgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("casOrgService")
public class CasOrgServiceImpl extends BaseServiceImpl<CasOrg, Long> implements CasOrgService {

	@Resource
	private CasOrgDao casOrgDao;

	@Override
	protected BaseDao<CasOrg, Long> getBaseDao() {
		return this.casOrgDao;
	}

    @Override
    public List<QuartersHcmDto> findByQuarter(QuartersHcmDto quartersHcmDto) {
        return this.casOrgDao.findByQuarter(quartersHcmDto);
    }
}
