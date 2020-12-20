package com.amtf.demo.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import com.amtf.demo.commonentity.AmtfVideoClassEntity;
import com.amtf.demo.commonentity.AmtfVideoEntity;
import com.amtf.demo.dao.CommonDao;
import com.amtf.demo.dao.F040001Dao;
import com.amtf.demo.dao.F050001Dao;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.entityin.F040001EntityIn;
import com.amtf.demo.entityout.F040001EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F040001Service;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
		// 标题
		videoentity.setVideo_head(entityin.getVideo_head());
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
		String  class_list = "";
		// idxcount -> #号出现的次数
		// idx -> #号出现的上一次下标
		int idxcount = 0,idx = 0;
		for (int i = 0; i< video_class.length(); i++){
			// 是否是#
			if("#".equals(video_class.substring(i,i+1))) {
				idxcount += 1;
				// 是否是第二个#
				if(idxcount % 2 == 0){
					class_list += video_class.substring(idx + 1, i);
					idx = i;
				}
			}
		}
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


		return entityOut;
	}
}
