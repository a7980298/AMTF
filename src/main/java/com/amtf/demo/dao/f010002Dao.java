package com.amtf.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.amtf.demo.f010002entity.f010002_select1entity;

@Mapper
public interface f010002Dao {

	int f010002_Select1Count();

	List<f010002_select1entity> f010002_Select1(@Param("start") String start, @Param("end") String end);
}
