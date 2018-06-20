/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MidProdInIosDao;
import com.zhiyun.entity.MidProdInIos;
import com.zhiyun.service.MidProdInIosService;

/**
 * 半成品入库单Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("midProdInIosService")
public class MidProdInIosServiceImpl extends BaseServiceImpl<MidProdInIos, Long> implements MidProdInIosService {

	@Resource
	private MidProdInIosDao midProdInIosDao;

	@Override
	protected BaseDao<MidProdInIos, Long> getBaseDao() {
		return this.midProdInIosDao;
	}
}
