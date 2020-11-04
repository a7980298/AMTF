package com.amtf.demo.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtf.demo.dao.CommonDao;
import com.amtf.demo.dao.F020001Dao;
import com.amtf.demo.entityin.F020001EntityIn;
import com.amtf.demo.entityout.F020001EntityOut;
import com.amtf.demo.exception.ErrListException;
import com.amtf.demo.f010001entity.F010001_Select1Entity;
import com.amtf.demo.f020001entity.F020001_Select1Entity;
import com.amtf.demo.f020001entity.F020001_Select2EntityIn;
import com.amtf.demo.f020001entity.F020001_Select5Entity;
import com.amtf.demo.f020001entity.F020001_Select7Entity;
import com.amtf.demo.service.F020001Service;
import com.amtf.demo.user.LogInFo;
import com.amtf.demo.util.CommonUtil;
import com.amtf.demo.util.Constant;
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.NumberUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.RedisUtils;
import com.amtf.demo.util.StringUtil;

import io.goeasy.GoEasy;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class F020001ServiceImpl implements F020001Service {

	@Autowired
	private final F020001Dao f020001dao;

	@Autowired
	private final CommonDao commondao;

	@Resource
	private RedisUtils redisUtils;

	@Autowired
	HttpServletResponse response;

	@Autowired
	DownLoad download;

	/**
	 * 初始化
	 */
	@Override
	public F020001EntityOut service01(F020001EntityIn entityin) throws ErrListException {

		F020001EntityOut entityOut = new F020001EntityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		String imgpath = ImgUtil.getImgPath(loginfo.getUser_email());

		loginfo.setImgpath(imgpath);

		List<F010001_Select1Entity> select1 = f020001dao.f020001_Select1(NumberUtil.toInt(loginfo.getUser_power()));

		List<F020001_Select1Entity> select1_view = new ArrayList<F020001_Select1Entity>();

		for (int i = 0; i < select1.size(); i++) {
			F020001_Select1Entity f02_select = new F020001_Select1Entity();
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
			f02_select.setUser_power(StringUtil.toStr(select1.get(i).getUser_power()));
			// 郵箱
			f02_select.setUser_email(select1.get(i).getUser_email());

			String path = ImgUtil.getImgPath(select1.get(i).getUser_email());

			f02_select.setUser_path(path);

			select1_view.add(f02_select);
		}

		List<F020001_Select5Entity> select5 = f020001dao.f020001_Select5(loginfo.getUser_email());

		entityOut.setSelect5(select5);

		entityOut.setLogInFo(loginfo);

		entityOut.setSelect1(select1_view);

		entityOut.setAdmin(ParameterUtil.getAdmin());

		String[] online = redisUtils.get("redis_key").split(",");

		entityOut.setOnline(StringUtil.toStr(online.length));

		return entityOut;
	}

	@Override
	public F020001EntityOut service02(F020001EntityIn entityin) throws ErrListException {
		F020001EntityOut entityOut = new F020001EntityOut();

		return entityOut;
	}

	/**
	 * 查看人員
	 */
	@Override
	public F020001EntityOut service03(F020001EntityIn entityin) throws ErrListException {
		F020001EntityOut entityOut = new F020001EntityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		F020001_Select2EntityIn selecentityIn = new F020001_Select2EntityIn();
		selecentityIn.setPow(NumberUtil.toInt(loginfo.getUser_power()));
		selecentityIn.setSearch_account(entityin.getSearch_account());
		selecentityIn.setSearch_name(entityin.getSearch_name());
		selecentityIn.setSearch_phone(entityin.getSearch_phone());
		selecentityIn.setSelect_state(entityin.getSelect_state());

		List<F010001_Select1Entity> select1 = f020001dao.f020001_Select2(selecentityIn);

		List<F020001_Select1Entity> select1_view = new ArrayList<F020001_Select1Entity>();

		for (int i = 0; i < select1.size(); i++) {
			F020001_Select1Entity f02_select = new F020001_Select1Entity();

			f02_select.setUser_account(select1.get(i).getUser_account());

			f02_select.setUser_attestation(select1.get(i).getUser_attestation());

			f02_select.setUser_id(select1.get(i).getUser_id());

			f02_select.setUser_name(select1.get(i).getUser_name());

			f02_select.setUser_phone(select1.get(i).getUser_phone());

			f02_select.setUser_power(StringUtil.toStr(select1.get(i).getUser_power()));

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
	public F020001EntityOut service04(F020001EntityIn entityin) throws ErrListException {
		F020001EntityOut entityOut = new F020001EntityOut();


		return entityOut;
	}

	/**
	 * 生成PDF
	 */
	@Override
	public F020001EntityOut service05(F020001EntityIn entityin) throws ErrListException {
		F020001EntityOut entityOut = new F020001EntityOut();
		String filename = "用户一览表.xlsx";
		XlsxCreator xlsxCreator = new XlsxCreator();
		// 第一个参数下载到的文件路径，第二个参数读取模板的文件路径
		xlsxCreator.openBook(Constant.PDF_EXCEL_DOWNLOAD + filename, Constant.PDF_EXCEL + "用户一览表.xlsx");
		xlsxCreator.getPdf().setTitle("用户一览表");
		xlsxCreator.getPdf().setProducer("ver 1.0");
		String name = filename.replace("xlsx", "pdf");
		// xlsxCreator.copySheet(0, 1, "クラス名簿" + (i + 1));
		// xlsxCreator.setSheetNo(i);
		xlsxCreator.getCell("E6").setValue("12313211");
		xlsxCreator.closeBook(true, Constant.PDF_EXCEL_DOWNLOAD + name, "", false);
		download.doPost(Constant.PDF_EXCEL_DOWNLOAD + name);
		try {
			response.setHeader("yes", new String(name.getBytes("utf-8"), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

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
	public F020001EntityOut service06(F020001EntityIn entityin) throws ErrListException {
		F020001EntityOut entityOut = new F020001EntityOut();

		LogInFo loginfo = new LogInFo();
		loginfo = ParameterUtil.getSession();

		// 刪除指定用戶
		int delect4 = f020001dao.f020001_Delect4(entityin.getUserid());
		// 沒有刪除成功
		if (delect4 <= 0) {
			throw new ErrListException(entityin, entityin.getIViewId(), "删除数据时发生错误!");
		}
		// 重新獲取用戶數據
		List<F010001_Select1Entity> select1 = f020001dao.f020001_Select1(NumberUtil.toInt(loginfo.getUser_power()));

		List<F020001_Select1Entity> select1_view = new ArrayList<F020001_Select1Entity>();

		for (int i = 0; i < select1.size(); i++) {
			F020001_Select1Entity f02_select = new F020001_Select1Entity();
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
			f02_select.setUser_power(StringUtil.toStr(select1.get(i).getUser_power()));
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
	public F020001EntityOut service07(F020001EntityIn entityin) throws ErrListException {
		F020001EntityOut entityOut = new F020001EntityOut();


		return entityOut;
	}
}
