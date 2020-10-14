package com.amtf.demo.entityout;

import java.util.List;
import java.util.Map;

import com.amtf.demo.f010001entity.F010001_Select2Entity;
import com.amtf.demo.f010001entity.F010001_Select3Entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010001EntityOut extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 用户id
	 */
	private Integer user_id;

	/**
	 * 账户
	 */
	private String user_account;

	/**
	 * 密码
	 */
	private String user_password;

	/**
	 * 姓名
	 */
	private String user_name;

	/**
	 * 别名
	 */
	private String user_fh;

	/**
	 * 地址
	 */
	private String user_homeaddress;

	/**
	 * 电话
	 */
	private String user_phone;

	/**
	 * 是否认证
	 */
	private String user_attestation;

	/**
	 * 密码是否正确
	 */
	public String pwdbol;

	/**
	 * 导航栏
	 */
	public Map<String, List<F010001_Select2Entity>> navigation_bar;

	/**
	 * 注册账号
	 */
	public String regist_user_name;
	/**
	 * 注册密码
	 */
	public String regist_user_password;
	/**
	 * 确认密码
	 */
	public String regist_confirm_user_password;
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
	public String phone_number;
	/**
	 * 是否跳转02画面
	 */
	public String bol02;
	/**
	 * 最新发布的通知
	 */
	F010001_Select3Entity select4;
	/**
	 * 验证码
	 */
	public String verifyCode;
	/**
	 * 注册成功
	 */
	public String yesorno;
}
