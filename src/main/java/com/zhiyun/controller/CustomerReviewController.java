/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.entity.ProcessPictMes;
import com.zhiyun.service.TaskFinishedMesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-22 10:45
 */
@Controller
@RequestMapping(value = "/customerReview", produces = "application/json;charset=UTF-8")
public class CustomerReviewController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerReviewController.class);

    @Resource
    private TaskFinishedMesService taskFinishedMesService;

    /**
     * 分页查询
     *
     * @param processPictMes
     * @param pager
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/22 9:58
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public String page(ProcessPictMes processPictMes, Pager pager) {
        BaseResult<String> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("客户上传资料分页查询成功");
        try {
            //TODO 从crm中分页查询订单
            //  List<> list =processPictMesService.cunstomPage(pager);
            DataGrid<Object> entity = taskFinishedMesService.page(Params.create().add("entity", processPictMes), pager);

        } catch (BusinessException be) {
            LOGGER.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            LOGGER.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult);
    }

}
