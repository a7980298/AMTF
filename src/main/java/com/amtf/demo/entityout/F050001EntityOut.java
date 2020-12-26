package com.amtf.demo.entityout;

import com.amtf.demo.commonentity.AmtfNewsEntity;
import com.amtf.demo.f050001entity.F050001_Select1Entity;
import com.amtf.demo.f050001entity.F050001_Select2Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class F050001EntityOut {

    /**
     * 查找所有新闻信息
     */
    private List<F050001_Select1Entity> news_list;

    /**
     * 添加新闻信息
     */
    private List<F050001_Select2Entity> news_list2;

    /**
     * 新闻标题
     */
    private String news_name;

    /**
     * 新闻内容
     */
    private String news_text;

    /**
     * 新闻发布时间
     */
    private Date news_date;
}
