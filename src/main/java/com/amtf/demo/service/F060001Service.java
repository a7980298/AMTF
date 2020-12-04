package com.amtf.demo.service;

import com.amtf.demo.entityin.F060001EntityIn;
import com.amtf.demo.entityout.F060001EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F060001Service {

	public F060001EntityOut service01(F060001EntityIn entityin) throws ErrListException;

	public F060001EntityOut service02(F060001EntityIn entityin) throws ErrListException;

	public F060001EntityOut service03(F060001EntityIn entityin) throws ErrListException;

	public F060001EntityOut service04(F060001EntityIn entityin) throws ErrListException;
}
