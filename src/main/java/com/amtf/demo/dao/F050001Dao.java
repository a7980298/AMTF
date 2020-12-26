package com.amtf.demo.dao;

import com.amtf.demo.commonentity.AmtfNewsEntity;
import com.amtf.demo.f010001entity.F010001_Select1Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface F050001Dao {
	List<AmtfNewsEntity> f050001_Select1();

	List<AmtfNewsEntity> f050001_Select2(@Param("name")String name);

	List<AmtfNewsEntity> f050001_Insert1();

}
