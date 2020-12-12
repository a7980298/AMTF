package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AmtfNewsEntity {

	/**
	 * 发布用户
	 */
	private String news_user;

	/**
	 *新闻标题
	 */
	private String news_name;

	/**
	 *新闻内容
	 */
	private String news_text;

	/**
	 *发布时间
	 */
	private Date news_date;

}
