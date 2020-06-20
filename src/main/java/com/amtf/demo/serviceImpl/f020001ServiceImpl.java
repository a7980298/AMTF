package com.amtf.demo.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.f020001Dao;
import com.amtf.demo.entityin.F020001entityIn;
import com.amtf.demo.entityout.F020001entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.f020001Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.ImgUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class f020001ServiceImpl implements f020001Service {

	@Autowired
	private final f020001Dao f020001dao;

	@Autowired
	HttpServletRequest request;

	@Override
	public F020001entityOut service01(F020001entityIn entityin) throws ErrListException {
		F020001entityOut entityOut = new F020001entityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = (LogInFo) request.getSession().getAttribute("loginfo");

		entityOut.setUser_Name(loginfo.getUser_Name());

		String imgpath = ImgUtil.getImgPath(loginfo.getUser_Phone());

		if (!CommonUtil.isEmpty(imgpath)) {
			entityOut.setImgPath(imgpath);
		}

		return entityOut;
	}

	@Override
	public F020001entityOut service02(F020001entityIn entityin) throws ErrListException {
		F020001entityOut entityOut = new F020001entityOut();

		return entityOut;
	}
}
