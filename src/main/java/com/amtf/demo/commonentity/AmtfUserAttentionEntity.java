package com.amtf.demo.commonentity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AmtfUserAttentionEntity {

	/**
	 * id
	 */
	private Integer user_attention_id;

	/**
	 * 关注用户id
	 */
	private String attention_id;

	/**
	 *用户id
	 */
	private String user_id;

	/**
	 *发布时间
	 */
	private String user_attention_time;
}
