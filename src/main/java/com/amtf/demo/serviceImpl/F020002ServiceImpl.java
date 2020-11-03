package com.amtf.demo.serviceImpl;

import com.amtf.demo.dao.CommonDao;
import com.amtf.demo.dao.F020001Dao;
import com.amtf.demo.entityin.F020002EntityIn;
import com.amtf.demo.entityout.F020002EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010001entity.F010001_Select1Entity;
import com.amtf.demo.f020001entity.F020001_Select1Entity;
import com.amtf.demo.service.F020002Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.*;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class F020002ServiceImpl implements F020002Service {

	@Autowired
	private final F020001Dao f020001dao;

	@Autowired
	private final CommonDao commondao;

	@Resource
	private RedisUtils redisUtils;

	@Autowired
	HttpServletResponse response;

	@Autowired
	DownLoad download;

	/**
	 * 初始化
	 */
	@Override
	public F020002EntityOut service01(F020002EntityIn entityin) throws ErrListException {

		F020002EntityOut entityOut = new F020002EntityOut();

		return entityOut;
	}
}
