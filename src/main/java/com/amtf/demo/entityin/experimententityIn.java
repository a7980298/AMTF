package com.amtf.demo.entityin;

import java.util.List;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class experimententityIn extends UserImpl {
	private String IViewId;

	private Integer User_id;
	/**
	 * 账户
	 */
	private String User_Account;
	/**
	 * 密码
	 */
	private String User_Password;

	private String User_Name;

	private String User_FH;

	private String User_HomeAddress;

	private String User_Phone;

	private String User_Attestation;

	private List<String> messageList;

}
