package com.amtf.demo.sessionmonitor;

import javax.annotation.Resource;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.amtf.demo.serviceImpl.LogInLimit;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.RedisUtils;

/**
 * session监听器
 * 
 * @author
 *
 */
@WebListener
public class SessionMonitor implements HttpSessionListener {

	@Resource
	private RedisUtils redisUtils;

	@Autowired
	private LogInLimit commonserviceimpl;

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
		LogInFo loginfo = null;
		try {
			HttpSession session = se.getSession();
			// 获取当前用户信息
			loginfo = (LogInFo) session.getAttribute("loginfo");
			// 销毁redis中的数据
			redisUtils.deleteUser("redis_key", loginfo.getUser_email());
			commonserviceimpl.users = CommonUtil.isEmpty(redisUtils.get("redis_key")) ? 0
					: redisUtils.get("redis_key").split(",").length;
		} catch (Exception e) {
			System.out.println("销毁" + loginfo.getUser_email() + "失败");
		}

		// se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
	}
}
