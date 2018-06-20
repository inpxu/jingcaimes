/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.ProdCrafworkParamPlmDto;
import com.zhiyun.dto.ProdCrafworkPathPlmDto;
import com.zhiyun.entity.ProdCrafworkParamPlm;
import com.zhiyun.entity.ProdCrafworkPathPlm;
import com.zhiyun.service.ProdCrafworkParamPlmService;
import com.zhiyun.service.ProdCrafworkPathPlmService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.beans.Transient;
import java.util.List;

/**
 * 产品工艺controller
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-20 09:36
 */
@Controller
@RequestMapping(value = "/ProdCrafworkPath", produces = "application/json;charset=UTF-8")
@Api(value = "产品工艺设置")
public class ProdCrafworkPathPlmController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(CrafworkStructPlmController.class);
    @Resource
    private ProdCrafworkPathPlmService prodCrafworkPathPlmService;
    @Resource
    private ProdCrafworkParamPlmService prodCrafworkParamPlmService;

    /**
     * 根据半成品编码产品编码查询工艺路线
     *
     * @param midProdNo
     * @param prodNo
     * @return java.lang.String
     * @author jiangxing
     * @date 2018/6/15 10:18
     */
    @ResponseBody
    @RequestMapping(value = "findByModNo", method = {RequestMethod.POST})
    public String findById(String midProdNo, String prodNo) {
        BaseResult<List<ProdCrafworkPathPlmDto>> baseResult = new BaseResult<List<ProdCrafworkPathPlmDto>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            ProdCrafworkPathPlm prodCrafworkPathPlm = new ProdCrafworkPathPlm();
            prodCrafworkPathPlm.setCompanyId(UserHolder.getCompanyId());
            prodCrafworkPathPlm.setMidProdNo(midProdNo);
            prodCrafworkPathPlm.setProdNo(prodNo);
            Params parmas = Params.create();
            parmas.add("entity", prodCrafworkPathPlm);
            List<ProdCrafworkPathPlmDto> PathPlmList = prodCrafworkPathPlmService.findByMidProdNo(parmas);
            baseResult.setModel(PathPlmList);
        } catch (BusinessException be) {
            logger.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 根据工艺ID查询参数+属性列表
     *
     * @param prodCrafworkParamPlm
     * @return java.lang.String
     * @author jiangxing
     * @date 2018/6/14 16:44
     */
    @ResponseBody
    @RequestMapping(value = "findById", method = {RequestMethod.POST})
    public String findByPathId(ProdCrafworkParamPlm prodCrafworkParamPlm) {
        BaseResult<List<ProdCrafworkParamPlmDto>> baseResult = new BaseResult<List<ProdCrafworkParamPlmDto>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            Params params = Params.create();
            params.add("entity", prodCrafworkParamPlm);
            List<ProdCrafworkParamPlmDto> paramPlmList = prodCrafworkParamPlmService.findByPath(params);
            baseResult.setModel(paramPlmList);
        } catch (BusinessException be) {
            logger.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 修改工艺属性参数
     *
     * @param prodCrafworkParamPlmDto
     * @return java.lang.Object
     * @author jiangxing
     * @date 2018/6/14 18:30
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "updateParam", method = {RequestMethod.POST})
    public Object updateParam(@Valid @RequestBody ProdCrafworkParamPlmDto prodCrafworkParamPlmDto, BindingResult bindingResult) {
        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setResult(true);
        baseResult.setMessage("编辑成功");
        // 1.参数校验
        try {
            prodCrafworkParamPlmService.updateRecord(prodCrafworkParamPlmDto);
            baseResult.setModel("编辑成功");
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
     * 修改半成品工艺路线信息(具体工艺顺序)
     *
     * @param prodCrafworkPathPlmDto
     * @return java.lang.Object
     * @author jiangxing
     * @date 2018/6/14 18:33
     */
    @Transient
    @ResponseBody
    @RequestMapping(value = "updatePath", method = {RequestMethod.POST})
    public Object updatePath(@Valid @RequestBody ProdCrafworkPathPlmDto prodCrafworkPathPlmDto) {
        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setResult(true);
        baseResult.setMessage("编辑成功");
        try {
            prodCrafworkPathPlmDto.setCompanyId(UserHolder.getCompanyId());
            prodCrafworkPathPlmService.updateRecord(prodCrafworkPathPlmDto);
            baseResult.setModel("编辑成功");
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

    @ResponseBody
    @RequestMapping(value = "findByIdA", method = {RequestMethod.POST})
    public String findByIdA(ProdCrafworkParamPlm prodCrafworkParamPlm) {
        BaseResult<ProdCrafworkParamPlmDto> baseResult = new BaseResult<ProdCrafworkParamPlmDto>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {

            List<ProdCrafworkParamPlm> paramPlmList = prodCrafworkParamPlmService.find(prodCrafworkParamPlm);

            ProdCrafworkParamPlmDto dto = new ProdCrafworkParamPlmDto();
            dto.setListParam(paramPlmList);
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
     * 根据产品半成品编码获取工艺名称，工艺参数名称字符串
     *
     * @param midProdNo
     * @param prodNo
     * @return java.lang.String
     * @author jiangxing
     * @date 2018/6/19 14:36
     */
    @ResponseBody
    @RequestMapping(value = "findByPM", method = {RequestMethod.POST})
    public String findByPM(String midProdNo, String prodNo) {
        BaseResult<ProdCrafworkPathPlmDto> baseResult = new BaseResult<ProdCrafworkPathPlmDto>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            ProdCrafworkPathPlm prodCrafworkPathPlm = new ProdCrafworkPathPlm();
            prodCrafworkPathPlm.setCompanyId(UserHolder.getCompanyId());
            prodCrafworkPathPlm.setMidProdNo(midProdNo);
            prodCrafworkPathPlm.setProdNo(prodNo);
            Params parmas = Params.create();
            parmas.add("entity", prodCrafworkPathPlm);
            ProdCrafworkPathPlmDto PathPlmList = prodCrafworkPathPlmService.findByPm(parmas);
            baseResult.setModel(PathPlmList);
        } catch (BusinessException be) {
            logger.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 根据半成品编码产品编码查询工艺路线
     *
     * @param midProdNo
     * @param prodNo
     * @return java.lang.String
     * @author jiangxing
     * @date 2018/6/15 10:18
     */
    @ResponseBody
    @RequestMapping(value = "findByPmWork", method = {RequestMethod.POST})
    public String findByPmWork(String midProdNo, String prodNo) {
        BaseResult<List<ProdCrafworkPathPlmDto>> baseResult = new BaseResult<List<ProdCrafworkPathPlmDto>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            ProdCrafworkPathPlm prodCrafworkPathPlm = new ProdCrafworkPathPlm();
            prodCrafworkPathPlm.setCompanyId(UserHolder.getCompanyId());
            prodCrafworkPathPlm.setMidProdNo(midProdNo);
            prodCrafworkPathPlm.setProdNo(prodNo);
            Params parmas = Params.create();
            parmas.add("entity", prodCrafworkPathPlm);
            List<ProdCrafworkPathPlmDto> PathPlmList = prodCrafworkPathPlmService.findByPmWork(parmas);
            baseResult.setModel(PathPlmList);
        } catch (BusinessException be) {
            logger.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

}
