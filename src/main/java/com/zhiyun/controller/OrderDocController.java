package com.zhiyun.controller;

import com.zhiyun.entity.OrderDocCrm;
import com.zhiyun.service.OrderDocCrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/23 13:38
 * @Description:
 */
@RestController
@RequestMapping("orderDoc")
public class OrderDocController {

    @Autowired
    private OrderDocCrmService orderDocCrmService;

    /**
     * 根据客户id查询销售订单号
     * @param customId
     * @return
     */
    @RequestMapping("listByCustomIdInCrm")
    public List<OrderDocCrm> listByCustomIdInCrm(@RequestParam(value = "customId",required = true) long customId){
        List<OrderDocCrm> orderDocCrms= orderDocCrmService.listByCustomIdInCrm(customId);
        return orderDocCrms;
    }

    /**
     * 根据订单号查询订单
     * @param id
     * @return
     */
    @RequestMapping("getByIdInCrm")
    public OrderDocCrm getByIdInCrm(@RequestParam(value = "id",required = true) long id){
        OrderDocCrm orderDocCrm =orderDocCrmService.getByIdInCrm(id);
        return orderDocCrm;
    }


}
