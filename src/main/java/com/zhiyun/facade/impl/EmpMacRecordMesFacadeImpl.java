/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.facade.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.facade.EmpMacRecordMesFacade;
import com.zhiyun.service.EmpMacRecordMesService;

/**
 * EmpMacRecordMesFacade接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("empMacRecordMesFacade")
public class EmpMacRecordMesFacadeImpl implements EmpMacRecordMesFacade {

	@Resource
	private EmpMacRecordMesService empMacRecordMesService;
	
	
}
