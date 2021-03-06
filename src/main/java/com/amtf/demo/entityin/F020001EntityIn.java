package com.amtf.demo.entityin;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.amtf.demo.f020001entity.F020001_Select5Entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F020001EntityIn extends UserImpl {

	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 认证状态
	 */
	private String userAttestation;

	/**
	 * 账户状态
	 */
	private String userStatus;

	/**
	 * 等级选择
	 */
	private String levelOptionsValue;

	/*----------------------------------------------------------------------------------------*/

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
	 * 上传图片
	 */
	public String input_file_commit;
	
	/**
	 * 刪除的用戶id
	 */
	public String userid;
	
	/**
	 * 通知信息
	 */
	List<F020001_Select5Entity> select5;
}
