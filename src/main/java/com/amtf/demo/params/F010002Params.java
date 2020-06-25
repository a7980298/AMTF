package com.amtf.demo.params;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.f010001entity.f010001_select2entity;
import com.amtf.demo.f010001entity.f010001_select3entity;
import com.amtf.demo.user.UserImpl;
import com.amtf.demo.util.FenYe;

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
	 * 导航栏
	 */
	public Map<String, List<f010001_select2entity>> navigation_bar;
	/**
	 * 最新发布的通知
	 */
	f010001_select3entity select4;

	public FenYe fenye;
	/**
	 * 修改：用户名
	 */
	public String upd_user_name;
	/**
	 * 修改：地址
	 */
	public String upd_user_homeaddress;
}
