package com.amtf.demo.entityout;

import java.util.List;

import com.amtf.demo.user.UserImpl;
import com.amtf.demo.user.WebSockerUsers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010008EntityOut extends UserImpl {

	/**
	 * 在线用户
	 */
	List<WebSockerUsers> userList;
}
