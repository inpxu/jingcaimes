/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.CrafworkParamPlmDto;
import com.zhiyun.entity.CrafworkParamPlm;

import java.util.List;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CrafworkParamPlmService extends BaseService<CrafworkParamPlm, Long> {

    List<CrafworkParamPlmDto> customFind(CrafworkParamPlm crafworkParamPlm);

    void deleteByCrafworkId(Long crafworkId);
}
