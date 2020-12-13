package com.amtf.demo.entityout;

import com.amtf.demo.commonentity.AmtfVideoClassEntity;
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
}
