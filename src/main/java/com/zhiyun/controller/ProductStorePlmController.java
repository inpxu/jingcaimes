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
import com.zhiyun.dto.ProductStorePlmDto;
import com.zhiyun.entity.ProductStorePlm;
import com.zhiyun.service.ProduceOrderDetailApsService;
import com.zhiyun.service.ProductStorePlmService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
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
public class ProductStorePlmController extends BaseController {

    private static final String NORMAL_SUPPLY_PRODUCT = "正常供货";

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductStorePlmController.class);
    @Resource
    private ProductStorePlmService productStorePlmService;
    @Resource
    private ProduceOrderDetailApsService produceOrderDetailApsService;

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
            productStorePlm.setProdStatus(NORMAL_SUPPLY_PRODUCT);
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
    public Object removeProduct(Long[] ids) {
        BaseResult<ProductStorePlm> baseResult = new BaseResult<ProductStorePlm>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            if (ArrayUtils.isNotEmpty(ids)) {
                //1 正常供货 2 缺货 3停产 4关闭
                ProductStorePlm pam = new ProductStorePlm();
                if (ArrayUtils.isNotEmpty(ids)) {
                    for (Long id : ids) {
                        //判断产品是否被订单关联
                        productStorePlmService.relationWithOrder(id);
                        //判断产品是否被半成品使用
                        productStorePlmService.usedByMidProduct(id);
                        pam.setId(id);
                        pam.setProdStatus("3");
                        productStorePlmService.delete(id);
                    }
                }
            }
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
     * 关闭产品状态
     * @param: @param ids
     * @param: @return
     * @return: Object 
     * @author: 徐飞
     * @date: 2018年8月3日 下午5:37:02
     */
    @ResponseBody
    @RequestMapping(value = "/closeProdStatus", method = {RequestMethod.GET, RequestMethod.POST})
    public Object closeProdStatus(Long[] ids) {
        BaseResult<ProductStorePlm> baseResult = new BaseResult<ProductStorePlm>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            if (ArrayUtils.isNotEmpty(ids)) {
                //1 正常供货 2 缺货 3停产 4关闭
                ProductStorePlm pam = new ProductStorePlm();
                if (ArrayUtils.isNotEmpty(ids)) {
                    for (Long id : ids) {
                        pam.setId(id);
                        pam.setProdStatus("关闭");
                        productStorePlmService.closeProdStatus(pam);
                    }
                }
            }
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
    public Object updateProduct(@Valid ProductStorePlm productStorePlm, BindingResult bindingResult) {
        BaseResult<ProductStorePlm> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            String status = productStorePlm.getProdStatus();
            if (status != null && status == "关闭") {
				throw new BusinessException("产品已关闭, 不能编辑");
			}
            productStorePlmService.updateProductStorePlm(productStorePlm);
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
     * @param
     * @param pager 分页对象
     * @return java.lang.Object
     * @author 邓艺
     */
    @ResponseBody
    @RequestMapping(value = "/pageProduct", method = {RequestMethod.POST})
    public Object pageProduct(ProductStorePlmDto productStorePlmDto, Pager pager) {
        BaseResult<DataGrid<ProductStorePlmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("产品分页查询成功");
        try {
            Params params = Params.create().add("entity", productStorePlmDto);
            pager.setOrder("DESC");
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

    /**
     * 查询所有产品
     *
     * @return
     */
    @RequestMapping("listForQueryCriteria")
    @ResponseBody
    public Object listForQueryCriteria() {

        BaseResult<List<ProductStorePlm>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            ProductStorePlm productStorePlm = new ProductStorePlm();
            productStorePlm.setCompanyId(UserHolder.getCompanyId());
            productStorePlm.setProdStatus(NORMAL_SUPPLY_PRODUCT);
            baseResult.setModel(productStorePlmService.find(productStorePlm));
        } catch (BusinessException be) {
            LOGGER.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            LOGGER.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }

        return baseResult;
    }

}
