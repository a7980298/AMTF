package com.amtf.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;

public class DownLoad {

	@Autowired
	static HttpServletResponse response;

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
}
