/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import com.zhiyun.entity.CasUser;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CasUserDao;
import com.zhiyun.service.CasUserService;

import java.util.List;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("casUserService")
public class CasUserServiceImpl extends BaseServiceImpl<CasUser, Long> implements CasUserService {

	@Resource
	private CasUserDao casUserDao;

	@Override
	protected BaseDao<CasUser, Long> getBaseDao() {
		return this.casUserDao;
	}

    @Override
    public List<CasUser> listCasUserInAuthAuthorization(CasUser casUser) {
        return casUserDao.listCasUserInAuthAuthorization(casUser);
    }
}
