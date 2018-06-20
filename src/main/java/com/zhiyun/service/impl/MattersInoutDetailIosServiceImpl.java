/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MattersInoutDetailIosDao;
import com.zhiyun.entity.MattersInoutDetailIos;
import com.zhiyun.service.MattersInoutDetailIosService;

/**
 * 物料进出记录Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("mattersInoutDetailIosService")
public class MattersInoutDetailIosServiceImpl extends BaseServiceImpl<MattersInoutDetailIos, Long> implements MattersInoutDetailIosService {

	@Resource
	private MattersInoutDetailIosDao mattersInoutDetailIosDao;

	@Override
	protected BaseDao<MattersInoutDetailIos, Long> getBaseDao() {
		return this.mattersInoutDetailIosDao;
	}
}
