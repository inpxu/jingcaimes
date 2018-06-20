/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProdInDetailIosDao;
import com.zhiyun.entity.ProdInDetailIos;
import com.zhiyun.service.ProdInDetailIosService;

/**
 * 成品入库明细Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("prodInDetailIosService")
public class ProdInDetailIosServiceImpl extends BaseServiceImpl<ProdInDetailIos, Long> implements ProdInDetailIosService {

	@Resource
	private ProdInDetailIosDao prodInDetailIosDao;

	@Override
	protected BaseDao<ProdInDetailIos, Long> getBaseDao() {
		return this.prodInDetailIosDao;
	}
}
