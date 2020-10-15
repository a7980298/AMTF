package com.amtf.demo.service;

import com.amtf.demo.entityin.F010005EntityIn;
import com.amtf.demo.entityout.F010005EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F010005Service {

	public F010005EntityOut service01(F010005EntityIn entityin) throws ErrListException;

	public F010005EntityOut service02(F010005EntityIn entityin) throws ErrListException;

}
