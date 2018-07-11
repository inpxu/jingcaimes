/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import java.math.BigDecimal;
import java.util.List;

import com.zhiyun.entity.DeliveryProdCrm;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-6-29上午10:44:36
 */
public class DeliveryProdCrmDto extends DeliveryProdCrm {

	private static final long serialVersionUID = 8355243487786211490L;
	
	// 客户信息
	private String customMess;
	// 总数量
	private BigDecimal sum;
	// 总金额
	private BigDecimal sumTatal;
	// 产品信息
	private List<TaskFinishedMesDto> TaskFinishedMesDtos;
	
	public List<TaskFinishedMesDto> getTaskFinishedMesDtos() {
		return TaskFinishedMesDtos;
	}

	public void setTaskFinishedMesDtos(List<TaskFinishedMesDto> taskFinishedMesDtos) {
		TaskFinishedMesDtos = taskFinishedMesDtos;
	}

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	public BigDecimal getSumTatal() {
		return sumTatal;
	}

	public void setSumTatal(BigDecimal sumTatal) {
		this.sumTatal = sumTatal;
	}

	public String getCustomMess() {
		return customMess;
	}

	public void setCustomMess(String customMess) {
		this.customMess = customMess;
	}
	
	

}
