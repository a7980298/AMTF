package com.amtf.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.CommonDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DaoUtil {

	@Autowired
	private static CommonDao commdao;

	/**
	 * 获取Userid
	 */
	public static int getUserMaxId() {
		int maxid = commdao.common_Select1();
		return maxid;
	}
}
