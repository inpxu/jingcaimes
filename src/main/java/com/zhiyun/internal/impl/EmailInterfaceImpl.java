/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.internal.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.dto.EmailSendDto;
import com.zhiyun.facade.EmailFacade;
import com.zhiyun.internal.EmailInterface;
import com.zhiyun.internal.base.BaseInterfResult;
import com.zhiyun.internal.base.BaseInterfaceImpl;


@Service("emailInterface")
public class EmailInterfaceImpl extends BaseInterfaceImpl implements EmailInterface {
	private static final Logger logger = LoggerFactory.getLogger(EmailInterfaceImpl.class);

	@Resource
	private EmailFacade emailFacade;
	
	@Override
	public BaseInterfResult<String> sendEmail(EmailSendDto emailSendDto) {
		BaseInterfResult<String> baseInterfResult = new BaseInterfResult<String>();
		baseInterfResult.setResult(true);
		try {
			if (emailSendDto == null) {
				throw new BusinessException("接收参数为空");
			}
			if (emailSendDto.getSendTo() == null || emailSendDto.getSendTo().length < 1) {
				throw new BusinessException("发送人邮箱为空");
			}
			emailFacade.sendEmail(emailSendDto.getSendTo(), emailSendDto.getCopyTo(), emailSendDto.getSubject(), emailSendDto.getContent());
		} catch (BusinessException be) {
			logger.debug("业务异常"+be);
			baseInterfResult.setResult(false);
			baseInterfResult.setMessage(be.getMessage());
		} catch (Exception e) {
			logger.debug("接口异常"+e);
			baseInterfResult.setResult(false);
			baseInterfResult.setMessage("接口异常");
		}
		return baseInterfResult;
	}

}
