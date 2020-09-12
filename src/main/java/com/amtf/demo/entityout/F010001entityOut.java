package com.amtf.demo.entityout;

import java.util.List;
import java.util.Map;

import com.amtf.demo.f010001entity.f010001_select2entity;
import com.amtf.demo.f010001entity.f010001_select3entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010001entityOut extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 用户id
	 */
	private Integer User_id;

	/**
	 * 账户
	 */
	private String User_Account;

	/**
	 * 密码
	 */
	private String User_Password;

	/**
	 * 姓名
	 */
	private String User_Name;

	/**
	 * 别名
	 */
	private String User_FH;

	/**
	 * 地址
	 */
	private String User_HomeAddress;

	/**
	 * 电话
	 */
	private String User_Phone;

	/**
	 * 是否认证
	 */
	private String User_Attestation;

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
	f010001_select3entity select4;
	/**
	 * 验证码
	 */
	public String verifyCode;
}
