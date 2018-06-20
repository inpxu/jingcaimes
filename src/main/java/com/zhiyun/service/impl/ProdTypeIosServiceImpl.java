/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProdTypeIosDao;
import com.zhiyun.entity.ProdTypeIos;
import com.zhiyun.service.ProdTypeIosService;

/**
 * 产品分类Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("prodTypeIosService")
public class ProdTypeIosServiceImpl extends BaseServiceImpl<ProdTypeIos, Long> implements ProdTypeIosService {

	@Resource
	private ProdTypeIosDao prodTypeIosDao;

	@Override
	protected BaseDao<ProdTypeIos, Long> getBaseDao() {
		return this.prodTypeIosDao;
	}
}
