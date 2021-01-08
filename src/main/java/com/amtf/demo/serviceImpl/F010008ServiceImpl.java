package com.amtf.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amtf.demo.entityin.F010008EntityIn;
import com.amtf.demo.entityout.F010008EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F010008Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.user.WebSockerUsers;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.RedisUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F010008ServiceImpl implements F010008Service {
	@Resource
	private RedisUtils redisUtils;

	/**
	 * 初期化
	 */
	@Override
	public F010008EntityOut service01(F010008EntityIn entityIn) throws ErrListException {

		F010008EntityOut entityout = new F010008EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 获取当前在线的用户
		String[] users = CommonUtil.isEmpty(redisUtils.get("redis_key")) ? null
				: redisUtils.get("redis_key").split(",");
		List<WebSockerUsers> userList = new ArrayList<WebSockerUsers>();
		for (int i = 0; i < users.length; i++) {
			if (loginfo.getUser_no().equals(users[i])) {
				continue;
			}
			WebSockerUsers websockerusers = new WebSockerUsers();
			websockerusers.setUserid(users[i]);
			websockerusers.setUserpath(ImgUtil.getImgPath(users[i]));
			userList.add(websockerusers);
		}
		entityout.setUserList(userList);

		entityout.setLogInFo(loginfo);

		return entityout;
	}
}
