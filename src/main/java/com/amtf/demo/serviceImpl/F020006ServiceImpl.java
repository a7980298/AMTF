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
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
		List<AmtfPowerEntity> clientPageDisplayed = f020006dao.f020006_Select1(Constant.STR_1);
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
		//去除 [] 符号
		entityin.setPagesShow(StringUtils.strip(entityin.getPagesShow(),"[]"));
		//根据逗号分隔成数组
		String[] pagesShows = entityin.getPagesShow().replaceAll(" ","").split(",");
		//将所有页面更改未不显示
		f020006dao.f020006_Update2();
		//将显示的页面更改
		Integer pageCount = 0;
		for (String str:pagesShows) {
			try{
				f020006dao.f020006_Update3(NumberUtil.toInt(str));
				pageCount ++;
			}catch (ErrListException e){
				pageCount --;
			}
		}
		entityOut.setPageCount(pageCount);
		return entityOut;
	}
}
