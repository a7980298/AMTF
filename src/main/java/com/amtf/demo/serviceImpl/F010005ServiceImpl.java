package com.amtf.demo.serviceImpl;

import java.util.List;

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

@Service
@RequiredArgsConstructor
public class F010005ServiceImpl implements F010005Service {

	@Autowired
	private final F010002Dao f010002dao;

	@Autowired
	private final CommonDao commondao;

	/**
	 * 初期化
	 */
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