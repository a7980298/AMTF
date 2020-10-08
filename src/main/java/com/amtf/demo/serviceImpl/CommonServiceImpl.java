package com.amtf.demo.serviceImpl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

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

	public static ReentrantLock lock = new ReentrantLock(true);

	// 限制登录人数
	public void stopLogin() {
		LogInFo loginfoget = new LogInFo();
		// 获取当前用户
		loginfoget = ParameterUtil.getSession();
		String redis_key = redisUtils.get("redis_key");
		// 判断是否有用户登录中
		if (CommonUtil.isEmpty(redis_key)) {
			redisUtils.set("redis_key", loginfoget.getUser_email());
			users = 1;
		} else {
			try {
				// 锁住当前线程
				lock.lock();
				// 判断用户人数是否超过1人
				if (users < 1) {
					// 没有超过则登录
					redisUtils.addUser("redis_key", loginfoget.getUser_email());
					users = redis_key.split(",").length;
					return;
				}
				// 判断当前人数是否超过1人
				while (users >= 1) {
					// 等待2秒
					lock.newCondition().await(2, TimeUnit.SECONDS);
					// 如果没有超过则登录
					if (users < 1) {
						redisUtils.addUser("redis_key", loginfoget.getUser_email());
						users = redis_key.split(",").length;

						return;
					}
				}
				// 唤醒线程
				lock.newCondition().signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 释放锁
				lock.unlock();
			}
		}
	}
}