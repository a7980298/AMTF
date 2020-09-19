package com.amtf.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.amtf.demo.f010001entity.f010001_select1entity;
import com.amtf.demo.f010002entity.f010002_select1entity;
import com.amtf.demo.f010002entity.f010002_select4entity;
import com.amtf.demo.user.LogInFo;

@Mapper
public interface f010002Dao {

	int f010002_Select1Count();

	List<f010002_select1entity> f010002_Select1(@Param("start") String start, @Param("end") String end);

	int f010002_update2(@Param("loginfo") LogInFo loginfo);

	f010001_select1entity f010002_Select3(@Param("loginfo") LogInFo loginfo);
	
	List<f010002_select4entity> f010002_Select5(@Param("id") String id);
	
	int f010002_Insert6(@Param("id") String id,@Param("upid") Integer upid);
	
	List<f010002_select4entity> f010002_Select7(@Param("id") Integer id);
	
	List<f010002_select4entity> f010002_Select8();

}
