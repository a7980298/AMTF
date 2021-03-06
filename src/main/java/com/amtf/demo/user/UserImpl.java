package com.amtf.demo.user;

import java.util.List;

import com.github.pagehelper.PageInfo;
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

	/**
	 * 错误信息
	 */
	private String message;

	/**
	 * 管理页面
	 */
	private Admin admin;

	/**
	 * 分页类
	 */
	PageInfo pageInfo;

	/**
	 * 跳转画面id
	 */
	private String login_html;
}
