package com.xt.ptus.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ShowImageServlet extends HttpServlet  {
	 private static final String JPG = "image/jpeg;charset=GB2312";
	    
	    /**
	     * get方法
	     */
	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // 本地文件路径
	    	
			InputStream is = this.getClass().getResourceAsStream("/system.properties");
			Properties prop = new Properties();
			prop.load(is);
			is.close();
			String path = prop.getProperty("file.upload");
			
	        String filePath = null;
	       
	        if(request.getParameterMap().containsKey("fileType")){
	        	filePath = path + File.separator + request.getParameter("uuid") + "." + request.getParameter("fileType");
	        } else {
	        	filePath = path + File.separator + request.getParameter("uuid");
	        }
	        
	        File file = new File(filePath);
	        // 获取输出流
	        OutputStream outputStream = response.getOutputStream();
	        FileInputStream fileInputStream = new FileInputStream(file);
	        // 读数据
	        byte[] data = new byte[fileInputStream.available()];
	        fileInputStream.read(data);
	        fileInputStream.close();
	        // 回写
	        response.setContentType(JPG);
	        outputStream.write(data);
	        outputStream.flush();
	        outputStream.close();
	    }
	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        
	    }
}
