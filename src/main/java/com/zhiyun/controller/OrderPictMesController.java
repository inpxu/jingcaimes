/**
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.OrderPictMesDto;
import com.zhiyun.entity.OrderPictMes;
import com.zhiyun.service.EmpFolderHcmService;
import com.zhiyun.service.OrderPictMesService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 确认完工工艺详情
 *
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
    @Autowired
    private EmpFolderHcmService empFolderHcmService;

    /**
     * 确认完工
     *
     * @param: @param orderPictMesDto
     * @param: @param bindingResult
     * @param: @return
     * @return: Object
     * @author: 徐飞
     * @date: 2018-6-22 下午1:46:41
     */
    @ResponseBody
    @RequestMapping(value = "/accomplish", method = {RequestMethod.GET, RequestMethod.POST})
    public Object accomplish(@Valid OrderPictMesDto orderPictMesDto, BindingResult bindingResult) {
        BaseResult<OrderPictMesDto> baseResult = new BaseResult<OrderPictMesDto>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            List<String> pics = orderPictMesDto.getPictureUrls();
            if (pics == null || pics.size() == 0) {
                throw new BusinessException("至少需上传一张图片");
            }
            Map<String, Object> param = new HashMap<>(2);
            param.put("companyId", UserHolder.getCompanyId());
            param.put("userId", UserHolder.getId());
            String byUserId = empFolderHcmService.findByUserId(param);
            if (StringUtils.isBlank(byUserId)) {
                throw new BusinessException("不能使用管理员交工");
            }
            //通过工艺执行人empno判断当前登录人只能交工自己的工作,true为交工自己的，false交工别人的不允许
            Map<String, Object> params = new HashMap<>(2);
            params.put("empNo", byUserId);
            params.put("companyId", UserHolder.getCompanyId());
            boolean b = orderPictMesService.isCommitLoginUserWork(params);
            if (b) {
                orderPictMesService.add(orderPictMesDto);
                baseResult.setModel(orderPictMesDto);
            } else {
                throw new BusinessException("不能交工别人任务");
            }
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
     * 详情
     *
     * @param: @param orderPictMes
     * @param: @param bindingResult
     * @param: @return
     * @return: Object
     * @author: 徐飞
     * @date: 2018-6-22 下午3:03:51
     */
    @ResponseBody
    @RequestMapping(value = "/pictDetail", method = {RequestMethod.GET, RequestMethod.POST})
    public Object pictDetail(@Valid OrderPictMes orderPictMes, BindingResult bindingResult) {
        BaseResult<OrderPictMesDto> baseResult = new BaseResult<OrderPictMesDto>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            OrderPictMesDto orderPictMesDto = orderPictMesService.pictPage(orderPictMes);
            if (orderPictMesDto.getPictureUrls() == null || orderPictMesDto.getPictureUrls().size() == 0) {
                orderPictMesDto.setPictureUrls(null);
            }
            baseResult.setModel(orderPictMesDto);
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
