package com.amtf.demo.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import com.amtf.demo.commonentity.AmtfVideoClassEntity;
import com.amtf.demo.dao.F040001Dao;
import com.amtf.demo.dao.F050001Dao;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.VideoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.entityin.F040001EntityIn;
import com.amtf.demo.entityout.F040001EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F040001Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class F040001ServiceImpl implements F040001Service {

	@Autowired
	HttpServletRequest request;

	@Autowired
	private final F040001Dao f040001dao;

	/**
	 * 初始化
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service01(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();

		// 获取视频标签分类
		List<AmtfVideoClassEntity> select1 = f040001dao.f040001_Select1();
		entityOut.setSelect1(select1);

		return entityOut;
	}

	/**
	 * 上传视频
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service02(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();

		VideoUtil.commitView(entityin.getCommit_video(), Constant.PATH_VIDEO_COMMIT);

		return entityOut;
	}
}
