/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.facade.impl;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.dto.EmailConfig;
import com.zhiyun.facade.EmailFacade;
/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-2下午2:42:48
 */
@Service("emailFacade")
public class EmailFacadeImpl implements EmailFacade {

	private static final Logger logger = LoggerFactory.getLogger(EmailFacadeImpl.class);

	@Override
	public BaseResult<String> sendEmail(String[] sendTo, String[] copyTo, String subject, String content) {
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult(true);
		EmailConfig emailUtil = new EmailConfig();
		emailUtil.setHost("smtp.163@com");
		emailUtil.setPassword("jingcai123456");
		emailUtil.setUsername("jingcai_mes@163.com");
		String host = emailUtil.getHost();
		String user = emailUtil.getUsername();
		String password = emailUtil.getPassword();
		Properties props = new Properties();
		props.put("mail.smtp.host", host); // 指定SMTP服务器
		props.put("mail.smtp.auth", "true"); // 指定是否需要SMTP验证
		try {
			Session mailSession = Session.getDefaultInstance(props);
			mailSession.setDebug(true);
			MimeMessage message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(user)); // 发件人
			System.out.println("发件人" + user);
			String toString = "";
			for (int i = 0; i < sendTo.length; i++) {
				if (i == 0) {
					toString = toString + sendTo[i];
				} else {
					toString = toString + "," + sendTo[i];
				}
			}
			// 发送
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toString));
			if (copyTo != null && copyTo.length > 0) {
				String csString = "";
				for (int i = 0; i < copyTo.length; i++) {
					if (i == 0) {
						csString = csString + copyTo[i];
					} else {
						csString = csString + "," + copyTo[i];
					}
				}
				// 抄送
				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(csString));
			}
			message.setSubject(subject); // 邮件主题
			// 指定邮箱内容及ContentType和编码方式
			message.setContent(content, "text/html;charset=utf-8");
			// 指定邮件发送日期
			message.setSentDate(new Date());
			message.saveChanges();
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, password);
			// transport.sendMessage(message, message.getAllRecipients());
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			if (copyTo != null && copyTo.length > 0) {
				transport.sendMessage(message, message.getRecipients(Message.RecipientType.CC));
			}
			transport.close();
		} catch (Exception e) {
			logger.debug("系统异常" + e);
			baseResult.setResult(false);
			baseResult.setMessage("系统异常");
		}
		return baseResult;
	}
}