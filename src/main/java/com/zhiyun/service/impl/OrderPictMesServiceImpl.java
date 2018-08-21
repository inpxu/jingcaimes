/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.constant.TaskMesStateEnmu;
import com.zhiyun.dao.EmpFolderHcmDao;
import com.zhiyun.dao.OrderPictMesDao;
import com.zhiyun.dao.TaskPondMesDao;
import com.zhiyun.dao.TaskReceiveEmpMesDao;
import com.zhiyun.dto.OrderPictMesDto;
import com.zhiyun.entity.OrderPictMes;
import com.zhiyun.entity.TaskFinishedMes;
import com.zhiyun.entity.TaskPondMes;
import com.zhiyun.entity.TaskReceiveEmpMes;
import com.zhiyun.service.OrderPictMesService;
import com.zhiyun.service.TaskFinishedMesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("orderPictMesService")
public class OrderPictMesServiceImpl extends BaseServiceImpl<OrderPictMes, Long> implements OrderPictMesService {

    @Resource
    private OrderPictMesDao orderPictMesDao;
    @Resource
    private TaskPondMesDao taskPondMesDao;
    @Resource
    private TaskReceiveEmpMesDao taskReceiveEmpMesDao;
    @Resource
    private TaskFinishedMesService taskFinishedMesService;
    @Autowired
    private EmpFolderHcmDao empFolderHcmDao;

    @Override
    protected BaseDao<OrderPictMes, Long> getBaseDao() {
        return this.orderPictMesDao;
    }

    @Override
    public OrderPictMesDto pictPage(OrderPictMes orderPictMes) {
        List<OrderPictMes> orderPictMess = orderPictMesDao.find(orderPictMes);
        List<String> picture = new ArrayList<>();
        OrderPictMesDto orderPictMesDto = new OrderPictMesDto();
        if (orderPictMess != null && orderPictMess.size() > 0) {
            OrderPictMes pictMes = orderPictMess.get(0);
            orderPictMesDto.setCompanyId(pictMes.getCompanyId());
            orderPictMesDto.setCrafworkId(pictMes.getCrafworkId());
            orderPictMesDto.setDeleted(pictMes.getDeleted());
            orderPictMesDto.setDesc(pictMes.getDesc());
            orderPictMesDto.setInsideOrder(pictMes.getInsideOrder());
            orderPictMesDto.setSendDate(pictMes.getSendDate());
            orderPictMesDto.setSendEmp(pictMes.getSendEmp());
            orderPictMesDto.setSerial(pictMes.getSerial());
            orderPictMesDto.setProdNo(pictMes.getProdNo());
            orderPictMesDto.setGetTime(pictMes.getGetTime());
            for (OrderPictMes order : orderPictMess) {
                picture.add(order.getLinkPath());
            }
            orderPictMesDto.setPictureUrls(picture);
        } else {
            orderPictMesDto.setPictureUrls(null);
        }
        return orderPictMesDto;
    }

    @Override
    public int updateTime(OrderPictMesDto orderPictMesDto) {
        TaskReceiveEmpMes task = new TaskReceiveEmpMes();
        task.setActHours(orderPictMesDto.getActHours());
        task.setCrafworkId(orderPictMesDto.getCrafworkId());
        task.setInsideOrder(orderPictMesDto.getInsideOrder());
        task.setProdNo(orderPictMesDto.getProdNo());
        task.setGetTime(orderPictMesDto.getGetTime());
        task.setCompanyId(UserHolder.getCompanyId());
        return orderPictMesDao.updateTime(task);
    }

    @Override
    public int updatePondStatus(OrderPictMesDto orderPictMesDto) {
        TaskPondMes taskPondMes = new TaskPondMes();
        taskPondMes.setInsideOrder(orderPictMesDto.getInsideOrder());
        taskPondMes.setProdNo(orderPictMesDto.getProdNo());
        taskPondMes.setCrafworkId(orderPictMesDto.getCrafworkId());
        taskPondMes.setStatus(orderPictMesDto.getStatus());
        return taskPondMesDao.updateStatus(taskPondMes);
    }

    @Override
    public int updateReceiveStatus(OrderPictMesDto orderPictMesDto) {
        TaskReceiveEmpMes taskReceiveEmpMes = new TaskReceiveEmpMes();
        taskReceiveEmpMes.setInsideOrder(orderPictMesDto.getInsideOrder());
        taskReceiveEmpMes.setProdNo(orderPictMesDto.getProdNo());
        taskReceiveEmpMes.setCrafworkId(orderPictMesDto.getCrafworkId());
        taskReceiveEmpMes.setStatus(orderPictMesDto.getStatus());
        taskReceiveEmpMes.setGetTime(orderPictMesDto.getGetTime());
        return taskReceiveEmpMesDao.updateStatus(taskReceiveEmpMes);
    }

    @Override
    @Transactional
    public int add(OrderPictMesDto orderPictMesDto) {
        // 添加图片详情
        orderPictMesDao.add(orderPictMesDto);
        TaskFinishedMes finishedMes = new TaskFinishedMes();
        finishedMes.setCrafworkId(orderPictMesDto.getCrafworkId());
        finishedMes.setInsideOrder(orderPictMesDto.getInsideOrder());
        finishedMes.setProdNo(orderPictMesDto.getProdNo());
        finishedMes.setGetTime(orderPictMesDto.getGetTime());
        finishedMes.setOkDatetime(orderPictMesDto.getOkDatetime());
        finishedMes.setCompanyId(UserHolder.getCompanyId());
        // 修改交工状态,完工时间
        taskFinishedMesService.updateIsCheck(finishedMes);
        TaskReceiveEmpMes task = new TaskReceiveEmpMes();
        task.setActHours(orderPictMesDto.getActHours());
        task.setCrafworkId(orderPictMesDto.getCrafworkId());
        task.setInsideOrder(orderPictMesDto.getInsideOrder());
        task.setProdNo(orderPictMesDto.getProdNo());
        task.setGetTime(orderPictMesDto.getGetTime());
        task.setCompanyId(UserHolder.getCompanyId());
        // 修改完工时间
        orderPictMesDao.updateTime(task);
        orderPictMesDto.setStatus(TaskMesStateEnmu.DONE.getId());
        TaskPondMes taskPondMes = new TaskPondMes();
        taskPondMes.setInsideOrder(orderPictMesDto.getInsideOrder());
        taskPondMes.setProdNo(orderPictMesDto.getProdNo());
        taskPondMes.setCrafworkId(orderPictMesDto.getCrafworkId());
        taskPondMes.setGetTime(orderPictMesDto.getGetTime());
        taskPondMes.setStatus(orderPictMesDto.getStatus());
        // 修改任务池状态
        taskPondMesDao.updateStatus(taskPondMes);
        TaskReceiveEmpMes taskReceiveEmpMes = new TaskReceiveEmpMes();
        taskReceiveEmpMes.setInsideOrder(orderPictMesDto.getInsideOrder());
        taskReceiveEmpMes.setProdNo(orderPictMesDto.getProdNo());
        taskReceiveEmpMes.setCrafworkId(orderPictMesDto.getCrafworkId());
        taskReceiveEmpMes.setStatus(orderPictMesDto.getStatus());
        taskReceiveEmpMes.setGetTime(orderPictMesDto.getGetTime());
        // 修改领派工状态
        int a = taskReceiveEmpMesDao.updateStatus(taskReceiveEmpMes);
        return a;
    }

    @Override
    public boolean isCommitLoginUserWork(Map<String, Object> params) {
        String empNo = (String) params.get("empNo");
        //通过当前登录用户的id，去授权中心查询用户的员工编号
        Long userId = UserHolder.getId();
        Map<String, Object> param = new HashMap<>(2);
        param.put("userId", userId);
        param.put("companyId", UserHolder.getCompanyId());
        String byUserId = empFolderHcmDao.findByUserId(param);
        return empNo.equals(byUserId);
    }
}
