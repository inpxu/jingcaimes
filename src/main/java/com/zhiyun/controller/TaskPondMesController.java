package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.dto.TaskPondMesDto;
import com.zhiyun.service.TaskPondMesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 工艺任务池
 * @Auther: sunyuntao
 * @Date: 2018/6/20 17:04
 * @Description:
 */
@RestController
@RequestMapping(value="/taskPondMes")
public class TaskPondMesController extends BaseController {


    @Autowired
    private TaskPondMesService taskPondMesService;

    private static final Logger logger = LoggerFactory.getLogger(TaskPondMesController.class);

    /**
     * 
     * @param
     * @return 
     */
    @RequestMapping("list")
    public Object list(TaskPondMesDto taskPondMesDto, Pager pager){
        BaseResult<DataGrid<TaskPondMesDto>> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            DataGrid<TaskPondMesDto> taskPondMesDataGrid = taskPondMesService.myPage(taskPondMesDto,pager);
            baseResult.setModel(taskPondMesDataGrid);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/taskPondMes/list响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }


    @RequestMapping("getById")
    public Object getById(@RequestParam(value = "id",required = true)Long id){
        BaseResult<TaskPondMesDto> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            TaskPondMesDto taskPondMesDto = taskPondMesService.getById(id);
            baseResult.setModel(taskPondMesDto);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/taskPondMes/getById响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }

    /**
     * 加实际开始时间和计划开始时间
     * 自己认领任务
     * @param
     * @return
     */
    @RequestMapping("drawTask")
    public Object draw(@RequestBody @Valid TaskPondMesDto taskPondMesDto, BindingResult bindingResult){
        BaseResult<TaskPondMesDto> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult,bindingResult);
            taskPondMesService.drawTask(taskPondMesDto);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/taskPondMes/draw响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }


    /**
     * 加实际开始时间和计划开始时间
     * 分配任务
     * @param
     * @return
     */
    @RequestMapping("distributeTask")
    public Object distributeTask(@RequestBody @Valid TaskPondMesDto taskPondMesDto, BindingResult bindingResult){
        BaseResult<TaskPondMesDto> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            vaildParamsDefault(baseResult,bindingResult);
            taskPondMesService.distributeTask(taskPondMesDto);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/taskPondMes/distributeTask响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }

    /**
     * 设置工艺工价
     * @param
     * @return
     */
    @RequestMapping("setTaskPrice")
    public Object setTaskPrice(@RequestParam("taskPondIds")List<Long> taskPondIds, @RequestParam("price")BigDecimal price){
        BaseResult<TaskPondMesDto> baseResult = new BaseResult();

        baseResult.setResult(true);
        baseResult.setMessage("操作成功");
        try {
            taskPondMesService.setTaskPrice(taskPondIds,price);
        } catch (BusinessException be) {
            logger.debug("业务异常"+be);
            baseResult.setResult(false);
            baseResult.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.debug("系统异常"+e);
            baseResult.setResult(false);
            baseResult.setMessage("系统异常");
        }
        logger.debug("MVCresponse:/taskPondMes/setTaskPrice响应结果={}",JSON.toJSONString(baseResult));
        return baseResult;
    }

}