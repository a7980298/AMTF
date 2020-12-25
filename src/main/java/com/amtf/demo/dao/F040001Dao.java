package com.amtf.demo.dao;

import com.amtf.demo.commonentity.*;
import com.amtf.demo.f010001entity.F010001_Select1Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface F040001Dao {

    List<AmtfVideoClassEntity> f040001_Select1();

    Integer f040001_Insert2(@Param("entity")AmtfVideoEntity entity);

    List<AmtfVideoEntity> f040001_Select3(@Param("getclass")String getclass);

    List<AmtfVideoEntity> f040001_Select4(@Param("video_id")String video_id);

    AmtfUserEntity f040001_Select5(@Param("user_id")String user_id);

    List<AmtfVideoEntity> f040001_Select6(@Param("video_head")String video_head,@Param("video_id")Integer video_id);

    Integer f040001_Insert7(@Param("entity") AmtfVideoHistoryEntity entity);

    List<AmtfVideoEntity> f040001_Select8();

    Integer f040001_Insert9(@Param("entity") AmtfVideoBarrageEntity entity);

    List<AmtfVideoBarrageEntity> f040001_Select10(@Param("video_id")Integer video_id);

    Integer f040001_Insert11(@Param("entity") AmtfVideoCommentEntity entity);

    List<AmtfVideoCommentEntity> f040001_Select12(@Param("video_id")Integer video_id);

    Integer f040001_Insert13(@Param("entity") AmtfVideoCommentReplyEntity entity);

    List<AmtfVideoCommentReplyEntity> f040001_Select14(@Param("video_id")Integer video_id,@Param("video_comment_id")Integer video_comment_id);

    AmtfVideoPraiseEntity f040001_Select15(@Param("video_id")Integer video_id,@Param("video_comment_id")Integer video_comment_id,@Param("user_id")String user_id);

    Integer f040001_Delete16(@Param("video_id")Integer video_id,@Param("video_comment_id")Integer video_comment_id,@Param("user_id")String user_id);

    Integer f040001_Insert17(@Param("entity") AmtfVideoPraiseEntity entity);

    Integer f040001_Select18(@Param("video_id")Integer video_id,@Param("video_comment_id")Integer video_comment_id);
}
