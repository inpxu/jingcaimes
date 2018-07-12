/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import com.zhiyun.entity.EmpFolderHcm;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-12上午8:26:54
 */
public class EmpFolderHcmDto extends EmpFolderHcm {

	private static final long serialVersionUID = 4671384606083626925L;
	
	// 执行人
	private String doEmpNo;
	private String doEmpName;
	public String getDoEmpNo() {
		return doEmpNo;
	}
	public void setDoEmpNo(String doEmpNo) {
		this.doEmpNo = doEmpNo;
	}
	public String getDoEmpName() {
		return doEmpName;
	}
	public void setDoEmpName(String doEmpName) {
		this.doEmpName = doEmpName;
	}
	

}
