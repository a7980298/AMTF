package com.amtf.demo.user;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.amtf.demo.iInterface.iName;
import com.amtf.demo.iInterface.iSize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserImpl {

	private String IViewId;

	private Integer User_id;

	/**
	 * 账户
	 */
	@iName(value = "1111232323")
	@iSize(name = "账户", max = 3, min = 0)
	private String User_Account;

	/**
	 * 密码
	 */
	@NotNull
	@iSize(name = "密码", max = 3, min = 0)
	private String User_Password;

	private String User_Name;

	private String User_FH;

	private String User_HomeAddress;

	private String User_Phone;

	private String User_Attestation;

	private List<String> messageList;
}
