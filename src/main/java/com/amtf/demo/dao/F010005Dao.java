package com.amtf.demo.dao;

import com.amtf.demo.commonentity.AmtfActivityEntity;
import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.f010001entity.F010001_Select1Entity;
import com.amtf.demo.f010002entity.F010002_Select1Entity;
import com.amtf.demo.f010002entity.F010002_Select4Entity;
import com.amtf.demo.f010002entity.F010002_Select9Entity;
import com.amtf.demo.f010005entity.F010005_Select1Entity;
import com.amtf.demo.user.LogInFo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface F010005Dao {


	List<F010005_Select1Entity> f010005_Select1(@Param("name") String name);

	List<F010005_Select1Entity> f010005_Select2(@Param("name") String name);

	AmtfActivityEntity f010005_Select3(@Param("id") Integer id);

	AmtfUserEntity f010005_Select4(@Param("email") String email);

}
