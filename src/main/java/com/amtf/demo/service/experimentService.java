package com.amtf.demo.service;

import javax.servlet.http.HttpServletRequest;

import com.amtf.demo.entityin.experimententityIn;
import com.amtf.demo.entityout.experimententityOut;
import com.amtf.demo.exception.ErrListException;

public interface experimentService {

	public experimententityOut service01(experimententityIn entityin, HttpServletRequest request)
			throws ErrListException;

	public experimententityOut service02(experimententityIn entityin) throws ErrListException;

}
