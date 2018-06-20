/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProductStorePdmDao;
import com.zhiyun.entity.ProductStorePdm;
import com.zhiyun.service.ProductStorePdmService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("productStorePdmService")
public class ProductStorePdmServiceImpl extends BaseServiceImpl<ProductStorePdm, Long> implements ProductStorePdmService {

	@Resource
	private ProductStorePdmDao productStorePdmDao;

	@Override
	protected BaseDao<ProductStorePdm, Long> getBaseDao() {
		return this.productStorePdmDao;
	}
}
