package com.amtf.demo.entityin;

import com.amtf.demo.user.UserImpl;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONObject;

@Getter
@Setter
public class F050001EntityIn extends UserImpl{
    /**
     * 页面id
     */
    private String IViewId;

    /**
     *检索新闻标题
     */
    private String news_title_name;

    /**
     * 新闻发布
     */
    private JSONObject submitjson;


}
