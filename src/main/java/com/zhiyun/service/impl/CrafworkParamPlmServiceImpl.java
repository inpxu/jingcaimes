/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CrafworkParamPlmDao;
import com.zhiyun.entity.CrafworkParamPlm;
import com.zhiyun.service.CrafworkParamPlmService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("crafworkParamPlmService")
public class CrafworkParamPlmServiceImpl extends BaseServiceImpl<CrafworkParamPlm, Long> implements CrafworkParamPlmService {

	@Resource
	private CrafworkParamPlmDao crafworkParamPlmDao;

	@Override
	protected BaseDao<CrafworkParamPlm, Long> getBaseDao() {
		return this.crafworkParamPlmDao;
	}
}
