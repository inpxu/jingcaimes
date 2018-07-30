/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.CustomLinkmanCrmDto;
import com.zhiyun.dto.CustomsCrmDto;
import com.zhiyun.dto.DeliveryProdCrmDto;
import com.zhiyun.dto.TaskFinishedMesDto;
import com.zhiyun.internal.EmailInterface;
import com.zhiyun.service.CustomLinkmanCrmService;
import com.zhiyun.service.CustomsCrmService;
import com.zhiyun.service.DeliveryDetailCrmService;
import com.zhiyun.service.DeliveryProdCrmService;
import com.zhiyun.service.TaskFinishedMesService;

/**
 * 交货单
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-2上午9:54:02
 */
@RestController
@RequestMapping(value="/deliveryProd")
public class DeliveryProdCrmController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryProdCrmController.class);
    
 // 交图明细前置链接
    @Value("${start.delivery.url}")
	private String START_DELIVERY_URL = "";
    
    @Resource
    private DeliveryProdCrmService deliveryProdCrmService;
    @Resource
    private CustomsCrmService customsCrmService;
    @Resource
    private CustomLinkmanCrmService customLinkmanCrmService;
    @Resource
    private TaskFinishedMesService finishedMesService;
    @Resource
    private EmailInterface emailInterface;
    @Resource
    private DeliveryDetailCrmService deliveryDetailCrmService;
    /**
     * 模糊查询客户信息
     * @param: @param customMess
     * @param: @param bindingResult
     * @param: @return
     * @return: Object 
     * @author: 徐飞
     * @date: 2018-7-2 上午10:07:27
     */
    @ResponseBody
 	@RequestMapping(value = "/findCus", method = { RequestMethod.GET, RequestMethod.POST })
    public Object findCus(@Valid CustomsCrmDto customsCrmDto, BindingResult bindingResult){
    	BaseResult<List<CustomsCrmDto>> baseResult = new BaseResult<List<CustomsCrmDto>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			List<CustomsCrmDto> customs = customsCrmService.findCus(customsCrmDto);
			baseResult.setModel(customs);
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
     * 获取客户邮箱
     * @param: @param customNo
     * @param: @param bindingResult
     * @param: @return
     * @return: Object 
     * @author: 徐飞
     * @date: 2018-7-2 上午10:13:51
     */
    @ResponseBody
 	@RequestMapping(value = "/findEmail", method = { RequestMethod.GET, RequestMethod.POST })
    public Object findEmail(@Valid CustomLinkmanCrmDto customLinkmanCrmDto, BindingResult bindingResult){
    	BaseResult<List<String>> baseResult = new BaseResult<List<String>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			List<String> emails = customLinkmanCrmService.findEmail(customLinkmanCrmDto);
			baseResult.setModel(emails);
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
     * 查询已全部完工的订单
     * @param: @param customNo
     * @param: @param bindingResult
     * @param: @return
     * @return: Object 
     * @author: 徐飞
     * @date: 2018-7-2 上午10:24:02
     */
    @ResponseBody
 	@RequestMapping(value = "/findOrder", method = { RequestMethod.GET, RequestMethod.POST })
    public Object findFinishOrder(@Valid TaskFinishedMesDto taskFinishedMesDto, BindingResult bindingResult){
    	BaseResult<Object> baseResult = new BaseResult<Object>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			List<Map<String, String>> orders = finishedMesService.findFinishOrder(taskFinishedMesDto);
			baseResult.setModel(orders);
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
     * 生成交图明细链接
     * @param: @param orderNo
     * @param: @param bindingResult
     * @param: @return
     * @return: Object 
     * @author: 徐飞
     * @date: 2018-7-20 上午9:33:17
     */
    @ResponseBody
 	@RequestMapping(value = "/getUrl", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getUrl(@Valid String orderNo){
    	BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			Long companyId = UserHolder.getCompanyId();
			String deliveryUrl = START_DELIVERY_URL + "?orderNo=" + orderNo + "&companyId" + companyId;
			baseResult.setModel(deliveryUrl);
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
     * 已发邮件信息分页查询显示
     * @param: @param deliveryProdCrmDto
     * @param: @param bindingResult
     * @param: @param pager
     * @param: @return
     * @return: Object 
     * @author: 徐飞
     * @date: 2018-7-2 上午10:44:41
     */
    @ResponseBody
 	@RequestMapping(value = "/deliPage", method = { RequestMethod.GET, RequestMethod.POST })
    public Object deliPage(@Valid DeliveryProdCrmDto deliveryProdCrmDto, BindingResult bindingResult, Pager pager){
    	BaseResult<DataGrid<DeliveryProdCrmDto>> baseResult = new BaseResult<DataGrid<DeliveryProdCrmDto>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			DataGrid<DeliveryProdCrmDto> dataGrid = deliveryProdCrmService.deliPage(deliveryProdCrmDto, pager.getPage());
			Collection<DeliveryProdCrmDto> dtos = dataGrid.getItems();
			for (DeliveryProdCrmDto dto : dtos) {
				dto.setEmpName(dto.getEmpNo());
			}
			baseResult.setModel(dataGrid);
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
     * 查询已发送邮件的客户信息
     * @param: @param deliveryProdCrmDto
     * @param: @param bindingResult
     * @param: @return
     * @return: Object 
     * @author: 徐飞
     * @date: 2018-7-21 下午1:16:58
     */
    @ResponseBody
 	@RequestMapping(value = "/findCustom", method = { RequestMethod.GET, RequestMethod.POST })
    public Object findCustom(@Valid DeliveryProdCrmDto deliveryProdCrmDto, BindingResult bindingResult){
    	BaseResult<List<String>> baseResult = new BaseResult<List<String>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			List<String> customMess = deliveryProdCrmService.findCustom(deliveryProdCrmDto);
			baseResult.setModel(customMess);
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
     * 查询已发邮件的订单号
     * @param: @param deliveryProdCrmDto
     * @param: @param bindingResult
     * @param: @return
     * @return: Object 
     * @author: 徐飞
     * @date: 2018-7-21 下午1:18:20
     */
    @ResponseBody
 	@RequestMapping(value = "/findOrderNo", method = { RequestMethod.GET, RequestMethod.POST })
    public Object findOrderNo(@Valid DeliveryProdCrmDto deliveryProdCrmDto, BindingResult bindingResult){
    	BaseResult<List<String>> baseResult = new BaseResult<List<String>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			List<String> OrderNos = deliveryProdCrmService.findOrderNo(deliveryProdCrmDto);
			baseResult.setModel(OrderNos);
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
     * 发送邮件
     * @param: @param deliveryProdCrmDto
     * @param: @param bindingResult
     * @param: @return
     * @return: Object 
     * @author: 徐飞
     * @date: 2018-7-16 上午9:54:18
     */
    @ResponseBody
 	@RequestMapping(value = "/sendMess", method = { RequestMethod.GET, RequestMethod.POST })
    public Object sendMess(@Valid DeliveryProdCrmDto deliveryProdCrmDto, BindingResult bindingResult){
    	BaseResult<DeliveryProdCrmDto> baseResult = new BaseResult<DeliveryProdCrmDto>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			baseResult = deliveryProdCrmService.sendMess(deliveryProdCrmDto);
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