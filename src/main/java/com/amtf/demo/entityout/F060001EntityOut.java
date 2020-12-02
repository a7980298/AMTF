package com.amtf.demo.entityout;

import java.util.List;

import com.amtf.demo.commonentity.AmtfQaClassEntity;
import com.amtf.demo.commonentity.AmtfQaEntity;

import com.amtf.demo.f060001entity.F060001_Select3Entity;
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
     * 回答问题是否成功
     */
    private int insert4;

    /**
     * 标签类型
     */
    private List<AmtfQaClassEntity> qa_class_lists;

    /**
     * 最新问题
     */
    private List<F060001_Select3Entity> select3;
}
