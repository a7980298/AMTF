package com.amtf.demo.entityout;

import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.commonentity.AmtfVideoClassEntity;
import com.amtf.demo.commonentity.AmtfVideoEntity;
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
     * 专辑一栏
     */
    private List<AmtfVideoEntity> albumList;

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
}
