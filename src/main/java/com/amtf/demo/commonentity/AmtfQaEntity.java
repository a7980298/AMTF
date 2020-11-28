package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AmtfQaEntity {

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
	 *发布的类型
	 */
	private String qa_class;

	/**
	 *发布时间
	 */
	private String qa_time;
}
