package com.amtf.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.amtf.demo.f010001entity.f010001_select1entity;

@Mapper
public interface experimentDao {

	f010001_select1entity f010001_Select1(@Param("user_account") String user_account, @Param("userpwd") String userpwd);
}
