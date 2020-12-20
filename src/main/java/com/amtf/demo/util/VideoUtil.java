package com.amtf.demo.util;

import Decoder.BASE64Decoder;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

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
	// 图片上传
	public static String commitImg(MultipartFile file,String url) {
		return  commitView(file,url);
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
			dest = new File(filePath + suffixName);
			// 判断文件夹是否存在
			if (dest.getParentFile().exists()) {
				filetextbol = false;
				dest.delete();
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
			return (fileName + suffixName);
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

	public static String GenerateImage(String imgStr, String imgFilePath){
		if (imgStr == null){
			// 图像数据为空
			return "";
		}
		BASE64Decoder decoder = new BASE64Decoder();

		// Base64解码,对字节数组字符串进行Base64解码并生成图片
		imgStr = imgStr.replaceAll(" ", "+");
		System.out.println(imgStr);
		String dbUrl = "";
		try{
			byte[] b = decoder.decodeBuffer(imgStr.replace("data:image/jpeg;base64,", ""));
			for (int i = 0; i < b.length; ++i) {
				// 调整异常数据
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			String imgName = getVideoFileName()+".jpg";
			// 生成jpeg图片D:\test\attendance\src\main\webapp\assets\images\leave
			//新生成的图片
			imgFilePath = imgFilePath + imgName;
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			dbUrl = imgName;
		}catch (Exception e){
			e.printStackTrace();
		}
		return dbUrl;
	}
}
