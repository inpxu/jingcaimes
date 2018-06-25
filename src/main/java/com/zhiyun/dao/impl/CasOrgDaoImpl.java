/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.CasOrgDao;
import com.zhiyun.entity.CasOrg;
import org.springframework.stereotype.Repository;

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
    public List<CasOrg> listInHcm(Long companyId) {
        return this.selectList(getMethodName(),Params.create().add("companyId",companyId));
    }


}
