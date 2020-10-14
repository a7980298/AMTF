package com.amtf.demo.params;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.f010001entity.F010001_Select3Entity;
import com.amtf.demo.f020001entity.F020001_Select1Entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class F030001Params extends UserImpl {
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
	private List<F020001_Select1Entity> select1;

	/**
	 * 用户搜索的名字
	 */
	public String search_name;

	/**
	 * 最新发布的通知
	 */
	F010001_Select3Entity select4;
}
