package com.amtf.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.amtf.demo.f010001entity.F010001_Insert4EntityIn;
import com.amtf.demo.f010001entity.F010001_Select1Entity;
import com.amtf.demo.f010001entity.F010001_Select2Entity;
import com.amtf.demo.f010001entity.F010001_Select3Entity;

@Mapper
public interface F010001Dao {

	F010001_Select1Entity f010001_Select1(@Param("user_account") String user_account, @Param("userpwd") String userpwd);

	List<F010001_Select2Entity> f010001_Select2(@Param("pow") Integer pow);

	List<F010001_Select3Entity> f010001_Select3();

	int f010001_Insert4(@Param("entityin") F010001_Insert4EntityIn entityin);

	int f010001_Select5(@Param("email") String email);

	List<F010001_Select2Entity> f010001_Select6(@Param("pow") Integer pow);

}
