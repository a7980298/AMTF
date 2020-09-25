package com.amtf.demo.serviceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.amtf.demo.dao.commonDao;
import com.amtf.demo.dao.f010001Dao;
import com.amtf.demo.entityin.F010001entityIn;
import com.amtf.demo.entityout.F010001entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010001entity.f010001_insert4entityIn;
import com.amtf.demo.f010001entity.f010001_select1entity;
import com.amtf.demo.service.f010001Service;
import com.amtf.demo.service.mailService;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.RedisUtils;
import com.amtf.demo.util.StringUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class f010001ServiceImpl implements f010001Service {

	@Autowired
	private final f010001Dao f010001dao;

	@Autowired
	private final commonDao commdao;

	@Autowired
	private mailService mailService;
	
	@Resource
	private RedisUtils redisUtils;

	/**
	 * 登录
	 */
	@Override
	public F010001entityOut service01(F010001entityIn entityIn) throws ErrListException {
		F010001entityOut entityout = new F010001entityOut();

		f010001_select1entity select1entity = new f010001_select1entity();
		LogInFo loginfo = new LogInFo();
		loginfo.setUser_account(entityIn.getUser_account());
		loginfo.setUser_password(entityIn.getUser_password());
		// 判断是否需要保存密码
		/*
		 * if (!CommonUtil.isEmpty(entityIn.getRemember())) { // 存入Cookie中
		 * ParameterUtil.setCookie(loginfo); }
		 */
		if (!CommonUtil.isEmpty(entityIn.getUser_password())) {
			// MD5加密
			String md5pwd = DigestUtils.md5DigestAsHex(entityIn.getUser_password().getBytes());

			// 用户是否正确
			select1entity = f010001dao.f010001_Select1(entityIn.getUser_account(), md5pwd);

			// 判断用户密码是否正确
			if (CommonUtil.isEmpty(select1entity)) {
				// entityout.setPwdbol(FixedNumberUtil.STR_0);
				throw new ErrListException(entityIn, entityIn.getIViewId(), "账户密码输入不正确!");
			}
		} else {
			throw new ErrListException(entityIn, entityIn.getIViewId(), "账户密码输入不能是空!");
		}
		if (CommonUtil.isEmpty(entityIn.getLocking())) {
			//获取session的用户
			LogInFo getsession = ParameterUtil.getSession();
			if (!CommonUtil.isEmpty(getsession)) {
				//判断是否是当前用户
				if (getsession.getUser_account().equals(entityIn.getUser_account()) && getsession.getUser_password().equals(entityIn.getUser_password())) {
					throw new ErrListException(entityIn, entityIn.getIViewId(), "该用户已登录!");
				}
			}
		}
		// 用户信息存入Session
		ParameterUtil.setSession(select1entity);

		entityout.setBol02(Constant.STR_1);
		
		return entityout;
	}

	/**
	 * 注册
	 */
	@Override
	public F010001entityOut service02(F010001entityIn entityIn) throws ErrListException {
		F010001entityOut entityout = new F010001entityOut();

		if (!CommonUtil.isEmpty(entityIn.getVerifyCode())) {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			// 获取验证码
			String sessionverifycode = (String) request.getSession().getAttribute("verifycode");
			// 验证码不符合
			if (!sessionverifycode.equals(entityIn.getVerifyCode())) {
				throw new ErrListException(entityIn, entityIn.getIViewId(), "验证码不正确!");
			}
			//判断是否已注册
			int select5 = f010001dao.f010001_Select5(entityIn.getRegist_user_email());
			if (select5 > 0) {
				throw new ErrListException(entityIn, entityIn.getIViewId(), "Email已注册。。。");
			}
			//注册
			f010001_insert4entityIn insert4entityin = new f010001_insert4entityIn();
			Integer common_select1 = commdao.common_Select1();
			insert4entityin.setUserid(CommonUtil.isEmpty(common_select1) ? 0 : common_select1 + 1);
			insert4entityin.setUseraccount(entityIn.getRegist_user_name());
			insert4entityin.setUserpwd(DigestUtils.md5DigestAsHex(entityIn.getRegist_user_password().getBytes()));
			insert4entityin.setUseremail(entityIn.getRegist_user_email());
			int insert4 = f010001dao.f010001_Insert4(insert4entityin);
			if (insert4 <= 0) {
				throw new ErrListException(entityIn, entityIn.getIViewId(), "注册失败!");
			}
		} else {
			throw new ErrListException(entityIn, entityIn.getIViewId(), "错误了!");
		}
		entityout.setYesorno(Constant.STR_1);
		return entityout;
	}

	/**
	 * 获取邮箱验证码
	 */
	@Override
	public F010001entityOut service03(F010001entityIn entityin) throws ErrListException {
		F010001entityOut entityout = new F010001entityOut();

		int round = (int) Math.round((Math.random() + 1) * 1000);

		entityout.setVerifyCode(mailService.sendSimpleMail(entityin.getPhone_number(), StringUtil.toStr(round)));
		if (Constant.STR_1.equals(entityout.getVerifyCode())) {
			// 创建requesst请求
			HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			// 创建session
			HttpSession session = httpRequest.getSession();
			session.setMaxInactiveInterval(60);// 以秒为单位
			session.setAttribute("verifycode", StringUtil.toStr(round));
		}
		return entityout;
	}

}
