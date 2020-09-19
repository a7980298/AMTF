package com.amtf.demo.f010002entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class f010002_select4entity {
	
	/**
	 * id
	 */
	private String updnotice_id;

	/**
	 * 发布人
	 */
	private String updnotice_name;
	
	/**
	 * 标题
	 */
	private String updnotice_head;

	/**
	 * 内容
	 */
	private String updnotice_text;

	/**
	 * 时间
	 */
	private Date updnotice_time;
	
	/**
	 * 是否被查看
	 */
	private String islook;

}
