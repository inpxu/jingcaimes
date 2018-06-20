/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.facade.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.facade.MachineSetMesFacade;
import com.zhiyun.service.MachineSetMesService;

/**
 * MachineSetMesFacade接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("machineSetMesFacade")
public class MachineSetMesFacadeImpl implements MachineSetMesFacade {

	@Resource
	private MachineSetMesService machineSetMesService;
	
	
}
