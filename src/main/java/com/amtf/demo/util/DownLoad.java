package com.amtf.demo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class DownLoad {
	
	public static void getExcel(String path,HSSFWorkbook workbook) {
		// 获得Excel文件输出流
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(new File("C:/excel/" + path));
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
