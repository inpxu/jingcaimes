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
import com.zhiyun.dto.ProductStorePlmDto;
import com.zhiyun.entity.ProductStorePlm;
import com.zhiyun.service.ProductStorePlmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * 产品库controller
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-20 10:26
 */
@Controller
@RequestMapping(value = "/productStorePlm", produces = "application/json;charset=UTF-8")
@Api(tags = "3.产品库设置", description = "产品库增删改查")
public class ProductStorePlmController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductStorePlmController.class);
    @Resource
    private ProductStorePlmService productStorePlmService;

    /**
     * 产品新增
     *
     * @param productStorePlm 产品库实体
     * @param bindingResult 参数验证
     * @return java.lang.Object
     * @author 邓艺
     */
    @ResponseBody
    @RequestMapping(value = "/addProduct", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "产品新增", httpMethod = "POST", response = String.class, notes = "产品新增")
    public Object addProduct(@Valid ProductStorePlm productStorePlm, BindingResult bindingResult) {
        BaseResult<ProductStorePlm> baseResult = new BaseResult<ProductStorePlm>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            //产品编码唯一校验
            ProductStorePlm param = new ProductStorePlm();
            param.setProdNo(productStorePlm.getProdNo());
            List<ProductStorePlm> productStorePlms = productStorePlmService.find(param);
            if (CollectionUtils.isNotEmpty(productStorePlms)) {
                baseResult.setResult(false);
                baseResult.setMessage("产品编码已经存在");
                return JSON.toJSONString(baseResult);
            }
            productStorePlmService.insert(productStorePlm);
            baseResult.setModel(productStorePlm);
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
     * 产品删除
     *
     * @param ids
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 10:29
     */
    @ResponseBody
    @RequestMapping(value = "/removeProduct", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "产品删除", httpMethod = "POST", response = String.class, notes = "产品删除")
    public Object removeProduct(Long[] ids) {
        BaseResult<ProductStorePlm> baseResult = new BaseResult<ProductStorePlm>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            if (ArrayUtils.isNotEmpty(ids)) {
                productStorePlmService.delete(Arrays.asList(ids));
            }

            //            for (Long id : ids) {
            //                ProductStorePlm ios = this.productStoreCrmService.get(id);
            //                Params params = Params.create();
            //                params.add("output", "");
            //                params.add("prodNo", ios.getProdNo());
            //                if (productStoreCrmService.judgeProdNoUsed(params).equals("0")) {
            //                    this.productStoreCrmService.delete(id);
            //                } else {
            //                    throw new BusinessException(ios.getProdName() + "产品已被使用，无法删除");
            //                }
            //            }
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
     * 产品修改
     *
     * @param productStorePlm 产品实体
     * @param bindingResult 参数校验
     * @return java.lang.Object
     * @author 邓艺
     */
    @ResponseBody
    @RequestMapping(value = "/updateProduct", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "产品修改", httpMethod = "POST", response = String.class, notes = "产品修改")
    public Object updateProduct(@Valid ProductStorePlm productStorePlm, BindingResult bindingResult) {
        BaseResult<ProductStorePlm> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            productStorePlmService.update(productStorePlm);
            baseResult.setModel(productStorePlm);
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
     * 产品分页查询
     *
     * @param productStorePlm 产品实体
     * @param pager 分页对象
     * @return java.lang.Object
     * @author 邓艺
     */
    @ResponseBody
    @RequestMapping(value = "/pageProduct", method = {RequestMethod.POST})
    @ApiOperation(value = "产品分页查询", httpMethod = "POST", response = String.class, notes = "产品分页查询")
    public Object pageProduct(ProductStorePlmDto productStorePlmDto, Pager pager) {
        BaseResult<DataGrid<ProductStorePlmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("产品分页查询成功");
        try {
            Params params = Params.create().add("entity", productStorePlmDto);
            DataGrid<ProductStorePlmDto> dataGrid = productStorePlmService.customPage(params, pager);
            baseResult.setModel(dataGrid);
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
     * 查询详情
     *
     * @param productStorePlm 条件实体
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/21 13:13
     */
    @ResponseBody
    @RequestMapping(value = "/findByProductId", method = {RequestMethod.POST})
    @ApiOperation(value = "查询详情", httpMethod = "POST", response = String.class, notes = "查询详情")
    public Object findByProduct(ProductStorePlm productStorePlm) {
        BaseResult<ProductStorePlm> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("产品分页查询成功");
        try {
            List<ProductStorePlm> productStorePlms = productStorePlmService.find(productStorePlm);
            baseResult.setModel(productStorePlms.get(0));
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