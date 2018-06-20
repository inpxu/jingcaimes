/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.MacOutputRecordMesDao;
import com.zhiyun.entity.MacOutputRecordMes;
import com.zhiyun.service.MacOutputRecordMesService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("macOutputRecordMesService")
public class MacOutputRecordMesServiceImpl extends BaseServiceImpl<MacOutputRecordMes, Long> implements MacOutputRecordMesService {

	@Resource
	private MacOutputRecordMesDao macOutputRecordMesDao;

	@Override
	protected BaseDao<MacOutputRecordMes, Long> getBaseDao() {
		return this.macOutputRecordMesDao;
	}
}
