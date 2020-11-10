package com.amtf.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.F010001Dao;
import com.amtf.demo.dao.F010002Dao;
import com.amtf.demo.entityin.F010004EntityIn;
import com.amtf.demo.entityout.F010004EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010001entity.F010001_Select3Entity;
import com.amtf.demo.f010002entity.F010002_Select4Entity;
import com.amtf.demo.service.F010004Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ParameterUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F010004ServiceImpl implements F010004Service {

	@Autowired
	private final F010001Dao f010001dao;

	@Autowired
	private final F010002Dao f010002dao;

	/**
	 * 初期化
	 */
	@Override
	public F010004EntityOut service01(F010004EntityIn entityIn) throws ErrListException {

		F010004EntityOut entityout = new F010004EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

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

		return entityout;
	}
}
