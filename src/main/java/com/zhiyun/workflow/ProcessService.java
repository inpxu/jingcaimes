package com.zhiyun.workflow;

import com.zhiyun.workflow.dto.ProcessDto;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/25 15:34
 * @Description:
 */
public interface ProcessService {

    ProcessDto startProcess(String processKey,String assignee);

    ProcessDto processTask(String taskId,boolean isPass);

}
