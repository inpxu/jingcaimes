/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.CustomsCrmDao;
import com.zhiyun.dto.CustomsCrmDto;
import com.zhiyun.entity.CustomsCrm;
import com.zhiyun.service.CustomsCrmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户信息表(客户公海)Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("customsCrmService")
public class CustomsCrmServiceImpl extends BaseServiceImpl<CustomsCrm, Long> implements CustomsCrmService {

	@Resource
	private CustomsCrmDao customsCrmDao;

	@Override
	protected BaseDao<CustomsCrm, Long> getBaseDao() {
		return this.customsCrmDao;
	}

	@Override
	public List<CustomsCrm> listInCrm() {
		Long companyId = UserHolder.getCompanyId();
		return customsCrmDao.listInCrm(companyId);
	}

	@Override
	public List<CustomsCrmDto> findCus(String customMess) {
		CustomsCrmDto cus = new CustomsCrmDto();
		cus.setCustomMess(customMess);
		cus.setCompanyId(UserHolder.getCompanyId());
		return customsCrmDao.findCus(cus);
	}
}
