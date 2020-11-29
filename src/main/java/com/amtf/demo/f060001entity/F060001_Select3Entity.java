package com.amtf.demo.f060001entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F060001_Select3Entity {

	/**
	 * id
	 */
	private Integer qa_id;

	/**
	 * 发布人id
	 */
	private String user_id;

	/**
	 *发布标题
	 */
	private String qa_head;

	/**
	 *发布内容
	 */
	private String qa_text;

	/**
	 *发布的类型1
	 */
	private String qa_classname1;

	/**
	 *发布的类型2
	 */
	private String qa_classname2;

	/**
	 *发布的类型3
	 */
	private String qa_classname3;

	/**
	 *发布时间
	 */
	private String qa_time;

	/**
	 *发布人姓名
	 */
	private String user_name;

	/**
	 *发布人头像
	 */
	private String user_img;
}
