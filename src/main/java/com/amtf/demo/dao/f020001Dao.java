package com.amtf.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.amtf.demo.f010001entity.f010001_select1entity;
import com.amtf.demo.f020001entity.f020001_select2entityIn;
import com.amtf.demo.f020001entity.f020001_select5entity;
import com.amtf.demo.f020001entity.f020001_select7entity;

@Mapper
public interface f020001Dao {

	List<f010001_select1entity> f020001_Select1(@Param("pow") Integer pow);

	List<f010001_select1entity> f020001_Select2(@Param("select2") f020001_select2entityIn select2);

	void f020001_insert3(@Param("id") Integer id, @Param("name") String name, @Param("head") String head,
			@Param("text") String text);

	int f020001_Delect4(@Param("userid") String userid);

	List<f020001_select5entity> f020001_Select5(@Param("id") String id);

	int f020001_insert6(@Param("id") Integer id, @Param("name") String name, @Param("head") String head,
			@Param("check") String check, @Param("sttymd") Integer sttymd, @Param("endymd") Integer endymd,
			@Param("text") String text);

	List<f020001_select7entity> f020001_Select7(@Param("pow") Integer pow);
}
