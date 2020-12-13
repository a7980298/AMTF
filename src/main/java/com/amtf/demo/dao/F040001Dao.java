package com.amtf.demo.dao;

import com.amtf.demo.commonentity.AmtfVideoClassEntity;
import com.amtf.demo.f010001entity.F010001_Select1Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface F040001Dao {
    List<AmtfVideoClassEntity> f040001_Select1();
}
