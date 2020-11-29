package com.amtf.demo.dao;

import java.util.List;

import com.amtf.demo.commonentity.AmtfQaClassEntity;
import com.amtf.demo.commonentity.AmtfQaEntity;
import com.amtf.demo.f060001entity.F060001_Select3Entity;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

@Mapper
public interface F060001Dao {

    Integer f060001_Insert1(@Param("entity") AmtfQaEntity entity);

    List<AmtfQaClassEntity> f060001_Select2();

    List<F060001_Select3Entity> f060001_Select3();
}
