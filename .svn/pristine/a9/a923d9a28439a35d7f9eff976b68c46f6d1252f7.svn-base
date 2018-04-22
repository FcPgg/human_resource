package com.xt.ptus.helper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.qiniu.http.Response;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;

public class QiNiuHelper {
	
	private static Logger logger = Logger.getLogger(QiNiuHelper.class);

	// 设置好账号的ACCESS_KEY和SECRET_KEY
	String ACCESS_KEY = ""; // 这两个登录七牛 账号里面可以找到
	String SECRET_KEY = "";

	// 要上传的空间
	String bucketname = ""; // 对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）

	public QiNiuHelper(String accessKey, String secretKey, String bucketName) {
		this.ACCESS_KEY = accessKey;
		this.SECRET_KEY = secretKey;
		this.bucketname = bucketName;
	}

	/**
	 *  普通上传
	 *  上传文件到七牛服务器
	 * @param in
	 * @param key
	 * @throws IOException
	 */
	public Response uploadFile(InputStream in, String key) throws IOException {
		Zone zone = Zone.autoZone();
		Configuration config = new Configuration(zone);
		Response res = null;
		// 密钥配置
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		// 创建上传对象
		UploadManager uploadManager = new UploadManager(config);

		try {
			// 调用put方法上传
			res = uploadManager.put(in, key, auth.uploadToken(bucketname), null, null);
			// 打印返回的信息
			logger.debug(res.bodyString());
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			logger.error(r.error);
		}
		return res;
	}

	public void getFileList(){
		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		//...其他参数参考类注释

		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		BucketManager bucketManager = new BucketManager(auth, cfg);

		//文件名前缀
		String prefix = "";
		//每次迭代的长度限制，最大1000，推荐值 1000
		int limit = 1000;
		//指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
		String delimiter = "";

		//列举空间文件列表
		BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucketname, prefix, limit, delimiter);
		while (fileListIterator.hasNext()) {
		    //处理获取的file list结果
		    FileInfo[] items = fileListIterator.next();
		    for (FileInfo item : items) {
		        System.out.println("key"+item.key);
		        System.out.println("hash"+item.hash);
		        System.out.println("fsize"+item.fsize);
		        System.out.println("mimeType"+item.mimeType);
		        System.out.println("putTime"+item.putTime);
		        System.out.println("endUser"+item.endUser);
		    }
		}
	}
	
	public String removeFile(String key){
		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		//...其他参数参考类注释

		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		BucketManager bucketManager = new BucketManager(auth, cfg);
		try {
		    bucketManager.delete(bucketname, key);
		    return "success";
		} catch (QiniuException ex) {
		    //如果遇到异常，说明删除失败
		    System.err.println(ex.code());
		    System.err.println(ex.response.toString());
		    return ex.response.toString();
		}
	}
	
	public static void main(String[] args) {
		QiNiuHelper helper = new QiNiuHelper("bn2WgRD0oZn2c6wjkm0EUJ00Fi0W9DJp7wen0f9G", "zs8UrROy86CNjwQAqzrSpbh9rsf8eVL_GlGr15Sg", "jdkxmarket");
		helper.removeFile("07804E2BEA0751E264A9EB6320444965.png");
		helper.getFileList();
	}
}
