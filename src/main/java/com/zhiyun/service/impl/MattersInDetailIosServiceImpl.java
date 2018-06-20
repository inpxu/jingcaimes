/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MattersInDetailIosDao;
import com.zhiyun.entity.MattersInDetailIos;
import com.zhiyun.service.MattersInDetailIosService;

/**
 * 物料入库明细Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("mattersInDetailIosService")
public class MattersInDetailIosServiceImpl extends BaseServiceImpl<MattersInDetailIos, Long> implements MattersInDetailIosService {

	@Resource
	private MattersInDetailIosDao mattersInDetailIosDao;

	@Override
	protected BaseDao<MattersInDetailIos, Long> getBaseDao() {
		return this.mattersInDetailIosDao;
	}
}
