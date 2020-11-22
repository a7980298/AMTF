package com.amtf.demo.entityout;

import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.f010011entity.F010011_Select5Entity;
import com.amtf.demo.user.UserImpl;
import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class F010011EntityOut extends UserImpl {
    /**
     * 用户信息
     */
    AmtfUserEntity select1;

    /**
     * 关注发布人
     */
    String isattention;

    /**
     * 是否关注发布人
     */
    Integer attention;

    /**
     * 发布人的活动
     */
    PageInfo<F010011_Select5Entity> select5;

    /**
     * 热门活动
     */
    List<F010011_Select5Entity> select6;
}
