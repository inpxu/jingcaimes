/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MidProdOutIosDao;
import com.zhiyun.entity.MidProdOutIos;
import com.zhiyun.service.MidProdOutIosService;

/**
 * 半成品领用单Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("midProdOutIosService")
public class MidProdOutIosServiceImpl extends BaseServiceImpl<MidProdOutIos, Long> implements MidProdOutIosService {

	@Resource
	private MidProdOutIosDao midProdOutIosDao;

	@Override
	protected BaseDao<MidProdOutIos, Long> getBaseDao() {
		return this.midProdOutIosDao;
	}
}
