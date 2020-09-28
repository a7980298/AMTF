package com.amtf.demo.monitor;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import com.amtf.demo.util.RedisUtils;

@Component
public class end implements ApplicationListener<ContextClosedEvent> {

	@Resource
	private RedisUtils redisUtils;

	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		// 清空redis缓存
		redisUtils.delete("redis_key");
		System.out.println("项目停止");
	}
}
