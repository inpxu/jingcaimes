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
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.ProdCrafworkPlmDto;
import com.zhiyun.entity.*;
import com.zhiyun.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 产品工艺路线controller
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-20 09:36
 */
@Controller
@RequestMapping(value = "/prodCrafworkPlm", produces = "application/json;charset=UTF-8")
@Api(tags = "5.产品工艺路线设置", description = "产品工艺路线增删改查")
public class ProdCrafworkPlmController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProdCrafworkPlmController.class);
    @Resource
    private ProductStorePlmService productStorePlmService;
    @Resource
    private ProductMidPlmService productMidPlmService;
    @Resource
    private ProdCrafworkPlmService prodCrafworkPlmService;
    @Resource
    private CrafworkStructPlmService crafworkStructPlmService;
    @Resource
    private CrafworkParamPlmService crafworkParamPlmService;

    /**
     * 查询所有产品
     *
     * @param productStorePlm 产品实体
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/21 15:02
     */
    @ResponseBody
    @RequestMapping(value = "findAllProduct", method = {RequestMethod.POST})
    @ApiOperation(value = "查询所有产品", httpMethod = "POST", response = String.class, notes = "查询所有产品")
    public String findAllProduct(ProductStorePlm productStorePlm) {
        BaseResult<List<ProductStorePlm>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            productStorePlm.setCompanyId(UserHolder.getCompanyId());
            List<ProductStorePlm> all = productStorePlmService.findAll();
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
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 根据产品编号查询所有半成品
     *
     * @param productStorePlm 产品实体
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/21 15:02
     */
    @ResponseBody
    @RequestMapping(value = "findAllMidProductByProductNo", method = {RequestMethod.POST})
    @ApiOperation(value = "根据产品编号查询所有半成品", httpMethod = "POST", response = String.class, notes = "根据产品编号查询所有半成品")
    @ApiImplicitParams({@ApiImplicitParam(name = "prodNo", value = "产品编码", required = true, paramType = "string")})
    public String findAllMidProductByProductNo(ProductStorePlm productStorePlm) {
        BaseResult<List<ProductMidPlm>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            ProductMidPlm pam = new ProductMidPlm();
            pam.setCompanyId(UserHolder.getCompanyId());
            pam.setProdNo(productStorePlm.getProdNo());
            List<ProductMidPlm> all = productMidPlmService.find(pam);
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
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 分页查询
     *
     * @return java.lang.String
     * @author jiangxing
     * @date 2018/6/15 10:18
     */
    @ResponseBody
    @RequestMapping(value = "page", method = {RequestMethod.POST})
    @ApiOperation(value = "分页查询", httpMethod = "POST", response = String.class, notes = "分页查询")
    public String findById(ProdCrafworkPlmDto prodCrafworkPlmDto, Pager pager) {
        BaseResult<DataGrid<ProdCrafworkPlmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            DataGrid<ProdCrafworkPlmDto> entity = prodCrafworkPlmService.cutomePage(Params.create().add("entity", prodCrafworkPlmDto), pager);
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
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 保存顺序
     *
     * @param prodCrafworkPlmDto
     * @param bindingResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveOrders", method = {RequestMethod.POST})
    @ApiOperation(value = "保存顺序", httpMethod = "POST", response = String.class, notes = "保存顺序")
    public String saveOrders(@Valid ProdCrafworkPlmDto prodCrafworkPlmDto, BindingResult bindingResult) {
        BaseResult<List<ProdCrafworkPlmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            //TODO 前置工艺拼接
            joinCraft(prodCrafworkPlmDto);
            prodCrafworkPlmService.update(prodCrafworkPlmDto);
        } catch (BusinessException be) {
            LOGGER.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            LOGGER.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 更新
     *
     * @param prodCrafworkPlmDto
     * @param bindingResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update", method = {RequestMethod.POST})
    @ApiOperation(value = "更新", httpMethod = "POST", response = String.class, notes = "更新")
    public String update(@Valid ProdCrafworkPlmDto prodCrafworkPlmDto, BindingResult bindingResult) {
        BaseResult<List<ProdCrafworkPlmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            prodCrafworkPlmService.update(prodCrafworkPlmDto);
            //TODO 前置工艺拼接

            ProdCrafworkPlm pam = new ProdCrafworkPlm();
            pam.setProdNo(prodCrafworkPlmDto.getProdNo());
            pam.setMidProdNo(prodCrafworkPlmDto.getMidProdNo());
            pam.setId(prodCrafworkPlmDto.getId());
            pam.setCompanyId(UserHolder.getCompanyId());
            List<ProdCrafworkPlmDto> all = prodCrafworkPlmService.findAllLeftBig(pam);
            if (CollectionUtils.isNotEmpty(all)) {
                for (ProdCrafworkPlmDto prodCrafworkPlmDto22 : all) {
                    joinCraft(prodCrafworkPlmDto22);
                    prodCrafworkPlmService.update(prodCrafworkPlmDto22);
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
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 新增工艺
     *
     * @param bindingResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addNew", method = {RequestMethod.POST})
    @ApiOperation(value = "新增工艺", httpMethod = "POST", response = String.class, notes = "新增工艺")
    public String addNew(@Valid ProdCrafworkPlmDto prodCrafworkPlmDto, BindingResult bindingResult) {
        BaseResult<List<ProdCrafworkPlmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            joinCraft(prodCrafworkPlmDto);

            prodCrafworkPlmService.insert(prodCrafworkPlmDto);
        } catch (BusinessException be) {
            LOGGER.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            LOGGER.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 拼接前置工艺
     *
     * @param prodCrafworkPlmDto
     * @return void
     * @author 邓艺
     * @date 2018/6/22 18:59
     */
    private void joinCraft(@Valid ProdCrafworkPlmDto prodCrafworkPlmDto) {
        //TODO 前置工艺拼接
        prodCrafworkPlmDto.setCompanyId(UserHolder.getCompanyId());
        List<ProdCrafworkPlmDto> all = prodCrafworkPlmService.findAllByDesc(prodCrafworkPlmDto);
        if (CollectionUtils.isNotEmpty(all)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (ProdCrafworkPlmDto prodCrafworkPathPlmDto : all) {
                stringBuilder.append(prodCrafworkPathPlmDto.getCrafworkName());
                stringBuilder.append(",");
            }
            String s = stringBuilder.toString();
            String substring = s.substring(0, s.length() - 1);
            String s1 = prodCrafworkPlmDto.getBefCrafwork() + "," + substring;
            prodCrafworkPlmDto.setBefCrafwork(s1);
        }
    }

    /**
     * 删除
     *
     * @param
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/22 15:23
     */
    @ResponseBody
    @RequestMapping(value = "remove", method = {RequestMethod.POST})
    @ApiOperation(value = "删除", httpMethod = "POST", response = String.class, notes = "删除")
    public String remove(ProdCrafworkPlmDto[] prodCrafworkPlmDtos) {
        BaseResult<List<CrafworkStructPlm>> baseResult = new BaseResult<List<CrafworkStructPlm>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            if (ArrayUtils.isEmpty(prodCrafworkPlmDtos)) {
                throw new BusinessException("id不能为空");
            }
            for (ProdCrafworkPlmDto prodCrafworkPlmDto : prodCrafworkPlmDtos) {
                prodCrafworkPlmService.delete(prodCrafworkPlmDto.getId());
                ProdCrafworkPlm pam = new ProdCrafworkPlm();
                pam.setId(prodCrafworkPlmDto.getId());
                pam.setProdNo(prodCrafworkPlmDto.getProdNo());
                pam.setMidProdNo(prodCrafworkPlmDto.getMidProdNo());
                pam.setCompanyId(UserHolder.getCompanyId());
                List<ProdCrafworkPlmDto> all = prodCrafworkPlmService.findAllLeftBig(pam);
                if (CollectionUtils.isNotEmpty(all)) {
                    for (ProdCrafworkPlmDto prodCrafworkPlmDtoss : all) {
                        joinCraft(prodCrafworkPlmDtoss);
                        prodCrafworkPlmService.update(prodCrafworkPlmDto);
                    }
                }
            }
            //TODO 删除后要更新所有的前置工艺
            //            Arrays.sort(ids);
            // pam.setId(ids[0]);
            //            List<ProdCrafworkPlmDto> all = prodCrafworkPlmService.findAllLeftBig(pam);
            //            if (CollectionUtils.isNotEmpty(all)) {
            //                for (ProdCrafworkPlmDto prodCrafworkPlmDto : all) {
            //                    joinCraft(prodCrafworkPlmDto);
            //                    prodCrafworkPlmService.update(prodCrafworkPlmDto);
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
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 工艺名称下拉
     *
     * @param
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/22 15:23
     */
    @ResponseBody
    @RequestMapping(value = "optionCraf", method = {RequestMethod.POST})
    @ApiOperation(value = "工艺名称下拉", httpMethod = "POST", response = String.class, notes = "工艺名称下拉")
    public String optionCraf() {
        BaseResult<List<CrafworkStructPlm>> baseResult = new BaseResult<List<CrafworkStructPlm>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            CrafworkStructPlm crafworkStructPlm = new CrafworkStructPlm();
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
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 查询所有工艺参数值
     *
     * @param crafworkId
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/23 8:37
     */
    @ResponseBody
    @RequestMapping(value = "findParamByPId", method = {RequestMethod.POST})
    @ApiOperation(value = "查询所有工艺参数值", httpMethod = "POST", response = String.class, notes = "查询所有工艺参数值")
    public String findParamByPId(Long crafworkId) {
        BaseResult<List<CrafworkParamPlm>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            CrafworkParamPlm crafworkParamPlm = new CrafworkParamPlm();
            crafworkParamPlm.setCompanyId(UserHolder.getCompanyId());
            crafworkParamPlm.setCrafworkId(crafworkId);
            List<CrafworkParamPlm> crafworkParamPlms = crafworkParamPlmService.find(crafworkParamPlm);
            baseResult.setModel(crafworkParamPlms);
        } catch (BusinessException be) {
            LOGGER.debug("业务异常" + be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            LOGGER.debug("系统异常" + e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 新增工艺参数值
     *
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/23 8:37
     */
    @ResponseBody
    @RequestMapping(value = "addParam", method = {RequestMethod.POST})
    @ApiOperation(value = "新增工艺参数值", httpMethod = "POST", response = String.class, notes = "新增工艺参数值")
    public String addParam(@RequestBody CrafworkParamPlm[] crafworkParamPlms) {
        BaseResult<List<CrafworkParamPlm>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            for (CrafworkParamPlm crafworkParamPlm : crafworkParamPlms) {
                crafworkParamPlmService.update(crafworkParamPlm);
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
        return JSON.toJSONString(baseResult, SerializerFeature.WriteMapNullValue);
    }

}
