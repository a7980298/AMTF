package com.amtf.demo.serviceImpl;

import java.util.*;

import com.amtf.demo.commonentity.*;
import com.amtf.demo.dao.F010005Dao;
import com.amtf.demo.f010005entity.CommentListEntity;
import com.amtf.demo.f010005entity.F010005_Select1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.CommonDao;
import com.amtf.demo.dao.F010002Dao;
import com.amtf.demo.entityin.F010005EntityIn;
import com.amtf.demo.entityout.F010005EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010002entity.F010002_Select9Entity;
import com.amtf.demo.service.F010005Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.NumberUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.StringUtil;

import lombok.RequiredArgsConstructor;
import org.thymeleaf.expression.Maps;

@Service
@RequiredArgsConstructor
public class F010005ServiceImpl implements F010005Service {

	@Autowired
	private final F010002Dao f010002dao;

	@Autowired
	private final F010005Dao f010005dao;

	@Autowired
	private final CommonDao commondao;

	/**
	 * 初期化
	 */
	@Override
	public F010005EntityOut service01(F010005EntityIn entityIn) throws ErrListException {

		F010005EntityOut entityout = new F010005EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		// 活动一览
		List<F010002_Select9Entity> select9 = f010002dao.f010002_Select9(NumberUtil.toInt(loginfo.getUser_power()));
		for (F010002_Select9Entity select9entity : select9) {
			select9entity.setActivity_sttymd(select9entity.getActivity_sttymd().substring(0, 4) + "-"
					+ select9entity.getActivity_sttymd().substring(4, 6) + "-"
					+ select9entity.getActivity_sttymd().substring(6, 8));
			select9entity.setActivity_endymd(select9entity.getActivity_endymd().substring(0, 4) + "-"
					+ select9entity.getActivity_endymd().substring(4, 6) + "-"
					+ select9entity.getActivity_endymd().substring(6, 8));
			select9entity.setActivity_img1(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select9entity.getActivity_name() + select9entity.getActivity_id() + "-1"));
			select9entity.setActivity_img2(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select9entity.getActivity_name() + select9entity.getActivity_id() + "-2"));
			select9entity.setActivity_img3(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select9entity.getActivity_name() + select9entity.getActivity_id() + "-3"));
			select9entity.setActivity_img4(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select9entity.getActivity_name() + select9entity.getActivity_id() + "-4"));
			select9entity.setActivity_img5(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select9entity.getActivity_name() + select9entity.getActivity_id() + "-5"));
		}
		entityout.setSelect9(select9);
		// 我参加的活动
		List<F010005_Select1Entity> select1 = f010005dao.f010005_Select1(loginfo.getUser_email());
		for (F010005_Select1Entity select1entity : select1) {
			select1entity.setActivity_sttymd(select1entity.getActivity_sttymd().substring(0, 4) + "-"
					+ select1entity.getActivity_sttymd().substring(4, 6) + "-"
					+ select1entity.getActivity_sttymd().substring(6, 8));
			select1entity.setActivity_endymd(select1entity.getActivity_endymd().substring(0, 4) + "-"
					+ select1entity.getActivity_endymd().substring(4, 6) + "-"
					+ select1entity.getActivity_endymd().substring(6, 8));
			select1entity.setActivity_img1(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select1entity.getActivity_name() + select1entity.getActivity_id() + "-1"));
			select1entity.setActivity_img2(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select1entity.getActivity_name() + select1entity.getActivity_id() + "-2"));
			select1entity.setActivity_img3(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select1entity.getActivity_name() + select1entity.getActivity_id() + "-3"));
			select1entity.setActivity_img4(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select1entity.getActivity_name() + select1entity.getActivity_id() + "-4"));
			select1entity.setActivity_img5(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select1entity.getActivity_name() + select1entity.getActivity_id() + "-5"));
		}
		entityout.setSelect1(select1);

		// 我发布的活动
		List<F010005_Select1Entity> select2 = f010005dao.f010005_Select2(loginfo.getUser_email());
		for (F010005_Select1Entity select2entity : select2) {
			select2entity.setActivity_sttymd(select2entity.getActivity_sttymd().substring(0, 4) + "-"
					+ select2entity.getActivity_sttymd().substring(4, 6) + "-"
					+ select2entity.getActivity_sttymd().substring(6, 8));
			select2entity.setActivity_endymd(select2entity.getActivity_endymd().substring(0, 4) + "-"
					+ select2entity.getActivity_endymd().substring(4, 6) + "-"
					+ select2entity.getActivity_endymd().substring(6, 8));
			select2entity.setActivity_img1(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select2entity.getActivity_name() + select2entity.getActivity_id() + "-1"));
			select2entity.setActivity_img2(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select2entity.getActivity_name() + select2entity.getActivity_id() + "-2"));
			select2entity.setActivity_img3(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select2entity.getActivity_name() + select2entity.getActivity_id() + "-3"));
			select2entity.setActivity_img4(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select2entity.getActivity_name() + select2entity.getActivity_id() + "-4"));
			select2entity.setActivity_img5(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
					select2entity.getActivity_name() + select2entity.getActivity_id() + "-5"));
		}
		entityout.setSelect2(select2);


		return entityout;
	}

	/**
	 * 参加活动
	 */
	@Override
	public F010005EntityOut service02(F010005EntityIn entityin) throws ErrListException {
		F010005EntityOut entityout = new F010005EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		int insert10 = 0;
		if (f010002dao.f010002_Select11(NumberUtil.toInt(entityin.getActivity_id()), loginfo.getUser_email()) > 0) {
			f010005dao.f010005_Delete14(NumberUtil.toInt(entityin.getActivity_id()), loginfo.getUser_email());
			insert10 = -1;
		} else {
			insert10 = f010002dao.f010002_Insert10(
					CommonUtil.isEmpty(commondao.common_Select4()) ? 0 : commondao.common_Select4() + 1,
					NumberUtil.toInt(entityin.getActivity_id()), loginfo.getUser_email());
		}
		entityout.setInsert10(StringUtil.toStr(insert10));

		return entityout;
	}

	/**
	 * 详细活动
	 */
	@Override
	public F010005EntityOut service03(F010005EntityIn entityin) throws ErrListException {
		F010005EntityOut entityout = new F010005EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		// 详细活动
		AmtfActivityEntity select3 = f010005dao.f010005_Select3(NumberUtil.toInt(entityin.getActivity_id()));
		entityout.setSelect3(select3);

		//活动点赞人数
		Integer fabulouscount = f010005dao.f010005_Select9(select3.getActivity_id());
		entityout.setFabulouscount(fabulouscount);

		// 活动发布人信息
		AmtfUserEntity select4 = f010005dao.f010005_Select4(select3.getActivity_name());
		String imgpath = ImgUtil.getImgPath(select4.getUser_email());
		select4.setImgpath(imgpath);
		entityout.setSelect4(select4);

		// 获取评论
		entityout.setCommentlist(this.service05(entityin).getCommentlist());

		//是否点赞
		entityout.setFabulous(StringUtil.toStr(f010005dao.f010005_Select11(NumberUtil.toInt(entityin.getActivity_id()),loginfo.getUser_email())));
		
		//是否参加
		entityout.setInsert10(StringUtil.toStr(f010002dao.f010002_Select11(NumberUtil.toInt(entityin.getActivity_id()), loginfo.getUser_email())));

		// 我发布的活动
		List<F010005_Select1Entity> select2 = f010005dao.f010005_Select2(select3.getActivity_name());
		if(!CommonUtil.isEmptyList(select2)) {
			for (F010005_Select1Entity select2entity : select2) {
				if (!CommonUtil.isEmpty(select2entity)){
					if (select2entity.getActivity_name().equals(select4.getUser_email())) {
						select3.setCount(select2entity.getCount());
					}
					select2entity.setActivity_sttymd(select2entity.getActivity_sttymd().substring(0, 4) + "-"
							+ select2entity.getActivity_sttymd().substring(4, 6) + "-"
							+ select2entity.getActivity_sttymd().substring(6, 8));
					select2entity.setActivity_endymd(select2entity.getActivity_endymd().substring(0, 4) + "-"
							+ select2entity.getActivity_endymd().substring(4, 6) + "-"
							+ select2entity.getActivity_endymd().substring(6, 8));
					select2entity.setActivity_img1(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
							select2entity.getActivity_name() + select2entity.getActivity_id() + "-1"));
					select2entity.setActivity_img2(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
							select2entity.getActivity_name() + select2entity.getActivity_id() + "-2"));
					select2entity.setActivity_img3(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
							select2entity.getActivity_name() + select2entity.getActivity_id() + "-3"));
					select2entity.setActivity_img4(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
							select2entity.getActivity_name() + select2entity.getActivity_id() + "-4"));
					select2entity.setActivity_img5(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
							select2entity.getActivity_name() + select2entity.getActivity_id() + "-5"));
				}
			}
			// 按参加人数最多的活动进行排序
			select2.sort((F010005_Select1Entity obj1, F010005_Select1Entity obj2) ->
					obj2.getCount() - obj1.getCount());
			List<F010005_Select1Entity> view_select2 = new ArrayList<F010005_Select1Entity>();
			for (int i = 0; i < select2.size(); i++) {
				if (i < 4) {
					view_select2.add(select2.get(i));
				}
			}
			select2.removeAll(Collections.singleton(null));
			entityout.setSelect2(select2);
		}
		// 活动一览
		List<F010002_Select9Entity> select9 = f010002dao.f010002_Select9(NumberUtil.toInt(loginfo.getUser_power()));
		if (!CommonUtil.isEmptyList(select9)) {
			for (F010002_Select9Entity select9entity : select9) {
				if (!CommonUtil.isEmpty(select9entity)){
					select9entity.setActivity_sttymd(select9entity.getActivity_sttymd().substring(0, 4) + "-"
							+ select9entity.getActivity_sttymd().substring(4, 6) + "-"
							+ select9entity.getActivity_sttymd().substring(6, 8));
					select9entity.setActivity_endymd(select9entity.getActivity_endymd().substring(0, 4) + "-"
							+ select9entity.getActivity_endymd().substring(4, 6) + "-"
							+ select9entity.getActivity_endymd().substring(6, 8));
					select9entity.setActivity_img1(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
							select9entity.getActivity_name() + select9entity.getActivity_id() + "-1"));
					select9entity.setActivity_img2(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
							select9entity.getActivity_name() + select9entity.getActivity_id() + "-2"));
					select9entity.setActivity_img3(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
							select9entity.getActivity_name() + select9entity.getActivity_id() + "-3"));
					select9entity.setActivity_img4(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
							select9entity.getActivity_name() + select9entity.getActivity_id() + "-4"));
					select9entity.setActivity_img5(ImgUtil.getImgPath(Constant.PATH_ACTIVITY,
							select9entity.getActivity_name() + select9entity.getActivity_id() + "-5"));
				}
			}
			// 按人数最多的活动进行排序
			select9.sort((F010002_Select9Entity obj1, F010002_Select9Entity obj2) ->
					obj2.getCount() - obj1.getCount());
			List<F010002_Select9Entity> view_select9 = new ArrayList<F010002_Select9Entity>();
			for (int i = 0; i < select9.size(); i++) {
				if (i < 4) {
					view_select9.add(select9.get(i));
				}
			}
			select9.removeAll(Collections.singleton(null));
			entityout.setSelect9(select9);
		}
		return entityout;
	}

	/**
	 * 评论
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F010005EntityOut service04(F010005EntityIn entityin) throws ErrListException {
		F010005EntityOut entityout = new F010005EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		AmtfActivityCommentEntity amtfactivitycommententity = new AmtfActivityCommentEntity();
		//评论id
		amtfactivitycommententity.setActivity_comment_id(CommonUtil.isEmpty(commondao.common_Select5()) ? 0 : commondao.common_Select5() + 1);
		//活动id
		amtfactivitycommententity.setActivity_id(NumberUtil.toInt(entityin.getActivity_id()));
		//用户
		amtfactivitycommententity.setUser_id(loginfo.getUser_email());
		//用户名字
		amtfactivitycommententity.setUser_name(loginfo.getUser_name());
		//评论
		amtfactivitycommententity.setUser_text(entityin.getActivity_text());

		Integer insert6 = f010005dao.f010005_Insert6(amtfactivitycommententity);
		entityout.setInsert6(insert6);
		return entityout;
	}

	/**
	 * 刷新评论
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F010005EntityOut service05(F010005EntityIn entityin) throws ErrListException {
		F010005EntityOut entityout = new F010005EntityOut();
		//活动一级评论
		List<AmtfActivityCommentEntity> select5 = f010005dao.f010005_Select5(NumberUtil.toInt(entityin.getActivity_id()));
		List<CommentListEntity> commentlist=new ArrayList<CommentListEntity>();
		select5.removeAll(Collections.singleton(null));
		if(!CommonUtil.isEmptyList(select5)){
			for (AmtfActivityCommentEntity select5entity:select5) {
				CommentListEntity commentlistentity=new CommentListEntity();
				commentlistentity.setAmtfactivitycommententity(select5entity);
				List<AmtfActivityCommentReplyEntity> select7 = new ArrayList<AmtfActivityCommentReplyEntity>();
				if (!CommonUtil.isEmpty(select5entity)){
					select5entity.setImgpath(ImgUtil.getImgPath(select5entity.getUser_id()));
					select7 = f010005dao.f010005_Select7(select5entity.getActivity_comment_id());
					select7.removeAll(Collections.singleton(null));
					if(!CommonUtil.isEmptyList(select7)) {
						for (AmtfActivityCommentReplyEntity select7entity : select7) {
							if (!CommonUtil.isEmpty(select7entity)){
								select7entity.setImgpath(ImgUtil.getImgPath(select7entity.getUser_id()));
							}
						}
					}
					commentlistentity.setAmtfactivitycommentreplyentity(select7);
				}

				commentlist.add(commentlistentity);
			}
			// 排序

			entityout.setCommentlist(commentlist);
		}
		return entityout;
	}

	/**
	 * 发表二级评论
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F010005EntityOut service06(F010005EntityIn entityin) throws ErrListException {
		F010005EntityOut entityout = new F010005EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		AmtfActivityCommentReplyEntity amtfactivitycommentreplyentity = new AmtfActivityCommentReplyEntity();
		//回复id
		amtfactivitycommentreplyentity.setActivity_comment_reply_id(CommonUtil.isEmpty(commondao.common_Select6()) ? 0 : commondao.common_Select6() + 1);
		//评论id
		amtfactivitycommentreplyentity.setActivity_comment_id(NumberUtil.toInt(entityin.getActivity_id()));
		//用户
		amtfactivitycommentreplyentity.setUser_id(loginfo.getUser_email());
		//用户名字
		amtfactivitycommentreplyentity.setUser_name(loginfo.getUser_name());
		//评论
		amtfactivitycommentreplyentity.setUser_text(entityin.getActivity_text());

		Integer insert8 = f010005dao.f010005_Insert8(amtfactivitycommentreplyentity);
		entityout.setInsert8(insert8);
		return entityout;
	}

	/**
	 * 活动点赞
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F010005EntityOut service07(F010005EntityIn entityin) throws ErrListException {
		F010005EntityOut entityout = new F010005EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		AmtfActivityFabulousEntity amtfactivityfabulousentity = new AmtfActivityFabulousEntity();
		// id
		amtfactivityfabulousentity.setActivity_fabulous_id(CommonUtil.isEmpty(commondao.common_Select7()) ? 0 : commondao.common_Select7());
		// 活动
		amtfactivityfabulousentity.setActivity_id(NumberUtil.toInt(entityin.getActivity_id()));
		// userid
		amtfactivityfabulousentity.setUser_id(loginfo.getUser_email());
		if(f010005dao.f010005_Select11(NumberUtil.toInt(entityin.getActivity_id()),loginfo.getUser_email()) == 0){
			// 添加点赞
			Integer insert10 = f010005dao.f010005_Insert10(amtfactivityfabulousentity);
			if(insert10 < 1){
				entityout.setFabulous("insert0");
			} else {
				entityout.setFabulous("insert1");
			}
		} else {
			Integer delete12 = f010005dao.f010005_Delete12(NumberUtil.toInt(entityin.getActivity_id()),loginfo.getUser_email());
			if(delete12 < 1){
				entityout.setFabulous("delete0");
			} else {
				entityout.setFabulous("delete1");
			}
		}
		return entityout;
	}

	/**
	 * 删除评论
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F010005EntityOut service08(F010005EntityIn entityin) throws ErrListException {
		F010005EntityOut entityout = new F010005EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		Integer delect13 = f010005dao.f010005_Delete13(NumberUtil.toInt(entityin.getActivity_id()),entityin.getLevel(),NumberUtil.toInt(entityin.getComment_id()));

		entityout.setDelect13(delect13);
		return entityout;
	}
}
