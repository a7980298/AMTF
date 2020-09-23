package com.amtf.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.amtf.demo.f010001entity.f010001_insert4entityIn;
import com.amtf.demo.f010001entity.f010001_select1entity;
import com.amtf.demo.f010001entity.f010001_select2entity;
import com.amtf.demo.f010001entity.f010001_select3entity;

@Mapper
public interface f010001Dao {

	f010001_select1entity f010001_Select1(@Param("user_account") String user_account, @Param("userpwd") String userpwd);

	List<f010001_select2entity> f010001_Select2(@Param("pow") String pow);

	List<f010001_select3entity> f010001_Select3();

	int f010001_Insert4(@Param("entityin") f010001_insert4entityIn entityin);
	
	int f010001_Select5(@Param("email") String email);

}
