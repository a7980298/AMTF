package com.amtf.demo.serviceImpl;

import com.amtf.demo.commonentity.AmtfUserAttentionEntity;
import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.dao.CommonDao;
import com.amtf.demo.dao.F010011Dao;
import com.amtf.demo.entityin.F010011EntityIn;
import com.amtf.demo.entityout.F010011EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.service.F010005Service;
import com.amtf.demo.service.F010011Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class F010011ServiceImpl implements F010011Service {

	@Autowired
	private final F010011Dao f010011dao;

	@Autowired
	private final CommonDao commondao;

	/**
	 * 初期化
	 */
	@Override
	public F010011EntityOut service01(F010011EntityIn entityIn) throws ErrListException {
		F010011EntityOut entityout = new F010011EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		//获取主页信息
		AmtfUserEntity select1 = f010011dao.f010011_Select1(entityIn.getUser());
		String imgpath = ImgUtil.getImgPath(select1.getUser_email());
		select1.setImgpath(imgpath);
		entityout.setSelect1(select1);

		//查看是否关注该发布人
		entityout.setAttention(f010011dao.f010011_Select2(select1.getUser_email(),loginfo.getUser_email()));

		return entityout;
	}

	/**
	 * 关注发布人
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F010011EntityOut service02(F010011EntityIn entityin) throws ErrListException {
		F010011EntityOut entityout = new F010011EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		AmtfUserAttentionEntity amtfuserattentionentity= new AmtfUserAttentionEntity();
		//id
		amtfuserattentionentity.setUser_attention_id(CommonUtil.isEmpty(commondao.common_Select9()) ? 0 : commondao.common_Select9());
		//关注用户id
		amtfuserattentionentity.setAttention_id(entityin.getAttention_id());
		//用户id
		amtfuserattentionentity.setUser_id(loginfo.getUser_email());
		//查看是否关注了该发布人
		if(f010011dao.f010011_Select2(entityin.getAttention_id(),loginfo.getUser_email()) < 1){
			//没有关注
			Integer insert2 = f010011dao.f010011_Insert3(amtfuserattentionentity);
			if(insert2 < 1){
				entityout.setIsattention("insert0");
			} else {
				entityout.setIsattention("insert1");
			}
		} else {
			//关注了
			Integer delete3 = f010011dao.f010011_Delete4(amtfuserattentionentity);
			if(delete3 < 1){
				entityout.setIsattention("delete0");
			} else {
				entityout.setIsattention("delete1");
			}
		}
		return entityout;
	}
}
