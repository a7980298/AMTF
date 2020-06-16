package com.amtf.demo.params;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class F010001Params extends UserImpl {
	/**
	 * 密码是否正确
	 */
	public String pwdbol;

	/**
	 * 导航栏
	 */
	public Map<String, List<String>> navigation_bar;
	/**
	 * 注册账号
	 */
	@NotNull
	@Size(max = 3)
	public String regist_user_name;
	/**
	 * 注册密码
	 */
	@NotNull
	@Size(max = 3)
	public String regist_user_password;
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
	@Size(max = 6)
	public String phone_number;
}
