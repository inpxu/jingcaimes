/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.entity.EmpFolderHcm;

import java.util.List;
import java.util.Map;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface EmpFolderHcmService extends BaseService<EmpFolderHcm, Long> {

    List<EmpFolderHcm> listByOrgId(Long orgId, Long companyId);

    List<EmpFolderHcm> listByTaskPondId(Long taskPondId,Long companyId);

    EmpFolderHcm getByUserId(Long userId,Long companyId);
    
    // 通过userId查询信息
    String findByUserId(Map<String, Object> userId);

}
