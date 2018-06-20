/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MidProdInDetailIosDao;
import com.zhiyun.entity.MidProdInDetailIos;
import com.zhiyun.service.MidProdInDetailIosService;

/**
 * 半成品入库明细Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("midProdInDetailIosService")
public class MidProdInDetailIosServiceImpl extends BaseServiceImpl<MidProdInDetailIos, Long> implements MidProdInDetailIosService {

	@Resource
	private MidProdInDetailIosDao midProdInDetailIosDao;

	@Override
	protected BaseDao<MidProdInDetailIos, Long> getBaseDao() {
		return this.midProdInDetailIosDao;
	}
}
