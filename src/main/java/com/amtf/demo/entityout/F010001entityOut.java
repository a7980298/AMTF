package com.amtf.demo.entityout;

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
}
