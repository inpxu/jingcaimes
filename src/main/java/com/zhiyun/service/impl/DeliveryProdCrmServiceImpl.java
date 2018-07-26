/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.CustomsCrmDao;
import com.zhiyun.dao.DeliveryDetailCrmDao;
import com.zhiyun.dao.DeliveryProdCrmDao;
import com.zhiyun.dao.ProduceOrderApsDao;
import com.zhiyun.dao.TaskFinishedMesDao;
import com.zhiyun.dto.DeliveryDetailCrmDto;
import com.zhiyun.dto.DeliveryProdCrmDto;
import com.zhiyun.dto.EmailSendDto;
import com.zhiyun.dto.TaskFinishedMesDto;
import com.zhiyun.entity.DeliveryProdCrm;
import com.zhiyun.entity.ProduceOrderAps;
import com.zhiyun.internal.EmailInterface;
import com.zhiyun.internal.base.BaseInterfResult;
import com.zhiyun.service.DeliveryDetailCrmService;
import com.zhiyun.service.DeliveryProdCrmService;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("deliveryProdCrmService")
public class DeliveryProdCrmServiceImpl extends BaseServiceImpl<DeliveryProdCrm, Long> implements DeliveryProdCrmService {

	@Resource
	private DeliveryProdCrmDao deliveryProdCrmDao;
	@Resource
	private TaskFinishedMesDao taskFinishedMesDao;
    @Resource
    private EmailInterface emailInterface;
    @Resource
    private DeliveryDetailCrmService deliveryDetailCrmService;
	@Resource
	private ProduceOrderApsDao produceOrderApsDao;
    @Resource
    private DeliveryDetailCrmDao deliveryDetailCrmDao;
    @Resource
    private CustomsCrmDao customsCrmDao;

	@Override
	protected BaseDao<DeliveryProdCrm, Long> getBaseDao() {
		return this.deliveryProdCrmDao;
	}

	@Override
	public DataGrid<DeliveryProdCrmDto> deliPage(DeliveryProdCrm deliveryProdCrm, Page page) {
		return deliveryProdCrmDao.deliPage(deliveryProdCrm, page);
	}

	@Override
	@Transactional
	public BaseResult<DeliveryProdCrmDto> sendMess(DeliveryProdCrmDto deliveryProdCrmDto) {
		BaseResult<DeliveryProdCrmDto> baseResult = new BaseResult<DeliveryProdCrmDto>();
		EmailSendDto emailSendDto = new EmailSendDto();
		Long companyId = UserHolder.getCompanyId();
		String email = deliveryProdCrmDto.getEmail();
		String remark = deliveryProdCrmDto.getRemark();
		String address = deliveryProdCrmDto.getSendAddress();
		String customName = customsCrmDao.findCusByNo(deliveryProdCrmDto.getCustomNo());
		String deliveryUrl = deliveryProdCrmDto.getDeliveryUrl();
//		String companyName = UserHolder.getCompanyName();
		String companyName = "晶彩云平台服务中心";
		String invoiceNo = deliveryProdCrmDto.getInvoiceNo();
		BigDecimal total = deliveryProdCrmDto.getTotal();
		String orderNo = deliveryProdCrmDto.getOrderNo();
		ProduceOrderAps orderAps = new ProduceOrderAps();
		orderAps.setCompanyId(companyId);
		orderAps.setOrderNo(orderNo);
		String voucherNo = produceOrderApsDao.findOrderNo(orderAps).getVoucherNo();
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年 MM月 dd日");
		String date = formatter.format(d);  
		String[] sendTo = {email};
		emailSendDto.setSendTo(sendTo);
		String subject = "【晶彩】订单" + orderNo + "交付详情";
		emailSendDto.setSubject(subject);
		String content = "尊敬的客户" + customName + "：<br/><br/>\t您的订单号为：" + orderNo + "<br/>\t收货地址：" +
				address + "<br/>\t发票号码：" + invoiceNo + "<br/>\t订单总价：" + total + "元<br/>\t产品工艺详情：" + 
				"<a href="+ deliveryUrl + ">" + "请点击此处查看" + "</a>" + "<br/>\t备注信息：" + remark + "<br/><br/><p align='right'>" + 
				companyName + "</p>" + "<p align='right'>" + date + "</p>";
		emailSendDto.setContent(content);
		// 发送邮件
		BaseInterfResult<String> inter = emailInterface.sendEmail(emailSendDto);
		if (inter.getResult() == false) {
			throw new BusinessException("异常码:" + inter.getErrorCode() + "异常信息:" + inter.getMessage());
		} else if (inter.getResult() == true) {
			baseResult.setResult(true);
			baseResult.setMessage("邮件发送成功！");
		}
		DeliveryProdCrm deliProd = new DeliveryProdCrm();
		deliProd.setCustomNo(deliveryProdCrmDto.getCustomNo());
		deliProd.setVoucherNo(voucherNo);
		deliProd.setDeliveryDate(d);
		deliProd.setInvoiceNo(invoiceNo);
		deliProd.setEmpNo(deliveryProdCrmDto.getEmpNo());
		deliProd.setTotal(total);
		deliProd.setRemark(deliveryProdCrmDto.getRemark());
		deliProd.setSendAddress(address);
		// 添加交货单信息
		int a = deliveryProdCrmDao.insert(deliProd);
		if (a == 0) {
			throw new BusinessException("交货单添加失败！");
		}
		Long id = deliProd.getId();
		TaskFinishedMesDto finishMes = new TaskFinishedMesDto();
		finishMes.setOrderNo(orderNo);
		finishMes.setCompanyId(companyId);
		List<TaskFinishedMesDto> finishDtos = taskFinishedMesDao.findOrderProd(finishMes);
		if (finishDtos == null || finishDtos.size() == 0) {
			throw new BusinessException("订单内商品为空！");
		}
		for (TaskFinishedMesDto task : finishDtos) {
			DeliveryDetailCrmDto deto = new DeliveryDetailCrmDto();
			deto.setOrderNo(orderNo);
			deto.setWaresNo(task.getWaresNo());
			deto.setDeliveryId(id);
			deto.setVoucherNo(voucherNo);
			// 添加交货明细
			int b = deliveryDetailCrmService.insertDeli(deto);
			if (b == 0) {
				throw new BusinessException("交货明细添加失败！");
			}
		}
		return baseResult;
	}

	@Override
	public List<String> findCustom(DeliveryProdCrmDto deliveryProdCrmDto) {
		return deliveryProdCrmDao.findCustom(deliveryProdCrmDto);
	}

	@Override
	public List<String> findOrderNo(DeliveryProdCrmDto deliveryProdCrmDto) {
		return deliveryProdCrmDao.findOrderNo(deliveryProdCrmDto);
	}

}
