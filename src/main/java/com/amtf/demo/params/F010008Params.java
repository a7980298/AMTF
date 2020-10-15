package com.amtf.demo.params;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.user.UserImpl;
import com.amtf.demo.user.WebSockerUsers;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class F010008Params extends UserImpl {

	/**
	 * 在线用户
	 */
	List<WebSockerUsers> userList;
}
