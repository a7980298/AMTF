package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AmtfActivityEntity {

	/**
	 * id
	 */
	private Integer activity_id;

	/**
	 * 发布人姓名
	 */
	private String activity_name;

	/**
	 *活动标题
	 */
	private String activity_head;

	/**
	 *参与级别
	 */
	private String activity_check;

	/**
	 *开始日期
	 */
	private Integer activity_sttymd;

	/**
	 *结束日期
	 */
	private Integer activity_endymd;

	/**
	 *活动内容
	 */
	private String activity_text;

	/**
	 *发布时间
	 */
	private Date activity_time;
}
