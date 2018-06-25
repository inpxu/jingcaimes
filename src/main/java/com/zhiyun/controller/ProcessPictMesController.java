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
import com.zhiyun.dto.ProcessPictMesDto;
import com.zhiyun.entity.ProcessPictMes;
import com.zhiyun.service.ProcessPictMesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 客户上传资料controller
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-22 09:18
 */
@Controller
@RequestMapping(value = "/processPictMes", produces = "application/json;charset=UTF-8")
public class ProcessPictMesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessPictMesController.class);

    @Resource
    private ProcessPictMesService processPictMesService;

    /**
     * 查看上传资料
     *
     * @param pager
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/22 9:58
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public String page(ProcessPictMesDto processPictMesDto, Pager pager) {
        BaseResult<DataGrid<ProcessPictMesDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("客户上传资料分页查询成功");
        try {
            //TODO 从crm中分页查询订单
            DataGrid<ProcessPictMesDto> entity = processPictMesService.customPage(Params.create().add("entity", processPictMesDto), pager);
            baseResult.setModel(entity);

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

    /**
     * 查看详情
     *
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/22 9:58
     */
    @RequestMapping(value = "findByProcessPictMes", method = RequestMethod.POST)
    @ResponseBody
    public String findByProcessPictMes(ProcessPictMesDto processPictMesDto) {
        BaseResult<DataGrid<ProcessPictMesDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("客户上传资料分页查询成功");
        try {
//            processPictMesService.get()
//            DataGrid<ProcessPictMesDto> entity = processPictMesService.customPage(Params.create().add("entity", processPictMesDto), pager);
            //baseResult.setModel(entity);

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








    /**
     * 客户上传资料(从内部订单中查询订单信息)
     *
     * @param processPictMes
     * @param pager
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/22 9:58
     */
    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(ProcessPictMes processPictMes, Pager pager) {
        BaseResult<String> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("客户上传资料分页查询成功");
        try {
            //TODO 从crm中分页查询订单
            //  List<> list =processPictMesService.cunstomPage(pager);

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
