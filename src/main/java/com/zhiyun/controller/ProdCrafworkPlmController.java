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
import com.zhiyun.dto.ProductMidPlmDto;
import com.zhiyun.entity.*;
import com.zhiyun.service.*;
import org.apache.commons.collections.CollectionUtils;
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
    public String findAllMidProductByProductNo(ProductStorePlm productStorePlm) {
        BaseResult<List<ProductMidPlmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            ProductMidPlm pam = new ProductMidPlm();
            pam.setCompanyId(UserHolder.getCompanyId());
            pam.setProdNo(productStorePlm.getProdNo());
            List<ProductMidPlmDto> all = productMidPlmService.customeFind(pam);
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
     * @param prodCrafworkPlmDtos
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveOrders", method = {RequestMethod.POST})
    public String saveOrders(@RequestBody ProdCrafworkPlmDto[] prodCrafworkPlmDtos) {
        BaseResult<List<ProdCrafworkPlmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            //上移
            if (prodCrafworkPlmDtos[0].getCarfSeq() < prodCrafworkPlmDtos[1].getCarfSeq()) {
                if (prodCrafworkPlmDtos[0].getCarfSeq() == 1) {
                    prodCrafworkPlmDtos[0].setBefCrafwork(null);
                    prodCrafworkPlmDtos[1].setBefCrafwork(prodCrafworkPlmDtos[0].getCrafworkName());

                } else {
                    String crafworkName = prodCrafworkPlmDtos[1].getBefCrafwork();
                    prodCrafworkPlmDtos[0].setBefCrafwork(crafworkName);
                    prodCrafworkPlmDtos[1].setBefCrafwork(crafworkName + "," + prodCrafworkPlmDtos[0].getCrafworkName());
                }
            } else {
                //下移
                if (prodCrafworkPlmDtos[1].getCarfSeq() == 1) {
                    prodCrafworkPlmDtos[1].setBefCrafwork(null);
                    prodCrafworkPlmDtos[0].setBefCrafwork(prodCrafworkPlmDtos[1].getCrafworkName());
                } else {
                    String crafworkName = prodCrafworkPlmDtos[0].getBefCrafwork();
                    prodCrafworkPlmDtos[1].setBefCrafwork(crafworkName);
                    prodCrafworkPlmDtos[0].setBefCrafwork(crafworkName + "," + prodCrafworkPlmDtos[1].getCrafworkName());
                }
            }
            prodCrafworkPlmService.customUpdate(prodCrafworkPlmDtos[0]);
            prodCrafworkPlmService.customUpdate(prodCrafworkPlmDtos[1]);

            List<ProdCrafworkPlmDto> all = prodCrafworkPlmService.findAllLeftBig(prodCrafworkPlmDtos[1]);
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
     * 更新
     *
     * @param prodCrafworkPlmDto
     * @param bindingResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update", method = {RequestMethod.POST})
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
    public String addNew(@Valid ProdCrafworkPlmDto prodCrafworkPlmDto, BindingResult bindingResult) {
        BaseResult<List<ProdCrafworkPlmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            if (prodCrafworkPlmDto.getCarfSeq() == 1) {
                prodCrafworkPlmService.insert(prodCrafworkPlmDto);
            } else {
                joinCraft(prodCrafworkPlmDto);
                prodCrafworkPlmService.insert(prodCrafworkPlmDto);
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
            if(s != null && s.endsWith(",")){
                s = s.substring(0,s.length()-1);
            }
            prodCrafworkPlmDto.setBefCrafwork(s);
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
    public String remove(ProdCrafworkPlmDto prodCrafworkPlmDto) {
        BaseResult<List<CrafworkStructPlm>> baseResult = new BaseResult<List<CrafworkStructPlm>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            //            if (ArrayUtils.isEmpty(prodCrafworkPlmDtos)) {
            //                throw new BusinessException("id不能为空");
            //            }
            //  for (ProdCrafworkPlmDto prodCrafworkPlmDto : prodCrafworkPlmDtos) {
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
                    prodCrafworkPlmService.update(prodCrafworkPlmDtoss);
                }
            }
            // }
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
    public String optionCraf() {
        BaseResult<List<CrafworkStructPlm>> baseResult = new BaseResult<List<CrafworkStructPlm>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            CrafworkStructPlm crafworkStructPlm = new CrafworkStructPlm();
            crafworkStructPlm.setCompanyId(UserHolder.getCompanyId());
            crafworkStructPlm.setDeleted("F");
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
    @RequestMapping(value = "addParam", method = RequestMethod.POST)
    public String addParam(@RequestBody CrafworkParamPlm[] crafworkParamPlms) {

        BaseResult<List<CrafworkParamPlm>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            for (CrafworkParamPlm crafworkParamPlm : crafworkParamPlms) {
                if (crafworkParamPlm.getId() != null) {
                    crafworkParamPlmService.update(crafworkParamPlm);
                } else {
                    crafworkParamPlmService.insert(crafworkParamPlm);
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

}
