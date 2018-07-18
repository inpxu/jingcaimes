package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.entity.EmpFolderHcm;
import com.zhiyun.service.EmpFolderHcmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: sunyuntao
 * @Date: 2018/06/28 18:09
 * @Description:
 */
@RestController
@RequestMapping(value="/empfloderHcm")
public class EmpFolderHcmController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(EmpFolderHcmController.class);

    @Autowired
    private EmpFolderHcmService empFolderHcmService;

    @RequestMapping("getByOrgId")
    public Object getByOrgId(@RequestParam(value = "orgId",required = true)Long orgId){
        BaseResult<List<EmpFolderHcm>> baseResult = new BaseResult();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            List<EmpFolderHcm> empFolderHcms = empFolderHcmService.listByOrgId(orgId,UserHolder.getCompanyId());
            baseResult.setModel(empFolderHcms);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/empfloderHcm/getByOrgId响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }


    @RequestMapping("getByTaskPondId")
    public Object getByTaskPondId(@RequestParam(value = "taskPondId",required = true)Long taskPondId){

        BaseResult<List<EmpFolderHcm>> baseResult = new BaseResult();
        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            List<EmpFolderHcm> empFolderHcms = empFolderHcmService.listByTaskPondId(taskPondId,UserHolder.getCompanyId());
            baseResult.setModel(empFolderHcms);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/empfloderHcm/getByTaskPondId响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }
}
