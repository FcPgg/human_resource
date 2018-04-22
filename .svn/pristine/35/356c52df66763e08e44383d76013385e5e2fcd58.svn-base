package com.xt.ptus.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主页控制器
 * @author win7
 *
 */

@Controller
@RequestMapping("/file-upload/")
public class FileUploadController {
	
	private static Logger logger = Logger.getLogger(FileUploadController.class);
	
	public FileUploadController(){
		logger.debug("initialized index controller");
	}
	
	@RequestMapping("/page")
	public ModelAndView showPage(HttpServletRequest request) throws IOException{
		
		ModelAndView mav = new ModelAndView("file-upload/file-upload");
		
		return mav;
	}
}
