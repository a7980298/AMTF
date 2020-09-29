package com.amtf.demo.sessionmonitor;

import javax.annotation.Resource;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.RedisUtils;

/**
 * session监听器
 * 
 * @author
 *
 */
@WebListener
public class sessionMonitor implements HttpSessionListener {

	@Resource
	private RedisUtils redisUtils;

	private int onlineCount = 0;// 记录session的数量

	/**
	 * session创建后执行
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		onlineCount++;
		// se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
	}

	/**
	 * 当session被销毁或超时时。
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		if (onlineCount > 0) {
			onlineCount--;
		}
		redisUtils.deleteUser("redis_key", ParameterUtil.getSession().getUser_email());
		// se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
	}
}
