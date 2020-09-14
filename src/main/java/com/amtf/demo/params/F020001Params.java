package com.amtf.demo.params;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.f010001entity.f010001_select3entity;
import com.amtf.demo.f020001entity.f020001_select1entity;
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
	private String user_name;

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

	/**
	 * 最新发布的通知
	 */
	f010001_select3entity select4;

	/**
	 * 上传图片
	 */
	public String input_file_commit;
}
