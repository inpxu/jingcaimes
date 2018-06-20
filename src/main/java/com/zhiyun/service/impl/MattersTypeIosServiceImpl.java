/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MattersTypeIosDao;
import com.zhiyun.entity.MattersTypeIos;
import com.zhiyun.service.MattersTypeIosService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("mattersTypeIosService")
public class MattersTypeIosServiceImpl extends BaseServiceImpl<MattersTypeIos, Long> implements MattersTypeIosService {

	@Resource
	private MattersTypeIosDao mattersTypeIosDao;

	@Override
	protected BaseDao<MattersTypeIos, Long> getBaseDao() {
		return this.mattersTypeIosDao;
	}
}
