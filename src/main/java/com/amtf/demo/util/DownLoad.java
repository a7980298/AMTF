package com.amtf.demo.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.amtf.demo.entityin.F020001entityIn;
import com.amtf.demo.entityout.F020001entityOut;
import com.amtf.demo.exception.ErrListException;

public class DownLoad {

	@Autowired
	static HttpServletResponse response;

	@Resource
	private static HttpServletResponse resp;

	public static void getExcel(String path, Workbook workbook) {
		// 获得Excel文件输出流
		FileOutputStream out = null;
		FileInputStream inp = null;
		// 让浏览器下载文件,name是上述默认文件下载名
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.addHeader("Content-Disposition", "attachment;filename=\"" + path + ".xlsx\"");
		try {

			out = new FileOutputStream(new File("C:/amtf_excel/" + path + ".xlsx"));
			inp = new FileInputStream(new File("C:/amtf_excel/" + path + ".xlsx"));
			response.setHeader("Content-Length", inp.available() + ""); // 内容长度
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.addHeader("Content-Disposition", "attachment;filename=fileName" + ".xlsx");
			response.setHeader("Content-Length", String.valueOf(inp.getChannel().size())); // 如果没有此行代码，打开excel文件时，会提示“发现不可读取的内容，是否继续”
			workbook.write(out);
			// 关流
			out.close();
		} catch (Exception e) {
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
	}

	/**
	 * 生成Excel示例Service
	 */
	public F020001entityOut service05(F020001entityIn entityin) throws ErrListException {
		F020001entityOut entityOut = new F020001entityOut();
		// 1:创建一个excel文档
		Workbook workbook = new XSSFWorkbook();
		// 2:创建一个sheet工作表
		Sheet sheet = workbook.createSheet("sleet1");
		// 创建表头
		Row row1 = sheet.createRow(0);
		// 创建表头的单元格-------------------------------
		Cell cell1_1 = row1.createCell(0);
		cell1_1.setCellValue("学号");
		Cell cell1_2 = row1.createCell(1);
		cell1_2.setCellValue("姓名");
		Cell cell1_3 = row1.createCell(2);
		cell1_3.setCellValue("年级");
		Cell cell1_4 = row1.createCell(3);
		cell1_4.setCellValue("年龄");
		Cell cell1_5 = row1.createCell(4);
		cell1_5.setCellValue("性别");
		// --------------------------------------------
		// 写入一行内容：
		Row row2 = sheet.createRow(1);
		Cell cell2_1 = row2.createCell(0);
		cell2_1.setCellValue(1);
		Cell cell2_2 = row2.createCell(1);
		cell2_2.setCellValue("阿荣");
		Cell cell2_3 = row2.createCell(2);
		cell2_3.setCellValue("17(3)");
		Cell cell2_4 = row2.createCell(3);
		cell2_4.setCellValue(20);
		Cell cell2_5 = row2.createCell(4);
		cell2_5.setCellValue("男");
		DownLoad.getExcel("excel1", workbook);
		response.setHeader("getpdf", "111");

		return entityOut;
	}

	/**
	 * ファイルをダウンロード出力処理
	 * 
	 * ホームページからファイルをダウンロードするサービスです。
	 */
	public synchronized static void doPost(String url) {
		DataInputStream in = null;
		OutputStream out = null;
		try {
			// ファイルコードがUTF-8を設定すること
			String filename = url.substring(url.lastIndexOf("/") + 1);
			in = new DataInputStream(new FileInputStream(new File(url)));
			out = resp.getOutputStream();
			URLEncoder.encode(filename, "UTF-8");
			resp.setCharacterEncoding("UTF-8");
			resp.setHeader("Content-disposition", "attachment; filename=" + filename);
			resp.setContentType("application/msexcel");
			// 元ファイルのローカルパス
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			// キャッシュをクリア
			out.flush();
			// Streamを閉じる
			out.close();
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				OutputStreamWriter writer = new OutputStreamWriter(resp.getOutputStream(), "UTF-8");
				String data = "<script language='javascript'>alert(\"\\u64cd\\u4f5c\\u5f02\\u5e38\\uff01\");</script>";
				writer.write(data);
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			// キャッシュをクリア
			if (!CommonUtil.isEmpty(out)) {
				try {
					out.flush();
					// Streamを閉じる
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (!CommonUtil.isEmpty(in)) {
				try {
					// inを閉じる
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
