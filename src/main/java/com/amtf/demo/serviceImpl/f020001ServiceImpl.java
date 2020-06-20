package com.amtf.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.f020001Dao;
import com.amtf.demo.entityin.F020001entityIn;
import com.amtf.demo.entityout.F020001entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010001entity.f010001_select1entity;
import com.amtf.demo.f020002entity.f020001_select1entity;
import com.amtf.demo.service.f020001Service;
import com.amtf.demo.user.LogInFo;
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

		entityOut.setImgPath(imgpath);

		List<f010001_select1entity> select1 = f020001dao.f020001_Select1(loginfo.getUser_power());

		List<f020001_select1entity> select1_view = new ArrayList<f020001_select1entity>();

		for (int i = 0; i < select1.size(); i++) {
			f020001_select1entity f02_select = new f020001_select1entity();
			f02_select.setUser_Account(select1.get(i).getUser_Account());

			f02_select.setUser_Attestation(select1.get(i).getUser_Attestation());

			f02_select.setUser_FH(select1.get(i).getUser_FH());

			f02_select.setUser_HomeAddress(select1.get(i).getUser_HomeAddress());

			f02_select.setUser_id(select1.get(i).getUser_id());

			f02_select.setUser_Name(select1.get(i).getUser_Name());

			f02_select.setUser_Phone(select1.get(i).getUser_Phone());

			f02_select.setUser_power(select1.get(i).getUser_power());

			String path = ImgUtil.getImgPath(select1.get(i).getUser_Phone());

			f02_select.setUser_path(path);

			select1_view.add(f02_select);
		}

		entityOut.setSelect1(select1_view);

		return entityOut;
	}

	@Override
	public F020001entityOut service02(F020001entityIn entityin) throws ErrListException {
		F020001entityOut entityOut = new F020001entityOut();

		return entityOut;
	}

	@Override
	public F020001entityOut service03(F020001entityIn entityin) throws ErrListException {
		F020001entityOut entityOut = new F020001entityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = (LogInFo) request.getSession().getAttribute("loginfo");

		List<f010001_select1entity> select1 = f020001dao.f020001_Select2(loginfo.getUser_power(),
				entityin.getSearch_name());

		List<f020001_select1entity> select1_view = new ArrayList<f020001_select1entity>();

		for (int i = 0; i < select1.size(); i++) {
			f020001_select1entity f02_select = new f020001_select1entity();
			f02_select.setUser_Account(select1.get(i).getUser_Account());

			f02_select.setUser_Attestation(select1.get(i).getUser_Attestation());

			f02_select.setUser_FH(select1.get(i).getUser_FH());

			f02_select.setUser_HomeAddress(select1.get(i).getUser_HomeAddress());

			f02_select.setUser_id(select1.get(i).getUser_id());

			f02_select.setUser_Name(select1.get(i).getUser_Name());

			f02_select.setUser_Phone(select1.get(i).getUser_Phone());

			f02_select.setUser_power(select1.get(i).getUser_power());

			String path = ImgUtil.getImgPath(select1.get(i).getUser_Phone());

			f02_select.setUser_path(path);

			select1_view.add(f02_select);
		}

		entityOut.setSelect1(select1_view);

		return entityOut;
	}
}
