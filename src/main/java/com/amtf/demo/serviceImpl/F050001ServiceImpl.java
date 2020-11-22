package com.amtf.demo.serviceImpl;

import com.amtf.demo.entityin.F040001EntityIn;
import com.amtf.demo.entityin.F050001EntityIn;
import com.amtf.demo.entityout.F040001EntityOut;
import com.amtf.demo.entityout.F050001EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F040001Service;
import com.amtf.demo.service.F050001Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class F050001ServiceImpl implements F050001Service {

	@Autowired
	HttpServletRequest request;

	/**
	 * 初始化
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F050001EntityOut service01(F050001EntityIn entityin) throws ErrListException {
		return null;
	}
}
