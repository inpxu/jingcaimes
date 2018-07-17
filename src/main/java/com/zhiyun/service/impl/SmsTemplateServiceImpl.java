/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.SmsTemplateDao;
import com.zhiyun.entity.SmsTemplate;
import com.zhiyun.service.SmsTemplateService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("smsTemplateService")
public class SmsTemplateServiceImpl extends BaseServiceImpl<SmsTemplate, Long> implements SmsTemplateService {

	@Resource
	private SmsTemplateDao smsTemplateDao;

	@Override
	protected BaseDao<SmsTemplate, Long> getBaseDao() {
		return this.smsTemplateDao;
	}
}
