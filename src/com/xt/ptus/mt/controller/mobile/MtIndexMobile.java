package com.xt.ptus.mt.controller.mobile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xt.ptus.base.BaseController;
import com.xt.ptus.mt.entity.MtCategory;
import com.xt.ptus.mt.entity.MtSystemAdvertisement;
import com.xt.ptus.mt.service.MtCategoryService;
import com.xt.ptus.mt.service.MtSystemAdvertisementService;
import com.xt.ptus.obejcts.Result;
import com.xt.ptus.util.RequestUtil;

@Controller
@RequestMapping(value = "/mt/mobile/disease")
public class MtIndexMobile{
	
	@Resource
	private MtCategoryService service;
	private MtSystemAdvertisementService systemAdvertisementService;
	private static Logger logger = Logger.getLogger(MtCategory.class);
	
	@RequestMapping(value="index")
	public ModelAndView index(HttpServletRequest request) throws IOException{
		InputStream in = this.getClass().getResourceAsStream("/system.properties");
		Properties prop = new Properties();
		prop.load(in);
		in.close();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userView/index");
		mv.addObject("projectName", prop.get("project.name"));
		return mv;
		
	}
	
	@RequestMapping(value="addProblem")
	public ModelAndView addProblem(HttpServletRequest request) throws IOException{
		InputStream in = this.getClass().getResourceAsStream("/system.properties");
		Properties prop = new Properties();
		prop.load(in);
		in.close();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userView/addProblem");
		mv.addObject("projectName", prop.get("project.name"));
		return mv;
		
	}
	
	@RequestMapping(value="doMypage")
	public ModelAndView doMypage(HttpServletRequest request) throws IOException{
		InputStream in = this.getClass().getResourceAsStream("/system.properties");
		Properties prop = new Properties();
		prop.load(in);
		in.close();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userView/myPage");
		mv.addObject("projectName", prop.get("project.name"));
		return mv;
		
	}
	
	
	/**
	 * 获取首页分类
	 */
	@ResponseBody
	@RequestMapping("listNormalSystemCategory")
	public Result listNormalSystemCategory(HttpServletRequest request){
		Result result = new Result();
		
		int page = 1;
		int rows = 10;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			rows = Integer.parseInt(request.getParameter("rows"));
		} catch(Exception e ){
			logger.error("分页数据转换异常，使用默认页码:page = 1，行数:rows=10");
		}
                                                                                                                                                                                                                                         
		try {
			Map<String, Object> params = RequestUtil.requestParamsToMap(request);
			DetachedCriteria dc = DetachedCriteria.forClass(MtCategory.class);
			dc.addOrder(Order.asc("sortOrder"));
			result.setData(service.getWithPagination(dc, page, rows, "id"));
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setError(e.getMessage());
			result.setMessage("操作失败");
			logger.error(e);
		}
		return result;
	}
	
	/**
	 * 获取正常治疗方案数据
	 */
	@ResponseBody
	@RequestMapping("listNormalAdvertisement")
	public Result listNormalAdvertisement(HttpServletRequest request,@RequestParam("categoryId")int categoryId){
		Result result = new Result();
		
		int page = 1;
		int rows = 10;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			rows = Integer.parseInt(request.getParameter("rows"));
		} catch(Exception e ){
			logger.error("分页数据转换异常，使用默认页码:page = 1，行数:rows=10");
		}
                                                                                                                                                                                                                                         
		try {
			Map<String, Object> params = RequestUtil.requestParamsToMap(request);
			
			DetachedCriteria dc = DetachedCriteria.forClass(MtSystemAdvertisement.class);
			dc.add(Property.forName("category").eq(categoryId));
			Order.desc("createTime");
			
			result.setData(service.getWithPagination(dc, page, rows, "id"));
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setError(e.getMessage());
			result.setMessage("操作失败");
			logger.error(e);
		}
		return result;
	}
	
}
