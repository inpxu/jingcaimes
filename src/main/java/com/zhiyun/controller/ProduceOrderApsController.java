package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.dto.ProduceOrderApsDto;
import com.zhiyun.service.ProduceOrderApsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/20 17:04
 * @Description:
 */
@RestController
@RequestMapping(value="/produceOrderAps")
public class ProduceOrderApsController extends BaseController {


    @Autowired
    private ProduceOrderApsService produceOrderApsService;

    private static final Logger logger = LoggerFactory.getLogger(ProduceOrderApsController.class);

    /**
     *
     * @param produceOrderApsDto
     * @return
     */
    @RequestMapping("save")
    public Object save(@Validated @RequestBody ProduceOrderApsDto produceOrderApsDto, BindingResult bindingResult){
        BaseResult<ProduceOrderApsDto> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            logger.debug("MVCrequest:/produceOrderAps/add请求参数={}",JSON.toJSONString(produceOrderApsDto));
            vaildParamsDefault(baseResult, bindingResult);
            produceOrderApsService.save(produceOrderApsDto);
            baseResult.setModel(produceOrderApsDto);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/produceOrderAps/add响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }

    /**
     * 单据号删除
     * @param voucherNos
     * @return
     */
    @RequestMapping("delete")
    public Object delete(@RequestParam(value = "ids[]") Long[] voucherNos){
        BaseResult<List<Long>> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            logger.debug("MVCrequest:/produceOrderAps/delete请求参数={}",JSON.toJSONString(voucherNos));
            produceOrderApsService.delete(Arrays.asList(voucherNos));
            baseResult.setModel(Arrays.asList(voucherNos));
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/produceOrderAps/delete响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }

    /**
     *
     * @param
     * @return
     */
    @RequestMapping("list")
    public Object list(@RequestParam(value = "insideOrder",required = false)String insideOrder,
                       @RequestParam(value = "custom",required = false)String custom,
                       @RequestParam(value = "orderNo",required = false)String orderNo,
                       @RequestParam(value = "voucherDateFrom",required = false)String voucherDateFrom,
                       @RequestParam(value = "voucherDateTo",required = false)String voucherDateTo,
                       @RequestParam(value = "orderStatus",required = false)String orderStatus){
        BaseResult<ProduceOrderApsDto> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
//            logger.debug("MVCrequest:/produceOrderAps/list请求参数={}",JSON.toJSONString(produceOrderApsDto));
//            vaildParamsDefault(baseResult, bindingResult);
//            produceOrderApsService.list(produceOrderApsDto);
//            baseResult.setModel(produceOrderApsDto);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/produceOrderAps/list响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }

}
