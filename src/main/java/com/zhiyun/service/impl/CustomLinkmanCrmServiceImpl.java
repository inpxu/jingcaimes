/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.CustomLinkmanCrmDao;
import com.zhiyun.dto.CustomLinkmanCrmDto;
import com.zhiyun.entity.CustomLinkmanCrm;
import com.zhiyun.service.CustomLinkmanCrmService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("customLinkmanCrmService")
public class CustomLinkmanCrmServiceImpl extends BaseServiceImpl<CustomLinkmanCrm, Long> implements CustomLinkmanCrmService {

	@Resource
	private CustomLinkmanCrmDao customLinkmanCrmDao;

	@Override
	protected BaseDao<CustomLinkmanCrm, Long> getBaseDao() {
		return this.customLinkmanCrmDao;
	}

	@Override
	public List<String> findEmail(CustomLinkmanCrmDto customLinkmanCrmDto) {
		customLinkmanCrmDto.setCompanyId(UserHolder.getCompanyId());
		return customLinkmanCrmDao.findEmail(customLinkmanCrmDto);
	}
}
