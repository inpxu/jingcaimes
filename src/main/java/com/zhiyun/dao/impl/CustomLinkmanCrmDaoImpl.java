/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.dao.CustomLinkmanCrmDao;
import com.zhiyun.dto.CustomLinkmanCrmDto;
import com.zhiyun.entity.CustomLinkmanCrm;

/**
 * CustomLinkmanCrmDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("customLinkmanCrmDao")
public class CustomLinkmanCrmDaoImpl extends BaseDaoImpl<CustomLinkmanCrm, Long> implements CustomLinkmanCrmDao {

	@Override
	public List<String> findEmail(CustomLinkmanCrmDto customLinkmanCrmDto) {
		return this.selectList(getMethodName(), customLinkmanCrmDto);
	}

}
