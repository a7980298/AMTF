package com.amtf.demo.entityin;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F020001entityIn extends UserImpl {

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

}
