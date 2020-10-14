package com.amtf.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.CommonDao;
import com.amtf.demo.dao.F010001Dao;
import com.amtf.demo.dao.F010002Dao;
import com.amtf.demo.entityin.F010002EntityIn;
import com.amtf.demo.entityout.F010002EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010001entity.F010001_Select1Entity;
import com.amtf.demo.f010001entity.F010001_Select3Entity;
import com.amtf.demo.f010002entity.F010002_Select4Entity;
import com.amtf.demo.f010002entity.F010002_Select9Entity;
import com.amtf.demo.service.F010002Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.user.WebSockerUsers;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.FenYe;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.NumberUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.RedisUtils;
import com.amtf.demo.util.StringUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F010002ServiceImpl implements F010002Service {

	@Autowired
	private final F010001Dao f010001dao;

	@Autowired
	private final F010002Dao f010002dao;

	@Autowired
	private final CommonDao commondao;

	@Resource
	private RedisUtils redisUtils;

	/**
	 * 初期化
	 */
	public F010002EntityOut service01(F010002EntityIn entityIn) throws ErrListException {

		F010002EntityOut entityout = new F010002EntityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 用户信息
		entityout.setLogInFo(loginfo);

		List<F010001_Select3Entity> select4 = f010001dao.f010001_Select3();
		F010001_Select3Entity select4entity = new F010001_Select3Entity();
		if (!CommonUtil.isEmptyList(select4)) {

			select4.sort((a, b) -> b.getUpdnotice_time().replace("-", "").replace(" ", "").replace(":", "")
					.compareTo(a.getUpdnotice_time().replace("-", "").replace(" ", "").replace(":", "")));

			select4entity = CommonUtil.isEmptyList(select4) ? null : select4.get(0);

		}
		entityout.setSelect4(select4entity);
		// 获取未读通知
		List<F010002_Select4Entity> select5 = f010002dao.f010002_Select5(loginfo.getUser_email());

		// 未读通知
		entityout.setSelect5(select5);

		// 所有通知一栏
		List<F010002_Select4Entity> select8 = f010002dao.f010002_Select8();

		for (F010002_Select4Entity select8entity : select8) {
			for (F010002_Select4Entity select5entity : select5) {
				if (select8entity.getUpdnotice_id().equals(select5entity.getUpdnotice_id())) {
					select8entity.setIslook(Constant.STR_1);
				}
			}
		}
		// 通知一栏
		entityout.setSelect8(select8);

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

		// 获取当前在线的用户
		String[] users = CommonUtil.isEmpty(redisUtils.get("redis_key")) ? null
				: redisUtils.get("redis_key").split(",");
		List<WebSockerUsers> userList = new ArrayList<WebSockerUsers>();
		for (int i = 0; i < users.length; i++) {
			if (loginfo.getUser_email().equals(users[i])) {
				continue;
			}
			WebSockerUsers websockerusers = new WebSockerUsers();
			websockerusers.setUserid(users[i]);
			websockerusers.setUserpath(ImgUtil.getImgPath(users[i]));
			userList.add(websockerusers);
		}
		entityout.setUserList(userList);

		return entityout;
	}

	/**
	 * 分页
	 */
	@Override
	public F010002EntityOut service02(F010002EntityIn entityIn) throws ErrListException {
		F010002EntityOut entityout = new F010002EntityOut();
		FenYe fenYe = new FenYe();
		fenYe.setFrequency(3);
		fenYe.setCount(f010002dao.f010002_Select1Count());
		fenYe.setFenyeList(f010002dao.f010002_Select1(StringUtil.toStr(fenYe.getCurrent() * fenYe.getFrequency()),
				StringUtil.toStr((fenYe.getCurrent() + 1) * fenYe.getFrequency())));
		fenYe.setPages(fenYe.getCount() / fenYe.getFrequency());
		entityout.setFenye(fenYe);
		return entityout;
	}

	/**
	 * 更改用户信息
	 */
	@Override
	public F010002EntityOut service03(F010002EntityIn entityIn) throws ErrListException {
		F010002EntityOut entityout = new F010002EntityOut();

		ImgUtil.CommitImg(entityIn.getUpd_user_img(), Constant.STR_1);

		LogInFo loginfo = new LogInFo();
		// id
		loginfo.setUser_id(ParameterUtil.getSession().getUser_id());
		// 账户
		loginfo.setUser_account(entityIn.getUpd_user_account());
		// 名字
		loginfo.setUser_name(entityIn.getUpd_user_name());
		// 国家
		loginfo.setUser_country(entityIn.getUpd_user_country());
		// 省
		loginfo.setUser_province(entityIn.getUpd_user_province());
		// 市
		loginfo.setUser_city(entityIn.getUpd_user_city());
		// 邮编
		loginfo.setUser_postcode(entityIn.getUpd_user_postcode());
		// 电话
		loginfo.setUser_phone(entityIn.getUpd_user_phone());
		// 介绍
		loginfo.setUser_introduce(entityIn.getUpd_user_introduce());
		// Email
		loginfo.setUser_email(ParameterUtil.getSession().getUser_email());

		Integer update2 = f010002dao.f010002_update2(loginfo);

		if (update2 < 0) {
			throw new ErrListException(entityIn, entityIn.getIViewId(), "更改信息时发生错误");
		}

		F010001_Select1Entity select3entity = f010002dao.f010002_Select3(loginfo);

		// 用户信息存入Session
		ParameterUtil.setSession(select3entity);

		entityout.setIsUpdatUserOk(Constant.STR_1);

		return entityout;
	}

	/**
	 * 标记查看过的通知
	 */
	@Override
	public F010002EntityOut service04(F010002EntityIn entityin) throws ErrListException {
		F010002EntityOut entityout = new F010002EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		if (!CommonUtil.isEmpty(entityin.getUpdnotice_id())) {
			f010002dao.f010002_Insert6(loginfo.getUser_email(), NumberUtil.toInt(entityin.getUpdnotice_id()));
		}
		List<F010002_Select4Entity> select5 = f010002dao.f010002_Select5(loginfo.getUser_email());

		entityout.setSelect5(select5);

		return entityout;
	}

	/**
	 * 打开选择的通知
	 */
	@Override
	public F010002EntityOut service05(F010002EntityIn entityin) throws ErrListException {
		F010002EntityOut entityout = new F010002EntityOut();

		List<F010002_Select4Entity> select7 = f010002dao.f010002_Select7(NumberUtil.toInt(entityin.getUpdnotice_id()));

		entityout.setSelect7(select7);

		return entityout;
	}

	/**
	 * 参加活动
	 */
	@Override
	public F010002EntityOut service06(F010002EntityIn entityin) throws ErrListException {
		F010002EntityOut entityout = new F010002EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		int insert10 = 0;
		if (f010002dao.f010002_Select11(NumberUtil.toInt(entityin.getActiyity_id()), loginfo.getUser_email()) > 0) {
			insert10 = -1;
		} else {
			insert10 = f010002dao.f010002_Insert10(
					CommonUtil.isEmpty(commondao.common_Select4()) ? 0 : commondao.common_Select4() + 1,
					NumberUtil.toInt(entityin.getActiyity_id()), loginfo.getUser_email());
		}
		entityout.setInsert10(StringUtil.toStr(insert10));

		return entityout;
	}
}
