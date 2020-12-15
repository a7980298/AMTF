package com.amtf.demo.dao;

import com.amtf.demo.commonentity.AmtfVideoClassEntity;
import com.amtf.demo.commonentity.AmtfVideoEntity;
import com.amtf.demo.f010001entity.F010001_Select1Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface F040001Dao {

    List<AmtfVideoClassEntity> f040001_Select1();

    Integer f040001_Insert2(@Param("entity")AmtfVideoEntity entity);

    List<AmtfVideoEntity> f040001_Select3(@Param("getclass")String getclass);
}
