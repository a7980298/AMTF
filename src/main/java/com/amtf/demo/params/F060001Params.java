package com.amtf.demo.params;

import java.util.List;

import com.amtf.demo.commonentity.AmtfQaClassEntity;
import com.amtf.demo.commonentity.AmtfQaEntity;
import com.amtf.demo.commonentity.AmtfQaReplyEntity;
import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.f060001entity.F060001_Select12Entity;
import com.amtf.demo.f060001entity.F060001_Select13Entity;
import com.amtf.demo.f060001entity.F060001_Select3Entity;
import com.github.pagehelper.PageInfo;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter

public class F060001Params {
	/**
	 * 页面id
	 */
	private String IViewId;

	/**
	 * 标签类型
	 */
	private List<AmtfQaClassEntity> qa_class_lists;

	/**
	 * 最新问题
	 */
	private List<F060001_Select3Entity> select3;

	/**
	 * 问题id
	 */
	private String qa_id;

	/**
	 * 详细问题
	 */
	private AmtfQaEntity select5;

	/**
	 * 问题回复
	 */
	private List<AmtfQaReplyEntity> select6;

	/**
	 * 发布人信息
	 */
	private AmtfUserEntity select7;

	/**
	 * 用户标签
	 */
	private List<AmtfQaClassEntity> select8;

	/**
	 * 提问数量
	 */
	private Integer select9;

	/**
	 * 回答数量
	 */
	private Integer select10;

	/**
	 * 标签分类
	 */
	private List<AmtfQaClassEntity> select11;

	/**
	 * 回复最多的问题
	 */
	private List<F060001_Select12Entity> select12;

	/**
	 * 回复最多的用户
	 */
	private List<F060001_Select13Entity> select13;

	/**
	 * 标签id
	 */
	private String class_id;

	/**
	 * 分页标签一栏
	 */
	private PageInfo<F060001_Select3Entity> select3_pageInfo;
}
