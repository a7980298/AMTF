package com.amtf.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.amtf.demo.f010001entity.f010001_select1entity;
import com.amtf.demo.f020001entity.f020001_select2entityIn;

@Mapper
public interface f020001Dao {

	List<f010001_select1entity> f020001_Select1(@Param("pow") String pow);

	List<f010001_select1entity> f020001_Select2(@Param("select2") f020001_select2entityIn select2);

	void f020001_insert3(@Param("id") String id, @Param("head") String head, @Param("text") String text);
	
	int f020001_Delect4(@Param("userid") String userid);
}
