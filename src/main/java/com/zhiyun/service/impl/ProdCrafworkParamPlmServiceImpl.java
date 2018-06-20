/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProdCrafworkParamPlmDao;
import com.zhiyun.entity.ProdCrafworkParamPlm;
import com.zhiyun.service.ProdCrafworkParamPlmService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("prodCrafworkParamPlmService")
public class ProdCrafworkParamPlmServiceImpl extends BaseServiceImpl<ProdCrafworkParamPlm, Long> implements ProdCrafworkParamPlmService {

	@Resource
	private ProdCrafworkParamPlmDao prodCrafworkParamPlmDao;

	@Override
	protected BaseDao<ProdCrafworkParamPlm, Long> getBaseDao() {
		return this.prodCrafworkParamPlmDao;
	}
}
