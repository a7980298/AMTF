package com.amtf.demo.f020001entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F020001_Select5Entity {
	
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

}
