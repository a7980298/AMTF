package com.amtf.demo.serviceImpl;

import com.amtf.demo.commonentity.AmtfPowerEntity;
import com.amtf.demo.dao.CommonDao;
import com.amtf.demo.dao.F020001Dao;
import com.amtf.demo.dao.F020006Dao;
import com.amtf.demo.entityin.F020006EntityIn;
import com.amtf.demo.entityout.F020006EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F020006Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
@RequiredArgsConstructor
public class F020006ServiceImpl implements F020006Service {

	@Autowired
	private final F020006Dao f020006dao;

	@Autowired
	private final CommonDao commondao;


	/**
	 * 初始化
	 */
	@Override
	public F020006EntityOut service01(F020006EntityIn entityin) throws ErrListException {
		F020006EntityOut entityOut = new F020006EntityOut();
		//获取所有客户端页面
		List<AmtfPowerEntity> totalClientPage = f020006dao.f020006_Select1(Constant.EMPTY);
		entityOut.setTotalClientPage(totalClientPage);
		//获取显示的客户端页面
		List<AmtfPowerEntity> clientPageDisplayed = f020006dao.f020006_Select1(Constant.STR_0);
		entityOut.setClientPageDisplayed(clientPageDisplayed);

		return entityOut;
	}

	/**
	 * 保存
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F020006EntityOut service02(F020006EntityIn entityin) throws ErrListException {
		F020006EntityOut entityOut = new F020006EntityOut();



		return entityOut;
	}
}
