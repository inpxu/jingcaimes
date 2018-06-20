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
import com.zhiyun.base.util.DateUtil;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.ProdMidDto;
import com.zhiyun.entity.ProdCrafworkParamPlm;
import com.zhiyun.entity.ProdCrafworkPathPlm;
import com.zhiyun.entity.ProductMidPlm;
import com.zhiyun.service.ProdCrafworkParamPlmService;
import com.zhiyun.service.ProdCrafworkPathPlmService;
import com.zhiyun.service.ProductMidPlmService;
import com.zhiyun.util.UniqueIdGenerater;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
@Api(value = "半成品库设置")
public class MidProductController extends BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(MidProductController.class);

	@Resource
	private ProductMidPlmService productMidIosService;
	@Resource
	private UniqueIdGenerater generater;
	@Resource
	private ProdCrafworkPathPlmService prodCrafworkPathPlmService;
	@Resource
	private ProdCrafworkParamPlmService prodCrafworkParamPlmService;

	/**
	 * 半产品条件分页查询
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/selectMidPage", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object pageUserdAuth(ProductMidPlm productMidPlm,
			BindingResult bindingResult, Pager page) {
		BaseResult<DataGrid<ProdMidDto>> baseResult = new BaseResult<DataGrid<ProdMidDto>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			vaildParamsDefault(baseResult, bindingResult);
			Params params = Params.create().add("entity", productMidPlm);
			DataGrid<ProdMidDto> dataGrid = productMidIosService.pageProdMid(
					params, page);
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

	/**
	 * 新增半成品
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/insertMid", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object insertMid(@Valid ProductMidPlm productMidPlm,
			BindingResult bindingResult) {
		BaseResult<ProductMidPlm> baseResult = new BaseResult<ProductMidPlm>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			if ("".equals(productMidPlm.getParentNo())
					|| productMidPlm.getParentNo() == null) {
				productMidPlm.setParentNo("0");
			}
			vaildParamsDefault(baseResult, bindingResult);
			String no = generater.getUniqueStringId("A", 4,
					UserHolder.getCompanyId());
			no = no.substring(1);
			String midNo = productMidPlm.getMidProdNo() + "#"
					+ DateUtil.format(new Date(), DateUtil.yyyyMMdd) + "#" + no;
			String remark = "";
			if (productMidPlm.getMidProdNo().contains("GB1")
					|| productMidPlm.getMidProdNo().contains("gb1")) {
				remark = "1" + DateUtil.format(new Date(), "yyMMdd") + no;
			} else if (productMidPlm.getMidProdNo().contains("GB2")
					|| productMidPlm.getMidProdNo().contains("gb2")) {
				remark = "2" + DateUtil.format(new Date(), "yyMMdd") + no;
			} else if (productMidPlm.getMidProdNo().contains("GB3")
					|| productMidPlm.getMidProdNo().contains("gb3")) {
				remark = "3" + DateUtil.format(new Date(), "yyMMdd") + no;
			} else if (productMidPlm.getMidProdNo().contains("GB4")
					|| productMidPlm.getMidProdNo().contains("gb4")) {
				remark = "4" + DateUtil.format(new Date(), "yyMMdd") + no;
			}
			productMidPlm.setMidProdNo(midNo);
			productMidPlm.setMidProdNoMark(remark);
			productMidPlm = productMidIosService.insert(productMidPlm);
			// if (productMidPlm.getAmount() != null) {
			// System.out.println(Integer.valueOf(productMidPlm.getAmount()
			// .toString()));
			// for (int i = 0; i < Integer.valueOf(productMidPlm.getAmount()
			// .toString()); i++) {
			// ProductMidPlm plm = new ProductMidPlm();
			// BeanUtils.copyProperties(productMidPlm, plm);
			// plm.setId(null);
			// plm.setParentNo(midNo)
			// plm.setMidProdNo(midNo + "-" + String.format("%1$02d", i));
			// plm.setMidProdNoMark(remark + String.format("%1$02d", i));
			// plm.setAmount(new BigDecimal(1));
			// productMidIosService.insert(plm);
			// }s
			// }

			// 向工艺表和工艺参数表插入数据
			String[] parm = productMidPlm.getCrafworkStructId().split(",");
			ProdCrafworkPathPlm crafworkParamPlm = new ProdCrafworkPathPlm();
			ProdCrafworkParamPlm crafworkParamPlm2 = new ProdCrafworkParamPlm();
			crafworkParamPlm2.setCompanyId(UserHolder.getCompanyId());
			crafworkParamPlm2.setMidProdNo(productMidPlm.getMidProdNo());
			crafworkParamPlm2.setProductNo(productMidPlm.getProdNo());
			crafworkParamPlm.setProdNo(productMidPlm.getProdNo());
			crafworkParamPlm.setMidProdNo(productMidPlm.getMidProdNo());
			crafworkParamPlm.setCompanyId(UserHolder.getCompanyId());
			for (String string : parm) {
				crafworkParamPlm.setId(null);
				crafworkParamPlm2.setId(null);
				crafworkParamPlm.setCrafworkId(Long.parseLong(string));
				crafworkParamPlm2.setCraftworkId(Long.parseLong(string));
				prodCrafworkParamPlmService.insert(crafworkParamPlm2);
				prodCrafworkPathPlmService.insert(crafworkParamPlm);
			}

			baseResult.setModel(productMidPlm);
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
	 * 编辑半成品
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/editMid", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object editMid(@Valid ProductMidPlm productMidIos,
			BindingResult bindingResult) {
		BaseResult<ProductMidPlm> baseResult = new BaseResult<ProductMidPlm>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			vaildParamsDefault(baseResult, bindingResult);
			productMidIosService.update(productMidIos);
			baseResult.setModel(productMidIos);
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
	 * 半成品下拉查询
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listMidProduct", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object listMidProduct(ProductMidPlm productMidIos) {
		BaseResult<List<ProdMidDto>> baseResult = new BaseResult<List<ProdMidDto>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			List<ProductMidPlm> dtos = productMidIosService.find(productMidIos);
			List<ProdMidDto> dtos2 = new ArrayList<>();
			for (ProductMidPlm productMidPlm : dtos) {
				ProdMidDto dto = new ProdMidDto();
				BeanUtils.copyProperties(productMidPlm, dto);
				dto.setLabel(productMidPlm.getMidProdNo() + "|"
						+ productMidPlm.getProdName());
				dto.setValue(productMidPlm.getMidProdNo());
				// if (productMidPlm.getParentNo() != null)
				// continue;
				dtos2.add(dto);
			}
			baseResult.setModel(dtos2);
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
	 * 删除半成品
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/removeMidProduct", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object removeMidProduct(@RequestParam("ids") Long[] ids) {
		BaseResult<ProductMidPlm> baseResult = new BaseResult<ProductMidPlm>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功");
		try {
			productMidIosService.delete(Arrays.asList(ids));
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
