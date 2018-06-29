package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.dto.TaskPondMesDto;
import com.zhiyun.service.TaskReceiveEmpMesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
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


}
