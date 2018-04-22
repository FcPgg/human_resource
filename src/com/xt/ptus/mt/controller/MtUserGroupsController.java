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
import com.xt.ptus.mt.entity.MtUserGroups;
import com.xt.ptus.mt.service.MtUserGroupsService;
import com.xt.ptus.obejcts.Result;
import com.xt.ptus.util.RequestUtil;

@Controller
@RequestMapping(value = "mt/userGroups")
public class MtUserGroupsController extends BaseController<MtUserGroups> {
	
	private static Logger logger = Logger.getLogger(MtUserGroups.class);
	
	@Resource
	private MtUserGroupsService service;
	
	/**
	 * 获取分组List
	 */
	@RequestMapping("listNormalGroups")
	@ResponseBody
	public Result listNormalGroups(HttpServletRequest request){
	
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
			DetachedCriteria dc = DetachedCriteria.forClass(MtUserGroups.class);
			result.setData(service.getWithPagination(dc, page, rows, "id"));
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("操作失败");
			result.setError(e.getMessage());
			logger.error(e);
		}
		return result;
	}
	
	/**
	 * 更新分组
	 */
	@RequestMapping("updateGroup")
	@ResponseBody
	public Result updateGroup(HttpServletRequest request){
	
		Result result = new Result();
		try {
			MtUserGroups userGroups = (MtUserGroups) fromJSON(request.getParameter("entity"),MtUserGroups.class);
			service.update(userGroups);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("操作失败");
			result.setError(e.getMessage());
			logger.error(e);
		}
		return result;
	}
	
	/**
	 * 获取某个分组权限
	 */
	@RequestMapping("selGroupInfo")
	@ResponseBody
	public Result selGroupInfo(HttpServletRequest request,@RequestParam("id")String id){
		
		Result result = new Result();
		try {
			result.setData(service.getGroupInfoById(id));
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("操作失败");
			result.setError(e.getMessage());
			logger.error(e);
		}
		return result;
	}
}
