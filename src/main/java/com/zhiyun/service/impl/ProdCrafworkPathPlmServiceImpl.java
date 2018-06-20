/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProdCrafworkPathPlmDao;
import com.zhiyun.entity.ProdCrafworkPathPlm;
import com.zhiyun.service.ProdCrafworkPathPlmService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("prodCrafworkPathPlmService")
public class ProdCrafworkPathPlmServiceImpl extends BaseServiceImpl<ProdCrafworkPathPlm, Long> implements ProdCrafworkPathPlmService {

	@Resource
	private ProdCrafworkPathPlmDao prodCrafworkPathPlmDao;

	@Override
	protected BaseDao<ProdCrafworkPathPlm, Long> getBaseDao() {
		return this.prodCrafworkPathPlmDao;
	}
}
