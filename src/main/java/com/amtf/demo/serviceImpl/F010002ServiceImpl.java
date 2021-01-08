package com.amtf.demo.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.F010002Dao;
import com.amtf.demo.entityin.F010002EntityIn;
import com.amtf.demo.entityout.F010002EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010002entity.F010002_Select4Entity;
import com.amtf.demo.service.F010002Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.FenYe;
import com.amtf.demo.util.NumberUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.RedisUtils;
import com.amtf.demo.util.StringUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F010002ServiceImpl implements F010002Service {

	@Autowired
	private final F010002Dao f010002dao;

	@Resource
	private RedisUtils redisUtils;

	/**
	 * 初期化
	 */
	@Override
	public F010002EntityOut service01(F010002EntityIn entityIn) throws ErrListException {

		F010002EntityOut entityout = new F010002EntityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 用户信息
		entityout.setLogInFo(loginfo);

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
	 * 标记查看过的通知
	 */
	@Override
	public F010002EntityOut service04(F010002EntityIn entityin) throws ErrListException {
		F010002EntityOut entityout = new F010002EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		if (!CommonUtil.isEmpty(entityin.getUpdnotice_id())) {
			f010002dao.f010002_Insert6(loginfo.getUser_no(), NumberUtil.toInt(entityin.getUpdnotice_id()));
		}
		List<F010002_Select4Entity> select5 = f010002dao.f010002_Select5(loginfo.getUser_no());

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
}
