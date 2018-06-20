/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProdTypeCrmDao;
import com.zhiyun.entity.ProdTypeCrm;
import com.zhiyun.service.ProdTypeCrmService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("prodTypeCrmService")
public class ProdTypeCrmServiceImpl extends BaseServiceImpl<ProdTypeCrm, Long> implements ProdTypeCrmService {

	@Resource
	private ProdTypeCrmDao prodTypeCrmDao;

	@Override
	protected BaseDao<ProdTypeCrm, Long> getBaseDao() {
		return this.prodTypeCrmDao;
	}
}
