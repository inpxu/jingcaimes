/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProduceOrderApsDao;
import com.zhiyun.entity.ProduceOrderAps;
import com.zhiyun.service.ProduceOrderApsService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("produceOrderApsService")
public class ProduceOrderApsServiceImpl extends BaseServiceImpl<ProduceOrderAps, Long> implements ProduceOrderApsService {

	@Resource
	private ProduceOrderApsDao produceOrderApsDao;

	@Override
	protected BaseDao<ProduceOrderAps, Long> getBaseDao() {
		return this.produceOrderApsDao;
	}
}
