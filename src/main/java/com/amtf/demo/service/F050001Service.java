package com.amtf.demo.service;

import com.amtf.demo.entityin.F050001EntityIn;
import com.amtf.demo.entityout.F050001EntityOut;
import com.amtf.demo.exception.ErrListException;

public interface F050001Service {
	// 初始画面检所出所有新闻
	public F050001EntityOut service01(F050001EntityIn entityin) throws ErrListException;
	// 根据关键字查数据
	public F050001EntityOut service02(F050001EntityIn entityin) throws ErrListException;
	// 新闻添加
	public F050001EntityOut service03(F050001EntityIn entityin) throws ErrListException;
}
