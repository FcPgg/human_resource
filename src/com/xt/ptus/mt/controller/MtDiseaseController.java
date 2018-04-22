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

import com.xt.ptus.base.BaseController;
import com.xt.ptus.mt.entity.MtDisease;
import com.xt.ptus.mt.service.MtDiseaseService;
import com.xt.ptus.obejcts.Result;
import com.xt.ptus.util.RequestUtil;

@Controller
@RequestMapping(value = "mt/disease")
public class MtDiseaseController extends BaseController<MtDisease> {
	
	@Resource
	private MtDiseaseService service;
	private static Logger logger = Logger.getLogger(MtDisease.class);
	
	/**
	 * 获取正常治疗方案数据
	 */
	@ResponseBody
	@RequestMapping("listNormalDisease")
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
			
			DetachedCriteria dc = DetachedCriteria.forClass(MtDisease.class);
			//dc.add(Property.forName("category").eq(categoryId));
			
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
	
	@RequestMapping(value="getTopTenDisease")
	@ResponseBody
	public Result getTopTenDisease(HttpServletRequest request){
		Result result = new Result();
		try {
			result.setData(service.getTopTenDisease());
			result.setSuccess(true);
		}catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("操作失败");
			result.setError(e.getMessage());
	    }
		return result;
	}
	
}
