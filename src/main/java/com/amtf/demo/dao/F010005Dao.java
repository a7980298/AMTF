package com.amtf.demo.dao;

import com.amtf.demo.commonentity.*;
import com.amtf.demo.f010001entity.F010001_Select1Entity;
import com.amtf.demo.f010002entity.F010002_Select1Entity;
import com.amtf.demo.f010002entity.F010002_Select4Entity;
import com.amtf.demo.f010002entity.F010002_Select9Entity;
import com.amtf.demo.f010005entity.F010005_Select1Entity;
import com.amtf.demo.user.LogInFo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface F010005Dao {


	List<F010005_Select1Entity> f010005_Select1(@Param("name") String name);

	List<F010005_Select1Entity> f010005_Select2(@Param("name") String name);

	AmtfActivityEntity f010005_Select3(@Param("id") Integer id);

	AmtfUserEntity f010005_Select4(@Param("email") String email);

	List<AmtfActivityCommentEntity> f010005_Select5(@Param("id") Integer id);

	Integer f010005_Insert6(@Param("entity") AmtfActivityCommentEntity entity);

	List<AmtfActivityCommentReplyEntity> f010005_Select7(@Param("id") Integer id);

	Integer f010005_Insert8(@Param("entity") AmtfActivityCommentReplyEntity entity);

	Integer f010005_Select9(@Param("id") Integer id);

	Integer f010005_Insert10(@Param("entity") AmtfActivityFabulousEntity entity);

	Integer f010005_Select11(@Param("id") Integer id,@Param("userid") String userid);

	Integer f010005_Delete12(@Param("id") Integer id,@Param("userid") String userid);

	Integer f010005_Delete13(@Param("id") Integer id,@Param("level") String level,@Param("comment_id") Integer comment_id);

	Integer f010005_Delete14(@Param("id") Integer id,@Param("userid") String userid);

	Integer f010005_Select15(@Param("id") Integer id);

	Integer f010005_Select16(@Param("id") Integer id,@Param("activity_comment_id") Integer activity_comment_id);

	Integer f010005_Select17(@Param("id") Integer id,@Param("activity_comment_id") Integer activity_comment_id,@Param("user_id") String user_id);

	Integer f010005_Insert18(@Param("entity") AmtfActivityCommentFabulousEntity entity);

	Integer f010005_Delete19(@Param("entity") AmtfActivityCommentFabulousEntity entity);

	Integer f010005_Select20(@Param("attention_id") String attention_id,@Param("userid") String userid);

	Integer f010005_Insert21(@Param("entity") AmtfUserAttentionEntity entity);

	Integer f010005_Delete22(@Param("entity") AmtfUserAttentionEntity entity);
}
