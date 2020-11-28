package com.amtf.demo.entityout;

import java.util.List;

import com.amtf.demo.commonentity.AmtfQaClassEntity;
import com.amtf.demo.f060001entity.F060001_Select1Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class F060001EntityOut {
    /**
     * 发布是否成功
     */
    private Integer insert1;

    /**
     * 标签类型
     */
    private List<AmtfQaClassEntity> qa_class_lists;
}
