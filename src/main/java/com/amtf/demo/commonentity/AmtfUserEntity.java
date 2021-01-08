package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AmtfUserEntity {

	/**
	 * 用户id
	 */
	private Integer user_id;

	/**
	 * No
	 */
	private String user_no;

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
	 * 省
	 */
	private String user_province;

	/**
	 * 市
	 */
	private String user_city;

	/**
	 * 邮编
	 */
	private String user_postcode;

	/**
	 * 电话
	 */
	private String user_phone;

	/**
	 * 介绍
	 */
	private String user_introduce;

	/**
	 * 是否认证
	 */
	private Integer user_attestation;

	/**
	 * 权限
	 */
	private Integer user_power;

	/**
	 * 状态
	 */
	private String user_status;

	/**
	 * 头像路径
	 */
	private String imgpath;
}
