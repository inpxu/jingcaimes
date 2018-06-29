package com.zhiyun.controller;

import com.zhiyun.entity.CasOrg;
import com.zhiyun.service.CasOrgService;
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

    @Autowired
    private CasOrgService casOrgService;

    /**
     * 在hcm中查询生产部门
     * @return
     */
    @RequestMapping("listInHcm")
    public List<CasOrg> listInHcm(){
        return casOrgService.listInHcm();
    }

}
