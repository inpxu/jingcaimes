/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.DeliveryDetailCrmDao;
import com.zhiyun.dao.OrderPictMesDao;
import com.zhiyun.dao.ProduceOrderApsDao;
import com.zhiyun.dao.ProduceOrderDetailApsDao;
import com.zhiyun.dao.TaskFinishedMesDao;
import com.zhiyun.dao.TaskReceiveEmpMesDao;
import com.zhiyun.dto.DeliveryDetailCrmDto;
import com.zhiyun.dto.DeliveryProdCrmDto;
import com.zhiyun.dto.OrderDetailCrmDto;
import com.zhiyun.dto.OrderPictMesDto;
import com.zhiyun.dto.ProduceOrderApsDto;
import com.zhiyun.dto.ProduceOrderDetailDto;
import com.zhiyun.dto.TaskFinishedMesDto;
import com.zhiyun.dto.TaskReceiveEmpMesDto;
import com.zhiyun.entity.DeliveryDetailCrm;
import com.zhiyun.entity.TaskReceiveEmpMes;
import com.zhiyun.service.DeliveryDetailCrmService;
import com.zhiyun.service.TaskReceiveEmpMesService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("deliveryDetailCrmService")
public class DeliveryDetailCrmServiceImpl extends BaseServiceImpl<DeliveryDetailCrm, Long> implements DeliveryDetailCrmService {

	@Resource
	private DeliveryDetailCrmDao deliveryDetailCrmDao;
	@Resource
	private ProduceOrderDetailApsDao produceOrderDetailApsDao;
	@Resource
	private ProduceOrderApsDao produceOrderApsDao;
	@Resource
	private TaskReceiveEmpMesDao taskReceiveEmpMesDao;
	@Resource
	private TaskFinishedMesDao taskFinishedMesDao;
	@Resource
	private OrderPictMesDao orderPictMesDao;

	@Override
	protected BaseDao<DeliveryDetailCrm, Long> getBaseDao() {
		return this.deliveryDetailCrmDao;
	}

	@Override
	public int insertDeli(DeliveryDetailCrm deliveryDetailCrm) {
		String orderNo = deliveryDetailCrm.getOrderNo();
		String waresNo = deliveryDetailCrm.getWaresNo();
		ProduceOrderDetailDto detailDto = new ProduceOrderDetailDto();
		detailDto.setOrderNo(orderNo);
		detailDto.setWaresNo(waresNo);
		detailDto = produceOrderDetailApsDao.findWares(detailDto);
		// 单位
		String unit = detailDto.getUnit();
		// 数量
		BigDecimal amount = detailDto.getAmount();
		TaskReceiveEmpMesDto empMesDto = new TaskReceiveEmpMesDto();
		empMesDto.setOrderNo(orderNo);
		empMesDto.setWaresNo(waresNo);
		empMesDto = taskReceiveEmpMesDao.getProdPrice(empMesDto);
		// 小计
		BigDecimal total = empMesDto.getProdPrice();
		deliveryDetailCrm.setTotal(total);
		deliveryDetailCrm.setUnit(unit);
		deliveryDetailCrm.setAmount(amount);
		return deliveryDetailCrmDao.insert(deliveryDetailCrm);
	}

	@Override
	public DeliveryDetailCrmDto prodDetail(DeliveryDetailCrm deliveryDetailCrm) {
		DeliveryDetailCrmDto deto = new DeliveryDetailCrmDto();
		String orderNo = deliveryDetailCrm.getOrderNo();
		String waresNo = deliveryDetailCrm.getWaresNo();
		Long companyId = deliveryDetailCrm.getCompanyId();
		TaskReceiveEmpMesDto taskReceiveEmpMesDto = new TaskReceiveEmpMesDto();
		taskReceiveEmpMesDto.setOrderNo(orderNo);
		taskReceiveEmpMesDto.setWaresNo(waresNo);
		taskReceiveEmpMesDto.setCompanyId(companyId);
		// 产品价格
		BigDecimal prodPrice = taskReceiveEmpMesDao.getProdPrice(taskReceiveEmpMesDto).getProdPrice();
		
		ProduceOrderDetailDto produceOrderDetailDto = new ProduceOrderDetailDto();
		produceOrderDetailDto.setOrderNo(orderNo);
		produceOrderDetailDto.setWaresNo(waresNo);
		produceOrderDetailDto.setCompanyId(companyId);
		ProduceOrderDetailDto orderDetailDto = produceOrderDetailApsDao.findWares(produceOrderDetailDto);
		// 总数量 , 单位
		BigDecimal amount = orderDetailDto.getAmount();
		String until = orderDetailDto.getUnit();
		
		OrderPictMesDto dto = new OrderPictMesDto();
		dto.setOrderNo(orderNo);
		dto.setWaresNo(waresNo);
		dto.setCompanyId(companyId);
		// 工艺名称, 工艺数量, 单位
		List<OrderPictMesDto> pictDtos = orderPictMesDao.findOrderProd(dto);
		for (OrderPictMesDto pictDto : pictDtos) {
			Long craId = pictDto.getCrafworkId();
			dto.setCrafworkId(craId);

			// 领派工时间
			Date getTime = pictDto.getGetTime();
			dto.setGetTime(getTime);
				// 工艺图片
				List<String> linkPaths = orderPictMesDao.findPictures(dto);
				pictDto.setPictureUrls(linkPaths);
				// 完工时间
				TaskFinishedMesDto tf = new TaskFinishedMesDto();
				tf.setOrderNo(orderNo);
				tf.setWaresNo(waresNo);
				tf.setCrafworkId(craId);
				tf.setGetTime(getTime);
				Date okDateTime = taskFinishedMesDao.getOkTime(tf);
				pictDto.setOkDatetime(okDateTime);
		}
		deto.setSumAmount(amount);
		deto.setTotal(prodPrice);
		deto.setSumUnit(until);
		deto.setPictMess(pictDtos);
		return deto;
	}

	@Override
	public DeliveryProdCrmDto orderDetail(DeliveryProdCrmDto deliveryProdCrmDto) {
		DeliveryProdCrmDto prodDto = new DeliveryProdCrmDto();
		String orderNo = deliveryProdCrmDto.getOrderNo();
		Long companyId = deliveryProdCrmDto.getCompanyId();
		TaskFinishedMesDto taskFinishedMesDto = new TaskFinishedMesDto();
		taskFinishedMesDto.setOrderNo(orderNo);
		taskFinishedMesDto.setCompanyId(companyId);
		List<TaskFinishedMesDto> finishDtos = taskFinishedMesDao.findOrderProd(taskFinishedMesDto);
		// 总数量
		BigDecimal sum = BigDecimal.ZERO;
		// 总金额
		BigDecimal sumTatal = BigDecimal.ZERO;
		for (TaskFinishedMesDto finishDto : finishDtos) {
			String waresNo = finishDto.getWaresNo();
			OrderPictMesDto dto = new OrderPictMesDto();
			dto.setOrderNo(orderNo);
			dto.setCompanyId(companyId);
            String pic = orderPictMesDao.findShowPic(dto);
            finishDto.setPicture(pic);
			finishDto.setOrderNo(orderNo);
            finishDto.setCompanyId(companyId);
			TaskReceiveEmpMesDto taskReceiveEmpMesDto = new TaskReceiveEmpMesDto();
			taskReceiveEmpMesDto.setOrderNo(orderNo);
			taskReceiveEmpMesDto.setWaresNo(waresNo);
			taskReceiveEmpMesDto.setCompanyId(companyId);
			// 产品价格
			BigDecimal prodPrice = taskReceiveEmpMesDao.getProdPrice(taskReceiveEmpMesDto).getProdPrice();
			// 数量
			BigDecimal amount = finishDto.getAmount();
			sum = sum.add(amount);
			sumTatal = sumTatal.add(prodPrice.multiply(amount));
		}
		prodDto.setSum(sum);
		prodDto.setSumTatal(sumTatal);
		prodDto.setTaskFinishedMesDtos(finishDtos);
        prodDto.setCompanyId(companyId);
		return prodDto;
	}
}
