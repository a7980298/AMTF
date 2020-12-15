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
}
