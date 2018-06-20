/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MidProdOutDetailIosDao;
import com.zhiyun.entity.MidProdOutDetailIos;
import com.zhiyun.service.MidProdOutDetailIosService;

/**
 * 半成品领用明细Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("midProdOutDetailIosService")
public class MidProdOutDetailIosServiceImpl extends BaseServiceImpl<MidProdOutDetailIos, Long> implements MidProdOutDetailIosService {

	@Resource
	private MidProdOutDetailIosDao midProdOutDetailIosDao;

	@Override
	protected BaseDao<MidProdOutDetailIos, Long> getBaseDao() {
		return this.midProdOutDetailIosDao;
	}
}
