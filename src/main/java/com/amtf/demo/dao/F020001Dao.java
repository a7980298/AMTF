package com.amtf.demo.dao;

import java.util.List;

import com.amtf.demo.commonentity.AmtfUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.amtf.demo.f010001entity.F010001_Select1Entity;
import com.amtf.demo.f020001entity.F020001_Select2EntityIn;
import com.amtf.demo.f020001entity.F020001_Select5Entity;
import com.amtf.demo.f020001entity.F020001_Select7Entity;

@Mapper
public interface F020001Dao {

	List<F010001_Select1Entity> f020001_Select1(@Param("pow") Integer pow);

	List<F010001_Select1Entity> f020001_Select2(@Param("select2") F020001_Select2EntityIn select2);

	void f020001_insert3(@Param("id") Integer id, @Param("name") String name, @Param("head") String head,
			@Param("text") String text);

	int f020001_Delect4(@Param("userid") String userid);

	List<F020001_Select5Entity> f020001_Select5(@Param("id") String id);

	int f020001_insert6(@Param("id") Integer id, @Param("name") String name, @Param("head") String head,
			@Param("check") String check, @Param("sttymd") Integer sttymd, @Param("endymd") Integer endymd,
			@Param("text") String text);

	List<F020001_Select7Entity> f020001_Select7(@Param("pow") Integer pow);

	AmtfUserEntity f020001_Select8(@Param("userId") String userId);
}
