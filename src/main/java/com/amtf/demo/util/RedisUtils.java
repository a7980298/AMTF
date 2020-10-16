package com.amtf.demo.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;

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
		if (!CommonUtil.isEmpty(value)) {
			try {
				String[] users = this.get(key).split(",");
				String redis_key = "";
				for (String string : users) {
					if (!string.equals(value) && !CommonUtil.isEmpty(string)) {
						redis_key += string + ",";
					}
				}
				if (!CommonUtil.isEmpty(redis_key)) {
					if (redis_key.substring(redis_key.length() - 1, redis_key.length()).equals(",")) {
						redis_key = redis_key.substring(0, redis_key.length() - 1);
					}
				}
				this.set(key, redis_key);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 添加用户
	 */
	public boolean addUser(final String key, String value) {
		if (!CommonUtil.isEmpty(value)) {
			try {
				String redis_key = this.get(key);
				if (!CommonUtil.isEmpty(redis_key)) {
					if (!redis_key.contains(value)) {
						redis_key += "," + value;
					}
				}
				this.set(key, redis_key);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 存入list
	 */
	public boolean addList(final String key, List<?> list) {
		if (!CommonUtil.isEmpty(list) && list.size() > 0) {
			try {
				// 异常设备的json数组，把list转换成json数组
				String json = JSONArray.fromObject(list).toString();
				this.set(key, json);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 取出list
	 */
	public JSONArray getList(final String key) {
		String jsonStr = this.get(key);
		JSONArray jsonArray = JSONArray.fromObject(jsonStr);
		return jsonArray;
	}
}