package com.xt.ptus.sys.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.ptus.base.BaseController;
import com.xt.ptus.obejcts.Result;
import com.xt.ptus.sys.entity.SysMenus;
import com.xt.ptus.sys.service.SysMenusService;

/**
 * 系统菜单
 * @author win7
 *
 */
@Controller
@RequestMapping(value = "/admin/sysMenus/")
public class SysMenusController extends BaseController<SysMenus> {

	private static Logger logger = Logger.getLogger(SysMenusController.class);
	
	@Resource
	private SysMenusService service;
	
	/**
	 * 获取树结构的菜单
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getSysMenusWithTreeStructure", method = RequestMethod.POST)
	public Result getSysMenusWithTreeStructure(HttpServletRequest request,@RequestParam("id") String userId){
		Result result = new Result();
		try {
			result.setData(service.getSysMenusWithTreeStructure(userId));
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			logger.error(e);
		}
		return result;
	}
}
