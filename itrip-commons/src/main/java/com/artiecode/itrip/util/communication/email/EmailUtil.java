package com.artiecode.itrip.util.communication.email;

import com.artiecode.itrip.util.ActiveCodeUtil;
import com.artiecode.itrip.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("emailUtil")
public class EmailUtil {
	@Autowired
	private JavaMailSender mailSender;

	@Async("asyncServieExecutor")
	public void sendEmail(String email, String activeCode) throws Exception {
		// 发送邮件到用户邮箱
		// 设定发送人
		// 创建邮件发送对象，使用MimeMailMessage对象可以发送HTML格式的邮件
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(ConstantUtil.MAIL_FROM);
		mailMessage.setTo(email);
		mailMessage.setSubject("爱旅行-爱文强账户激活码");
		mailMessage.setText("您的激活码是："+ activeCode + "请在" + ConstantUtil.ACTIVE_CODE_TIMEOUT + "分钟内登录系统，输入本验证码激活您的账户！");
		mailSender.send(mailMessage);
	}
}
