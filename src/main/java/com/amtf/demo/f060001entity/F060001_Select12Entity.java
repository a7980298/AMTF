package com.amtf.demo.f060001entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F060001_Select12Entity {

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
	private String qa_class1;

	/**
	 *发布的类型1
	 */
	private String qa_class2;

	/**
	 *发布的类型1
	 */
	private String qa_class3;

	/**
	 *发布时间
	 */
	private String qa_time;

	/**
	 *头像路径
	 */
	private String user_img;

	/**
	 *回复人数
	 */
	private String count;
}
