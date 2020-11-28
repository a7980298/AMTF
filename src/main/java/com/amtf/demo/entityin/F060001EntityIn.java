package com.amtf.demo.entityin;

import com.amtf.demo.user.UserImpl;

import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONObject;

@Getter
@Setter
public class F060001EntityIn extends UserImpl{

    /**
     * 发布问题
     */
    private JSONObject submitjson;
}
