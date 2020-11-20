package com.amtf.demo.params;

import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Getter
@Setter
public class F010011Params extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 用户主页信息
	 */
	String user;

	/**
	 * 用户信息
	 */
	AmtfUserEntity select1;

	/**
	 * 是否关注发布人
	 */
	Integer attention;
}
