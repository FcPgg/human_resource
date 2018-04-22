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
import com.xt.ptus.sys.entity.SysUsers;
import com.xt.ptus.sys.service.SysUsersService;
import com.xt.ptus.util.MD5Util;

/**
 * 用户管理
 * @author win7
 *
 */
@Controller
@RequestMapping(value = "/admin/sysUsers")
public class SysUsersController extends BaseController<SysUsers>{
	
	private static Logger logger = Logger.getLogger(SysUsersController.class);
	
	@Resource
	private SysUsersService service;
	
	@Override
	public Result doUpdate(SysUsers user, HttpServletRequest request) {
		Result result = new Result();
		try {
			//给密码加密
			user.setPassword(MD5Util.MD5(user.getPassword()));
			this.service.update(user);
			result.setData(user);
			result.setSuccess(true);
			request.getSession().removeAttribute("currentUser");
			request.getSession().setAttribute("currentUser", user);
		} catch (Exception ex) {
			result.setSuccess(false);
			result.setMessage(ex.getMessage());
			logger.error(ex);
		}
		return result;
	}
	
	/**
	 * 用户管理-更新用户信息
	 * @param user
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String doUpdateUser(SysUsers user, HttpServletRequest request) {
		Result result = new Result();
		try {
			
			this.service.update(user);
			result.setData(user);
			result.setSuccess(true);
		} catch (Exception ex) {
			result.setSuccess(false);
			result.setMessage(ex.getMessage());
			logger.error(ex);
		}
		return toJSON(result);
	}
	
	/**
	 * 修改用户头像
	 * @param userId
	 * @param headSculpture
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateHeadSculpture")
	public String updateHeadSculpture(@RequestParam("userId")String userId, @RequestParam("headSculpture")String headSculpture, HttpServletRequest request){
		Result result = new Result();
		try {
			SysUsers user = service.get(userId);
			if(user != null){
				user.setHeadSculpture(headSculpture);
			}
			result.setData(user);
			result.setSuccess(true);
			this.service.update(user);
			request.getSession().removeAttribute("currentUser");
			request.getSession().setAttribute("currentUser", user);
		} catch (Exception ex) {
			result.setSuccess(false);
			result.setMessage(ex.getMessage());
			logger.error(ex);
		}
		return toJSON(result);
	}
	
	/**
	 * 重置用户密码
	 * @param id
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/resetPassword")
	public String resetPassword(@RequestParam("id")String id, @RequestParam("password")String password){
		Result result = new Result();
		try {
			//给密码加密
			SysUsers user = service.get(id);
			if(user != null){
				user.setPassword(MD5Util.MD5(password));
			}
			this.service.update(user);
			result.setData(user);
			result.setSuccess(true);
		} catch (Exception ex) {
			result.setSuccess(false);
			result.setMessage(ex.getMessage());
			logger.error(ex);
		}
		return toJSON(result);
	}
}

