/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.OrderDocCrmDao;
import com.zhiyun.dto.OrderDocCrmDto;
import com.zhiyun.entity.OrderDocCrm;
import com.zhiyun.service.OrderDocCrmService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单库Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("orderDocCrmService")
public class OrderDocCrmServiceImpl extends BaseServiceImpl<OrderDocCrm, Long> implements OrderDocCrmService {

	@Resource
	private OrderDocCrmDao orderDocCrmDao;

	@Override
	protected BaseDao<OrderDocCrm, Long> getBaseDao() {
		return this.orderDocCrmDao;
	}

	@Override
	public List<OrderDocCrm> listByCustomIdInCrm(Long customId){
		OrderDocCrm orderDocCrm = new OrderDocCrm();
		orderDocCrm.setCustomId(customId);
		orderDocCrm.setCompanyId(UserHolder.getCompanyId());
		return orderDocCrmDao.listInCrm(orderDocCrm);
	}

	@Override
	public OrderDocCrmDto getByIdInCrm(Long id){
		OrderDocCrm orderDocCrm = new OrderDocCrm();
		orderDocCrm.setId(id);
		orderDocCrm.setCompanyId(UserHolder.getCompanyId());
		List<OrderDocCrmDto> orderDocCrmDtos= orderDocCrmDao.getOrderDocDtoById(id,UserHolder.getCompanyId());
		if(CollectionUtils.isEmpty(orderDocCrmDtos)){
			return null;
		}
		return orderDocCrmDtos.get(0);
	}
}
