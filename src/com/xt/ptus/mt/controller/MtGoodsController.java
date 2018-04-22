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
	 * 获取正常商品数据
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
			
//			if(params.containsKey("name")){
//				dc.add(Property.forName("name").like("%" + params.get("name") + "%"));
//			}
//			
//			if(params.containsKey("status")){
//				dc.add(Property.forName("status").eq(Integer.parseInt(params.get("status").toString())));
//			}
//			
//			if(params.containsKey("secondLevelCategory")){
//				dc.add(Property.forName("secondLevelCategory").eq(Integer.parseInt(params.get("secondLevelCategory").toString())));
//			}
//			if(params.containsKey("sellerId")){
//				dc.add(Property.forName("sellerId").eq(Integer.parseInt(params.get("sellerId").toString())));
//			}
			
			dc.addOrder(Order.asc("status"));
			
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
	@RequestMapping("getGoodsBySellerId")
	public Result getGoodsBySellerId(@RequestParam("sellerId") String sellerId){
		Result result = new Result();

		try {
			result.setData(service.getGoodsBySellerId(sellerId));
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
	 * 更新商品数据
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateGoods")
	public Result updateData(HttpServletRequest request) {
		Result result = new Result();
		try {
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
	
	/** 获取复杂商品
	 * @param id
	 * @param reqeust
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getComplexGoods")
	public Result getComplexGoods(@RequestParam("id") String id,@RequestParam(name = "userId", required = false) String userId ,HttpServletRequest reqeust){
		Result result = new Result();
		try {
			if(StringUtil.IsNullOrEmpty(id)){
				throw new Exception("传递参数有误!");
			}
			result.setData(service.getComplexGoods(id,userId));
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error(e);
			result.setSuccess(false);
			result.setMessage("操作失败");
			result.setError(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 下架商品
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("doUndercarriage")
	public Result doUndercarriage(@RequestParam("id") String id){
		Result result = new Result();
		try {
			service.undercarriageGoods(id, 1);
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
