package com.amtf.demo.params;

import com.amtf.demo.commonentity.AmtfVideoClassEntity;
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
}
