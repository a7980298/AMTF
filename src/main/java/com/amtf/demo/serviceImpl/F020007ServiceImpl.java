package com.amtf.demo.serviceImpl;

import com.amtf.demo.commonentity.AmtfClassImgEntity;
import com.amtf.demo.dao.F020007Dao;
import com.amtf.demo.entityin.F020007EntityIn;
import com.amtf.demo.entityout.F020007EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.oss.FileUploadResultEntity;
import com.amtf.demo.service.F020007Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class F020007ServiceImpl implements F020007Service {

	@Autowired
	private final F020007Dao f020007dao;

	/**
	 * 初始化
	 */
	@Override
	public F020007EntityOut service01(F020007EntityIn entityin) throws ErrListException {
		F020007EntityOut entityOut = new F020007EntityOut();
		//获取全部背景图片
		List<AmtfClassImgEntity> backgroundPictureList = f020007dao.f020007_Select1();
		backgroundPictureList.forEach(entity->{



		});


		entityOut.setBackgroundPictureList(f020007dao.f020007_Select1());

		return entityOut;
	}

	@Override
	public F020007EntityOut service02(F020007EntityIn entityin) throws ErrListException {
		return null;
	}
}
