package com.amtf.demo.util;

import javax.annotation.Resource;

public class text {
	public static void main(String[] args) {
		set();
		get();
	}
	@Resource
	private static RedisUtils redisUtils;
 
	/**
	 * 插入缓存数据
	 */
	public static void set() {
		redisUtils.set("redis_key", "redis_vale");
	}
	
	/**
	 * 读取缓存数据
	 */
	public static void get() {
		String value = redisUtils.get("redis_key");
		System.out.println(value);
	}

}
