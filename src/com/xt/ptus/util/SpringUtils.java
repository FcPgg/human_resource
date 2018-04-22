package com.xt.ptus.util;

public class SpringUtils {
	 /**
	  * @Descrption : 获取当前web工程部署路径并找到config文件夹
	  * @return :String有则返回否则空
	  * @Version：1.0
	  * @Date：2012-6-8
	  * @Author：lixw
	  */
	 public static String getWEBINFOPath(){
	  String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	  if (!StringUtil.IsNullOrEmpty(path)) {
		  path=path.replace('/', '\\'); // 将/换成\  
		  path=path.replace("file:", ""); //去掉file:  
		  path=path.replace("classes\\", ""); //去掉class\  
		  path=path.substring(1); //去掉第一个\,如 \D:\JavaWeb..
	  } else {
		  path = "";
	  }
	  return path;
	 }
}
