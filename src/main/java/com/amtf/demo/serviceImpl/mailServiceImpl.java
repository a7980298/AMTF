package com.amtf.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.amtf.demo.service.mailService;
import com.amtf.demo.util.Constant;

@Service
public class mailServiceImpl implements mailService {

	@Autowired
	private JavaMailSender mailSender;

	public String sendSimpleMail(String to, String verifyCode) {
		SimpleMailMessage message = new SimpleMailMessage();
		try {
			message.setFrom("2428503607@qq.com");
			// 收件人邮箱
			message.setTo(to);
			// 主题
			message.setSubject("AMTF");
			// 验证码
			message.setText("艾玛天府提醒您，您的验证码是：" + verifyCode);

			mailSender.send(message);
		} catch (Exception e) {
			return Constant.STR_0;
		}
		return Constant.STR_1;
	}
}