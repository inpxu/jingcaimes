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
import com.zhiyun.base.model.LabelValue;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.util.CommonUtils;
import com.zhiyun.client.UserHolder;
import com.zhiyun.entity.ProdTypeIos;
import com.zhiyun.entity.ProductStorePlm;
import com.zhiyun.service.ProdTypeIosService;
import com.zhiyun.service.ProductStorePlmService;
import com.zhiyun.util.UniqueIdGenerater;
import io.swagger.annotations.Api;
import org.slf4j.LOGGER;
import org.slf4j.LOGGERFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
@Api(value = "工艺设置")
public class ProdTypeController extends BaseController {
    private static final LOGGER LOGGER = LOGGERFactory.getLOGGER(ProdTypeController.class);

    @Resource
    private ProdTypeIosService prodTypeIosService;
    @Resource
    private ProductStorePlmService productStorePlmService;
    @Resource
    private UniqueIdGenerater generater;

    /**
     * 产品库分类分页查询
     *
     * @param prodTypeIos
     * @param pager
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 10:35
     */
    @ResponseBody
    @RequestMapping(value = "/findPageProdType", method = {RequestMethod.GET, RequestMethod.POST})
    public Object findPageType(ProdTypeIos prodTypeIos, Pager pager) {
        BaseResult<DataGrid<ProdTypeIos>> baseResult = new BaseResult<DataGrid<ProdTypeIos>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            // vaildParamsDefault(baseResult, bindingResult);
            Params params = Params.create().add("entity", prodTypeIos);
            DataGrid<ProdTypeIos> dataGrid = prodTypeIosService.page(params, pager);
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
     * 产品库分类查询
     *
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectProdType", method = {RequestMethod.GET, RequestMethod.POST})
    public Object selectProdType(ProdTypeIos prodTypeIos) {
        BaseResult<List<LabelValue>> baseResult = new BaseResult<List<LabelValue>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            // vaildParamsDefault(baseResult, bindingResult);
            List<LabelValue> list = prodTypeIosService.findList(prodTypeIos);
            baseResult.setModel(list);
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
     * 产品库分类新增
     *
     * @param prodTypeIos
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 10:36
     */
    @ResponseBody
    @RequestMapping(value = "/addProdType", method = {RequestMethod.GET, RequestMethod.POST})
    public Object addMatterType(ProdTypeIos prodTypeIos) {
        BaseResult<ProdTypeIos> baseResult = new BaseResult<ProdTypeIos>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            // vaildParamsDefault(baseResult, bindingResult);

            ProdTypeIos ios = new ProdTypeIos();
            ios.setCompanyId(UserHolder.getCompanyId());
            ios.setTypeDesc(prodTypeIos.getTypeDesc());
            if (prodTypeIos.getTypeDesc() == null || "".equals(prodTypeIos.getTypeDesc())) {
                throw new BusinessException("请输入分类名称");
            }
            List<ProdTypeIos> list = prodTypeIosService.find(ios);

            if (!CommonUtils.isEmpty(list)) {
                throw new BusinessException("分类已存在");
            }
            prodTypeIos.setTypeNo(generater.getUniqueStringId("PT", 10, UserHolder.getCompanyId()));
            prodTypeIos = prodTypeIosService.insert(prodTypeIos);
            baseResult.setModel(prodTypeIos);
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
     * @param prodTypeIos
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 10:36
     */
    @ResponseBody
    @RequestMapping(value = "/editProdType", method = {RequestMethod.GET, RequestMethod.POST})
    public Object editMatterType(ProdTypeIos prodTypeIos) {
        BaseResult<ProdTypeIos> baseResult = new BaseResult<ProdTypeIos>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            // vaildParamsDefault(baseResult, bindingResult);
            ProdTypeIos ios = new ProdTypeIos();
            ios.setCompanyId(UserHolder.getCompanyId());
            ios.setTypeDesc(prodTypeIos.getTypeDesc());
            List<ProdTypeIos> list = prodTypeIosService.find(ios);
            if (!list.isEmpty()) {
                if (list.size() > 1 || !list.get(0).getId().equals(prodTypeIos.getId())) {
                    throw new BusinessException("分类已存在");
                }
            }
            prodTypeIosService.update(prodTypeIos);
            baseResult.setModel(prodTypeIos);
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
    @RequestMapping(value = "/removeProdType", method = {RequestMethod.GET, RequestMethod.POST})
    public Object removeMatterType(@RequestParam("ids") Long[] ids) {
        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            // vaildParamsDefault(baseResult, bindingResult);
            ProductStorePlm plm = new ProductStorePlm();
            for (Long long1 : ids) {
                plm.setMattersTypeId(long1.toString());
                List<ProductStorePlm> list = productStorePlmService.find(plm);
                if (!list.isEmpty()) {
                    throw new BusinessException("分类下有产品,无法删除");
                }
            }
            prodTypeIosService.delete(Arrays.asList(ids));
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
