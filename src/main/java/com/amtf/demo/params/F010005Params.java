package com.amtf.demo.params;

import java.util.List;
import java.util.Map;

import com.amtf.demo.commonentity.AmtfActivityCommentEntity;
import com.amtf.demo.commonentity.AmtfActivityCommentReplyEntity;
import com.amtf.demo.commonentity.AmtfActivityEntity;
import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.f010005entity.CommentListEntity;
import com.amtf.demo.f010005entity.F010005_Select1Entity;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.f010002entity.F010002_Select9Entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010005Params extends UserImpl {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 活动id
	 */
	private String actiyity_id;

	/**
	 * 参加活动添加成功?
	 */
	private String insert10;

	/**
	 * 所有活动
	 */
	private List<F010002_Select9Entity> select9;

	/**
	 * 我参加的活动
	 */
	private List<F010005_Select1Entity> select1;

	/**
	 * 我发布的活动
	 */
	private List<F010005_Select1Entity> select2;

	/**
	 * 详细活动id
	 */
	private String activity_id;


	/**
	 * 详细活动
	 */
	private AmtfActivityEntity select3;

	/**
	 * 活动发布人信息
	 */
	private AmtfUserEntity select4;

	/**
	 * 活动评论
	 */
	private List<CommentListEntity> commentlist;

	/**
	 * 活动点赞人数
	 */
	private Integer fabulouscount;

	/**
	 * 点赞添加
	 */
	private String fabulous;

	/**
	 * 评论点赞添加
	 */
	String comment_fabulous;

	/**
	 * 参加人数
	 */
	Integer useractivity_count;

	/**
	 * 是否关注发布人
	 */
	Integer attention;

	/**
	 * 关注发布人
	 */
	String isattention;
}
