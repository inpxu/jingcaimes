/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProdInIosDao;
import com.zhiyun.entity.ProdInIos;
import com.zhiyun.service.ProdInIosService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("prodInIosService")
public class ProdInIosServiceImpl extends BaseServiceImpl<ProdInIos, Long> implements ProdInIosService {

	@Resource
	private ProdInIosDao prodInIosDao;

	@Override
	protected BaseDao<ProdInIos, Long> getBaseDao() {
		return this.prodInIosDao;
	}
}
