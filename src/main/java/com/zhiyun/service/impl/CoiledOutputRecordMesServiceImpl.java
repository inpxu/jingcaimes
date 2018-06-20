/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CoiledOutputRecordMesDao;
import com.zhiyun.entity.CoiledOutputRecordMes;
import com.zhiyun.service.CoiledOutputRecordMesService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("coiledOutputRecordMesService")
public class CoiledOutputRecordMesServiceImpl extends BaseServiceImpl<CoiledOutputRecordMes, Long> implements CoiledOutputRecordMesService {

	@Resource
	private CoiledOutputRecordMesDao coiledOutputRecordMesDao;

	@Override
	protected BaseDao<CoiledOutputRecordMes, Long> getBaseDao() {
		return this.coiledOutputRecordMesDao;
	}
}
