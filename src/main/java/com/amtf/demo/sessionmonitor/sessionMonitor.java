package com.amtf.demo.sessionmonitor;

import javax.annotation.Resource;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.amtf.demo.user.LogInFo;
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
		HttpSession session = se.getSession();
		// 获取当前用户信息
		LogInFo loginfo = (LogInFo) session.getAttribute("loginfo");

		redisUtils.deleteUser("redis_key", loginfo.getUser_email());
		// se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
	}
}
