/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.facade;

import com.zhiyun.base.dto.BaseResult;


/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-2下午2:39:29
 */
public interface EmailFacade {

	/**
	 * 邮件发送
	 * @param sendTo 收件人邮箱
	 * @param copyTo 抄送人邮箱
	 * @param subject 标题
	 * @param content 内容
	 */
	BaseResult<String> sendEmail(String[] sendTo, String[] copyTo, String subject, String content);

}
