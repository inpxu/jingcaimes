/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
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
import com.zhiyun.dao.DeliveryDetailCrmDao;
import com.zhiyun.dao.DeliveryProdCrmDao;
import com.zhiyun.dao.TaskFinishedMesDao;
import com.zhiyun.dto.DeliveryDetailCrmDto;
import com.zhiyun.dto.DeliveryProdCrmDto;
import com.zhiyun.dto.EmailSendDto;
import com.zhiyun.dto.TaskFinishedMesDto;
import com.zhiyun.entity.DeliveryDetailCrm;
import com.zhiyun.entity.DeliveryProdCrm;
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
    private DeliveryDetailCrmDao deliveryDetailCrmDao;

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
//		String companyName = UserHolder.getCompanyName();
		String email = deliveryProdCrmDto.getEmail();
		String address = deliveryProdCrmDto.getSendAddress();
		String customName = deliveryProdCrmDto.getCustomName();
//		String deliveryUrl = deliveryProdCrmDto.getDeliveryUrl();
		String deliveryUrl = "http://slide.news.sina.com.cn/y/slide_1_2841_299773.html#p=1";
		String companyName = "晶彩云平台服务中心";
		String invoiceNo = deliveryProdCrmDto.getInvoiceNo();
		BigDecimal total = deliveryProdCrmDto.getTotal();
		Long voucherNo = deliveryProdCrmDto.getVoucherNo();
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年 MM月 dd日");
		String date = formatter.format(d);  
		String[] sendTo = {email};
		emailSendDto.setSendTo(sendTo);
		String subject = "【晶彩】订单" + voucherNo + "交付详情";
		emailSendDto.setSubject(subject);
		String content = "尊敬的客户" + customName + "：<br/><br/>您的订单号为：" + voucherNo + "<br/>收货地址：" +
				address + "<br/>发票号码：" + invoiceNo + "<br/>订单总价：" + total + "元<br/>产品工艺详情：" + 
				deliveryUrl + "<br/><p align='right'>" + companyName + "</p>" + "<p align='right'>" + date + "</p>";
		emailSendDto.setContent(content);
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
		deliProd.setDeliveryDate(deliveryProdCrmDto.getDeliveryDate());
		deliProd.setInvoiceNo(invoiceNo);
		deliProd.setEmpNo(deliveryProdCrmDto.getEmpNo());
		deliProd.setTotal(total);
		deliProd.setRemark(deliveryProdCrmDto.getRemark());
		deliProd.setSendAddress(address);
		int a = deliveryProdCrmDao.insert(deliProd);
		if (a == 0) {
			throw new BusinessException("订单详情添加失败！");
		}
		Long id = deliProd.getId();
		DeliveryDetailCrm deli = new DeliveryDetailCrm();
		deli.setOrderNo(String.valueOf(voucherNo));
		List<TaskFinishedMesDto> finishDtos = deliveryDetailCrmService.orderDetail(deli).getTaskFinishedMesDtos();
		if (finishDtos == null || finishDtos.size() == 0) {
			throw new BusinessException("订单内商品为空！");
		}
		for (TaskFinishedMesDto task : finishDtos) {
			deli.setWaresNo(task.getWaresNo());
			DeliveryDetailCrmDto deliDetail = deliveryDetailCrmService.prodDetail(deli);
			DeliveryDetailCrm deliveryDetailCrm = new DeliveryDetailCrm();
			deliveryDetailCrm.setDeliveryId(id);
			deliveryDetailCrm.setVoucherNo(String.valueOf(voucherNo));
			deliveryDetailCrm.setOrderNo(deliDetail.getOrderNo());
			deliveryDetailCrm.setWaresNo(deliDetail.getWaresNo());
			deliveryDetailCrm.setAmount(task.getAmount());
			deliveryDetailCrm.setPrice(deliDetail.getTotal());
			deliveryDetailCrm.setUnit(deliDetail.getUnit());
			deliveryDetailCrm.setTotal(deliDetail.getTotal());
			int b = deliveryDetailCrmDao.insert(deliveryDetailCrm);
			if (b == 0) {
				throw new BusinessException("商品发图详情添加失败！");
			}
		}
		return baseResult;
	}
}
