package com.amtf.demo.dao;

import com.amtf.demo.commonentity.AmtfClassImgEntity;
import com.amtf.demo.commonentity.AmtfPowerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface F020007Dao {

    List<AmtfClassImgEntity> f020007_Select1();

}
