/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.controller.BaseController;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.constant.Constant;
import com.zhiyun.dto.TaskFinishedMesDto;
import com.zhiyun.entity.TaskCheckRecordMes;
import com.zhiyun.entity.TaskFinishedMes;
import com.zhiyun.service.EmpFolderHcmService;
import com.zhiyun.service.TaskCheckRecordMesService;
import com.zhiyun.service.TaskFinishedMesService;

/**
 * 任务交工
 * @author 徐飞
 * @version v1.0
 * @date 2018-6-21下午2:36:44
 */

@Controller
@RequestMapping(value = "/taskFinishedMes")
public class TaskFinishedMesController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskFinishedMesController.class);
	
	@Resource
	private TaskFinishedMesService taskFinishedMesService;
	@Resource
	private TaskCheckRecordMesService checkRecordMesService;
	@Resource
	private EmpFolderHcmService empFolderHcmService;
	
	/**
	 * 任务交工分页查询
	 * @param: @param taskFinishedMesDto
	 * @param: @param bindingResult
	 * @param: @param pager
	 * @param: @return
	 * @return: Object 
	 * @author: 徐飞
	 * @date: 2018-6-21 下午5:33:26
	 */
	@ResponseBody
	@RequestMapping(value = "/findByMes", method = { RequestMethod.GET, RequestMethod.POST })
	public Object findByMes(@Valid TaskFinishedMesDto taskFinishedMesDto, BindingResult bindingResult, Pager pager) {
		BaseResult<DataGrid<TaskFinishedMesDto>> baseResult = new BaseResult<DataGrid<TaskFinishedMesDto>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			Params params = Params.create();
			params.add("companyId", UserHolder.getCompanyId());
			params.add("entity", taskFinishedMesDto);
			DataGrid<TaskFinishedMesDto> dataGrid = taskFinishedMesService.findByMes(params, pager.getPage());
			for (TaskFinishedMesDto task : dataGrid.getItems()) {
				task.setStatus(Constant.IsCheck.getIsCheckDesc(task.getIsCheck()));
			}
			baseResult.setModel(dataGrid);
		} catch (BusinessException be) {
			logger.debug("业务异常"+be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常"+e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
	}
	
	/**
	 * 任务交工记录分页查询
	 * @param: @param taskFinishedMesDto
	 * @param: @param bindingResult
	 * @param: @param pager
	 * @param: @return
	 * @return: Object 
	 * @author: 徐飞
	 * @date: 2018-6-25 上午11:24:48
	 */
	@ResponseBody
	@RequestMapping(value = "/checkRecord", method = { RequestMethod.GET, RequestMethod.POST })
	public Object checkRecord(@Valid TaskFinishedMesDto taskFinishedMesDto, BindingResult bindingResult, Pager pager) {
		BaseResult<DataGrid<TaskFinishedMesDto>> baseResult = new BaseResult<DataGrid<TaskFinishedMesDto>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			Params params = Params.create();
			params.add("companyId", UserHolder.getCompanyId());
			params.add("entity", taskFinishedMesDto);
			DataGrid<TaskFinishedMesDto> dataGrid = taskFinishedMesService.findByMes(params, pager.getPage());
			for (TaskFinishedMesDto task : dataGrid.getItems()) {
				task.setStatus(Constant.IsCheck.getIsCheckDesc(task.getIsCheck()));
			}
			baseResult.setModel(dataGrid);
		} catch (BusinessException be) {
			logger.debug("业务异常"+be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常"+e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
	}

	/**
	 * 发起评审分页查询
	 * @param: @param taskFinishedMesDto
	 * @param: @param bindingResult
	 * @param: @param pager
	 * @param: @return
	 * @return: Object 
	 * @author: 徐飞
	 * @date: 2018-6-25 下午4:57:34
	 */
	@ResponseBody
	@RequestMapping(value = "/cusReview", method = { RequestMethod.GET, RequestMethod.POST })
	public Object cusReview(@Valid TaskFinishedMesDto taskFinishedMesDto, BindingResult bindingResult, Pager pager) {
		BaseResult<DataGrid<TaskFinishedMesDto>> baseResult = new BaseResult<DataGrid<TaskFinishedMesDto>>();
		baseResult.setResult(true);
		baseResult.setMessage("操作成功"); 
		try {
			vaildParamsDefault(baseResult, bindingResult);
			Params params = Params.create();
			params.add("companyId", UserHolder.getCompanyId());
			params.add("entity", taskFinishedMesDto);
			DataGrid<TaskFinishedMesDto> dataGrid = taskFinishedMesService.cusReview(params, pager.getPage());
			for (TaskFinishedMesDto task : dataGrid.getItems()) {
				if ("1".equals(task.getCusIsOk())) {
					task.setCusIsOk("评审中");
				} else if ("2".equals(task.getCusIsOk())) {
					task.setCusIsOk("已通过");
				} else if ("3".equals(task.getCusIsOk())) {
					task.setCusIsOk("未通过");
				} else {
					task.setCusIsOk("未发起评审");
				}
			}
			baseResult.setModel(dataGrid);
		} catch (BusinessException be) {
			logger.debug("业务异常"+be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常"+e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
	}
	
	/**
	 * 发起评审
	 * @param: @param orderPictMesDto
	 * @param: @param bindingResult
	 * @param: @return
	 * @return: Object 
	 * @author: 徐飞
	 * @date: 2018-6-22 下午1:46:41
	 */
	@ResponseBody
	@RequestMapping(value = "/tasks", method = { RequestMethod.GET, RequestMethod.POST })
	public Object tasks(@Valid TaskFinishedMes taskFinishedMes , BindingResult bindingResult) {
		BaseResult<TaskFinishedMes> baseResult = new BaseResult<TaskFinishedMes>();
		baseResult.setResult(true);
		baseResult.setMessage("成功发起评审！"); 
		try {
			TaskCheckRecordMes checKMes = new TaskCheckRecordMes();
			checKMes.setCrafworkId(taskFinishedMes.getCrafworkId());
			checKMes.setInsideOrder(taskFinishedMes.getInsideOrder());
			checKMes.setProdNo(taskFinishedMes.getProdNo());
			checKMes.setCompanyId(UserHolder.getCompanyId());
			List<TaskCheckRecordMes> checkRecordMes = checkRecordMesService.find(checKMes);
			checKMes.setCusIsOk("1");
			checKMes.setCheckDate(new Date());
			Long userId = UserHolder.getId();
			String empNo = empFolderHcmService.findByUserId(userId).getDoEmpNo();
			checKMes.setCheckEmpNo(empNo);
			for (TaskCheckRecordMes check : checkRecordMes) {
				String isOk = check.getCusIsOk();
				if (isOk == null ) {
					checkRecordMesService.insert(checKMes);
				} else if ("3".equals(isOk)) {
					checKMes.setId(check.getId());
					checkRecordMesService.update(check);
				} else {
					throw new BusinessException("评审已发起，不能重复评审！");
				}
			}
			checkRecordMesService.insert(checKMes);
			baseResult.setModel(taskFinishedMes);
		} catch (BusinessException be) {
			logger.debug("业务异常"+be);
			baseResult.setResult(false);
			baseResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("系统异常"+e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return JSON.toJSONString(baseResult);
	}
}
