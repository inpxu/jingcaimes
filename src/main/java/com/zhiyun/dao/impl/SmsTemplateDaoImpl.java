/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.SmsTemplateDao;
import com.zhiyun.entity.SmsTemplate;

/**
 * SmsTemplateDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("smsTemplateDao")
public class SmsTemplateDaoImpl extends BaseDaoImpl<SmsTemplate, Long> implements SmsTemplateDao {

}
