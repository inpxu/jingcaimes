/**
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.DeliveryDetailCrmDto;
import com.zhiyun.dto.DeliveryProdCrmDto;
import com.zhiyun.entity.DeliveryDetailCrm;
import com.zhiyun.service.DeliveryDetailCrmService;

/**
 * 客户显示交图详情
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-25下午4:33:55
 */
@Controller
@RequestMapping(value = "/remote")
public class DeliveryRemoteController {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryRemoteController.class);

    @Resource
    private DeliveryDetailCrmService deliveryDetailCrmService;

    @RequestMapping(value = "/index_dl", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
        logger.debug("request in");
        return "/demo/index_dl";
    }

    /**
     * 交图明细
     * @param: @param deliveryDetailCrm
     * @param: @return
     * @return: Object
     * @author: 徐飞
     * @date: 2018-7-12 上午8:54:53
     */
    @ResponseBody
    @RequestMapping(value = "/orderDetail", method = {RequestMethod.GET, RequestMethod.POST})
    public Object orderDetail(DeliveryProdCrmDto deliveryProdCrmDto) {
        BaseResult<DeliveryProdCrmDto> baseResult = new BaseResult<DeliveryProdCrmDto>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            DeliveryProdCrmDto dto = deliveryDetailCrmService.orderDetail(deliveryProdCrmDto);
            baseResult.setModel(dto);
        } catch (BusinessException be) {
            logger.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult);
    }

    /**
     * 产品明细
     * @param: @param deliveryDetailCrm
     * @param: @return
     * @return: Object
     * @author: 徐飞
     * @date: 2018-7-10 下午2:26:16
     */
    @ResponseBody
    @RequestMapping(value = "/prodDelivery", method = {RequestMethod.GET, RequestMethod.POST})
    public Object prodDelivery(@Valid DeliveryDetailCrm deliveryDetailCrm) {
        BaseResult<DeliveryDetailCrmDto> baseResult = new BaseResult<DeliveryDetailCrmDto>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            DeliveryDetailCrmDto dto = deliveryDetailCrmService.prodDetail(deliveryDetailCrm);
            baseResult.setModel(dto);
        } catch (BusinessException be) {
            logger.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult);
    }

}
