/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MattersStoreIosDao;
import com.zhiyun.entity.MattersStoreIos;
import com.zhiyun.service.MattersStoreIosService;

/**
 * 物料库Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("mattersStoreIosService")
public class MattersStoreIosServiceImpl extends BaseServiceImpl<MattersStoreIos, Long> implements MattersStoreIosService {

	@Resource
	private MattersStoreIosDao mattersStoreIosDao;

	@Override
	protected BaseDao<MattersStoreIos, Long> getBaseDao() {
		return this.mattersStoreIosDao;
	}
}
