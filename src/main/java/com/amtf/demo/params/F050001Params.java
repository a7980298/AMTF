package com.amtf.demo.params;

import com.amtf.demo.commonentity.AmtfNewsEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.List;

@ConfigurationProperties
@Getter
@Setter

public class F050001Params {
    /**
     * 页面id
     */
    private String IViewId;

    /**
     * 新闻记者
     */
    private String news_user;


    /**
     * 新闻标题
     */
    private String news_name;

    /**
     * 新闻内容
     */
    private String news_text;

    /**
     * 新闻时间
     */
    private Date news_time;

    /**
     * 新闻信息
     */
    private List<AmtfNewsEntity> news_list;


}
