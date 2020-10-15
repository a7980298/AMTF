package com.amtf.demo.params;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.f010002entity.F010002_Select9Entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class F010005Params extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 活动id
	 */
	public String actiyity_id;

	/**
	 * 参加活动添加成功?
	 */
	public String insert10;

	/**
	 * 所有活动
	 */
	List<F010002_Select9Entity> select9;
}
