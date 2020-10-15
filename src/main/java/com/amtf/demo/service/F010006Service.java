package com.amtf.demo.service;

import com.amtf.demo.entityin.F010006EntityIn;
import com.amtf.demo.entityout.F010006EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F010006Service {

	public F010006EntityOut service01(F010006EntityIn entityin) throws ErrListException;

}
