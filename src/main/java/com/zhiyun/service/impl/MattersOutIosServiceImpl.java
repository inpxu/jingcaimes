/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MattersOutIosDao;
import com.zhiyun.entity.MattersOutIos;
import com.zhiyun.service.MattersOutIosService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("mattersOutIosService")
public class MattersOutIosServiceImpl extends BaseServiceImpl<MattersOutIos, Long> implements MattersOutIosService {

	@Resource
	private MattersOutIosDao mattersOutIosDao;

	@Override
	protected BaseDao<MattersOutIos, Long> getBaseDao() {
		return this.mattersOutIosDao;
	}
}
