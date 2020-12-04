package com.amtf.demo.dao;

import java.util.List;

import com.amtf.demo.commonentity.AmtfQaClassEntity;
import com.amtf.demo.commonentity.AmtfQaEntity;
import com.amtf.demo.commonentity.AmtfQaReplyEntity;
import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.f060001entity.F060001_Select12Entity;
import com.amtf.demo.f060001entity.F060001_Select13Entity;
import com.amtf.demo.f060001entity.F060001_Select3Entity;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

@Mapper
public interface F060001Dao {

    Integer f060001_Insert1(@Param("entity") AmtfQaEntity entity);

    List<AmtfQaClassEntity> f060001_Select2();

    List<F060001_Select3Entity> f060001_Select3();

    Integer f060001_Insert4(@Param("entity") AmtfQaReplyEntity entity);

    AmtfQaEntity f060001_Select5(@Param("id") Integer id);

    List<AmtfQaReplyEntity> f060001_Select6(@Param("id") Integer id);

    AmtfUserEntity f060001_Select7(@Param("id") String id);

    List<AmtfQaClassEntity> f060001_Select8(@Param("class1") String class1,@Param("class2") String class2,@Param("class3") String class3);

    Integer f060001_Select9(@Param("id") String id);

    Integer f060001_Select10(@Param("id") String id);

    List<AmtfQaClassEntity> f060001_Select11();

    List<F060001_Select12Entity> f060001_Select12();

    List<F060001_Select13Entity> f060001_Select13();
}
