package com.zhiyun.controller;

import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.client.UserHolder;
import com.zhiyun.entity.CasOrg;
import com.zhiyun.entity.ProductStorePlm;
import com.zhiyun.service.CasOrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 查询人资部门
 * @Auther: sunyuntao
 * @Date: 2018/6/22 19:09
 * @Description:
 */
@RestController
@RequestMapping("casOrg")
public class CasOrgController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CasOrgController.class);

    @Autowired
    private CasOrgService casOrgService;

    /**
     * 在hcm中查询生产部门
     * @return
     */
    @RequestMapping("listInHcm")
    public Object listInHcm(){

        BaseResult<List<CasOrg>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            baseResult.setModel(casOrgService.listInHcm());
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
