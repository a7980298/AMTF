package com.amtf.demo.f050001entity;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class F050001_Select1Entity {
    /**
     * 发布用户
     */
    private String news_user;

    /**
     *新闻标题
     */
    private String news_name;

    /**
     *新闻内容
     */
    private String news_text;

    /**
     * 新闻发布时间
     */
    private String news_date;

}
