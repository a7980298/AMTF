package com.amtf.demo.serviceImpl;

import com.amtf.demo.commonentity.AmtfQaEntity;
import com.amtf.demo.dao.CommonDao;
import com.amtf.demo.f060001entity.F060001_Select3Entity;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.F060001Dao;
import com.amtf.demo.entityin.F060001EntityIn;
import com.amtf.demo.entityout.F060001EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F060001Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class F060001ServiceImpl implements F060001Service {

	@Autowired
	private final F060001Dao f060001dao;

	@Autowired
	private final CommonDao commondao;

	/**
	 * 初始化
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F060001EntityOut service01(F060001EntityIn entityin) throws ErrListException {
		F060001EntityOut entityout = new F060001EntityOut();
		// 获取标签类型
		entityout.setQa_class_lists(f060001dao.f060001_Select2());

		// 获取最新问题
		List<F060001_Select3Entity> select3 = f060001dao.f060001_Select3();
		for (F060001_Select3Entity select3entity: select3) {
			//获取头像
			select3entity.setUser_img(ImgUtil.getImgPath(select3entity.getUser_id()));
		}
		entityout.setSelect3(select3);
		return entityout;
	}

	/**
	 * 发布问题
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F060001EntityOut service02(F060001EntityIn entityin) throws ErrListException {
		F060001EntityOut entityout = new F060001EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		AmtfQaEntity insert1in = new AmtfQaEntity();
		//id
		insert1in.setQa_id(CommonUtil.isEmpty(commondao.common_Select10()) ? 0 : commondao.common_Select10() + 1);
		//标题
		insert1in.setQa_head(entityin.getSubmitjson().getString("head"));
		//内容
		insert1in.setQa_text(entityin.getSubmitjson().getString("text"));
		String [] classs=entityin.getSubmitjson().getString("get_class").split(",");
		//标签1
		insert1in.setQa_class1(classs.length > 1 ? classs[0] : "");
		//标签3
		insert1in.setQa_class2(classs.length > 2 ? classs[1] : "");
		//标签3
		insert1in.setQa_class3(classs.length > 3 ? classs[2] : "");
		//发布人
		insert1in.setUser_id(loginfo.getUser_email());
		//发布问题添加
		int insert1 = f060001dao.f060001_Insert1(insert1in);

		entityout.setInsert1(insert1);

		return entityout;
	}
}
