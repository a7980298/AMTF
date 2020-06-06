package com.amtf.demo.service;

import javax.servlet.http.HttpServletRequest;

import com.amtf.demo.entityin.F010001entityIn;
import com.amtf.demo.entityout.F01001entityOut;
import com.amtf.demo.exception.ErrListException;

public interface f010001Service {

	public F01001entityOut service01(F010001entityIn entityin, HttpServletRequest request) throws ErrListException;

}
