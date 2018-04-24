package com.xt.ptus.mt.controller;

import java.util.Map;

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

import com.xt.ptus.base.BaseController;
import com.xt.ptus.mt.entity.MtGoods;
import com.xt.ptus.mt.service.MtGoodsService;
import com.xt.ptus.obejcts.Result;
import com.xt.ptus.util.RequestUtil;
import com.xt.ptus.util.StringUtil;


@Controller
@RequestMapping(value = "/mt/mtGoods/")
public class MtGoodsController extends BaseController<MtGoods> {
	
	private static Logger logger = Logger.getLogger(MtGoodsController.class);
	
	@Resource
	private MtGoodsService service;
	
	/**
	 * 获取档案列表数据
	 */
	@ResponseBody
	@RequestMapping("listNormalGoods")
	public Result listNormalGoods(HttpServletRequest request){
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
			
			DetachedCriteria dc = DetachedCriteria.forClass(MtGoods.class);
			
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
	 * 根据id获取档案详情
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getArchivesInfoById")
	public Result getArchivesInfoById(@RequestParam("id") int id){
		Result result = new Result();

		try {
			result.setData(service.getArchivesInfoById(id));
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
	 * 更新档案数据
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateGoods")
	public Result updateData(HttpServletRequest request) {
		Result result = new Result();
		try {
		    logger.error((MtGoods) fromJSON(request.getParameter("entity"), MtGoods.class));
			MtGoods goods = (MtGoods) fromJSON(request.getParameter("entity"), MtGoods.class);
			service.update(goods);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error(e);
			result.setSuccess(false);
			result.setMessage("操作失败");
			result.setError(e.getMessage());
		}
		return result;
	}
	
	
}
