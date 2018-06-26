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
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.TaskCheckRecordMesDto;
import com.zhiyun.entity.TaskCheckRecordMes;
import com.zhiyun.service.ProductStorePlmService;
import com.zhiyun.service.TaskCheckRecordMesService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工艺评审controller
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-25 09:38
 */
@Controller
@RequestMapping(value = "crafworkApprove", produces = "application/json;charset=UTF-8")
public class CrafworkApproveController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrafworkApproveController.class);

    @Resource
    private TaskCheckRecordMesService taskCheckRecordMesService;
    @Resource
    private ProductStorePlmService productStorePlmService;

    /**
     * 订单号下拉
     *
     * @param
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/25 10:01
     */
    @RequestMapping(value = "optionOrderNo", method = RequestMethod.POST)
    @ResponseBody
    public String optionOrderNo() {
        BaseResult<List<TaskCheckRecordMes>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("订单号下拉查询成功");
        try {
            TaskCheckRecordMes taskCheckRecordMes = new TaskCheckRecordMes();
            taskCheckRecordMes.setCompanyId(UserHolder.getCompanyId());
            List<TaskCheckRecordMes> all = taskCheckRecordMesService.find(taskCheckRecordMes);
            baseResult.setModel(all);
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
     * 产品信息下拉
     *
     * @param
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/25 10:01
     */
    @RequestMapping(value = "optionProd", method = RequestMethod.POST)
    @ResponseBody
    public String optionProd() {
        BaseResult<String> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("产品信息下拉查询成功");
        try {
            TaskCheckRecordMes taskCheckRecordMes = new TaskCheckRecordMes();
            taskCheckRecordMes.setCompanyId(UserHolder.getCompanyId());
            List<TaskCheckRecordMesDto> all = taskCheckRecordMesService.findAllProd(taskCheckRecordMes);

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
     * 工艺评审分页查询
     *
     * @param taskCheckRecordMesDto 参数实体
     * @param pager
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/25 10:18
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "insideOrder", value = "订单号", required = false, dataType = "form", paramType = "String"),
                               @ApiImplicitParam(name = "prodNo", value = "产品编码", required = false, dataType = "form", paramType = "String")})
    public String page(TaskCheckRecordMesDto taskCheckRecordMesDto, Pager pager) {
        BaseResult<DataGrid<TaskCheckRecordMesDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("工艺评审分页查询成功");
        try {
            DataGrid<TaskCheckRecordMesDto> entity = taskCheckRecordMesService.page(Params.create().add("entity", taskCheckRecordMesDto), pager);
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
     * 工艺评审显示详情
     *
     * @param taskCheckRecordMes 参数实体
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/25 10:18
     */
    @RequestMapping(value = "approve", method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "insideOrder", value = "订单号", required = false, dataType = "form", paramType = "String"),
                               @ApiImplicitParam(name = "prodNo", value = "产品编码", required = false, dataType = "form", paramType = "String")})
    public String approve(TaskCheckRecordMes taskCheckRecordMes) {
        BaseResult<List<TaskCheckRecordMes>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("工艺评审分页查询成功");
        try {
            List<TaskCheckRecordMes> taskCheckRecordMes1 = taskCheckRecordMesService.find(taskCheckRecordMes);

            baseResult.setModel(taskCheckRecordMes1);
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
     * 客户是否通过
     *
     * @param taskCheckRecordMes 参数实体
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/25 10:18
     */
    @RequestMapping(value = "approveStatus", method = RequestMethod.POST)
    @ResponseBody
    public String approveStatus(TaskCheckRecordMes taskCheckRecordMes) {
        BaseResult<List<TaskCheckRecordMes>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("工艺评审分页查询成功");
        try {
            taskCheckRecordMesService.update(taskCheckRecordMes);
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
