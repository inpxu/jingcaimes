/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProductStorePlmDao;
import com.zhiyun.entity.ProductStorePlm;
import com.zhiyun.service.ProductStorePlmService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("productStorePlmService")
public class ProductStorePlmServiceImpl extends BaseServiceImpl<ProductStorePlm, Long> implements ProductStorePlmService {

	@Resource
	private ProductStorePlmDao productStorePlmDao;

	@Override
	protected BaseDao<ProductStorePlm, Long> getBaseDao() {
		return this.productStorePlmDao;
	}
}
