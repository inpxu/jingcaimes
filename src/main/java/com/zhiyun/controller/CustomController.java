package com.zhiyun.controller;

import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.entity.CasOrg;
import com.zhiyun.entity.CustomsCrm;
import com.zhiyun.service.CustomsCrmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/22 20:18
 * @Description:
 */
@RestController
@RequestMapping("custom")
public class CustomController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomController.class);

    @Autowired
    private CustomsCrmService customsCrmService;

    /**
     * 在crm中查询客户信息
     * @return
     */
    @RequestMapping("listInCrm")
    public Object listInCrm(){

        BaseResult<List<CustomsCrm>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            baseResult.setModel(customsCrmService.listInCrm());
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
