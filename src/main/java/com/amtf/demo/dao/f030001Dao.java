package com.amtf.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.amtf.demo.f010001entity.f010001_select1entity;

@Mapper
public interface f030001Dao {

	List<f010001_select1entity> f020001_Select1(@Param("pow") String pow);

	List<f010001_select1entity> f020001_Select2(@Param("pow") String pow, @Param("name") String name,
			@Param("selectval") String selectval);

	void f020001_insert3(@Param("id") String id, @Param("head") String head, @Param("text") String text);
}
