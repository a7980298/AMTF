package com.amtf.demo.dao;

import com.amtf.demo.commonentity.*;
import com.amtf.demo.f010005entity.F010005_Select1Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface F010011Dao {

	AmtfUserEntity f010011_Select1(@Param("email") String email);
}
