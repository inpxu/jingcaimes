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
import com.zhiyun.dto.CrafworkStructPlmDto;
import com.zhiyun.dto.QuartersHcmDto;
import com.zhiyun.entity.CrafworkParamPlm;
import com.zhiyun.entity.CrafworkStructPlm;
import com.zhiyun.entity.TaskReceiveEmpMes;
import com.zhiyun.service.CasOrgService;
import com.zhiyun.service.CrafworkParamPlmService;
import com.zhiyun.service.CrafworkStructPlmService;
import com.zhiyun.service.TaskReceiveEmpMesService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 工艺设置controller
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-20 09:36
 */
@Controller
@RequestMapping(value = "/crafworkStructPlm", produces = "application/json;charset=UTF-8")
public class CrafworkStructPlmController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrafworkStructPlmController.class);
    @Resource
    private CrafworkStructPlmService crafworkStructPlmService;
    @Resource
    private CrafworkParamPlmService crafworkParamPlmService;
    @Resource
    private CasOrgService casOrgService;
    @Resource
    private TaskReceiveEmpMesService taskReceiveEmpMesService;

    /**
     * 新增工艺
     *
     * @param crafworkStructPlm
     * @param bindingResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid CrafworkStructPlm crafworkStructPlm, BindingResult bindingResult, String actHours) {
        BaseResult<CrafworkStructPlm> baseResult = new BaseResult<CrafworkStructPlm>();
        baseResult.setResult(true);
        baseResult.setMessage("新增成功");
        // 1.参数校验
        try {
            crafworkStructPlm.setCompanyId(UserHolder.getCompanyId());
            vaildParamsDefault(baseResult, bindingResult);
            BigDecimal b = new BigDecimal(actHours);
            crafworkStructPlm.setStandHours(b);
            CrafworkStructPlm insert = crafworkStructPlmService.insert(crafworkStructPlm);
            //            if (insert != null) {
            //                TaskReceiveEmpMes taskReceiveEmpMes = new TaskReceiveEmpMes();
            //                BigDecimal c = new BigDecimal(actHours);
            //                taskReceiveEmpMes.setActHours(c);
            //                taskReceiveEmpMes.setActDate(new Date());
            //                taskReceiveEmpMes.setCrafworkId(insert.getId());
            //                taskReceiveEmpMes.setCompanyId(insert.getCompanyId());
            //                taskReceiveEmpMes.setDeleted("F");
            //                taskReceiveEmpMesService.insert(taskReceiveEmpMes);
            //            } else {
            //                baseResult.setResult(false);
            //                baseResult.setMessage("新增失败");
            //                return JSON.toJSONString(baseResult);
            //            }
            baseResult.setModel(crafworkStructPlm);
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
     * 删除工艺
     *
     * @param ids id数组
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/20 10:10
     */
    @ResponseBody
    @RequestMapping(value = "/remove", method = {RequestMethod.POST})
    public String remove(Long[] ids) {
        BaseResult<CrafworkStructPlm> baseResult = new BaseResult<CrafworkStructPlm>();
        baseResult.setResult(true);
        baseResult.setMessage("删除成功");
        try {
            if (ids == null || ids.length == 0) {
                throw new BusinessException("请选择要删除的工艺");
            }
            //删除前判断是否被使用，如果工艺被使用不能被删除
            boolean b = crafworkStructPlmService.uesd(ids);
            if (b) {
                throw new BusinessException("工艺正在被使用不能删除");
            }
            crafworkStructPlmService.delete(Arrays.asList(ids));
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
     * 修改工艺
     *
     * @param crafworkStructPlm 工艺实体
     * @param bindingResult 参数校验
     * @return java.lang.Object
     * @author 邓艺
     */
    @ResponseBody
    @RequestMapping(value = "update", method = {RequestMethod.POST})
    public String update(@Valid CrafworkStructPlm crafworkStructPlm, BindingResult bindingResult, String actHours) {
        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setResult(true);
        baseResult.setMessage("修改成功");
        try {
            vaildParamsDefault(baseResult, bindingResult);
            crafworkStructPlm.setStandHours(new BigDecimal(actHours));
            crafworkStructPlmService.update(crafworkStructPlm);
//            TaskReceiveEmpMes pa = new TaskReceiveEmpMes();
//            pa.setCrafworkId(crafworkStructPlm.getId());
//            pa.setCompanyId(UserHolder.getCompanyId());
//            pa.setDeleted("F");
//            List<TaskReceiveEmpMes> taskReceiveEmpMes = taskReceiveEmpMesService.find(pa);
//            if (CollectionUtils.isNotEmpty(taskReceiveEmpMes)) {
//                TaskReceiveEmpMes taskReceiveEmpMes1 = taskReceiveEmpMes.get(0);
//                taskReceiveEmpMes1.setActHours(new BigDecimal(actHours));
//                taskReceiveEmpMes1.setCompanyId(UserHolder.getCompanyId());
//                taskReceiveEmpMesService.update(taskReceiveEmpMes1);
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
        return JSON.toJSONString(baseResult);
    }

    /**
     * 工艺分页查询
     *
     * @param crafworkStructPlmDto
     * @param pager 分页器
     * @return java.lang.String
     * @author 邓艺
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public String page(CrafworkStructPlmDto crafworkStructPlmDto, Pager pager) {
        BaseResult<DataGrid<CrafworkStructPlmDto>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("分页查询成功");
        try {
            crafworkStructPlmDto.setCompanyId(UserHolder.getCompanyId());
            Params parmas = Params.create();
            parmas.add("entity", crafworkStructPlmDto);
            DataGrid<CrafworkStructPlmDto> crackList = crafworkStructPlmService.customPage(parmas, pager);
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
     * @param crafworkParamPlms
     * @return java.lang.String
     * @author 邓艺
     */
    @ResponseBody
    @RequestMapping(value = "addParam", method = {RequestMethod.POST})
    public String addParam(Long id, CrafworkParamPlm[] crafworkParamPlms) {
        BaseResult<List<CrafworkParamPlm>> baseResult = new BaseResult<List<CrafworkParamPlm>>();
        baseResult.setResult(true);
        baseResult.setMessage("新增工艺参数成功");
        try {
            if (ArrayUtils.isNotEmpty(crafworkParamPlms)) {
                for (CrafworkParamPlm crafworkParamPlm : crafworkParamPlms) {
                    crafworkParamPlm.setCompanyId(UserHolder.getCompanyId());

                    List<CrafworkParamPlm> crafworkParamPlmss = crafworkParamPlmService.find(crafworkParamPlm);
                    if (CollectionUtils.isNotEmpty(crafworkParamPlmss)) {
                        //已经存在不能添加
                        throw new BusinessException("工艺参数名已存在");
                    } else {
                        crafworkParamPlmService.insert(crafworkParamPlm);
                        baseResult.setModel(crafworkParamPlmss);
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
     * 删除工艺参数
     *
     * @param ids 工艺参数id数组
     * @return java.lang.String
     * @author 邓艺
     */
    @ResponseBody
    @RequestMapping(value = "removeParam", method = {RequestMethod.POST})
    public String addParam(@RequestParam(value = "ids") Long[] ids) {
        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setResult(true);
        baseResult.setMessage("删除工艺参数成功");
        try {
            if (ids == null || ids.length == 0) {
                throw new BusinessException("请选择要删除的工艺参数");
            }
            crafworkParamPlmService.delete(Arrays.asList(ids));
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
     * 工艺参数设置更新
     *
     * @return java.lang.String
     * @author 邓艺
     */
    @ResponseBody
    @RequestMapping(value = "updateParam", method = {RequestMethod.POST})
    public Object updateParam(@RequestBody CrafworkParamPlm[] crafworkParamPlm) {

        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setResult(true);
        baseResult.setMessage("设置成功");
        try {
            if (ArrayUtils.isNotEmpty(crafworkParamPlm)) {
            	crafworkStructPlmService.updateParam(crafworkParamPlm);
//            	 for (CrafworkParamPlm paramPlm : crafworkParamPlm) {
//                     String paramName = paramPlm.getParamName();
//                     if (paramName == null || paramName == "") {
//                         throw new BusinessException("工艺参数名不能为空");
//                     }
//                     Long crafworkId = paramPlm.getCrafworkId();
//                     Long companyId = UserHolder.getCompanyId();
//                     //有id为更新，无id为新增
//                     if (paramPlm.getId() == null) {
//                         CrafworkParamPlm parm = new CrafworkParamPlm();
//                         parm.setParamName(paramName);
//                         parm.setCrafworkId(crafworkId);
//                         parm.setCompanyId(companyId);
//                         parm.setDeleted("F");
//                         List<CrafworkParamPlm> crafworkParamPlmss = crafworkParamPlmService.find(parm);
//                         if (CollectionUtils.isNotEmpty(crafworkParamPlmss)) {
//                             baseResult.setResult(false);
//                             baseResult.setMessage("工艺参数名已存在");
//                             return JSON.toJSONString(baseResult);
//                         } else {
//                             crafworkParamPlmService.insert(paramPlm);
//                         }
//
//                     } else {
//                         CrafworkParamPlm parm = new CrafworkParamPlm();
//                         parm.setParamName(paramName);
//                         parm.setCrafworkId(crafworkId);
//                         parm.setCompanyId(companyId);
//                         parm.setDeleted("F");
//                         List<CrafworkParamPlm> crafworkParamPlmss = crafworkParamPlmService.find(parm);
//                         CrafworkParamPlm validateResults = crafworkParamPlmService.get(paramPlm.getId());
//                         if (CollectionUtils.isNotEmpty(crafworkParamPlmss) && !validateResults.getParamName().equals(paramPlm.getParamName())) {
//                             baseResult.setResult(false);
//                             baseResult.setMessage("工艺参数名已存在");
//                             return JSON.toJSONString(baseResult);
//                         } else {
//                             crafworkParamPlmService.update(paramPlm);
//                         }
//                     }
//                 }
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
     * 工艺参数查询
     *
     * @param crafworkParamPlm 工艺参数实体
     * @return java.lang.String
     * @author 邓艺
     */
    @ResponseBody
    @RequestMapping(value = "findParamByStructId", method = {RequestMethod.POST})
    public String findByStructId(CrafworkParamPlm crafworkParamPlm) {
        BaseResult<List<CrafworkParamPlm>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("工艺参数查询成功");
        try {

            //            if (crafworkParamPlm.getId() == 0L) {
            //
            //                throw new BusinessException("工艺主键不存在!");
            //            }
            crafworkParamPlm.setCompanyId(UserHolder.getCompanyId());
            List<CrafworkParamPlm> paramPlmList = crafworkParamPlmService.find(crafworkParamPlm);
            baseResult.setModel(paramPlmList);
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
     * 工艺岗位下拉查询
     *
     * @param quartersHcmDto
     * @return java.lang.String
     * @author 邓艺
     * @date 2018/6/20 14:55
     */
    @ResponseBody
    @RequestMapping(value = "optionQuarters", method = {RequestMethod.POST})
    public String optionQuarters(QuartersHcmDto quartersHcmDto) {
        BaseResult<List<QuartersHcmDto>> baseResult = new BaseResult<List<QuartersHcmDto>>();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            quartersHcmDto.setCompanyId(UserHolder.getCompanyId());
            List<QuartersHcmDto> list = casOrgService.findByQuarter(quartersHcmDto);
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

}
