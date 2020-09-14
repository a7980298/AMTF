package com.amtf.demo.params;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.f010001entity.f010001_select2entity;
import com.amtf.demo.f010001entity.f010001_select3entity;
import com.amtf.demo.iInterface.iName;
import com.amtf.demo.iInterface.iSize;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class F010001Params extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;
	/**
	 * 账户
	 */
	@iName(value = "1111232323")
	@iSize(name = "账户", max = 3, min = 0)
	private String user_account;
	/**
	 * 密码
	 */
	private String user_password;
	/**
	 * 记住账户密码
	 */
	private String remember;
	/**
	 * 密码是否正确
	 */
	public String pwdbol;
	/**
	 * 导航栏
	 */
	public Map<String, List<f010001_select2entity>> navigation_bar;
	/**
	 * 注册账号
	 */
	@iSize(name = "注册账户", max = 3, min = 0)
	public String regist_user_name;
	/**
	 * 注册密码
	 */
	@iSize(name = "注册密码", max = 3, min = 0)
	public String regist_user_password;

	/**
	 * 注册邮箱
	 */
	public String regist_user_email; 
	/**
	 * 男
	 */
	public String man;
	/**
	 * 女
	 */
	public String woman;
	/**
	 * 注册电话号码
	 */
	@iSize(name = "电话号码", max = 30, min = 0)
	public String phone_number;
	/**
	 * 是否跳转02画面
	 */
	public String bol02;
	/**
	 * 最新发布的通知
	 */
	f010001_select3entity select4;
	/**
	 * 验证码
	 */
	public String verifyCode;
	/**
	 * 注册成功
	 */
	public String yesorno;
	/**
	 * 锁定
	 */
	public String locking;
}
