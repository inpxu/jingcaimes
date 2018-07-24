package com.zhiyun.controller;

import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.dto.OrderDocCrmDto;
import com.zhiyun.entity.OrderDocCrm;
import com.zhiyun.service.OrderDocCrmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDocController.class);

    @Autowired
    private OrderDocCrmService orderDocCrmService;

    /**
     * 根据客户id查询销售订单号
     * @param customId
     * @return
     */
    @RequestMapping("listByCustomIdInCrm")
    public Object listByCustomIdInCrm(@RequestParam(value = "customId",required = true) long customId){

        BaseResult<List<OrderDocCrm>> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            baseResult.setModel(orderDocCrmService.listByCustomIdInCrm(customId));
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

    /**
     * 根据订单号查询订单
     * @param id
     * @return
     */
    @RequestMapping("getByIdInCrm")
    public Object getByIdInCrm(@RequestParam(value = "id",required = true) long id){

        BaseResult<OrderDocCrmDto> baseResult = new BaseResult<>();
        baseResult.setResult(true);
        baseResult.setMessage("查询成功");
        try {
            baseResult.setModel(orderDocCrmService.getByIdInCrm(id));
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
