/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.dto.EmpFolderHcmDto;
import com.zhiyun.entity.EmpFolderHcm;

import java.util.List;

/**
 * EmpFolderHcmDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface EmpFolderHcmDao extends BaseDao<EmpFolderHcm, Long> {

    List<EmpFolderHcm> listByOrgIdInHcm(Long orgId,Long companyId);

    EmpFolderHcm getInHcm(EmpFolderHcm empFolderHcm);
    
    // 通过userId查询信息
    EmpFolderHcmDto findByUserId(Long userId);

}
