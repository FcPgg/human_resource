package com.xt.ptus.mt.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.ptus.base.BaseController;
import com.xt.ptus.mt.entity.MtCategory;
import com.xt.ptus.mt.entity.MtSystemAdvertisement;
import com.xt.ptus.mt.service.MtCategoryService;
import com.xt.ptus.mt.service.MtSystemAdvertisementService;
import com.xt.ptus.obejcts.Result;
import com.xt.ptus.util.RequestUtil;

@Controller
@RequestMapping(value = "/mt/mtCategory/")
public class MtCategoryController extends BaseController<MtCategory> {
	
	@Resource
	private MtCategoryService service;
	private static Logger logger = Logger.getLogger(MtCategory.class);
	
	
	/**
	 * 获取正常系统分类数据
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
	
}
