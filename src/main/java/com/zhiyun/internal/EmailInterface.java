/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.internal;

import com.zhiyun.dto.EmailSendDto;
import com.zhiyun.internal.base.BaseInterfResult;


/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-2下午3:39:49
 */
public interface EmailInterface {
	
	/**
	 * 邮件发送
	 * @param emailSendDto
	 * @return
	 */
    public BaseInterfResult<String> sendEmail(EmailSendDto emailSendDto);

}
