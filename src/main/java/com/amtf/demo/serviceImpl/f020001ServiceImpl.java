package com.amtf.demo.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import com.amtf.demo.util.ImgUtil;
import com.amtf.demo.util.NumberUtil;
import com.amtf.demo.util.ParameterUtil;
import com.amtf.demo.util.RedisUtils;

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
	 * 生成pdf
	 */
	@Override
	public F020001entityOut service05(F020001entityIn entityin) throws ErrListException {
		F020001entityOut entityOut = new F020001entityOut();
		// 获得Excel文件输出流
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(new File("C:/excel/excel.pdf"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// 1:创建一个excel文档
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 2:创建一个sheet工作表
		HSSFSheet sheet = workbook.createSheet("sleet1");
		// 创建表头
		HSSFRow row1 = sheet.createRow(0);
		// 创建表头的单元格-------------------------------
		HSSFCell cell1_1 = row1.createCell(0);
		cell1_1.setCellValue("学号");
		HSSFCell cell1_2 = row1.createCell(1);
		cell1_2.setCellValue("姓名");
		HSSFCell cell1_3 = row1.createCell(2);
		cell1_3.setCellValue("年级");
		HSSFCell cell1_4 = row1.createCell(3);
		cell1_4.setCellValue("年龄");
		HSSFCell cell1_5 = row1.createCell(4);
		cell1_5.setCellValue("性别");
		// --------------------------------------------
		// 写入一行内容：
		HSSFRow row2 = sheet.createRow(1);
		HSSFCell cell2_1 = row2.createCell(0);
		cell2_1.setCellValue(1);
		HSSFCell cell2_2 = row2.createCell(1);
		cell2_2.setCellValue("阿荣");
		HSSFCell cell2_3 = row2.createCell(2);
		cell2_3.setCellValue("17(3)");
		HSSFCell cell2_4 = row2.createCell(3);
		cell2_4.setCellValue(20);
		HSSFCell cell2_5 = row2.createCell(4);
		cell2_5.setCellValue("男");

		// 输出excel的错误形式：
		// out.write(fs.getBytes(), 0, fs.getBytes().length);
		// 正确形式：
		try {
			workbook.write(out);
			out.flush();
			// 关流
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		response.setHeader("getpdf", "111");

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
