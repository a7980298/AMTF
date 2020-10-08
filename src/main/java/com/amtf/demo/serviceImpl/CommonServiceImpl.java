package com.amtf.demo.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.RedisUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonServiceImpl {

	@Resource
	private RedisUtils redisUtils;

	public volatile int users;

	// 限制登录人数
	public synchronized void stopLogin() {
		LogInFo loginfoget = new LogInFo();
		loginfoget = ParameterUtil.getSession();
		String redis_key = redisUtils.get("redis_key");
		if (CommonUtil.isEmpty(redis_key)) {
			redisUtils.set("redis_key", loginfoget.getUser_email());
			users = 1;
		} else {
			if (getUsers()) {
				redisUtils.addUser("redis_key", loginfoget.getUser_email());
				users = redis_key.split(",").length;
			}
		}
	}

	public boolean getUsers() {
		if (users >= 1) {
			getUsers();
		}
		return true;
	}
}
