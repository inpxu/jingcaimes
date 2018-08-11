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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private static final int MAX_PICTURE_NUM =  50;

    @Resource
    private ProcessPictMesService processPictMesService;

    /**
     * 客户上传资料分页查询
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

            //FIX ME

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
     * 客户上传资料
     *
     * @param processPictMesDto
     * @param pager
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/22 9:58
     */
    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(ProcessPictMesDto processPictMesDto, Pager pager) {
        BaseResult<String> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("客户上传资料分页查询成功");
        try {
            if(processPictMesDto.getPictures() == null || processPictMesDto.getPictures().split(",").length > MAX_PICTURE_NUM){
                throw new BusinessException("上传图片过多！");
            }

            processPictMesService.update(processPictMesDto);
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
     * 查看上传资料分页查询
     *
     * @param processPictMesDto 条件实体
     * @param pager 分页器
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/25 9:02
     */
    @RequestMapping(value = "pageAfterUpload", method = RequestMethod.POST)
    @ResponseBody
    public String pageAfterUpload(ProcessPictMesDto processPictMesDto, Pager pager) {
        BaseResult<DataGrid<ProcessPictMesDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("客户上传资料前分页查询成功");
        try {
            DataGrid<ProcessPictMesDto> entity = processPictMesService.customPageAfterUpload(Params.create().add("entity", processPictMesDto), pager);
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
     * 下来查询订单编号
     *
     * @param processPictMesDto
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/26 0026 下午 6:13
     */
    @RequestMapping(value = "optionInsideOrder", method = RequestMethod.POST)
    @ResponseBody
    public String optionInsideOrder(ProcessPictMesDto processPictMesDto) {
        BaseResult<List<ProcessPictMesDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("客户上传资料前分页查询成功");
        try {
            processPictMesDto.setCompanyId(UserHolder.getCompanyId());
            List<ProcessPictMesDto> entity = processPictMesService.queryAllInsideOrder(processPictMesDto);
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
     * 查看上传资料详情
     *
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/22 9:58
     */
    @RequestMapping(value = "findAllUploadPic", method = RequestMethod.POST)
    @ResponseBody
    public String findAllUploadPic(ProcessPictMesDto processPictMesDto) {
        BaseResult<List<String>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查看详情查询成功");
        try {
            ProcessPictMes processPictMes = new ProcessPictMes();
            processPictMes.setId(processPictMesDto.getId());
            processPictMes = processPictMesService.get(processPictMesDto.getId());

            List<String> picts = new ArrayList<>();
            if(processPictMes.getPictures()!=null){
                picts.addAll(Arrays.asList(processPictMes.getPictures().split(",")));
            }

            baseResult.setModel(picts);
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
