package com.amtf.demo.f020001entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F020001_UserHistoryEntity {

	/**
	 * 介绍
	 */
	private String userIntroduce;

	/**
	 * 是否认证
	 */
	private String userAttestation;

	/**
	 * 参加的活动次数
	 */
	private Integer numberOfActivities;

	/**
	 * 发布问题的次数
	 */
	private Integer numberOfQuestions;

	/**
	 * 发布视频的次数
	 */
	private Integer numberOfVideo;
}
