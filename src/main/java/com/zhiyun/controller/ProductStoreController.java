/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 产品库controller
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-20 10:26
 */
@Controller
@RequestMapping(value = "crafworkStructPlm", produces = "application/json;charset=UTF-8")
@Api(value = "产品库设置")
public class ProductStoreController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductStoreController.class);

    /**
     * 产品新增
     *
     * @param productStoreCrm
     * @param bindingResult
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 10:28
     */
    @ResponseBody
    @RequestMapping(value = "/addProduct", method = {RequestMethod.GET, RequestMethod.POST})
    public Object addProduct(@Valid ProductStorePlm productStoreCrm, BindingResult bindingResult) {
        BaseResult<ProductStorePlm> baseResult = new BaseResult<ProductStorePlm>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            ProductStorePlm crm = productStoreCrmService.insertProduct(productStoreCrm);
            baseResult.setModel(crm);
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
     * 产品删除
     *
     * @param ids
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 10:29
     */
    @ResponseBody
    @RequestMapping(value = "/removeProduct", method = {RequestMethod.GET, RequestMethod.POST})
    public Object removeProduct(@RequestParam("ids") Long[] ids) {
        BaseResult<ProductStorePlm> baseResult = new BaseResult<ProductStorePlm>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            for (Long id : ids) {
                ProductStorePlm ios = this.productStoreCrmService.get(id);
                Params params = Params.create();
                params.add("output", "");
                params.add("prodNo", ios.getProdNo());
                if (productStoreCrmService.judgeProdNoUsed(params).equals("0")) {
                    this.productStoreCrmService.delete(id);
                } else {
                    throw new BusinessException(ios.getProdName() + "产品已被使用，无法删除");
                }
            }
            // productStoreCrmService.delete(Arrays.asList(ids));
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
     * 产品修改
     *
     * @param productStoreCrm
     * @param bindingResult
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 10:30
     */
    @ResponseBody
    @RequestMapping(value = "/editProductMsg", method = {RequestMethod.GET, RequestMethod.POST})
    public Object editProductMsg(@Valid ProductStorePlm productStoreCrm, BindingResult bindingResult) {
        BaseResult<ProductStorePlm> baseResult = new BaseResult<ProductStorePlm>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            ProductStorePlm crm = productStoreCrmService.editProduct(productStoreCrm);
            baseResult.setModel(crm);
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
     * 产品分页查询
     *
     * @param productStorePlm
     * @param bindingResult
     * @param page
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 10:27
     */
    @ResponseBody
    @RequestMapping(value = "/page", method = {RequestMethod.GET, RequestMethod.POST})
    public Object pageProduct(@Valid ProductStorePlm productStorePlm, BindingResult bindingResult, Pager page) {
        BaseResult<DataGrid<ProductDto>> baseResult = new BaseResult<DataGrid<ProductDto>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            Params params = Params.create().add("entity", productStorePlm);
            DataGrid<ProductDto> dataGrid = productStoreCrmService.pageProd(params, page);
            baseResult.setModel(dataGrid);
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
