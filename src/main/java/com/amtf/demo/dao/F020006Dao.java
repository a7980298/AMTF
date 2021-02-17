package com.amtf.demo.dao;

import com.amtf.demo.commonentity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface F020006Dao {

    List<AmtfPowerEntity> f020006_Select1(@Param("power_show") String power_show);

    Integer f020006_Update2(@Param("pow") Integer pow);

    Integer f020006_Update3(@Param("power_id") Integer power_id);

    Integer f020006_Update4(@Param("power_id") Integer power_id,@Param("power_name") String power_name,@Param("power_type") String power_type);
}
