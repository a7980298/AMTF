package com.amtf.demo.entityout;

import java.util.List;

import com.amtf.demo.f020001entity.f020001_select1entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F030001entityOut extends UserImpl {
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
	 * 用户图片
	 */
	private String imgPath;

	/**
	 * 可操作的用户信息
	 */
	List<f020001_select1entity> select1;

}
