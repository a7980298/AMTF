package com.amtf.demo.entityout;

import com.amtf.demo.commonentity.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class F040001EntityOut {
    /**
     * 视频分类
     */
    private List<AmtfVideoClassEntity> select1;

    /**
     * 上传视频
     */
    private Integer insert2;

    /**
     * 点赞人数最多的视频
     */
    private List<AmtfVideoEntity> sumpraise;

    /**
     * 专辑一栏
     */
    private List<AmtfVideoEntity> albumList;

    /**
     * 电视剧一栏
     */
    private List<AmtfVideoEntity> albumList2;

    /**
     * 电影一栏
     */
    private List<AmtfVideoEntity> albumList3;

    /**
     * 小视频一栏
     */
    private List<AmtfVideoEntity> albumList4;

    /**
     * 纪录片一栏
     */
    private List<AmtfVideoEntity> albumList5;

    /**
     * 少儿一栏
     */
    private List<AmtfVideoEntity> albumList6;

    /**
     * 推荐视频
     */
    private List<AmtfVideoEntity> recommendvideo;

    /**
     * 视频详情
     */
    private AmtfVideoEntity videoView;

    /**
     * 作者信息
     */
    private AmtfUserEntity videoAuthor;

    /**
     * 标题略同的视频
     */
    private List<AmtfVideoEntity> videoSimilar;

    /**
     * 弹幕是否添加成功
     */
    private Integer insert9;

    /**
     * 弹幕信息
     */
    private List<AmtfVideoBarrageViewEntity> barrageList;

    /**
     * 评论信息
     */
    private List<AmtfVideoCommentEntity> commentList;

    /**
     * 发布评论是否成功
     */
    private Integer insert11;

    /**
     * 回复评论是否成功
     */
    private Integer insert13;

    /**
     * 回复评论
     */
    private List<AmtfVideoCommentReplyEntity> replylist;

    /**
     * 评论是否点赞
     */
    private Integer select15;

    /**
     * 搜索标题略同
     */
    private List<AmtfVideoEntity> search_headlist;
}
