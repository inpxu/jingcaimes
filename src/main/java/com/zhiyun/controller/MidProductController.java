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
import com.zhiyun.dto.ProductMidPlmDto;
import com.zhiyun.entity.CrafworkStructPlm;
import com.zhiyun.entity.ProductMidPlm;
import com.zhiyun.entity.ProductStorePlm;
import com.zhiyun.service.CrafworkStructPlmService;
import com.zhiyun.service.ProductMidPlmService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * 半成品库controller
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-20 10:26
 */
@Controller
@RequestMapping(value = "/midProduct", produces = "text/json;charset=UTF-8")
@Api(tags = "4.半成品库设置", description = "半成品库增删改查")
public class MidProductController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MidProductController.class);

    @Resource
    private ProductMidPlmService productMidPlmService;
    @Resource
    private CrafworkStructPlmService crafworkStructPlmService;
    @Resource
    private ProductStorePlmService productStorePlmService;

    /**
     * 半成品库分页查询
     *
     * @param pager 分页器
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/20 13:50
     */
    @ResponseBody
    @RequestMapping(value = "/page", method = {RequestMethod.POST})
    @ApiOperation(value = "半成品库分页查询", httpMethod = "POST", response = String.class, notes = "半成品库分页查询")
    public String pageUserdAuth(ProductMidPlmDto productMidPlmDto, Pager pager) {
        BaseResult<DataGrid<ProductMidPlmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("分页查询成功");
        try {
            Params params = Params.create().add("entity", productMidPlmDto);
            DataGrid<ProductMidPlmDto> dataGrid = productMidPlmService.customPage(params, pager);
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
     * 新增半成品
     *
     * @param productMidPlm 半成品实体
     * @param bindingResult 参数验证
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 13:52
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ApiOperation(value = "新增半成品", httpMethod = "POST", response = String.class, notes = "新增半成品")
    public Object insertMid(@Valid ProductMidPlm productMidPlm, BindingResult bindingResult) {
        BaseResult<ProductMidPlm> baseResult = new BaseResult<ProductMidPlm>();
        baseResult.setResult(true);
        baseResult.setMessage("半成品添加成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            productMidPlm.setCompanyId(UserHolder.getCompanyId());
            ProductMidPlm insert = productMidPlmService.insert(productMidPlm);
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
     * 编辑半成品
     *
     * @param productMidIos 半成品实体
     * @param bindingResult 参数校验
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 13:54
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    @ApiOperation(value = "编辑半成品", httpMethod = "POST", response = String.class, notes = "编辑半成品")
    public Object update(@Valid ProductMidPlm productMidIos, BindingResult bindingResult) {
        BaseResult<ProductMidPlm> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("编辑半成品成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            productMidPlmService.update(productMidIos);
            baseResult.setModel(productMidIos);
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
     * 删除半成品
     *
     * @param ids 半成品id数组
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 13:57
     */
    @ResponseBody
    @RequestMapping(value = "/remove", method = {RequestMethod.POST})
    @ApiOperation(value = "删除半成品", httpMethod = "POST", response = String.class, notes = "删除半成品")
    public Object remove(@RequestParam("ids") Long[] ids) {
        BaseResult<ProductMidPlm> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("删除半成品成功");
        try {
            if (ArrayUtils.isEmpty(ids)) {
                throw new BusinessException("id必须输入");
            }
            productMidPlmService.delete(Arrays.asList(ids));
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
     * 下拉查询所属工艺
     *
     * @param crafworkStructPlm 工艺实体
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/20 14:11
     */
    @RequestMapping(value = "optionCrafworkStructPlm", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "下拉查询所属工艺", httpMethod = "POST", response = String.class, notes = "下拉查询所属工艺")
    public String optionCrafworkStructPlm(CrafworkStructPlm crafworkStructPlm) {
        BaseResult<List<CrafworkStructPlm>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("下拉查询所属工艺成功");
        try {
            crafworkStructPlm.setCompanyId(UserHolder.getCompanyId());
            List<CrafworkStructPlm> crafworkStructPlms = crafworkStructPlmService.find(crafworkStructPlm);
            baseResult.setModel(crafworkStructPlms);

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
     * 下拉查询产品信息
     *
     * @param productStorePlm 产品实体
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/20 14:11
     */
    @RequestMapping(value = "optionProductStorePlm", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "下拉查询产品信息", httpMethod = "POST", response = String.class, notes = "下拉查询产品信息")
    public String optionCrafworkStructPlm(ProductStorePlm productStorePlm) {
        BaseResult<List<ProductStorePlm>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("下拉查询产品信息成功");
        try {
            productStorePlm.setCompanyId(UserHolder.getCompanyId());
            List<ProductStorePlm> productStorePlms = productStorePlmService.find(productStorePlm);
            baseResult.setModel(productStorePlms);

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
     * 查询详细信息
     *
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/20 14:11
     */
    @RequestMapping(value = "findByMidProductId", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "查询详细信息", httpMethod = "POST", response = String.class, notes = "查询详细信息")
    public String findByMidProductId(ProductMidPlm productMidPlm) {
        BaseResult<ProductMidPlm> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询详细信息成功");
        try {
            ProductMidPlm productMidPlm1 = productMidPlmService.get(productMidPlm.getId());
            baseResult.setModel(productMidPlm1);
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
