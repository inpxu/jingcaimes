/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import java.io.Serializable;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-2下午3:22:10
 */
public class EmailSendDto implements Serializable {

	private static final long serialVersionUID = 3050503125875204777L;

	//发送给
	private String[] sendTo;
	//抄送给
	private String[] copyTo;
	//标题
	private String subject;
	//内容
	private String content;
	public String[] getSendTo() {
		return sendTo;
	}
	public void setSendTo(String[] sendTo) {
		this.sendTo = sendTo;
	}
	public String[] getCopyTo() {
		return copyTo;
	}
	public void setCopyTo(String[] copyTo) {
		this.copyTo = copyTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
