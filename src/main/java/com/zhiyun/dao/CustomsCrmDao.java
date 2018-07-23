/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.dto.CustomsCrmDto;
import com.zhiyun.entity.CustomsCrm;

import java.util.List;

/**
 * CustomsCrmDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CustomsCrmDao extends BaseDao<CustomsCrm, Long> {

    List<CustomsCrm> listInCrm(Long companyId);
    
    
    // 模糊查询客户信息
    List<CustomsCrmDto> findCus(CustomsCrmDto customsCrmDto);
    
    // 通过编码查询客户名称
    String findCusByNo(String customNo);

}
