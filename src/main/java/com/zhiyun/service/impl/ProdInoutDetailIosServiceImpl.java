/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProdInoutDetailIosDao;
import com.zhiyun.entity.ProdInoutDetailIos;
import com.zhiyun.service.ProdInoutDetailIosService;

/**
 * 成品进出记录Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("prodInoutDetailIosService")
public class ProdInoutDetailIosServiceImpl extends BaseServiceImpl<ProdInoutDetailIos, Long> implements ProdInoutDetailIosService {

	@Resource
	private ProdInoutDetailIosDao prodInoutDetailIosDao;

	@Override
	protected BaseDao<ProdInoutDetailIos, Long> getBaseDao() {
		return this.prodInoutDetailIosDao;
	}
}
