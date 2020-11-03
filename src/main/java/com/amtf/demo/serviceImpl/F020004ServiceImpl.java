package com.amtf.demo.serviceImpl;

import com.amtf.demo.dao.CommonDao;
import com.amtf.demo.dao.F020001Dao;
import com.amtf.demo.entityin.F020004EntityIn;
import com.amtf.demo.entityout.F020004EntityOut;
import com.amtf.demo.entityout.F020004EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F020004Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.RedisUtils;
import io.goeasy.GoEasy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class F020004ServiceImpl implements F020004Service {

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
	public F020004EntityOut service01(F020004EntityIn entityin) throws ErrListException {

		F020004EntityOut entityOut = new F020004EntityOut();

		return entityOut;
	}

	/**
	 * 发布通知
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F020004EntityOut service02(F020004EntityIn entityin) throws ErrListException {
		F020004EntityOut entityOut = new F020004EntityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		// 参数：服务器地址 , AppKey:commonKey
		GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-6bb634d86a8c493799745be104a4e0c0");
		int id = CommonUtil.isEmpty(commondao.common_Select2()) ? 0 : commondao.common_Select2() + 1;
		// 参数：管道标识，发送内容
		goEasy.publish("amtf_channel", id + "," + entityin.getRelease_head() + "," + entityin.getRelease_name());
		try {
			f020001dao.f020001_insert3(id, loginfo.getUser_email(), entityin.getRelease_head(),
					entityin.getRelease_name());
		} catch (Exception e) {
			throw new ErrListException(entityin, entityin.getIViewId(), "发布通知时出现错误!");
		}
		return entityOut;
	}
}
