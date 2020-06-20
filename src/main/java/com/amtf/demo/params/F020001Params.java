package com.amtf.demo.params;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.f020002entity.f020001_select1entity;
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

	/**
	 * 用户图片
	 */
	private String imgPath;

	/**
	 * 可操作的用户信息
	 */
	private List<f020001_select1entity> select1;

	/**
	 * 用户搜索的名字
	 */
	public String search_name;
}
