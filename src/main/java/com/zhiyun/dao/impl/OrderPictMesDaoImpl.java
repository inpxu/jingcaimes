/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.OrderPictMesDao;
import com.zhiyun.dto.OrderPictMesDto;
import com.zhiyun.entity.OrderPictMes;
import com.zhiyun.entity.TaskReceiveEmpMes;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * OrderPictMesDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("orderPictMesDao")
public class OrderPictMesDaoImpl extends BaseDaoImpl<OrderPictMes, Long> implements OrderPictMesDao {

	@Override
	public int updateTime(TaskReceiveEmpMes taskReceiveEmpMes) {
		return this.update(getMethodName(), taskReceiveEmpMes);
	}

	@Override
	public List<OrderPictMesDto> findOrderProd(OrderPictMesDto orderPictMesDto) {
		return this.selectList(getMethodName(), orderPictMesDto);
	}

	@Override
	public List<String> findPictures(OrderPictMesDto orderPictMesDto) {
		return this.selectList(getMethodName(), orderPictMesDto);
	}

	@Override
	public String findShowPic(OrderPictMesDto orderPictMesDto) {
		return this.selectOne(getMethodName(), orderPictMesDto);
	}

	@Override
	public List<OrderPictMesDto> findGetTime(OrderPictMesDto orderPictMesDto) {
		return this.selectList(getMethodName(), orderPictMesDto);
	}

	@Override
	public void add(OrderPictMesDto orderPictMesDto) {
		List<String> pics = orderPictMesDto.getPictureUrls();
		for (String pic : pics) {
			OrderPictMes orMes = new OrderPictMes();
			orMes.setCrafworkId(orderPictMesDto.getCrafworkId());
			orMes.setDesc(orderPictMesDto.getDesc());
			orMes.setInsideOrder(orderPictMesDto.getInsideOrder());
			orMes.setProdNo(orderPictMesDto.getProdNo());
			orMes.setGetTime(orderPictMesDto.getGetTime());
			orMes.setSendDate(new Date());
			orMes.setLinkPath(pic);
			orMes.setCompanyId(UserHolder.getCompanyId());
			orMes.setSendEmp(UserHolder.getUserName());
			this.insert(orMes);
		}
	}



}
