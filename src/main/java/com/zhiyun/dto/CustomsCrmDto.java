/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import com.zhiyun.entity.CustomsCrm;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-6-30上午9:11:48
 */
public class CustomsCrmDto extends CustomsCrm {

	private static final long serialVersionUID = 3874355712356916086L;
	
	// 客户信息
	private String customMess;

	public String getCustomMess() {
		return customMess;
	}

	public void setCustomMess(String customMess) {
		this.customMess = customMess;
	}
	
	


}
