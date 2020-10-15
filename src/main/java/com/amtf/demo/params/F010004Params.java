package com.amtf.demo.params;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.f010001entity.F010001_Select3Entity;
import com.amtf.demo.f010002entity.F010002_Select4Entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter
public class F010004Params extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 最新发布的通知
	 */
	F010001_Select3Entity select4;

	/**
	 * 通知信息
	 */
	List<F010002_Select4Entity> select5;

	/**
	 * 所有通知
	 */
	List<F010002_Select4Entity> select8;
}
