package com.amtf.demo.entityout;

import java.util.List;
import java.util.Map;

import com.amtf.demo.f010001entity.F010001_Select2Entity;
import com.amtf.demo.f010001entity.F010001_Select3Entity;
import com.amtf.demo.f010002entity.F010002_Select4Entity;
import com.amtf.demo.f010002entity.F010002_Select9Entity;
import com.amtf.demo.user.UserImpl;
import com.amtf.demo.util.FenYe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010002EntityOut extends UserImpl {

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
	public Map<String, List<F010001_Select2Entity>> navigation_bar;

	/**
	 * 最新发布的通知
	 */
	F010001_Select3Entity select4;

	public FenYe fenye;
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
	 * 是否修改成功
	 */
	public String isUpdatUserOk;

	/**
	 * 通知信息
	 */
	List<F010002_Select4Entity> select5;

	/**
	 * 详细通知信息
	 */
	List<F010002_Select4Entity> select7;

	/**
	 * 所有通知
	 */
	List<F010002_Select4Entity> select8;

	/**
	 * 所有活动
	 */
	List<F010002_Select9Entity> select9;

}
