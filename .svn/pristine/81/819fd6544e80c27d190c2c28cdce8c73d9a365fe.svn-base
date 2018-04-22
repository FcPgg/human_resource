package com.xt.ptus.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.xt.ptus.obejcts.Result;
import com.xt.ptus.sys.entity.SysAttachments;
import com.xt.ptus.sys.service.SysAttachmentsService;
import com.xt.ptus.util.MD5Util;
import com.xt.ptus.util.StringUtil;

@SuppressWarnings("serial")
public class FileUploadServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(FileUploadServlet.class);
	
	private SysAttachmentsService service;
	
	@Override
	public void init() throws ServletException {
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		service = (SysAttachmentsService)ctx.getBean("sysAttachmentsServiceImpl");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); // 设置编码
		
		Result result = new Result();
		result.setSuccess(true);
		
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取文件需要上传到的路径
		// String path = request.getRealPath("/upload1");
		InputStream is = this.getClass().getResourceAsStream("/system.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		String path = prop.getProperty("file.upload");
		
		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(path));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);
		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<SysAttachments> atts = new ArrayList<SysAttachments>();
			// 可以上传多个文件
			@SuppressWarnings("unchecked")
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				
				//判断是否表单中普通类型字段
				if(item.isFormField())
					continue;
		
				// 获取表单的属性名字
//				String name = item.getFieldName();
				// 对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
				/**
				 * 以下三步，主要获取 上传文件的名字
				 */
				// 获取路径名
				String value = item.getName();
				
				if(StringUtil.IsNullOrEmpty(value))
					continue;
				
				// 索引到最后一个反斜杠
				int start = value.lastIndexOf("\\");
				// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
				String fileName = value.substring(start + 1);

				SysAttachments att = new SysAttachments();
				
				att.setSrcFileName(fileName.substring(0, fileName.lastIndexOf(".")));
				att.setSrcFileType(fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()));
				att.setUuid(MD5Util.MD5(String.valueOf(att.hashCode())));

				service.update(att);

				// 真正写到磁盘上
				// 它抛出的异常 用exception 捕捉
				// item.write( new File(path,filename) );//第三方提供的
				// 手动写的
				InputStream in = item.getInputStream();
				OutputStream out = new FileOutputStream(new File(path, att.getUuid() + "." + att.getSrcFileType()));

				int length = 0;
				byte[] buf = new byte[1024];

				logger.info("上传文件的总共的容量：" + item.getSize());
				// in.read(buf) 每次读到的数据存放在 buf 数组中
				while ((length = in.read(buf)) != -1) {
					// 在 buf 数组中 取出数据 写到 （输出流）磁盘上
					out.write(buf, 0, length);
				}
				in.close();
				out.close();
				atts.add(att);
			}
			result.setData(atts);
		} catch (FileUploadException e) {
			logger.error(e);
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		
		response.setContentType("text/html;charset=utf-8");// 这行代码其实既通知浏览器用u8发送，又通知浏览器用u8打开
		// 但是为了方便观看，还是会写上下面这行代码
		response.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(result));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
