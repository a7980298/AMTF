package com.amtf.demo.dao;

import com.amtf.demo.commonentity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface F020006Dao {

    List<AmtfPowerEntity> f020006_Select1(@Param("power_show") String power_show);
}
