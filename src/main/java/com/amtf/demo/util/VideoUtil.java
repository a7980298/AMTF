package com.amtf.demo.util;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoUtil {

	// 视频格式
	final static String[] suffix = { ".mp4", ".3gp",".wmv",".avi",".dat",".asf",".mpeg",".mpg",".rm",".rmvb",".ram",".flv",".mov",".divx",".dv",".vob",".mkv"
			,".qt",".cpk",".fli",".flc",".f4v",".m4v",".mod",".m2t",".swf",".webm",".mts",".m2ts",".3g2",".mpe",".ts",".div",".lavf",".dirac"};

	// 获取视频地址
	public static String getVideoPath(String path,String name) {

		for (int i = 0; i < suffix.length; i++) {
			File file = new File(path + name + suffix[i]);
			if (file.exists()) {
				return name + suffix[i];
			}
		}
		return "";
	}

	// 视频上传
	public static String commitView(MultipartFile file,String url) {
		// 文件名
		String fileName = file.getOriginalFilename();
		if (!CommonUtil.isEmpty(fileName)) {
			// 后缀名
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			// 上传后的路径
			String filePath = url;

			// 随机一个文件名
			fileName = VideoUtil.getVideoFileName();

			filePath += fileName;

			boolean filetextbol = true;
			// 创建流
			File dest = null;
			for (int i = 0; i < suffix.length; i++) {
				dest = new File(filePath + suffix[i]);
				// 判断文件夹是否存在
				if (dest.getParentFile().exists()) {
					filetextbol = false;
					dest.delete();
				}
			}
			if (filetextbol) {
				dest = new File(filePath + suffixName);
				// 新建生成所有目录
				dest.getParentFile().mkdirs();
			}
			try {
				// 将上传文件写到服务器上指定的文件。
				file.transferTo(dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return getVideoPath(url,fileName);
		}
		return null;
	}

	public static String getVideoFileName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timeStr = sdf.format(new Date());
		String str = RandomStringUtils.random(5,
				"abcdefghijklmnopqrstuvwxyz1234567890");
		String name = timeStr + str;
		return name;
	}
}
