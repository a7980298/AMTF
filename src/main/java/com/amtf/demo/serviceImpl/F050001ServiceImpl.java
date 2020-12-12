package com.amtf.demo.serviceImpl;

import com.amtf.demo.commonentity.AmtfNewsEntity;
import com.amtf.demo.dao.F050001Dao;
import com.amtf.demo.dao.F060001Dao;
import com.amtf.demo.entityin.F040001EntityIn;
import com.amtf.demo.entityin.F050001EntityIn;
import com.amtf.demo.entityout.F040001EntityOut;
import com.amtf.demo.entityout.F050001EntityOut;
import com.amtf.demo.entityout.F060001EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f050001entity.F050001_Select1Entity;
import com.amtf.demo.f060001entity.F060001_Select3Entity;
import com.amtf.demo.service.F040001Service;
import com.amtf.demo.service.F050001Service;
import com.amtf.demo.util.DateUtil;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class F050001ServiceImpl implements F050001Service {

	@Autowired
	HttpServletRequest request;

	@Autowired
	private final F050001Dao f050001dao;

	/**
	 * 初始化
	 *
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F050001EntityOut service01(F050001EntityIn entityin) throws ErrListException {
		F050001EntityOut entityout = new F050001EntityOut();


		List<AmtfNewsEntity> lists = f050001dao.f050001_Select1();
		List<F050001_Select1Entity> newsout = new ArrayList<F050001_Select1Entity>();
		for (AmtfNewsEntity newsEntity : lists) {
			F050001_Select1Entity out = new F050001_Select1Entity();
			out.setNews_name(newsEntity.getNews_name());
			out.setNews_text(newsEntity.getNews_text());
			out.setNews_user(newsEntity.getNews_user());
			out.setNews_date(DateUtil.dateToStr(newsEntity.getNews_date(), DateUtil.DATE_TOSTR3));
			newsout.add(out);
		}
		// 获取新闻信息(将SQL语句查询到的信息通过一个List传给实体类entityout)
		entityout.setNews_list(newsout);
		return entityout;
	}
}