/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 工艺设置controller
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-20 09:36
 */
@Controller
@RequestMapping(value = "crafworkStructPlm", produces = "application/json;charset=UTF-8")
@Api(value = "工艺设置")
public class CrafworkStructPlmController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrafworkStructPlmController.class);

    /**
     * 新增工艺
     *
     * @param crafworkStructPlm
     * @param bindingResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增工艺", httpMethod = "POST", response = String.class, notes = "新增工艺")
    public String add(@Valid CrafworkStructPlm crafworkStructPlm, BindingResult bindingResult) {
        BaseResult<CrafworkStructPlm> baseResult = new BaseResult<CrafworkStructPlm>();
        baseResult.setResult(true);
        baseResult.setMessage("新增成功");
        // 1.参数校验
        try {
            crafworkStructPlm.setCompanyId(UserHolder.getCompanyId());
            vaildParamsDefault(baseResult, bindingResult);
            crafworkStructPlm = this.crafworkStructPlmService.insertRecord(crafworkStructPlm);
            baseResult.setModel(crafworkStructPlm);
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
     * 删除工艺
     *
     * @param ids id数组
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/20 10:10
     */
    @ResponseBody
    @RequestMapping(value = "/remove", method = {RequestMethod.POST})
    @ApiOperation(value = "删除工艺", httpMethod = "POST", response = String.class, notes = "删除工艺")
    @ApiImplicitParams({@ApiImplicitParam(name = "ids", value = "id数组", required = true, paramType = "Long")})
    public String remove(@RequestParam(value = "ids") Long[] ids) {
        BaseResult<CrafworkStructPlm> baseResult = new BaseResult<CrafworkStructPlm>();
        baseResult.setResult(true);
        baseResult.setMessage("删除成功");
        try {
            if (ids == null || ids.length == 0) {
                throw new BusinessException("请选择要删除的工艺");
            }
            crafworkStructPlmService.RemoveRecord(ids);
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
     * 修改工艺
     *
     * @param crafworkStructPlmdto
     * @return java.lang.Object
     * @author 邓艺
     * @date 2018/6/20 10:10
     */
    @ResponseBody
    @RequestMapping(value = "update", method = {RequestMethod.POST})
    @ApiOperation(value = "修改工艺", httpMethod = "POST", response = String.class, notes = "修改工艺")
    public Object update(@Valid @RequestBody CrafworkStructPlmDto crafworkStructPlmdto) {
        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setResult(true);
        baseResult.setMessage("编辑成功");
        // 1.参数校验
        try {
            crafworkParamPlmService.updateRecord(crafworkStructPlmdto);
            baseResult.setModel("编辑成功");
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
     * 工艺分页查询
     *
     * @param crafworkStructPlm
     * @param pager
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/20 10:14
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public String page(CrafworkStructPlm crafworkStructPlm, Pager pager) {
        BaseResult<DataGrid<CrafworkStructPlmDto>> baseResult = new BaseResult<DataGrid<CrafworkStructPlmDto>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            crafworkStructPlm.setCompanyId(UserHolder.getCompanyId());
            Params parmas = Params.create();
            parmas.add("entity", crafworkStructPlm);
            DataGrid<CrafworkStructPlmDto> crackList = crafworkStructPlmService.pageForFront(parmas, pager.getPage());
            baseResult.setModel(crackList);

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
     * 新增工艺参数
     *
     * @param quartersHcmDto
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/20 10:18
     */
    @ResponseBody
    @RequestMapping(value = "addParam", method = {RequestMethod.POST})
    public String addParam(QuartersHcmDto quartersHcmDto) {
        BaseResult<List<QuartersHcmDto>> baseResult = new BaseResult<List<QuartersHcmDto>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            quartersHcmDto.setCompanyId(UserHolder.getCompanyId());
            quartersHcmDto.setDeleted("F");
            List<QuartersHcmDto> List = casOrgService.findByQuarter(quartersHcmDto);
            baseResult.setModel(List);
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
     * 删除工艺参数
     *
     * @param quartersHcmDto
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/20 10:18
     */
    @ResponseBody
    @RequestMapping(value = "removeParam", method = {RequestMethod.POST})
    public String addParam(@RequestParam(value = "ids") Long[] ids) {
        BaseResult<List<QuartersHcmDto>> baseResult = new BaseResult<List<QuartersHcmDto>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            quartersHcmDto.setCompanyId(UserHolder.getCompanyId());
            quartersHcmDto.setDeleted("F");
            List<QuartersHcmDto> List = casOrgService.findByQuarter(quartersHcmDto);
            baseResult.setModel(List);
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
     * 工艺参数设置更新
     *
     * @param crafworkId
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/20 10:23
     */
    @ResponseBody
    @RequestMapping(value = "updateParam", method = {RequestMethod.POST})
    public Object updateParam(@Valid @RequestBody CrafworkStructPlmDto crafworkStructPlmdto) {
        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setResult(true);
        baseResult.setMessage("编辑成功");
        // 1.参数校验
        try {
            crafworkParamPlmService.updateRecord(crafworkStructPlmdto);
            baseResult.setModel("编辑成功");
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
     * 工艺参数查询
     *
     * @param crafworkId
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/20 10:23
     */
    @ResponseBody
    @RequestMapping(value = "findParamByStructId", method = {RequestMethod.POST})
    public String findByStructId(Long crafworkId) {
        BaseResult<List<CrafworkParamPlm>> baseResult = new BaseResult<List<CrafworkParamPlm>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            if (crafworkId == null || crafworkId == 0L) {
                throw new BusinessException("工艺主键不存在!");
            }
            CrafworkParamPlm entity = new CrafworkParamPlm();
            entity.setCompanyId(UserHolder.getCompanyId());
            entity.setCrafworkId(crafworkId);
            entity.setDeleted("F");
            List<CrafworkParamPlm> paramPlmList = crafworkParamPlmService.find(entity);
            baseResult.setModel(paramPlmList);
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
