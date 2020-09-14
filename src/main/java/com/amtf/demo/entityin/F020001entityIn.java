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
	 * 用户搜索的名字
	 */
	public String search_name;

	/**
	 * 用户搜索的状态
	 */
	public String select_state;
	/**
	 * 用户搜索的账户
	 */
	public String search_account;
	/**
	 * 用户搜索的电话
	 */
	public String search_phone;

	/**
	 * 发布通知
	 */
	public String release_name;

	/**
	 * 上传图片
	 */
	public String input_file_commit;

}
