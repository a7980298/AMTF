package com.amtf.demo.params;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.f010002entity.F010002_Select4Entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class F010002Params extends UserImpl {
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
	 * 通知id
	 */
	public String updnotice_id;

	/**
	 * 详细通知信息
	 */
	List<F010002_Select4Entity> select7;

}
