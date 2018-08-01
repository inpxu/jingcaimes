package com.zhiyun.workflow.impl;

import com.alibaba.fastjson.JSON;
import com.zhiyun.workflow.ProcessService;
import com.zhiyun.workflow.dto.ProcessDto;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/25 15:35
 * @Description:
 */
@Service
public class ProcessServiceImpl implements ProcessService {

    @Value("${workflow.start.process.url}")
    private String startProcessUrl;

    @Value("${workflow.process.task.url}")
    private String processTaskUrl;

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    
    static {
    	okHttpClient.newBuilder().connectTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS);
    }

    @Override
    public ProcessDto startProcess(String processKey, String assignee) {

        RequestBody body = new FormBody.Builder()
                .add("userId", assignee).build();

        String url = null;
        if(startProcessUrl.endsWith("/")){
            url = startProcessUrl + processKey;
        }else {
            url = startProcessUrl + "/" + processKey;
        }

        return doExecute(url,body);

    }

    @Override
    public ProcessDto processTask(String taskId, boolean isPass) {

        RequestBody body = new FormBody.Builder()
                .add("isPass", Boolean.toString(isPass)).build();

        String url = null;
        if(processTaskUrl.endsWith("/")){
            url = processTaskUrl + taskId;
        }else {
            url = processTaskUrl + "/" + taskId;
        }

        return doExecute(url,body);

    }

    private ProcessDto doExecute(String url,RequestBody body){
        ProcessDto result = null;
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            String res = response.body().string();
            System.out.println(res);
            result = JSON.parseObject(res,ProcessDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
