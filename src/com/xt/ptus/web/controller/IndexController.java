package com.xt.ptus.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.Resource;
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
@RequestMapping("/")
public class IndexController {
	
	private static Logger logger = Logger.getLogger(IndexController.class);
	
	
	public IndexController(){
		logger.debug("initialized index controller");
	}
	
	@RequestMapping("/")
	public ModelAndView goIndex(HttpServletRequest request) throws IOException{
		InputStream in = this.getClass().getResourceAsStream("/system.properties");
		Properties prop = new Properties();
		prop.load(in);
		in.close();
		
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("projectName", prop.get("project.name"));
		
		mav.addObject("currentUser", request.getSession().getAttribute("currentUser"));
		mav.addObject("currentStaff",  request.getSession().getAttribute("currentStaff"));
		
		//TODO: 处理当前登录用户的信息
		//request.getSession().setAttribute("currentSeller", sellerService.get("1"));
		mav.addObject("currentSeller", request.getSession().getAttribute("currentSeller"));
		return mav;
	}
}
