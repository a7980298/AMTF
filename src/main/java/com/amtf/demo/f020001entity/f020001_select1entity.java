package com.amtf.demo.f020001entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class f020001_select1entity {

	/**
	 * 用户id
	 */
	private Integer user_id;
	
	/**
	 * Email
	 */
	private String user_email;

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
	 * 国家
	 */
	private String user_country;

	/**
	 *  省
	 */
	private String user_province;
	
	/**
	 *  市
	 */
	private String user_city;
	
	/**
	 *  邮编
	 */
	private String user_postcode;

	/**
	 * 电话
	 */
	private String user_phone;
	
	/**
	 * 介绍
	 */
	private String user_introduce ;

	/**
	 * 是否认证
	 */
	private String user_attestation;

	/**
	 * 权限
	 */
	private String user_power;

	private String user_path;

}
