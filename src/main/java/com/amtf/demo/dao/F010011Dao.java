package com.amtf.demo.dao;

import com.amtf.demo.commonentity.*;
import com.amtf.demo.f010005entity.F010005_Select1Entity;
import com.amtf.demo.f010011entity.F010011_Select5Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface F010011Dao {

	AmtfUserEntity f010011_Select1(@Param("email") String email);

	Integer f010011_Select2(@Param("attention_id") String attention_id,@Param("userid") String userid);

	Integer f010011_Insert3(@Param("entity") AmtfUserAttentionEntity entity);

	Integer f010011_Delete4(@Param("entity") AmtfUserAttentionEntity entity);

	List<F010011_Select5Entity> f010011_Select5(@Param("name") String name);
}
