package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.dto.TaskPondMesDto;
import com.zhiyun.service.TaskPondMesService;
import com.zhiyun.service.TaskReceiveEmpMesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 任务分配记录
 * @Auther: sunyuntao
 * @Date: 2018/06/28 17:46
 * @Description:
 */
@RestController
@RequestMapping(value="taskReceiveEmpMes")
public class TaskReceiveEmpMesController {

    private static final Logger logger = LoggerFactory.getLogger(TaskReceiveEmpMesController.class);

    @Autowired
    private TaskReceiveEmpMesService taskReceiveEmpMesService;


    @Autowired
    private TaskPondMesService taskPondMesService;

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
            DataGrid<TaskPondMesDto> taskPondMesDataGrid = taskReceiveEmpMesService.myPage(taskPondMesDto,pager);
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


}
