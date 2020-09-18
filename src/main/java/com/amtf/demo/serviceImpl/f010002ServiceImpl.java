package com.amtf.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.f010001Dao;
import com.amtf.demo.dao.f010002Dao;
import com.amtf.demo.entityin.F010002entityIn;
import com.amtf.demo.entityout.F010002entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010001entity.f010001_select1entity;
import com.amtf.demo.f010001entity.f010001_select2entity;
import com.amtf.demo.f010001entity.f010001_select3entity;
import com.amtf.demo.f010002entity.f010002_select4entity;
import com.amtf.demo.service.f010002Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.FenYe;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.StringUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class f010002ServiceImpl implements f010002Service {

	@Autowired
	private final f010001Dao f010001dao;

	@Autowired
	private final f010002Dao f010002dao;

	public F010002entityOut service01(F010002entityIn entityIn) throws ErrListException {

		F010002entityOut entityout = new F010002entityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 根据权限获取导航栏
		List<f010001_select2entity> select2 = f010001dao.f010001_Select2(loginfo.getUser_power());

		// 将导航栏数据整合成map
		Map<String, List<f010001_select2entity>> navigation_bar = select2.stream()
				.collect(Collectors.toMap(f010001_select2entity::getPower_type, s -> {
					List<f010001_select2entity> studentNameList = new ArrayList<>();
					studentNameList.add(s);
					return studentNameList;
				},
						// 重复时将现在的值全部加入到之前的值内
						(List<f010001_select2entity> value1, List<f010001_select2entity> value2) -> {
							value1.addAll(value2);
							return value1;
						}));
		String imgpath = ImgUtil.getImgPath(loginfo.getUser_email());
		loginfo.setImgpath(imgpath);
		// 用户信息
		entityout.setLogInFo(loginfo);
		// 导航栏
		entityout.setNavigation_bar(navigation_bar);

		List<f010001_select3entity> select4 = f010001dao.f010001_Select3();
		f010001_select3entity select4entity = new f010001_select3entity();
		if (!CommonUtil.isEmptyList(select4)) {

			select4.sort((a, b) -> b.getUpdnotice_time().replace("-", "").replace(" ", "").replace(":", "")
					.compareTo(a.getUpdnotice_time().replace("-", "").replace(" ", "").replace(":", "")));

			select4entity = CommonUtil.isEmptyList(select4) ? null : select4.get(0);

		}
		List<f010002_select4entity> select5 = f010002dao.f010002_Select5(loginfo.getUser_email());
		
		entityout.setSelect4(select4entity);
		
		entityout.setSelect5(select5);

		return entityout;
	}

	@Override
	public F010002entityOut service02(F010002entityIn entityIn) throws ErrListException {
		F010002entityOut entityout = new F010002entityOut();
		FenYe fenYe = new FenYe();
		fenYe.setFrequency(3);
		fenYe.setCount(f010002dao.f010002_Select1Count());
		fenYe.setFenyeList(f010002dao.f010002_Select1(StringUtil.toStr(fenYe.getCurrent() * fenYe.getFrequency()),
				StringUtil.toStr((fenYe.getCurrent() + 1) * fenYe.getFrequency())));
		fenYe.setPages(fenYe.getCount() / fenYe.getFrequency());
		entityout.setFenye(fenYe);
		return entityout;
	}

	@Override
	public F010002entityOut service03(F010002entityIn entityIn) throws ErrListException {
		F010002entityOut entityout = new F010002entityOut();

		ImgUtil.CommitImg(entityIn.getUpd_user_img(), Constant.STR_1);
		
		LogInFo loginfo = new LogInFo();
		//id
		loginfo.setUser_id(ParameterUtil.getSession().getUser_id());
		//账户
		loginfo.setUser_account(entityIn.getUpd_user_account());
		//名字
		loginfo.setUser_name(entityIn.getUpd_user_name());
		//国家
		loginfo.setUser_country(entityIn.getUpd_user_country());
		//省
		loginfo.setUser_province(entityIn.getUpd_user_province());
		//市
		loginfo.setUser_city(entityIn.getUpd_user_city());
		//邮编
		loginfo.setUser_postcode(entityIn.getUpd_user_postcode());
		//电话
		loginfo.setUser_phone(entityIn.getUpd_user_phone());
		//介绍
		loginfo.setUser_introduce(entityIn.getUpd_user_introduce());
		//Email
		loginfo.setUser_email(ParameterUtil.getSession().getUser_email());

		Integer update2 = f010002dao.f010002_update2(loginfo);

		if (update2 < 0) {
			throw new ErrListException(entityIn, entityIn.getIViewId(), "更改信息时发生错误");
		}

		f010001_select1entity select3entity = f010002dao.f010002_Select3(loginfo);

		// 用户信息存入Session
		ParameterUtil.setSession(select3entity);

		entityout.setIsUpdatUserOk(Constant.STR_1);

		return entityout;
	}
}
