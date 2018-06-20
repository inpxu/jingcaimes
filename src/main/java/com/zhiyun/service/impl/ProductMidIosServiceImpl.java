/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProductMidIosDao;
import com.zhiyun.entity.ProductMidIos;
import com.zhiyun.service.ProductMidIosService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("productMidIosService")
public class ProductMidIosServiceImpl extends BaseServiceImpl<ProductMidIos, Long> implements ProductMidIosService {

	@Resource
	private ProductMidIosDao productMidIosDao;

	@Override
	protected BaseDao<ProductMidIos, Long> getBaseDao() {
		return this.productMidIosDao;
	}
}
