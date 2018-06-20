/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.WasteRecordMidMesDao;
import com.zhiyun.entity.WasteRecordMidMes;
import com.zhiyun.service.WasteRecordMidMesService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("wasteRecordMidMesService")
public class WasteRecordMidMesServiceImpl extends BaseServiceImpl<WasteRecordMidMes, Long> implements WasteRecordMidMesService {

	@Resource
	private WasteRecordMidMesDao wasteRecordMidMesDao;

	@Override
	protected BaseDao<WasteRecordMidMes, Long> getBaseDao() {
		return this.wasteRecordMidMesDao;
	}
}
