package com.amtf.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.commonDao;
import com.amtf.demo.dao.f020001Dao;
import com.amtf.demo.entityin.F020001entityIn;
import com.amtf.demo.entityout.F020001entityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010001entity.f010001_select1entity;
import com.amtf.demo.f020001entity.f020001_select1entity;
import com.amtf.demo.f020001entity.f020001_select2entityIn;
import com.amtf.demo.f020001entity.f020001_select5entity;
import com.amtf.demo.service.f020001Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.DownLoad;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.NumberUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.RedisUtils;

import jp.co.adv.excelcreator.creator.XlsxCreator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class f020001ServiceImpl implements f020001Service {

	@Autowired
	private final f020001Dao f020001dao;

	@Autowired
	private final commonDao commondao;

	@Resource
	private RedisUtils redisUtils;

	@Autowired
	HttpServletResponse response;

	/**
	 * 初始化
	 */
	@Override
	public F020001entityOut service01(F020001entityIn entityin) throws ErrListException {

		F020001entityOut entityOut = new F020001entityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		String imgpath = ImgUtil.getImgPath(loginfo.getUser_email());

		loginfo.setImgpath(imgpath);

		List<f010001_select1entity> select1 = f020001dao.f020001_Select1(loginfo.getUser_power());

		List<f020001_select1entity> select1_view = new ArrayList<f020001_select1entity>();

		for (int i = 0; i < select1.size(); i++) {
			f020001_select1entity f02_select = new f020001_select1entity();
			// 賬戶
			f02_select.setUser_account(select1.get(i).getUser_account());
			// 是否认证
			f02_select.setUser_attestation(select1.get(i).getUser_attestation());
			// 用户id
			f02_select.setUser_id(select1.get(i).getUser_id());
			// 姓名
			f02_select.setUser_name(select1.get(i).getUser_name());
			// 电话
			f02_select.setUser_phone(select1.get(i).getUser_phone());
			// 权限
			f02_select.setUser_power(select1.get(i).getUser_power());
			// 郵箱
			f02_select.setUser_email(select1.get(i).getUser_email());

			String path = ImgUtil.getImgPath(select1.get(i).getUser_email());

			f02_select.setUser_path(path);

			select1_view.add(f02_select);
		}

		List<f020001_select5entity> select5 = f020001dao.f020001_Select5(loginfo.getUser_email());

		entityOut.setSelect5(select5);

		entityOut.setLogInFo(loginfo);

		entityOut.setSelect1(select1_view);

		entityOut.setAdmin(ParameterUtil.getAdmin());

		String online = redisUtils.get("redis_key");

		entityOut.setOnline(online);

		return entityOut;
	}

	@Override
	public F020001entityOut service02(F020001entityIn entityin) throws ErrListException {
		F020001entityOut entityOut = new F020001entityOut();

		return entityOut;
	}

	@Override
	public F020001entityOut service03(F020001entityIn entityin) throws ErrListException {
		F020001entityOut entityOut = new F020001entityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		f020001_select2entityIn selecentityIn = new f020001_select2entityIn();
		selecentityIn.setPow(loginfo.getUser_power());
		selecentityIn.setSearch_account(entityin.getSearch_account());
		selecentityIn.setSearch_name(entityin.getSearch_name());
		selecentityIn.setSearch_phone(entityin.getSearch_phone());
		selecentityIn.setSelect_state(entityin.getSelect_state());

		List<f010001_select1entity> select1 = f020001dao.f020001_Select2(selecentityIn);

		List<f020001_select1entity> select1_view = new ArrayList<f020001_select1entity>();

		for (int i = 0; i < select1.size(); i++) {
			f020001_select1entity f02_select = new f020001_select1entity();

			f02_select.setUser_account(select1.get(i).getUser_account());

			f02_select.setUser_attestation(select1.get(i).getUser_attestation());

			f02_select.setUser_id(select1.get(i).getUser_id());

			f02_select.setUser_name(select1.get(i).getUser_name());

			f02_select.setUser_phone(select1.get(i).getUser_phone());

			f02_select.setUser_power(select1.get(i).getUser_power());

			String path = ImgUtil.getImgPath(select1.get(i).getUser_email());

			f02_select.setUser_path(path);

			select1_view.add(f02_select);
		}

		entityOut.setSelect1(select1_view);

		return entityOut;
	}

	/**
	 * 发布通知
	 */
	@Override
	public F020001entityOut service04(F020001entityIn entityin) throws ErrListException {
		F020001entityOut entityOut = new F020001entityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		try {
			f020001dao.f020001_insert3(
					CommonUtil.isEmpty(commondao.common_Select2()) ? 0 : commondao.common_Select2() + 1,
					loginfo.getUser_email(), entityin.getRelease_head(), entityin.getRelease_name());
		} catch (Exception e) {
			throw new ErrListException(entityin, entityin.getIViewId(), "发布通知时出现错误!");
		}
		return entityOut;
	}

	/**
	 * 生成Excel
	 */
	@Override
	public F020001entityOut service05(F020001entityIn entityin) throws ErrListException {
		F020001entityOut entityOut = new F020001entityOut();
		String filename = "excel1.xlsx";
		XlsxCreator xlsxCreator = new XlsxCreator();
		/**
		 * PDF ファイルを出力する
		 * 
		 * 単一excelが存在すること
		 */
		// r00501001_classhyo.xlsx と r00514001_passhyo.pdf を出力します。
		xlsxCreator.openBook("C:\\amtf_excel\\" + filename, "C:\\amtf_excel\\" + "excel1.xlsx");
		xlsxCreator.getPdf().setTitle("進級テスト結果通知書");
		xlsxCreator.getPdf().setProducer("ver 1.0");
		// C ドライブに r00501001_classhyo.pdf を出力します。
		String name = filename.replace("xlsx", "pdf");
		// xlsxCreator.copySheet(0, 1, "クラス名簿" + (i + 1));
		// xlsxCreator.setSheetNo(i);
		xlsxCreator.getCell("D3").setValue("1");
		// 出力処理を実行する
		xlsxCreator.closeBook(true, "C:\\amtf_excel\\" + name, "", false);

		DownLoad.doPost("C:\\amtf_excel\\" + name);
		return entityOut;
	}

	/**
	 * 刪除指定userid的數據
	 * 
	 * @param entityin
	 * @return
	 * @throws ErrListException
	 */
	@Override
	public F020001entityOut service06(F020001entityIn entityin) throws ErrListException {
		F020001entityOut entityOut = new F020001entityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		// 刪除指定用戶
		int delect4 = f020001dao.f020001_Delect4(entityin.getUserid());
		// 沒有刪除成功
		if (delect4 <= 0) {
			throw new ErrListException(entityin, entityin.getIViewId(), "刪除數據時發生錯誤！");
		}
		// 重新獲取用戶數據
		List<f010001_select1entity> select1 = f020001dao.f020001_Select1(loginfo.getUser_power());

		List<f020001_select1entity> select1_view = new ArrayList<f020001_select1entity>();

		for (int i = 0; i < select1.size(); i++) {
			f020001_select1entity f02_select = new f020001_select1entity();
			// 賬戶
			f02_select.setUser_account(select1.get(i).getUser_account());
			// 是否认证
			f02_select.setUser_attestation(select1.get(i).getUser_attestation());
			// 用户id
			f02_select.setUser_id(select1.get(i).getUser_id());
			// 姓名
			f02_select.setUser_name(select1.get(i).getUser_name());
			// 电话
			f02_select.setUser_phone(select1.get(i).getUser_phone());
			// 权限
			f02_select.setUser_power(select1.get(i).getUser_power());
			// 郵箱
			f02_select.setUser_email(select1.get(i).getUser_email());
			// 照片路徑
			String path = ImgUtil.getImgPath(select1.get(i).getUser_email());

			f02_select.setUser_path(path);

			select1_view.add(f02_select);
		}
		// 用戶數據
		entityOut.setLogInFo(loginfo);
		// 查詢用戶數據
		entityOut.setSelect1(select1_view);

		return entityOut;
	}

	/**
	 * 活动发布
	 */
	@Override
	public F020001entityOut service07(F020001entityIn entityin) throws ErrListException {
		F020001entityOut entityOut = new F020001entityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();
		// 图片上传
		Integer activity_idInteger = CommonUtil.isEmpty(commondao.common_Select3()) ? 0
				: commondao.common_Select3() + 1;
		ImgUtil.activity_CommitImg(entityin.getActivity_img1(), activity_idInteger + "-1");
		ImgUtil.activity_CommitImg(entityin.getActivity_img2(), activity_idInteger + "-2");
		ImgUtil.activity_CommitImg(entityin.getActivity_img3(), activity_idInteger + "-3");
		ImgUtil.activity_CommitImg(entityin.getActivity_img4(), activity_idInteger + "-4");
		ImgUtil.activity_CommitImg(entityin.getActivity_img5(), activity_idInteger + "-5");
		// 添加活动
		int insert6 = f020001dao.f020001_insert6(activity_idInteger, loginfo.getUser_email(),
				entityin.getActivity_head(), entityin.getActivity_check(),
				NumberUtil.toInt(entityin.getActivity_sttymd().replace("/", "")),
				NumberUtil.toInt(entityin.getActivity_endymd().replace("/", "")), entityin.getActivity_editor());

		if (insert6 <= 0) {
			entityOut.setIsactivity(Constant.STR_1);
		}
		return entityOut;
	}
}
