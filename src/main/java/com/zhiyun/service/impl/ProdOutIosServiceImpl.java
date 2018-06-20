/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProdOutIosDao;
import com.zhiyun.entity.ProdOutIos;
import com.zhiyun.service.ProdOutIosService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("prodOutIosService")
public class ProdOutIosServiceImpl extends BaseServiceImpl<ProdOutIos, Long> implements ProdOutIosService {

	@Resource
	private ProdOutIosDao prodOutIosDao;

	@Override
	protected BaseDao<ProdOutIos, Long> getBaseDao() {
		return this.prodOutIosDao;
	}
}
