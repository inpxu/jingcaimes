/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.EmpMacRecordMesDao;
import com.zhiyun.entity.EmpMacRecordMes;
import com.zhiyun.service.EmpMacRecordMesService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("empMacRecordMesService")
public class EmpMacRecordMesServiceImpl extends BaseServiceImpl<EmpMacRecordMes, Long> implements EmpMacRecordMesService {

	@Resource
	private EmpMacRecordMesDao empMacRecordMesDao;

	@Override
	protected BaseDao<EmpMacRecordMes, Long> getBaseDao() {
		return this.empMacRecordMesDao;
	}
}
