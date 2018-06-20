/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MattersInIosDao;
import com.zhiyun.entity.MattersInIos;
import com.zhiyun.service.MattersInIosService;

/**
 * 物料入库单Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("mattersInIosService")
public class MattersInIosServiceImpl extends BaseServiceImpl<MattersInIos, Long> implements MattersInIosService {

	@Resource
	private MattersInIosDao mattersInIosDao;

	@Override
	protected BaseDao<MattersInIos, Long> getBaseDao() {
		return this.mattersInIosDao;
	}
}
