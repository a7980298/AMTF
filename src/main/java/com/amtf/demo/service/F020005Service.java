package com.amtf.demo.service;

import com.amtf.demo.entityin.F020005EntityIn;
import com.amtf.demo.entityout.F020005EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F020005Service {

	public F020005EntityOut service01(F020005EntityIn entityin) throws ErrListException;

	public F020005EntityOut service02(F020005EntityIn entityin) throws ErrListException;
}
