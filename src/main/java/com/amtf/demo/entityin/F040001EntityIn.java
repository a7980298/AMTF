package com.amtf.demo.entityin;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class F040001EntityIn extends UserImpl{
    /**
     * 页面id
     */
    private String IViewId;

    /**
     * 上传视频
     */
    public MultipartFile commit_video;

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
     * 上传视频时长
     */
    private String video_duration;

    /**
     * 上传的更改封面图片
     */
    private MultipartFile video_upimg;

    /**
     *  视频id
     */
    private String video_id;

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
}
