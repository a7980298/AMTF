package com.amtf.demo.service;

import com.amtf.demo.entityin.F010001EntityIn;
import com.amtf.demo.entityout.F010001EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F010001Service {

	public F010001EntityOut service01(F010001EntityIn entityin) throws ErrListException;

	public F010001EntityOut service02(F010001EntityIn entityin) throws ErrListException;

	public F010001EntityOut service03(F010001EntityIn entityin) throws ErrListException;

}
