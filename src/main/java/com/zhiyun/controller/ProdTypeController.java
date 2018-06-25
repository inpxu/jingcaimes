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
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.entity.ProdTypeCrm;
import com.zhiyun.service.ProdTypeCrmService;
import com.zhiyun.service.ProductStorePlmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * 产品库分类controller
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-20 09:36
 */
@Controller
@RequestMapping(value = "/prodType", produces = "text/json;charset=UTF-8")
@Api(tags = "2.产品库分类设置", description = "产品库分类增删改查")
public class ProdTypeController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProdTypeController.class);

    @Resource
    private ProdTypeCrmService prodTypeCrmService;
    @Resource
    private ProductStorePlmService productStorePlmService;

    /**
     * 产品库分类分页查询
     *
     * @param ProdTypeCrm 产品分类实体
     * @param pager 分页器
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 10:35
     */
    @ResponseBody
    @RequestMapping(value = "/page", method = {RequestMethod.POST})
    @ApiOperation(value = "产品库分类分页查询", httpMethod = "POST", response = String.class, notes = "产品库分类分页查询")
    public String page(ProdTypeCrm prodTypeCrm, Pager pager) {
        BaseResult<DataGrid<ProdTypeCrm>> baseResult = new BaseResult<>();
        pager.setOrder(Page.ORDER_DESC);
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            // vaildParamsDefault(baseResult, bindingResult);
            Params params = Params.create().add("entity", prodTypeCrm);
            DataGrid<ProdTypeCrm> dataGrid = prodTypeCrmService.page(params, pager);
            baseResult.setModel(dataGrid);
        } catch (BusinessException be) {
            LOGGER.error("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            LOGGER.error("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage(e.getMessage());
        }
        return JSON.toJSONString(baseResult);
    }

    /**
     * 产品库分类新增
     *
     * @param ProdTypeCrm 产品分类实体
     * @return java.lang.Object
     * @author 邓艺
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ApiOperation(value = "产品库分类新增", httpMethod = "POST", response = String.class, notes = "产品库分类新增")
    public String add(@Valid ProdTypeCrm prodTypeCrm, BindingResult bindingResult) {
        BaseResult<ProdTypeCrm> baseResult = new BaseResult<ProdTypeCrm>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            prodTypeCrm.setCompanyId(UserHolder.getCompanyId());
            //TODO     编码格式是什么合适
            ProdTypeCrm insert = prodTypeCrmService.insert(prodTypeCrm);
            baseResult.setModel(insert);
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
     * 产品库分类修改
     *
     * @param ProdTypeCrm
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 10:36
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "产品库分类修改", httpMethod = "POST", response = String.class, notes = "产品库分类修改")
    public Object update(@Valid ProdTypeCrm prodTypeCrm, BindingResult bindingResult) {
        BaseResult<ProdTypeCrm> baseResult = new BaseResult<ProdTypeCrm>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            List<ProdTypeCrm> list = prodTypeCrmService.find(prodTypeCrm);
            if (!list.isEmpty()) {
                if (list.size() > 1 || !list.get(0).getId().equals(prodTypeCrm.getId())) {
                    throw new BusinessException("分类已存在");
                }
            }
            prodTypeCrmService.update(prodTypeCrm);
            baseResult.setModel(prodTypeCrm);
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
     * 产品库分类删除
     *
     * @param ids
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 10:37
     */
    @ResponseBody
    @RequestMapping(value = "/remove", method = {RequestMethod.POST})
    @ApiOperation(value = "产品库分类修改", httpMethod = "POST", response = String.class, notes = "产品库分类修改")
    public Object remove(Long[] ids) {
        BaseResult<String> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            if (ArrayUtils.isEmpty(ids)) {
                throw new BusinessException("id必须输入");
            }
            prodTypeCrmService.delete(Arrays.asList(ids));
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
