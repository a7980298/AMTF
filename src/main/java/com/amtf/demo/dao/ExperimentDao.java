package com.amtf.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.amtf.demo.f010001entity.F010001_Select1Entity;

@Mapper
public interface ExperimentDao {

	F010001_Select1Entity f010001_Select1(@Param("user_account") String user_account, @Param("userpwd") String userpwd);
}
