package com.amtf.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.amtf.demo.f060001entity.F060001_Select1Entity;

@Mapper
public interface F060001Dao {
	List<F060001_Select1Entity> f060001_Select1();
}
