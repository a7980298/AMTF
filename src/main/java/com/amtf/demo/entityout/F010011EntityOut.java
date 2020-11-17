package com.amtf.demo.entityout;

import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.user.UserImpl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F010011EntityOut extends UserImpl {
    /**
     * 用户信息
     */
    AmtfUserEntity select1;
}
