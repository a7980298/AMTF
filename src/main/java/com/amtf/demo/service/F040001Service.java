package com.amtf.demo.service;

import com.amtf.demo.entityin.F040001EntityIn;
import com.amtf.demo.entityout.F040001EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F040001Service {

	public F040001EntityOut service01(F040001EntityIn entityin) throws ErrListException;
	public F040001EntityOut service02(F040001EntityIn entityin) throws ErrListException;
}
