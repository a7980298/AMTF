package com.amtf.demo.params;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;

import com.amtf.demo.f010001entity.f010001_select2entity;
import com.amtf.demo.f010001entity.f010001_select3entity;
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
	 * 导航栏
	 */
	public Map<String, List<f010001_select2entity>> navigation_bar;
	/**
	 * 最新发布的通知
	 */
	f010001_select3entity select4;

	/**
	 * 修改：用户id
	 */
	private Integer upd_user_id;

	/**
	 * 修改：账户
	 */
	private String upd_user_account;

	/**
	 * 修改：密码
	 */
	private String upd_user_password;

	/**
	 * 修改：姓名
	 */
	private String upd_user_name;

	/**
	 * 修改：国家
	 */
	private String upd_user_country;

	/**
	 * 修改：省
	 */
	private String upd_user_province;
	
	/**
	 * 修改：市
	 */
	private String upd_user_city;
	
	/**
	 * 修改：邮编
	 */
	private String upd_user_postcode;

	/**
	 * 修改：电话
	 */
	private String upd_user_phone;
	
	/**
	 * 修改：介绍
	 */
	private String upd_user_introduce;
	
	/**
	 * 修改：用户照片
	 */
	public MultipartFile upd_user_img;
	
	/**
	 * 是否修改成功
	 */
	public String isUpdatUserOk;
}
