package com.amtf.demo.serviceImpl;

import com.amtf.demo.dao.CommonDao;
import com.amtf.demo.dao.F020001Dao;
import com.amtf.demo.entityin.F020005EntityIn;
import com.amtf.demo.entityin.F020005EntityIn;
import com.amtf.demo.entityout.F020005EntityOut;
import com.amtf.demo.entityout.F020005EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F020005Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.*;
import io.goeasy.GoEasy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class F020005ServiceImpl implements F020005Service {

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
	public F020005EntityOut service01(F020005EntityIn entityin) throws ErrListException {

		F020005EntityOut entityOut = new F020005EntityOut();

		return entityOut;
	}

	/**
	 * 活动发布
	 */
	@Override
	public F020005EntityOut service02(F020005EntityIn entityin) throws ErrListException {
		F020005EntityOut entityOut = new F020005EntityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		// 添加活动
		int insert6 = f020001dao.f020001_insert6(loginfo.getUser_no(),
				entityin.getActivity_head(), entityin.getActivity_check(),
				NumberUtil.toInt(entityin.getActivity_sttymd().replace("/", "")),
				NumberUtil.toInt(entityin.getActivity_endymd().replace("/", "")), entityin.getActivity_editor());

		if (insert6 <= 0) {
			entityOut.setIsactivity(Constant.STR_1);
		}
		return entityOut;
	}
}
