package com.amtf.demo.service;

import com.amtf.demo.entityin.F020006EntityIn;
import com.amtf.demo.entityout.F020006EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F020006Service {

	public F020006EntityOut service01(F020006EntityIn entityin) throws ErrListException;

	public F020006EntityOut service02(F020006EntityIn entityin) throws ErrListException;

	public F020006EntityOut service03(F020006EntityIn entityin) throws ErrListException;
}
