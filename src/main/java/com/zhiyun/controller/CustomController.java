package com.zhiyun.controller;

import com.zhiyun.entity.CustomsCrm;
import com.zhiyun.service.CustomsCrmService;
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

    @Autowired
    private CustomsCrmService customsCrmService;

    /**
     * 在crm中查询客户信息
     * @return
     */
    @RequestMapping("listInCrm")
    public List<CustomsCrm> listInCrm(){
        return customsCrmService.listInCrm();
    }



}
