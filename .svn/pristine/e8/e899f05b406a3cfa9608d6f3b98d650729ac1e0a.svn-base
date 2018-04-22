package com.xt.ptus.mt.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.ptus.base.BaseController;
import com.xt.ptus.mt.entity.MtPermissions;
import com.xt.ptus.mt.service.MtPermissionsService;
import com.xt.ptus.obejcts.Result;

@Controller
@RequestMapping(value = "mt/permissions")
public class MtPermissionsController extends BaseController<MtPermissions> {
	
	@Resource
	private MtPermissionsService service;
	
	/**
	 * 获取树状结构的权限
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getPermissionTree")
	public Result getPermissionTree(){
		
		Result result = new Result();
		try {
			result.setData(service.getPermissionTree());
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("操作失败");
			result.setError(e.getMessage());
//			logger.error(e);
		}
		return result;
	}
	
}
