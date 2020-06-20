package com.amtf.demo.util;

import java.io.File;

public class ImgUtil {

	// 获取照片地址
	public static String getImgPath(String name) {
		String[] suffix = { ".jpg", ".png" };

		for (int i = 0; i < suffix.length; i++) {
			File file = new File("C:/imgs/" + name + suffix[i]);
			if (file.exists()) {
				return name + suffix[i];
			}
		}
		return "";
	}
}
