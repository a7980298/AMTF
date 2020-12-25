package com.amtf.demo.service;

import com.amtf.demo.commonentity.AmtfVideoEntity;
import com.amtf.demo.entityin.F040001EntityIn;
import com.amtf.demo.entityout.F040001EntityOut;
import com.amtf.demo.exception.ErrListException;

import java.util.List;

public interface F040001Service {

	public F040001EntityOut service01(F040001EntityIn entityin) throws ErrListException;

	public F040001EntityOut service02(F040001EntityIn entityin) throws ErrListException;

	public F040001EntityOut service03(F040001EntityIn entityin) throws ErrListException;

	public List<AmtfVideoEntity> videoLike(AmtfVideoEntity video,List<AmtfVideoEntity> list,boolean isbreak);

	public F040001EntityOut service04(F040001EntityIn entityin) throws ErrListException;

	public F040001EntityOut service05(F040001EntityIn entityin) throws ErrListException;

	public F040001EntityOut service06(F040001EntityIn entityin) throws ErrListException;

	public F040001EntityOut service07(F040001EntityIn entityin) throws ErrListException;

	public F040001EntityOut service08(F040001EntityIn entityin) throws ErrListException;

	public F040001EntityOut service09(F040001EntityIn entityin) throws ErrListException;

	public F040001EntityOut service10(F040001EntityIn entityin) throws ErrListException;
}
