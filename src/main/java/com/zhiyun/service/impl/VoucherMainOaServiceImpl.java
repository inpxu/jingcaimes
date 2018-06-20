/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.VoucherMainOaDao;
import com.zhiyun.entity.VoucherMainOa;
import com.zhiyun.service.VoucherMainOaService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("voucherMainOaService")
public class VoucherMainOaServiceImpl extends BaseServiceImpl<VoucherMainOa, Long> implements VoucherMainOaService {

	@Resource
	private VoucherMainOaDao voucherMainOaDao;

	@Override
	protected BaseDao<VoucherMainOa, Long> getBaseDao() {
		return this.voucherMainOaDao;
	}
}
