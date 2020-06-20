package com.amtf.demo.user;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserImpl {

	/**
	 * 用户信息
	 */
	private LogInFo logInFo;

	/**
	 * 错误信息
	 */
	private List<String> messageList;

}
