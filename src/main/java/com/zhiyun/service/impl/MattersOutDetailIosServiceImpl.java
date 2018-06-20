/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MattersOutDetailIosDao;
import com.zhiyun.entity.MattersOutDetailIos;
import com.zhiyun.service.MattersOutDetailIosService;

/**
 * 物料领用明细Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("mattersOutDetailIosService")
public class MattersOutDetailIosServiceImpl extends BaseServiceImpl<MattersOutDetailIos, Long> implements MattersOutDetailIosService {

	@Resource
	private MattersOutDetailIosDao mattersOutDetailIosDao;

	@Override
	protected BaseDao<MattersOutDetailIos, Long> getBaseDao() {
		return this.mattersOutDetailIosDao;
	}
}
