package com.amtf.demo.f020001entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F020001_Select2EntityIn {

	public Integer pow;

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
}
