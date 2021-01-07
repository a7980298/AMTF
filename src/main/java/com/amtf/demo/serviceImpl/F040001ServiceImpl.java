package com.amtf.demo.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import com.amtf.demo.commonentity.*;
import com.amtf.demo.dao.CommonDao;
import com.amtf.demo.dao.F040001Dao;
import com.amtf.demo.dao.F050001Dao;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.entityin.F040001EntityIn;
import com.amtf.demo.entityout.F040001EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F040001Service;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@Service
@RequiredArgsConstructor
public class F040001ServiceImpl implements F040001Service {

	@Autowired
	HttpServletRequest request;

	@Autowired
	private final F040001Dao f040001dao;

	@Autowired
	private final CommonDao commondao;

	private final String GETCLASS_1 = "专辑";

	private final String GETCLASS_2 = "电视剧";

	private final String GETCLASS_3 = "电影";

	private final String GETCLASS_4 = "小视频";

	private final String GETCLASS_5 = "纪录片";

	private final String GETCLASS_6 = "少儿";
	/**
	 * 初始化
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service01(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		// 获取视频标签分类
		List<AmtfVideoClassEntity> select1 = f040001dao.f040001_Select1();
		entityOut.setSelect1(select1);

		// 获取点赞数最多的视频
		List<AmtfVideoEntity> sumpraise = f040001dao.f040001_Select20();
		entityOut.setSumpraise(sumpraise);

		// 获取专辑视频的前8个
		List<AmtfVideoEntity> albumList = f040001dao.f040001_Select3(GETCLASS_1);
		entityOut.setAlbumList(albumList);

		// 获取电视剧视频的前8个
		List<AmtfVideoEntity> albumList2 = f040001dao.f040001_Select3(GETCLASS_2);
		entityOut.setAlbumList2(albumList2);

		// 获取电影视频的前8个
		List<AmtfVideoEntity> albumList3 = f040001dao.f040001_Select3(GETCLASS_3);
		entityOut.setAlbumList3(albumList3);

		// 获取小视频视频的前8个
		List<AmtfVideoEntity> albumList4 = f040001dao.f040001_Select3(GETCLASS_4);
		entityOut.setAlbumList4(albumList4);

		// 获取纪录片视频的前8个
		List<AmtfVideoEntity> albumList5 = f040001dao.f040001_Select3(GETCLASS_5);
		entityOut.setAlbumList5(albumList5);

		// 获取少儿视频的前8个
		List<AmtfVideoEntity> albumList6 = f040001dao.f040001_Select3(GETCLASS_6);
		entityOut.setAlbumList6(albumList6);

		// 获取推荐视频
		List<AmtfVideoEntity> recommendvideo = f040001dao.f040001_Select21();
		entityOut.setRecommendvideo(recommendvideo);

		// 获取观看历史
		List<AmtfVideoHistoryEntity> videohistory = f040001dao.f040001_Select24(loginfo.getUser_email());
		for (AmtfVideoHistoryEntity historyentity : videohistory) {
			List<AmtfVideoEntity> videos = f040001dao.f040001_Select4(StringUtil.toStr(historyentity.getVideo_id()));
			// 视频封面
			historyentity.setVideo_img(videos.get(0).getVideo_img());
			// 视频标题
			historyentity.setVideo_head(videos.get(0).getVideo_head());
		}

		entityOut.setVideohistory(videohistory);

		return entityOut;
	}

	/**
	 * 上传视频
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service02(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		AmtfVideoEntity videoentity = new AmtfVideoEntity();
		// 用户id
		videoentity.setUser_id(loginfo.getUser_email());
		// 简介
		videoentity.setVideo_text(entityin.getVideo_body());
		// 时长
		videoentity.setVideo_duration(entityin.getVideo_duration());
		// 封面图片
		String imgpath=Constant.EMPTY;
		if(!CommonUtil.isEmpty(entityin.getVideo_upimg())){
			imgpath = VideoUtil.commitImg(entityin.getVideo_upimg(),Constant.PATH_VIDEOIMG_COMMIT);
		} else {
			imgpath = VideoUtil.GenerateImage(entityin.getVideo_img(),Constant.PATH_VIDEOIMG_COMMIT);
		}
		videoentity.setVideo_img(imgpath);
		// 路径
		videoentity.setVideo_path(VideoUtil.commitView(entityin.getCommit_video(), Constant.PATH_VIDEO_COMMIT));
		// 获取标签
		String video_class = entityin.getVideo_head().substring(entityin.getVideo_head().indexOf("#"),entityin.getVideo_head().length());
		String  class_list = Constant.EMPTY,
				class_head = Constant.EMPTY;
		// idxcount -> #号出现的次数
		// idx -> #号出现的上一次下标
		int idxcount = 0,idx = 0;
		for (int i = 0; i< video_class.length(); i++){
			// 是否是#
			if("#".equals(video_class.substring(i,i+1))) {
				idxcount += 1;
				// 是否是第二个#
				if(idxcount % 2 == 0){
					class_list += video_class.substring(idx + 1, i) + ",";
					idx = i;
				}
			}
		}
		String head = entityin.getVideo_head();
		if(class_list.length() > 0) {
			String[] clas = class_list.split(",");
			for (String cla : clas){
				cla = cla.replaceAll(cla,Constant.EMPTY);
				String cl = "#" + cla + "#";
				head = head.replaceAll(cl,Constant.EMPTY);
				head = head.replaceAll(cla,Constant.EMPTY);
				head = head.replaceAll("#",Constant.EMPTY);
			}
		}
		// 标题
		videoentity.setVideo_head(head);
		// 标签
		videoentity.setVideo_class(class_list);

		int insert2 = f040001dao.f040001_Insert2(videoentity);

		entityOut.setInsert2(insert2);

		return entityOut;
	}

	/**
	 * 观看视频
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service03(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 视频id不是空
		if(!CommonUtil.isEmpty(entityin.getVideo_id())){
			// 获取视频详情
			List<AmtfVideoEntity> select4 = f040001dao.f040001_Select4(entityin.getVideo_id());
			// 取第一条
			if(!CommonUtil.isEmptyList(select4)){
				AmtfVideoEntity video = select4.get(0);
				// 视频详细信息
				entityOut.setVideoView(video);
				// 获取作者信息
				AmtfUserEntity select5 = f040001dao.f040001_Select5(video.getUser_id());
				// 获取作者头像
				select5.setImgpath(ImgUtil.getImgPath(select5.getUser_email()));
				entityOut.setVideoAuthor(select5);
				// 获取名字相同的视频
				List<AmtfVideoEntity> select6list = new ArrayList<AmtfVideoEntity>();
				AmtfVideoEntity select6entity = new AmtfVideoEntity();
				select6entity.setVideo_head(video.getVideo_head());
				select6entity.setVideo_id(video.getVideo_id());
				select6entity.setVideo_class(video.getVideo_class());
				select6list = videoLike(select6entity,select6list,true);
				entityOut.setVideoSimilar(select6list);
				// 获取评论信息
				entityOut.setCommentList(this.service07(entityin).getCommentList());
				if(CommonUtil.isEmpty(f040001dao.f040001_Select22(video.getVideo_id(),loginfo.getUser_email()))){
					// 添加观看历史
					AmtfVideoHistoryEntity amtfvideohistoryentity = new AmtfVideoHistoryEntity();
					// 视频id
					amtfvideohistoryentity.setVideo_id(video.getVideo_id());
					// 用户id
					amtfvideohistoryentity.setUser_id(loginfo.getUser_email());
					f040001dao.f040001_Insert7(amtfvideohistoryentity);
				} else {
					f040001dao.f040001_Update23(video.getVideo_id(),loginfo.getUser_email());
				}
				// 获取观看历史
				List<AmtfVideoHistoryEntity> videohistory = f040001dao.f040001_Select24(loginfo.getUser_email());
				for (AmtfVideoHistoryEntity historyentity : videohistory) {
					List<AmtfVideoEntity> videos = f040001dao.f040001_Select4(StringUtil.toStr(historyentity.getVideo_id()));
					// 视频封面
					historyentity.setVideo_img(videos.get(0).getVideo_img());
					// 视频标题
					historyentity.setVideo_head(videos.get(0).getVideo_head());
				}

				entityOut.setVideohistory(videohistory);
			}
		}
		return entityOut;
	}

	/**
	 * 获取名字略同的视频
	 * @param video
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public List<AmtfVideoEntity> videoLike(AmtfVideoEntity video,List<AmtfVideoEntity> list,boolean isbreak){
		while (isbreak){
			// 获取包含标题的视频
			List<AmtfVideoEntity> select6 = f040001dao.f040001_Select6(video.getVideo_head(),video.getVideo_id());
			if(!CommonUtil.isEmptyList(select6)){
				list.addAll(select6);
			}
			// 如果没有
			if(CommonUtil.isEmptyList(list) || list.size() < 8){
				// 如果标题不是最后一位
				if(video.getVideo_head().length() != Constant.INT_1){
					// 标题缩减继续查找
					video.setVideo_head(video.getVideo_head().substring(0,video.getVideo_head().length() - 1));
				} else {
					// 如果标题是最后一位，获取标签相同
					select6= f040001dao.f040001_Select3(video.getVideo_class().split(",")[0]);
					if(!CommonUtil.isEmptyList(select6)){
						list.addAll(select6);
					}
					// 如果还是为空就查询最新的视频
					if(CommonUtil.isEmptyList(list)){
						list = f040001dao.f040001_Select8();
					}
				}
			} else if(list.size() >= 8){
				// 根据id去重
				list = list.stream().collect(collectingAndThen(
						toCollection(() -> new TreeSet<>(comparingLong(AmtfVideoEntity::getVideo_id))), ArrayList::new)
				);
				if(list.size() < 8){
					video.setVideo_head(video.getVideo_head().substring(0,video.getVideo_head().length() - 1));
					videoLike(video,list,isbreak);
				} else if(list.size() > 8){
					for (int i = list.size(); i < 8; i--) {
						list.remove(list.size() - 1);
					}
				} else {
					isbreak = false;
				}
			}
		}
		return list;
	}

	/**
	 * 添加弹幕
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service04(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		AmtfVideoBarrageEntity amtfvideobarrageentity = new AmtfVideoBarrageEntity();
		// 视频id
		amtfvideobarrageentity.setVideo_id(NumberUtil.toInt(entityin.getVideo_id()));
		// 发言人
		amtfvideobarrageentity.setUser_id(loginfo.getUser_email());
		// 发言的内容
		amtfvideobarrageentity.setVideo_barrage_text(entityin.getVideo_barrage_text());
		// 颜色
		amtfvideobarrageentity.setVideo_barrage_color(entityin.getVideo_barrage_color());
		// 字体大小
		amtfvideobarrageentity.setVideo_barrage_size(entityin.getVideo_barrage_size());
		// 弹幕位置
		amtfvideobarrageentity.setVideo_barrage_position(entityin.getVideo_barrage_position());
		// 弹幕时间
		amtfvideobarrageentity.setVideo_barrage_time(entityin.getVideo_barrage_time());
		// 添加弹幕信息
		Integer insert9 = f040001dao.f040001_Insert9(amtfvideobarrageentity);

		entityOut.setInsert9(insert9);
		return entityOut;
	}

	/**
	 * 获取弹幕
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service05(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();

		List<AmtfVideoBarrageEntity> barrageList = f040001dao.f040001_Select10(NumberUtil.toInt(entityin.getVideo_id()));
		List<AmtfVideoBarrageViewEntity> amtfvideobarrageviewlist = new ArrayList<AmtfVideoBarrageViewEntity>();
		barrageList.forEach(entity ->{
			AmtfVideoBarrageViewEntity amtfvideobarrageviewentity = new AmtfVideoBarrageViewEntity();
			// 颜色
			amtfvideobarrageviewentity.setColor(entity.getVideo_barrage_color());
			// 内容
			amtfvideobarrageviewentity.setText(entity.getVideo_barrage_text());
			// 位置
			amtfvideobarrageviewentity.setPosition(entity.getVideo_barrage_position());
			// 时间
			amtfvideobarrageviewentity.setTime(entity.getVideo_barrage_time());
			// 大小
			amtfvideobarrageviewentity.setSize(entity.getVideo_barrage_size());
			amtfvideobarrageviewlist.add(amtfvideobarrageviewentity);

		});
		entityOut.setBarrageList(amtfvideobarrageviewlist);

		return entityOut;
	}

	/**
	 * 发表评论
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service06(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		AmtfVideoCommentEntity amtfvideocommententity = new AmtfVideoCommentEntity();
		// 用户id
		amtfvideocommententity.setUser_id(loginfo.getUser_email());
		// 视频id
		amtfvideocommententity.setVideo_id(entityin.getVideo_id());
		// 发布内容
		amtfvideocommententity.setVideo_comment_text(entityin.getVideo_comment_text());
		Integer insert11 = f040001dao.f040001_Insert11(amtfvideocommententity);
		entityOut.setInsert11(insert11);
		return entityOut;
	}

	/**
	 * 刷新评论
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service07(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		List<AmtfVideoCommentEntity> commentList = f040001dao.f040001_Select12(NumberUtil.toInt(entityin.getVideo_id()));
		for (AmtfVideoCommentEntity entity:commentList) {
			// 名字
			entity.setUser_name(f040001dao.f040001_Select5(entity.getUser_id()).getUser_name());
			// 头像
			entity.setUser_img(ImgUtil.getImgPath(entity.getUser_id()));
			// 发布时间
			entity.setNowtime(DateUtil.dateToStr(entity.getVideo_comment_time(),DateUtil.DATE_TOSTR_YMD));
			// 点赞人数
			Integer sumpraise = f040001dao.f040001_Select18(NumberUtil.toInt(entityin.getVideo_id()),NumberUtil.toInt(entity.getVideo_comment_id()));
			entity.setSumpraise(StringUtil.toStr(sumpraise == 0 ? "" : sumpraise));
			// 判断当前用户是否点赞
			AmtfVideoPraiseEntity amtfvideopraiseentity = f040001dao.f040001_Select15(
															NumberUtil.toInt(entityin.getVideo_id()),
															NumberUtil.toInt(entity.getVideo_comment_id()), loginfo.getUser_email());
			if(!CommonUtil.isEmpty(amtfvideopraiseentity)){
				entity.setIspraise(Constant.STR_1);
			}
		}
		entityOut.setCommentList(commentList);
		return entityOut;
	}

	/**
	 * 添加回复评论
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service08(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		AmtfVideoCommentReplyEntity amtfvideocommentreplyentity = new AmtfVideoCommentReplyEntity();
		// 视频id
		amtfvideocommentreplyentity.setVideo_id(entityin.getVideo_id());
		// 评论id
		amtfvideocommentreplyentity.setVideo_comment_id(NumberUtil.toInt(entityin.getVideo_comment_id()));
		// 用户id
		amtfvideocommentreplyentity.setUser_id(loginfo.getUser_email());
		// 内容
		amtfvideocommentreplyentity.setVideo_comment_reply_text(entityin.getVideo_comment_reply_text());

		Integer insert13 = f040001dao.f040001_Insert13(amtfvideocommentreplyentity);

		entityOut.setInsert13(insert13);

		return entityOut;
	}

	/**
	 * 展开回复
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service09(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();
		// 获取回复评论
		List<AmtfVideoCommentReplyEntity> replylist = f040001dao.f040001_Select14(NumberUtil.toInt(entityin.getVideo_id()),NumberUtil.toInt(entityin.getVideo_comment_id()));
		replylist.forEach(entity ->{
			// 名字
			entity.setUser_name(f040001dao.f040001_Select5(entity.getUser_id()).getUser_name());
			// 头像
			entity.setUser_img(ImgUtil.getImgPath(entity.getUser_id()));
			// 发布时间
			entity.setNowtime(DateUtil.dateToStr(entity.getVideo_comment_reply_time(),DateUtil.DATE_TOSTR_YMD));
		});
		entityOut.setReplylist(replylist);
		return entityOut;
	}

	/**
	 * 评论点赞
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service10(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		AmtfVideoPraiseEntity select15 = f040001dao.f040001_Select15(NumberUtil.toInt(entityin.getVideo_id()),NumberUtil.toInt(entityin.getVideo_comment_id()),loginfo.getUser_email());

		if(!CommonUtil.isEmpty(select15)){
			Integer delete16 = f040001dao.f040001_Delete16(NumberUtil.toInt(entityin.getVideo_id()),NumberUtil.toInt(entityin.getVideo_comment_id()),loginfo.getUser_email());
			if(delete16 > 0){
				entityOut.setSelect15(Constant.INT_1);
			}
		} else {
			AmtfVideoPraiseEntity amtfvideopraiseentity = new AmtfVideoPraiseEntity();
			// 视频id
			amtfvideopraiseentity.setVideo_id(NumberUtil.toInt(entityin.getVideo_id()));
			// 评论id
			amtfvideopraiseentity.setVideo_comment_id(NumberUtil.toInt(entityin.getVideo_comment_id()));
			// 用户id
			amtfvideopraiseentity.setUser_id(loginfo.getUser_email());
			Integer insert17 = f040001dao.f040001_Insert17(amtfvideopraiseentity);
			if(insert17 > 0){
				entityOut.setSelect15(Constant.INT_2);
			}
		}

		return entityOut;
	}

	/**
	 * 搜索提示
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service11(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();
		if(!CommonUtil.isEmpty(entityin.getVideo_head())){
			List<AmtfVideoEntity> select19 = f040001dao.f040001_Select19(entityin.getVideo_head());
			entityOut.setSearch_headlist(select19);
		}
		return entityOut;
	}
}
