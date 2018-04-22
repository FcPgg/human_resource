package com.xt.ptus.mt.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.xt.ptus.base.BaseController;
import com.xt.ptus.mt.entity.MtSystemAdvertisement;
import com.xt.ptus.mt.service.MtSystemAdvertisementService;
import com.xt.ptus.obejcts.Result;
import com.xt.ptus.util.RequestUtil;

@Controller
@RequestMapping(value = "mt/systemAd")
public class MtSystemAdvertisementController extends BaseController<MtSystemAdvertisement> {
	
	@Resource
	private MtSystemAdvertisementService service;
	private static Logger logger = Logger.getLogger(MtSystemAdvertisementController.class);
	
	
	/**
	 * 获取正常广告数据
	 */
	@ResponseBody
	@RequestMapping("listNormalAdvertisement")
	public Result listNormalAdvertisement(HttpServletRequest request){
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
	
	@ResponseBody
	@RequestMapping("updateAdvertisement")
	public Result updateAdvertisement(HttpServletRequest request,	
		    @RequestParam("attId")int attId,
            @RequestParam("name")String name,
            @RequestParam("programme")String programme,
            @RequestParam("symptom")String symptom,
            @RequestParam("category")int category
            ){
		Result result = new Result();
		try {
			result.setData(service.updateAdvertisement(attId,name,symptom,programme,category));
			result.setSuccess(true);
		}catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("操作失败");
			result.setError(e.getMessage());
	    }
		return result;
	}
}
