/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.DeliveryDetailCrmDto;
import com.zhiyun.dto.DeliveryProdCrmDto;
import com.zhiyun.entity.DeliveryDetailCrm;
import com.zhiyun.service.DeliveryDetailCrmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 交货详情
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-10下午2:20:01
 */
@RestController
@RequestMapping(value="/deliDetl")
public class DeliveryDetailCrmController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryDetailCrmController.class);
    
    // 交图明细前置链接
    @Value("${start.delivery.url}")
    private String START_DELIVERY_URL = "";
    
    @Resource
    private DeliveryDetailCrmService deliveryDetailCrmService;
    
    /**
     * 产品明细
     * @param: @param deliveryDetailCrm
     * @param: @param bindingResult
     * @param: @return
     * @return: Object 
     * @author: 徐飞
     * @date: 2018-7-10 下午2:26:16
     */
    @ResponseBody
 	@RequestMapping(value = "/prodDelivery", method = { RequestMethod.GET, RequestMethod.POST })
    public Object prodDelivery(@Valid DeliveryDetailCrm deliveryDetailCrm, BindingResult bindingResult){
    	BaseResult<DeliveryDetailCrmDto> baseResult = new BaseResult<>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			deliveryDetailCrm.setCompanyId(UserHolder.getCompanyId());
			DeliveryDetailCrmDto dto = deliveryDetailCrmService.prodDetail(deliveryDetailCrm);
			baseResult.setModel(dto);
		} catch (BusinessException be) {
			logger.debug("业务异常"+be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常"+e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
    }
	
    /**
     * 交图明细
     * @param: @param deliveryDetailCrm
     * @param: @param bindingResult
     * @param: @return
     * @return: Object 
     * @author: 徐飞
     * @date: 2018-7-12 上午8:54:53
     */
    @ResponseBody
   	@RequestMapping(value = "/orderDetail", method = { RequestMethod.GET, RequestMethod.POST })
    public Object orderDetail(@Valid DeliveryProdCrmDto deliveryProdCrmDto, BindingResult bindingResult){
      	BaseResult<DeliveryProdCrmDto> baseResult = new BaseResult<>();
  		baseResult.setResult(true);
  		baseResult.setMessage("操作成功"); 
  		try {
  			vaildParamsDefault(baseResult, bindingResult);
            Long companyId = UserHolder.getCompanyId();
            deliveryProdCrmDto.setCompanyId(companyId);
  			DeliveryProdCrmDto dto = deliveryDetailCrmService.orderDetail(deliveryProdCrmDto);
  			String orderNo = deliveryProdCrmDto.getOrderNo();
            dto.setDeliveryUrl(START_DELIVERY_URL + "?orderNo=" + orderNo + "&companyId=" + companyId);
  			baseResult.setModel(dto);
  		} catch (BusinessException be) {
  			logger.debug("业务异常"+be);
  			baseResult.setResult(false);
  			baseResult.setMessage(be.getMessage());
  		} catch (Exception e) {
  			logger.debug("系统异常"+e);
  			baseResult.setResult(false);
  			baseResult.setMessage("系统异常");
  		}
  		return JSON.toJSONString(baseResult);
    }
}
