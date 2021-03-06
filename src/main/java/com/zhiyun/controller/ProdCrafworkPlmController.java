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
import org.apache.commons.lang3.StringUtils;
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
import java.math.BigDecimal;
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
    @Resource
    private ProduceOrderDetailApsService produceOrderDetailApsService;

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
    public synchronized String findById(ProdCrafworkPlmDto prodCrafworkPlmDto, Pager pager) {
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
    public synchronized String saveOrders(@RequestBody ProdCrafworkPlmDto[] prodCrafworkPlmDtos) {
        BaseResult<List<ProdCrafworkPlmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            //上移
            if (prodCrafworkPlmDtos[0].getCarfSeq() < prodCrafworkPlmDtos[1].getCarfSeq()) {
                if (prodCrafworkPlmDtos[0].getCarfSeq() == 1) {
                    prodCrafworkPlmDtos[0].setBefCrafwork(null);
                    prodCrafworkPlmDtos[1].setBefCrafwork(prodCrafworkPlmDtos[0].getCrafworkName());
                    //0是当前的1 是要移动到的位置
                    prodCrafworkPlmService.customUpdate(prodCrafworkPlmDtos[0]);
                    prodCrafworkPlmService.customUpdate(prodCrafworkPlmDtos[1]);
                    List<ProdCrafworkPlmDto> all = prodCrafworkPlmService.findAllLeftBig(prodCrafworkPlmDtos[1]);
                    if (CollectionUtils.isNotEmpty(all)) {
                        for (ProdCrafworkPlmDto prodCrafworkPlmDto22 : all) {
                            joinCraft(prodCrafworkPlmDto22);
                            prodCrafworkPlmService.update(prodCrafworkPlmDto22);
                        }
                    }

                } else {
                    String befCrafwork = prodCrafworkPlmDtos[1].getBefCrafwork();
                    if (StringUtils.isBlank(befCrafwork)) {
                        prodCrafworkPlmDtos[0].setBefCrafwork(befCrafwork);
                        prodCrafworkPlmDtos[1].setBefCrafwork(prodCrafworkPlmDtos[0].getCrafworkName());
                    } else {
                        prodCrafworkPlmDtos[0].setBefCrafwork(befCrafwork);
                        prodCrafworkPlmDtos[1].setBefCrafwork(prodCrafworkPlmDtos[0].getCrafworkName() + "," + befCrafwork);
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
                }
            } else {
                //下移
                if (prodCrafworkPlmDtos[1].getCarfSeq() == 1) {
                    prodCrafworkPlmDtos[1].setBefCrafwork(null);
                    prodCrafworkPlmDtos[0].setBefCrafwork(prodCrafworkPlmDtos[1].getCrafworkName());
                    prodCrafworkPlmService.customUpdate(prodCrafworkPlmDtos[0]);
                    prodCrafworkPlmService.customUpdate(prodCrafworkPlmDtos[1]);

                    List<ProdCrafworkPlmDto> all = prodCrafworkPlmService.findAllLeftBig(prodCrafworkPlmDtos[0]);
                    if (CollectionUtils.isNotEmpty(all)) {
                        for (ProdCrafworkPlmDto prodCrafworkPlmDto22 : all) {
                            joinCraft(prodCrafworkPlmDto22);
                            prodCrafworkPlmService.update(prodCrafworkPlmDto22);
                        }
                    }
                } else {
                    String befCrafwork = prodCrafworkPlmDtos[0].getBefCrafwork();
                    if (StringUtils.isBlank(befCrafwork)) {
                        prodCrafworkPlmDtos[1].setBefCrafwork(null);
                        prodCrafworkPlmDtos[0].setBefCrafwork(prodCrafworkPlmDtos[1].getCrafworkName());
                    } else {
                        prodCrafworkPlmDtos[1].setBefCrafwork(befCrafwork);
                        prodCrafworkPlmDtos[0].setBefCrafwork(prodCrafworkPlmDtos[1].getCrafworkName() + "," + befCrafwork);
                    }
                    prodCrafworkPlmService.customUpdate(prodCrafworkPlmDtos[0]);
                    prodCrafworkPlmService.customUpdate(prodCrafworkPlmDtos[1]);

                    List<ProdCrafworkPlmDto> all = prodCrafworkPlmService.findAllLeftBig(prodCrafworkPlmDtos[0]);
                    if (CollectionUtils.isNotEmpty(all)) {
                        for (ProdCrafworkPlmDto prodCrafworkPlmDto22 : all) {
                            joinCraft(prodCrafworkPlmDto22);
                            prodCrafworkPlmService.update(prodCrafworkPlmDto22);
                        }
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

            ProduceOrderDetailAps produceOrderDetailAps = new ProduceOrderDetailAps();
            produceOrderDetailAps.setProdNo(prodCrafworkPlmDto.getProdNo());
            List<ProduceOrderDetailAps> podas = produceOrderDetailApsService.find(produceOrderDetailAps);
            if (CollectionUtils.isNotEmpty(podas)) {
                throw new BusinessException("产品正在被使用无法编辑工艺");
            }

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
        return JSON.toJSONString(baseResult);
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

            ProduceOrderDetailAps produceOrderDetailAps = new ProduceOrderDetailAps();

            BigDecimal amount = prodCrafworkPlmDto.getAmount();
            if (amount == null) {
                throw new BusinessException("构成数量不能为空");
            }
            if (amount.equals(BigDecimal.ZERO)) {
                throw new BusinessException("构成数量不能为0");
            }
            BigDecimal of = BigDecimal.valueOf(999999999.99);
            if (amount.compareTo(of) == 1) {
                throw new BusinessException("构成数量数值过大");
            }

            produceOrderDetailAps.setProdNo(prodCrafworkPlmDto.getProdNo());
            List<ProduceOrderDetailAps> podas = produceOrderDetailApsService.find(produceOrderDetailAps);
            if (CollectionUtils.isNotEmpty(podas)) {
                throw new BusinessException("产品正在被使用无法新增工艺");
            }

            //判断是否是第一次添加工艺，如果不是第一次添加name还需要将前置工艺插入
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
        return JSON.toJSONString(baseResult);
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
            if (s.endsWith(",")) {
                s = s.substring(0, s.length() - 1);
            }
            prodCrafworkPlmDto.setBefCrafwork(s);
        } else {
            prodCrafworkPlmDto.setBefCrafwork(null);
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
    public synchronized String remove(ProdCrafworkPlmDto prodCrafworkPlmDto) {
        BaseResult<List<CrafworkStructPlm>> baseResult = new BaseResult<List<CrafworkStructPlm>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            ProduceOrderDetailAps produceOrderDetailAps = new ProduceOrderDetailAps();
            produceOrderDetailAps.setProdNo(prodCrafworkPlmDto.getProdNo());
            List<ProduceOrderDetailAps> podas = produceOrderDetailApsService.find(produceOrderDetailAps);
            if (CollectionUtils.isNotEmpty(podas)) {
                throw new BusinessException("产品正在被使用无法编辑工艺");
            }
            //获取删除条目的顺序
            ProdCrafworkPlm prodCrafworkPlm = prodCrafworkPlmService.get(prodCrafworkPlmDto.getId());
            //删除
            prodCrafworkPlmService.delete(prodCrafworkPlmDto.getId());
            //TODO 删除以后将删除工艺之后的工艺的前置工艺全部重置
            ProdCrafworkPlm pam = new ProdCrafworkPlm();
            pam.setId(prodCrafworkPlmDto.getId());
            pam.setProdNo(prodCrafworkPlmDto.getProdNo());
            pam.setMidProdNo(prodCrafworkPlmDto.getMidProdNo());
            pam.setCompanyId(UserHolder.getCompanyId());
            pam.setCarfSeq(prodCrafworkPlm.getCarfSeq());
            List<ProdCrafworkPlmDto> all = prodCrafworkPlmService.findAllLeftBig(pam);
            //查询小于删除条目顺序的，如果小于的为零那么就是删的第一条
            List<ProdCrafworkPlmDto> small = prodCrafworkPlmService.findAllLeftSmall(pam);
            if (CollectionUtils.isNotEmpty(all)) {
                for (int i = 0; i < all.size(); i++) {
                    if (i == 0 && small.size() == 0) {
                        ProdCrafworkPlmDto prodCrafworkPlmDto1 = all.get(0);
                        prodCrafworkPlmDto1.setBefCrafwork(null);
                        prodCrafworkPlmService.update(prodCrafworkPlmDto1);
                    } else {
                        joinCraft(all.get(i));
                        prodCrafworkPlmService.update(all.get(i));
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
