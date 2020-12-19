package com.amtf.demo.util;

import com.aliyun.oss.OSSClient;
import com.amtf.demo.dao.CommonDao;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class Aliyunoss {
	//你自己的endPoint
	private final String ENDPOINT = "endPoint";
	//shenzhen:认准自己的定位，是深圳，还是张家界之类的地方
	private final String BUCKET = "https://oss-cn-shenzhen.aliyuncs.com/";
	//你自己的bucketName
	private final String BUCKEY_NAME = "bucketName";
	//你自己的accessKeyId
	private final String ACCESSKEYID = "accessKeyId";
	//你自己的accessKeySecret
	private final String ACCESSKEYSECRET = "accessKeySecret";

	/**
	 * 保存文件进入阿里云的OSS
	 *
	 * @param file 上传的文件
	 * @return
	 * @throws Exception
	 */
	public String uploadAli(MultipartFile file, String folder) throws Exception {
		//生成文件名称
		String uuid = VideoUtil.getVideoFileName().toString();
		//获取真实文件名称 xxx.jpg
		String orgFileName = file.getOriginalFilename();
		//获取拓展名字.jpg
		String ext = "." + FilenameUtils.getExtension(orgFileName);
		//xxxxxsfsasa.jpg
		String fileName = folder + uuid + ext;

		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，
		// 请登录 https://ram.console.aliyun.com 创建。
		String accessKeyId = ACCESSKEYID;
		String accessKeySecret = ACCESSKEYSECRET;
		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(BUCKET, accessKeyId, accessKeySecret);
		// 上传文件流。
		ossClient.putObject(BUCKEY_NAME, fileName, file.getInputStream());
		// 关闭OSSClient。
		ossClient.shutdown();
		return ENDPOINT + fileName;
	}
}
