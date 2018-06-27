/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.OrderPictMesDto;
import com.zhiyun.entity.OrderPictMes;
import com.zhiyun.service.OrderPictMesService;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-6-22下午1:21:14
 */
@Controller
@RequestMapping(value = "/pictMess")
public class OrderPictMesController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(OrderPictMesController.class);
	
	@Resource
	private OrderPictMesService orderPictMesService;
	
	/**
	 * 确认完工
	 * @param: @param orderPictMesDto
	 * @param: @param bindingResult
	 * @param: @return
	 * @return: Object 
	 * @author: 徐飞
	 * @date: 2018-6-22 下午1:46:41
	 */
	@ResponseBody
	@RequestMapping(value = "/accomplish", method = { RequestMethod.GET, RequestMethod.POST })
	public Object accomplish(@Valid OrderPictMesDto orderPictMesDto , BindingResult bindingResult) {
		BaseResult<OrderPictMesDto> baseResult = new BaseResult<OrderPictMesDto>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			List<String> pics = orderPictMesDto.getPictureUrls();
			for (String pic : pics) {
				OrderPictMes orMes = new OrderPictMes();
//				BeanUtils.copyProperties(orMes, orderPictMesDto);
				orMes.setCrafworkId(orderPictMesDto.getCrafworkId());
				orMes.setDesc(orderPictMesDto.getDesc());
				orMes.setInsideOrder(orderPictMesDto.getInsideOrder());
				orMes.setProdNo(orderPictMesDto.getProdNo());
				orMes.setSendDate(orderPictMesDto.getSendDate());
				orMes.setLinkPath(pic);
				orMes.setCompanyId(UserHolder.getCompanyId());
				orMes.setSendEmp(UserHolder.getUserName());
				orderPictMesService.insert(orMes);
			}
			orderPictMesService.updateTime(orderPictMesDto);
			baseResult.setModel(orderPictMesDto);
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
	 * 详情
	 * @param: @param orderPictMes
	 * @param: @param bindingResult
	 * @param: @return
	 * @return: Object 
	 * @author: 徐飞
	 * @date: 2018-6-22 下午3:03:51
	 */
	@ResponseBody
	@RequestMapping(value = "/pictDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public Object pictDetail(@Valid OrderPictMes orderPictMes , BindingResult bindingResult) {
		BaseResult<OrderPictMesDto> baseResult = new BaseResult<OrderPictMesDto>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			OrderPictMesDto orderPictMesDto = orderPictMesService.pictPage(orderPictMes);
			baseResult.setModel(orderPictMesDto);
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
