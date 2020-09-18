package com.amtf.demo.f010002entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class f010002_select4entity {

	/**
	 * 发布人
	 */
	private String updnotice_id;
	
	/**
	 * 标题
	 */
	private String updnotice_name;

	/**
	 * 内容
	 */
	private String updnotice_text;

	/**
	 * 时间
	 */
	private Date updnotice_time;

}
