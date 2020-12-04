package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AmtfQaReplyEntity {

	/**
	 * id
	 */
	private Integer qa_reply_id ;

	/**
	 * 问题id
	 */
	private Integer qa_id ;

	/**
	 * 回答人id
	 */
	private String user_id;

	/**
	 * 回答内容
	 */
	private String qa_reply_text ;

	/**
	 *发布时间
	 */
	private String qa_reply_time ;

	/**
	 *图片路径
	 */
	private String user_img ;

	/**
	 * 回答人姓名
	 */
	private String user_name;
}
