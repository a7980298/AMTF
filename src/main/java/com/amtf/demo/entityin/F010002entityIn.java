package com.amtf.demo.entityin;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010002entityIn extends UserImpl {
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
	 * 修改：用户名
	 */
	public String upd_user_name;

	/**
	 * 修改：地址
	 */
	public String upd_user_homeaddress;
}
