package com.amtf.demo.params;

import com.amtf.demo.commonentity.AmtfVideoClassEntity;
import com.amtf.demo.commonentity.AmtfVideoEntity;
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
     * 专辑一栏
     */
    private List<AmtfVideoEntity> albumList;

    /**
     *  视频id
     */
    private String video_id;
}
