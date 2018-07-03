/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import java.io.Serializable;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-2下午2:40:36
 */
public class EmailConfig implements Serializable {

	private static final long serialVersionUID = -364140512315046292L;
	// 用户名
	private String username;
	// 授权码
	private String password;
	// stmp地址
	private String host;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
