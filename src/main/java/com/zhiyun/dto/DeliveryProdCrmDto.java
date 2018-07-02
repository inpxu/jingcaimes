/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import com.zhiyun.entity.DeliveryProdCrm;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-6-29上午10:44:36
 */
public class DeliveryProdCrmDto extends DeliveryProdCrm {

	private static final long serialVersionUID = 8355243487786211490L;
	
	private String customMess;

	public String getCustomMess() {
		return customMess;
	}

	public void setCustomMess(String customMess) {
		this.customMess = customMess;
	}
	
	

}
