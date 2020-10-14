package com.amtf.demo.entityout;

import java.util.List;
import java.util.Map;

import com.amtf.demo.f020001entity.F020001_Select1Entity;
import com.amtf.demo.f020001entity.F020001_Select5Entity;
import com.amtf.demo.f020001entity.F020001_Select7Entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F020001EntityOut extends UserImpl {
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
	 * 用户图片
	 */
	private String imgPath;

	/**
	 * 可操作的用户信息
	 */
	List<F020001_Select1Entity> select1;

	/**
	 * 通知信息
	 */
	List<F020001_Select5Entity> select5;

	/**
	 * 活动是否发布成功
	 */
	public String isactivity;

	/**
	 * 在线人数
	 */
	public String online;

	/**
	 * 导航栏
	 */
	public Map<String, List<F020001_Select7Entity>> navigation_bar;

}
