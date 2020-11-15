package com.amtf.demo.entityout;

import java.util.List;
import java.util.Map;

import com.amtf.demo.commonentity.AmtfActivityCommentEntity;
import com.amtf.demo.commonentity.AmtfActivityCommentReplyEntity;
import com.amtf.demo.commonentity.AmtfActivityEntity;
import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.f010002entity.F010002_Select9Entity;
import com.amtf.demo.f010005entity.CommentListEntity;
import com.amtf.demo.f010005entity.F010005_Select1Entity;
import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010005EntityOut extends UserImpl {

	/**
	 * 参加活动添加成功?
	 */
	public String insert10;

	/**
	 * 所有活动
	 */
	List<F010002_Select9Entity> select9;

	/**
	 * 我参加的活动
	 */
	List<F010005_Select1Entity> select1;

	/**
	 * 我发布的活动
	 */
	List<F010005_Select1Entity> select2;

	/**
	 * 详细活动
	 */
	AmtfActivityEntity select3;

	/**
	 * 活动发布人信息
	 */
	AmtfUserEntity select4;

	/**
	 * 活动评论
	 */
	List<CommentListEntity> commentlist;

	/**
	 * 一级评论添加
	 */
	Integer insert6;

	/**
	 * 二级评论添加
	 */
	Integer insert8;

	/**
	 * 活动点赞人数
	 */
	Integer fabulouscount;

	/**
	 * 点赞添加
	 */
	String isfabulous;
}
