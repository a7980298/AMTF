package com.amtf.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.F010002Dao;
import com.amtf.demo.entityin.F010003EntityIn;
import com.amtf.demo.entityout.F010003EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010001entity.F010001_Select1Entity;
import com.amtf.demo.service.F010003Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F010003ServiceImpl implements F010003Service {

	@Autowired
	private final F010002Dao f010002dao;

	/**
	 * 初期化
	 */
	public F010003EntityOut service01(F010003EntityIn entityIn) throws ErrListException {

		F010003EntityOut entityout = new F010003EntityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 用户信息
		entityout.setLogInFo(loginfo);

		return entityout;
	}

	/**
	 * 更改用户信息
	 */
	@Override
	public F010003EntityOut service02(F010003EntityIn entityIn) throws ErrListException {
		F010003EntityOut entityout = new F010003EntityOut();

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
}
