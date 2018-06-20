/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProdBomPlmDao;
import com.zhiyun.entity.ProdBomPlm;
import com.zhiyun.service.ProdBomPlmService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("prodBomPlmService")
public class ProdBomPlmServiceImpl extends BaseServiceImpl<ProdBomPlm, Long> implements ProdBomPlmService {

	@Resource
	private ProdBomPlmDao prodBomPlmDao;

	@Override
	protected BaseDao<ProdBomPlm, Long> getBaseDao() {
		return this.prodBomPlmDao;
	}
}
