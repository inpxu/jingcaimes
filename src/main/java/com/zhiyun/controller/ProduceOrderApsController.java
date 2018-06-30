/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.constant.OrderSourceEnum;
import com.zhiyun.constant.OrderStateEnum;
import com.zhiyun.constant.TaskMesStateEnmu;
import com.zhiyun.dto.ProduceOrderApsDto;
import com.zhiyun.dto.ProduceOrderApsQueryDto;
import com.zhiyun.entity.ProduceOrderAps;
import com.zhiyun.service.ProduceOrderApsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/20 17:04
 * @Description:
 */
@RestController
@RequestMapping(value="/produceOrderAps")
public class ProduceOrderApsController extends BaseController {


    @Autowired
    private ProduceOrderApsService produceOrderApsService;

    private static final Logger logger = LoggerFactory.getLogger(ProduceOrderApsController.class);

    /**
     *
     * @param produceOrderApsDto
     * @return
     */
    @RequestMapping("save")
    public Object save(@Validated @RequestBody ProduceOrderApsDto produceOrderApsDto, BindingResult bindingResult){
        BaseResult<ProduceOrderApsDto> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            logger.debug("MVCrequest:/produceOrderAps/add请求参数={}",JSON.toJSONString(produceOrderApsDto));
            vaildParamsDefault(baseResult, bindingResult);
            produceOrderApsService.save(produceOrderApsDto);
            baseResult.setModel(produceOrderApsDto);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/produceOrderAps/add响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }

    /**
     * 单据号删除
     * @param voucherNos
     * @return
     */
    @RequestMapping("delete")
    public Object delete(@RequestParam(value = "voucherNos") String[] voucherNos){
        BaseResult<List<String>> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            logger.debug("MVCrequest:/produceOrderAps/delete请求参数={}",JSON.toJSONString(voucherNos));
            produceOrderApsService.delete(Arrays.asList(voucherNos));
            baseResult.setModel(Arrays.asList(voucherNos));
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/produceOrderAps/delete响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }

    /**
     *
     * @param produceOrderApsDto
     * @return
     */
    @RequestMapping("update")
    public Object update(@Validated @RequestBody ProduceOrderApsDto produceOrderApsDto, BindingResult bindingResult){
        BaseResult<ProduceOrderApsDto> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            logger.debug("MVCrequest:/produceOrderAps/update请求参数={}",JSON.toJSONString(produceOrderApsDto));
            vaildParamsDefault(baseResult, bindingResult);
            produceOrderApsService.update(produceOrderApsDto);
            baseResult.setModel(produceOrderApsDto);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/produceOrderAps/update响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }

    /**
     *
     * @param
     * @return
     */
    @RequestMapping("list")
    public Object list(ProduceOrderApsQueryDto produceOrderApsQueryDto, Pager pager){
        BaseResult<DataGrid<ProduceOrderApsDto>> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            produceOrderApsQueryDto.setUserId(UserHolder.getId());
            logger.debug("MVCrequest:/produceOrderAps/list请求参数={}",JSON.toJSONString(produceOrderApsQueryDto));
            DataGrid<ProduceOrderApsDto> produceOrderApsDtoDataGrid = produceOrderApsService.myPage(produceOrderApsQueryDto,pager);

            for(ProduceOrderApsDto produceOrderApsDto:produceOrderApsDtoDataGrid.getItems()){
                produceOrderApsDto.setOrderSourceLabel(OrderSourceEnum.getLabelById(produceOrderApsDto.getOrderSourceId()));
                produceOrderApsDto.setStatusLabel(TaskMesStateEnmu.getNameById(String.valueOf(produceOrderApsDto.getStatus())));
                produceOrderApsDto.setOrderStatusLabel(OrderStateEnum.getLabelById(produceOrderApsDto.getIsFinished()));
                produceOrderApsDto.setOrderStatus(produceOrderApsDto.getIsFinished());
            }
            baseResult.setModel(produceOrderApsDtoDataGrid);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/produceOrderAps/list响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }

    @RequestMapping("getDetailByVoucherNo")
    public Object get(@RequestParam(value = "voucherNo",required = true) String voucherNo){
        BaseResult<ProduceOrderApsDto> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            logger.debug("MVCrequest:/produceOrderAps/getDetailByVoucherNo请求参数={}",voucherNo);
            ProduceOrderApsDto produceOrderApsDto = produceOrderApsService.getDetailByVoucherNo(voucherNo);
            produceOrderApsDto.setOrderSourceLabel(OrderSourceEnum.getLabelById(produceOrderApsDto.getOrderSourceId()));
            produceOrderApsDto.setStatusLabel(TaskMesStateEnmu.getNameById(String.valueOf(produceOrderApsDto.getStatus())));
            produceOrderApsDto.setOrderStatusLabel(OrderStateEnum.getLabelById(produceOrderApsDto.getIsFinished()));
            produceOrderApsDto.setOrderStatus(produceOrderApsDto.getIsFinished());
            baseResult.setModel(produceOrderApsDto);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/produceOrderAps/getDetailByVoucherNo响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }


    @RequestMapping("audit")
    public Object audit(@RequestParam(value = "voucherNo",required = true)String voucherNo,
                        @RequestParam(value = "isPass",required = true)boolean isPass){
        BaseResult<ProduceOrderApsDto> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            logger.debug("MVCrequest:/produceOrderAps/audit请求参数={}",voucherNo);
            produceOrderApsService.audit(voucherNo,isPass);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/produceOrderAps/audit响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }


    @RequestMapping("listForQueryCriteria")
    public Object listForQueryCriteria(){
        BaseResult<ProduceOrderApsDto> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            ProduceOrderAps produceOrderAps =new ProduceOrderAps();
            produceOrderAps.setCompanyId(UserHolder.getCompanyId());
            produceOrderApsService.list(produceOrderAps);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/produceOrderAps/listForQueryCriteria响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }

    @RequestMapping("listOnPrivilegeForQueryCriteria")
    public Object listOnPrivilegeForQueryCriteria(){
        BaseResult<ProduceOrderApsDto> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            ProduceOrderAps produceOrderAps =new ProduceOrderAps();
            produceOrderApsService.list(produceOrderAps);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/produceOrderAps/listForQueryCriteria响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }
}
