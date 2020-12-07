package com.amtf.demo.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import com.amtf.demo.util.Constant;
import com.amtf.demo.util.VideoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.entityin.F040001EntityIn;
import com.amtf.demo.entityout.F040001EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F040001Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F040001ServiceImpl implements F040001Service {

	@Autowired
	HttpServletRequest request;

	/**
	 * 初始化
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F040001EntityOut service01(F040001EntityIn entityin) throws ErrListException {
		F040001EntityOut entityOut = new F040001EntityOut();
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
