package com.amtf.demo.f010005entity;

import com.amtf.demo.commonentity.AmtfActivityCommentEntity;
import com.amtf.demo.commonentity.AmtfActivityCommentReplyEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommentListEntity {

	/**
	 * 一级评论
	 */
	private AmtfActivityCommentEntity amtfactivitycommententity;

	/**
	 * 二级评论
	 */
	private List<AmtfActivityCommentReplyEntity> amtfactivitycommentreplyentity;
}
