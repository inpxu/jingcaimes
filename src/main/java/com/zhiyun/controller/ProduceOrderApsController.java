package com.zhiyun.controller;

import com.zhiyun.client.UserHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/20 17:04
 * @Description:
 */
@RestController
@RequestMapping(value="/produceOrderAps")
public class ProduceOrderApsController {

    /**
     * 查询样式接口
     *
     * @param model 传输对象
     * @return java.lang.String 响应页面地址
     * @author 庄超
     */
    @RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
    public String index( Model model) {
        model.addAttribute("userName", UserHolder.getUserName());
        model.addAttribute("companyName", UserHolder.getCompanyName());
        return "/demo/index";
    }


}
