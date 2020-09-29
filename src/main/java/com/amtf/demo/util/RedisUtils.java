package com.amtf.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis操作工具类.</br>
 */
@Component
public class RedisUtils {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
	public String get(final String key) {
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * 写入缓存
	 */
	public boolean set(final String key, String value) {
		boolean result = false;
		try {
			redisTemplate.opsForValue().set(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 更新缓存
	 */
	public boolean getAndSet(final String key, String value) {
		boolean result = false;
		try {
			redisTemplate.opsForValue().getAndSet(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 删除缓存
	 */
	public boolean delete(final String key) {
		boolean result = false;
		try {
			redisTemplate.delete(key);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 删除用户
	 */
	public boolean deleteUser(final String key, String value) {
		try {
			String[] users = this.get(key).split(",");
			String redis_key = "";
			for (String string : users) {
				if (!string.equals(value)) {
					redis_key += string + ",";
				}
			}
			this.set(key, redis_key);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 添加用户
	 */
	public boolean addUser(final String key, String value) {
		try {
			String redis_key = this.get("redis_key");
			if (!redis_key.contains(value)) {
				redis_key += "," + value;
				this.set("redis_key", redis_key);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}