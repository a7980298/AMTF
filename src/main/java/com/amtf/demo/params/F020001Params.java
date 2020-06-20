package com.amtf.demo.params;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class F020001Params extends UserImpl {
	/**
	 * 姓名
	 */
	private String User_Name;

	private String imgPath;
}
