package com.xt.ptus.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import sun.misc.BASE64Decoder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xt.ptus.mt.entity.MtCommonAttachements;
import com.xt.ptus.mt.service.MtCommonAttachementsService;
import com.xt.ptus.obejcts.Result;
import com.xt.ptus.util.MD5Util;
import com.xt.ptus.util.StringUtil;

/**
 * Base64方式上传材料
 * url: /fileUploadBase64
 * @param : json格式的 {params: [{fileName:"", fileType:"", image:""}]} {文件名:"", 文件类型:"", 图片:"图片的BASE64编码"}
 * @return List<Attachements> list
 */
public class Base64MaterialsUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(Base64MaterialsUploadServlet.class);
	
	private MtCommonAttachementsService service;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		service = (MtCommonAttachementsService)ctx.getBean("mtCommonAttachementsServiceImpl");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 设置编码
		
		Result result = new Result();
		result.setSuccess(true);
		
		InputStream is = this.getClass().getResourceAsStream("/system.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		
		List<MtCommonAttachements> attList = new ArrayList<MtCommonAttachements>();
		
		try {
			if(!request.getParameterMap().containsKey("params") && StringUtil.IsNullOrEmpty(request.getParameter("params"))){
				throw new Exception("传递参数不正确，请检查");
			}
			
			List<Map<String,String>> params = (new Gson()).fromJson(request.getParameter("params"), new TypeToken<List<Map<String,String>>>(){}.getType());
			
			if(params != null && params.size() > 0){
				
				for(Map<String, String> param : params){
					MtCommonAttachements att = new MtCommonAttachements();
					
					att.setSrcName(param.get("fileName"));
					att.setSrcFileType(param.get("fileType"));
					
					att.setUuid(MD5Util.MD5(String.valueOf(att.hashCode())));
					att.setFileName(att.getUuid());
					
					GenerateImage(param.get("image"), prop.getProperty("file.material"), att.getUuid(), att.getSrcFileType());
					service.update(att);
					attList.add(att);
				}
				
			}
			result.setData(attList);
			result.setMessage("上传成功");
		}  catch (Exception e) {
			logger.error(e);
			result.setSuccess(false);
			result.setMessage("上传失败");
		}
		
		response.setContentType("text/html;charset=utf-8");// 这行代码其实既通知浏览器用u8发送，又通知浏览器用u8打开
		// 但是为了方便观看，还是会写上下面这行代码
		response.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(result));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * base64字符串转化成图片  
	 * @param imgStr BASE64格式的图片
	 * @param storePath 存储路径
	 * @param fileName 文件名
	 * @param fileType 文件类型
	 * @throws Exception
	 */
	private void GenerateImage(String imgStr, String storePath, String fileName, String fileType) throws Exception  {
    	
    	
    	//对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) //图像数据为空  
            return;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成jpeg图片  
            String imgFilePath = storePath + File.separator + fileName + "." + fileType;//新生成的图片  
            OutputStream out = new FileOutputStream(imgFilePath);      
            out.write(b);  
            out.flush();  
            out.close();  
        } catch (Exception e){
        	throw e;
        }  
    }  
}
