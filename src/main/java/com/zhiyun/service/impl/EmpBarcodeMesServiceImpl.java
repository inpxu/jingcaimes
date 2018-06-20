/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.EmpBarcodeMesDao;
import com.zhiyun.entity.EmpBarcodeMes;
import com.zhiyun.service.EmpBarcodeMesService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("empBarcodeMesService")
public class EmpBarcodeMesServiceImpl extends BaseServiceImpl<EmpBarcodeMes, Long> implements EmpBarcodeMesService {

	@Resource
	private EmpBarcodeMesDao empBarcodeMesDao;

	@Override
	protected BaseDao<EmpBarcodeMes, Long> getBaseDao() {
		return this.empBarcodeMesDao;
	}
}
