package com.amtf.demo.params;

import com.amtf.demo.commonentity.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@ConfigurationProperties
@Getter
@Setter

public class F040001Params {
    /**
     * 页面id
     */
    private String IViewId;

    /**
     * 上传视频
     */
    public MultipartFile commit_video;

    /**
     * 视频分类
     */
    private List<AmtfVideoClassEntity> select1;

    /**
     * 上传的标题
     */
    private String video_head;

    /**
     * 上传的简介
     */
    private String video_body;

    /**
     * 上传的默认封面图片
     */
    private String video_img;

    /**
     * 上传的更改封面图片
     */
    private MultipartFile video_upimg;

    /**
     * 上传视频时长
     */
    private String video_duration;

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
     *  视频id
     */
    private String video_id;

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
     * 发言的内容
     */
    private String video_barrage_text;

    /**
     * 颜色
     */
    private String video_barrage_color;

    /**
     * 字体大小
     */
    private String video_barrage_size;

    /**
     * 弹幕位置
     */
    private String video_barrage_position;

    /**
     * 弹幕时间
     */
    private String video_barrage_time;

    /**
     * 评论信息
     */
    private List<AmtfVideoCommentEntity> commentList;

    /**
     * 发布评论
     */
    private String video_comment_text;

    /**
     * 评论id
     */
    private String video_comment_id;

    /**
     * 回复评论内容
     */
    private String video_comment_reply_text;

    /**
     * 回复评论
     */
    private List<AmtfVideoCommentReplyEntity> replylist;

    /**
     * 观看历史
     */
    private List<AmtfVideoHistoryEntity> videohistory;
}
