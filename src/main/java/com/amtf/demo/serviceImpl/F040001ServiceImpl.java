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
	/**
	 * 初始化
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service01(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();

		// 获取视频标签分类
		List<AmtfVideoClassEntity> select1 = f040001dao.f040001_Select1();
		entityOut.setSelect1(select1);

		// 获取专辑视频的前8个
		List<AmtfVideoEntity> albumList = f040001dao.f040001_Select3(GETCLASS_1);
		entityOut.setAlbumList(albumList);

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
		// id
		videoentity.setVideo_id(CommonUtil.isEmpty(commondao.common_Select12()) ? 0 : (commondao.common_Select12() + 1));
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
				try {
					select6list = videoLike(select6entity,select6list,true);
				}catch (Exception e){

				}
				entityOut.setVideoSimilar(select6list);
				// 获取评论信息
				// 添加观看历史
				AmtfVideoHistoryEntity amtfvideohistoryentity = new AmtfVideoHistoryEntity();
				// id
				amtfvideohistoryentity.setVideo_history_id(CommonUtil.isEmpty(commondao.common_Select13()) ? 0 : (commondao.common_Select13() + 1));
				// 视频id
				amtfvideohistoryentity.setVideo_id(video.getVideo_id());
				// 用户id
				amtfvideohistoryentity.setUser_id(loginfo.getUser_email());
				f040001dao.f040001_Insert7(amtfvideohistoryentity);
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
		// 弹幕id
		amtfvideobarrageentity.setVideo_barrage_id(CommonUtil.isEmpty(commondao.common_Select14()) ? 0 : commondao.common_Select14() + 1);
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
			amtfvideobarrageviewentity.setColor(entity.getVideo_barrage_color());
			amtfvideobarrageviewentity.setText(entity.getVideo_barrage_text());
			amtfvideobarrageviewentity.setPosition(entity.getVideo_barrage_position());
			amtfvideobarrageviewentity.setTime(entity.getVideo_barrage_time());
			amtfvideobarrageviewentity.setSize(entity.getVideo_barrage_size());
			amtfvideobarrageviewlist.add(amtfvideobarrageviewentity);

		});

		entityOut.setBarrageList(amtfvideobarrageviewlist);

		return entityOut;
	}
}
