package com.amtf.demo.service;

public interface MailService {

	/**
	 * 发送邮件
	 * 
	 * @param to         邮件收件人
	 * @param verifyCode 邮件验证码
	 */
	public String sendSimpleMail(String to, String verifyCode);

}
