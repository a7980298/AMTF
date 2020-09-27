package com.amtf.demo.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ImgUtil {

	// 图片格式
	final static String[] suffix = { ".jpg", ".png" };

	// 获取照片地址
	public static String getImgPath(String name) {

		for (int i = 0; i < suffix.length; i++) {
			File file = new File("C:/imgs/" + name + suffix[i]);
			if (file.exists()) {
				return name + suffix[i];
			}
		}
		return "";
	}

	// 获取照片地址
	public static String getImgPath(String path,String name) {

		for (int i = 0; i < suffix.length; i++) {
			File file = new File(path + name + suffix[i]);
			if (file.exists()) {
				return name + suffix[i];
			}
		}
		return "";
	}
	
	// 文件copy
	public static void CommitFile(String name) {
		File fileIn = new File(name);
		File fileOut = new File("C:\\imgs", fileIn.getName());
		try {
			// 创建字符输入流
			FileReader reader = new FileReader(fileIn);
			// 创建字符输出流
			FileWriter wreter = new FileWriter(fileOut);
			// 创建空间
			char[] c = new char[1024];
			// 定义结尾
			int i = 0;
			// 循环判断是否是最后一字节
			while ((i = reader.read(c)) != -1) {
				// 写入自定路径
				wreter.write(c, 0, i);
				// 刷新流
				wreter.flush();
			}
			// 关闭流
			wreter.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 图片上传
	public static void CommitImg(MultipartFile file, String isuser) {
		// 文件名
		String fileName = file.getOriginalFilename();
		if (!CommonUtil.isEmpty(fileName)) {
			// 后缀名
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			// 上传后的路径
			String filePath = "C://temp-rainy//";

			// 随机一个文件名
			fileName = UUID.randomUUID().toString();

			if (Constant.STR_1.equals(isuser)) {
				filePath = "C:/imgs/";
				fileName = ParameterUtil.getSession().getUser_email();
			} 

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
		}
	}
	
	// 图片上传
		public static void activity_CommitImg(MultipartFile file, String isuser) {
			// 文件名
			String fileName = file.getOriginalFilename();
			if (!CommonUtil.isEmpty(fileName)) {
				// 后缀名
				String suffixName = fileName.substring(fileName.lastIndexOf("."));
				// 上传后的路径
				String filePath = "C:/activity_imgs/";

				// 随机一个文件名
				fileName = ParameterUtil.getSession().getUser_email() + isuser;

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
			}
		}
}
