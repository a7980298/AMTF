package com.amtf.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.amtf.demo.f060001entity.f060001_select1entity;

@Mapper
public interface f060001Dao {
	List<f060001_select1entity> f060001_Select1();
}
