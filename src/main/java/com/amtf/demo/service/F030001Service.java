package com.amtf.demo.service;

import com.amtf.demo.entityin.F030001EntityIn;
import com.amtf.demo.entityout.F030001EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F030001Service {

	public F030001EntityOut service01(F030001EntityIn entityin) throws ErrListException;

	public F030001EntityOut service02(F030001EntityIn entityin) throws ErrListException;

	public F030001EntityOut service03(F030001EntityIn entityin) throws ErrListException;

	public F030001EntityOut service04(F030001EntityIn entityin) throws ErrListException;

}
