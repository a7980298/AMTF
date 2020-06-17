package com.amtf.demo.entityin;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010001entityIn extends UserImpl {

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
