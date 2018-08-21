/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.EmpFolderHcmDao;
import com.zhiyun.entity.EmpFolderHcm;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * EmpFolderHcmDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("empFolderHcmDao")
public class EmpFolderHcmDaoImpl extends BaseDaoImpl<EmpFolderHcm, Long> implements EmpFolderHcmDao {

    @Override
    public List<EmpFolderHcm> listByOrgIdInHcm(Long orgId, Long companyId) {
        Params params = Params.create();
        params.add("orgId", orgId);
        params.add("companyId", companyId);
        return this.selectList(getMethodName(), params);
    }

    @Override
    public EmpFolderHcm getInHcm(EmpFolderHcm empFolderHcm) {
        return this.selectOne(getMethodName(), empFolderHcm);
    }

    @Override
    public String findByUserId(Map<String, Object> userId) {
         return this.selectOne(getMethodName(), userId);
    }
}
