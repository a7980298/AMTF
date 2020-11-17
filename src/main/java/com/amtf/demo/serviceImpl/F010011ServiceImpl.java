package com.amtf.demo.serviceImpl;

import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.dao.F010011Dao;
import com.amtf.demo.entityin.F010011EntityIn;
import com.amtf.demo.entityout.F010011EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F010011Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class F010011ServiceImpl implements F010011Service {

	@Autowired
	private final F010011Dao f010011dao;

	/**
	 * 初期化
	 */
	@Override
	public F010011EntityOut service01(F010011EntityIn entityIn) throws ErrListException {
		F010011EntityOut entityout = new F010011EntityOut();
		//获取主页信息
		AmtfUserEntity select1 = f010011dao.f010011_Select1(entityIn.getUser());
		String imgpath = ImgUtil.getImgPath(select1.getUser_email());
		select1.setImgpath(imgpath);
		entityout.setSelect1(select1);

		return entityout;
	}
}
