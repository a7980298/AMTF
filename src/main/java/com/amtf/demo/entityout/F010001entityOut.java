package com.amtf.demo.entityout;

import java.util.List;
import java.util.Map;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010001entityOut extends UserImpl {

	/**
	 * 密码是否正确
	 */
	public String pwdbol;

	/**
	 * 导航栏
	 */
	public Map<String, List<String>> navigation_bar;
}
