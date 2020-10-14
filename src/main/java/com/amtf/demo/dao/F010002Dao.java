package com.amtf.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.amtf.demo.f010001entity.F010001_Select1Entity;
import com.amtf.demo.f010002entity.F010002_Select1Entity;
import com.amtf.demo.f010002entity.F010002_Select4Entity;
import com.amtf.demo.f010002entity.F010002_Select9Entity;
import com.amtf.demo.user.LogInFo;

@Mapper
public interface F010002Dao {

	int f010002_Select1Count();

	List<F010002_Select1Entity> f010002_Select1(@Param("start") String start, @Param("end") String end);

	int f010002_update2(@Param("loginfo") LogInFo loginfo);

	F010001_Select1Entity f010002_Select3(@Param("loginfo") LogInFo loginfo);
	
	List<F010002_Select4Entity> f010002_Select5(@Param("id") String id);
	
	int f010002_Insert6(@Param("id") String id,@Param("upid") Integer upid);
	
	List<F010002_Select4Entity> f010002_Select7(@Param("id") Integer id);
	
	List<F010002_Select4Entity> f010002_Select8();
	
	List<F010002_Select9Entity> f010002_Select9(@Param("check") Integer check);
	
	int f010002_Insert10(@Param("id") Integer id,@Param("acid") Integer acid,@Param("name") String name);
	
	int f010002_Select11(@Param("id") Integer id,@Param("name") String name);
}
