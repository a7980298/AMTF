package com.amtf.demo.serviceImpl;

import com.amtf.demo.commonentity.AmtfUserAttentionEntity;
import com.amtf.demo.commonentity.AmtfUserEntity;
import com.amtf.demo.dao.CommonDao;
import com.amtf.demo.dao.F010011Dao;
import com.amtf.demo.entityin.F010011EntityIn;
import com.amtf.demo.entityout.F010011EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010005entity.F010005_Select1Entity;
import com.amtf.demo.f010011entity.F010011_Select5Entity;
import com.amtf.demo.service.F010005Service;
import com.amtf.demo.service.F010011Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.ParameterUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

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
		String imgpath = ImgUtil.getImgPath(select1.getUser_no());
		select1.setImgpath(imgpath);
		entityout.setSelect1(select1);

		//查看是否关注该发布人
		entityout.setAttention(f010011dao.f010011_Select2(select1.getUser_no(),loginfo.getUser_no()));
		// 发布人的活动
		entityIn.setPageNum(Constant.INT_0);
		entityIn.setAttention_id(select1.getUser_no());
		entityout.setSelect5(this.service03(entityIn).getSelect5());

		//热门活动
		List<F010011_Select5Entity> select6 = f010011dao.f010011_Select6(select1.getUser_no());
		entityout.setSelect6(select6);

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
		//关注用户id
		amtfuserattentionentity.setAttention_id(entityin.getAttention_id());
		//用户id
		amtfuserattentionentity.setUser_id(loginfo.getUser_no());
		//查看是否关注了该发布人
		if(f010011dao.f010011_Select2(entityin.getAttention_id(),loginfo.getUser_no()) < 1){
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

	/**
	 * 发布人的活动
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F010011EntityOut service03(F010011EntityIn entityin) throws ErrListException {
		F010011EntityOut entityout = new F010011EntityOut();
		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 发布人的活动
		PageHelper.startPage(entityin.getPageNum(),Constant.PAGESIZE10);
		List<F010011_Select5Entity> select5 = f010011dao.f010011_Select5(entityin.getAttention_id());
		select5.removeAll(Collections.singleton(null));
		if(!CommonUtil.isEmptyList(select5)) {
			for (F010011_Select5Entity select5entity : select5) {
				if(!CommonUtil.isEmpty(select5entity.getActivity_sttymd()) && select5entity.getActivity_sttymd().length() == 8){
					select5entity.setActivity_sttymd(select5entity.getActivity_sttymd().substring(0, 4) + "-"
							+ select5entity.getActivity_sttymd().substring(4, 6) + "-"
							+ select5entity.getActivity_sttymd().substring(6, 8));
				}
				if(!CommonUtil.isEmpty(select5entity.getActivity_endymd()) && select5entity.getActivity_endymd().length() == 8){
					select5entity.setActivity_endymd(select5entity.getActivity_endymd().substring(0, 4) + "-"
							+ select5entity.getActivity_endymd().substring(4, 6) + "-"
							+ select5entity.getActivity_endymd().substring(6, 8));
				}
				if(select5entity.getActivity_text().contains("<img")){
					// 封面图片筛选
					int stt_index = select5entity.getActivity_text().indexOf("<img");
					String cverImg = select5entity.getActivity_text().substring(stt_index, select5entity.getActivity_text().length());
					int src_index = cverImg.indexOf(" src=\"");
					cverImg = cverImg.substring(src_index + 6, cverImg.length());
					int end_index = cverImg.indexOf("\"");
					cverImg = cverImg.substring(0, end_index);
					cverImg = cverImg.replace("/amtf/wangactivityimg/",Constant.EMPTY);
					cverImg = cverImg.substring(0,cverImg.indexOf("."));
					String getimgpath = ImgUtil.getImgPath(Constant.PATH_WANGEDITO_ACTIVITYIMG,cverImg);
					select5entity.setCover_img(getimgpath == Constant.EMPTY ? Constant.EMPTY : "/amtf/wangactivityimg/" + getimgpath);
				}
				// 删除html标签
				String cvertext = CommonUtil.getTextForty(select5entity.getActivity_text());
				select5entity.setCover_text(cvertext);
			}
			select5.removeAll(Collections.singleton(null));
			select5.sort((F010011_Select5Entity obj1, F010011_Select5Entity obj2) ->
					obj2.getCount() - obj1.getCount());
			PageInfo<F010011_Select5Entity> pageInfo = new PageInfo<>(select5);
			entityout.setSelect5(pageInfo);
		}
		return entityout;
	}


}
