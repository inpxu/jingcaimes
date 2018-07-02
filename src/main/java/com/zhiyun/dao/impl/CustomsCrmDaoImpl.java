/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.model.Params;
import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.CustomsCrmDao;
import com.zhiyun.dto.CustomsCrmDto;
import com.zhiyun.entity.CustomsCrm;

import java.util.List;

/**
 * CustomsCrmDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("customsCrmDao")
public class CustomsCrmDaoImpl extends BaseDaoImpl<CustomsCrm, Long> implements CustomsCrmDao {

    @Override
    public List<CustomsCrm> listInCrm(Long companyId) {
        return this.selectList(getMethodName(), Params.create().add("companyId",companyId));
    }

	@Override
	public List<CustomsCrmDto> findCus(CustomsCrmDto customsCrmDto) {
		return this.selectList(getMethodName(), customsCrmDto);
	}
}
