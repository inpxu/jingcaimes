/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.JudgeOnlycodeIosDao;
import com.zhiyun.entity.JudgeOnlycodeIos;
import com.zhiyun.service.JudgeOnlycodeIosService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("judgeOnlycodeIosService")
public class JudgeOnlycodeIosServiceImpl extends BaseServiceImpl<JudgeOnlycodeIos, Long> implements JudgeOnlycodeIosService {

	@Resource
	private JudgeOnlycodeIosDao judgeOnlycodeIosDao;

	@Override
	protected BaseDao<JudgeOnlycodeIos, Long> getBaseDao() {
		return this.judgeOnlycodeIosDao;
	}
}
