package com.xt.ptus.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xt.ptus.constants.Constants;
import com.xt.ptus.helper.SMSHelper;
import com.xt.ptus.mt.entity.MtUserInfo;
import com.xt.ptus.mt.service.MtUserInfoService;
import com.xt.ptus.obejcts.Result;
import com.xt.ptus.util.MD5Util;
import com.xt.ptus.util.RequestUtil;

@Controller
@RequestMapping("/login/")
public class LoginController {
	
	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private MtUserInfoService userService;
	
	
	@RequestMapping("page")
	private ModelAndView goPage() throws IOException{
		InputStream in = this.getClass().getResourceAsStream("/system.properties");
		Properties prop = new Properties();
		prop.load(in);
		in.close();

		ModelAndView model = new ModelAndView("admin/login");
		model.addObject("projectName", prop.get("project.name"));
		return model;
	}
	
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	private Result doLogin(@RequestParam("userName")String userName, @RequestParam("password")String password, HttpServletRequest request){
		Result result = null;
		Map<String, Object> params = RequestUtil.requestParamsToMap(request);
		if(!params.containsKey("userName") || !params.containsKey("password")){
			 result = new Result();
			 result.setSuccess(false);
			 result.setMessage("传递参数有误");
		} else {
			result = userLogin(userName, password, request);
		}
		return result;
	}
	
	/**
	 * 获取短信验证码
	 * @param phoneNumber 电话号码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getIdentifyingCode", method = RequestMethod.POST)
	private Result getIdentifyingCode(@RequestParam("phoneNumber") String phoneNumber){
		Result result = new Result();

		try {
			Map<String, String> map = SMSHelper.sendSMSIdentifyingCode(phoneNumber);
			logger.info(map);
			if(map.get("code").equals("200")){
				result.setData(map.get("obj"));
				result.setSuccess(true);
				result.setMessage("获取验证码成功");
			} else {
				result.setSuccess(false);
				result.setMessage("获取验证码失败");
			}
		} catch (Exception e) {
			result.setSuccess(false);
			result.setError(e.getMessage());
			result.setMessage("操作失败");
			logger.error(e);
		}
		return result;
	}
	
	/**
	 * 注册
	 * @param request
	 * @return
	 */
	
	
	@ResponseBody
	@RequestMapping(value = "doRegister", method = RequestMethod.POST)
	private Result doRegister(HttpServletRequest request){
		Result result = new Result();
		Map<String, Object> params = RequestUtil.requestParamsToMap(request);
		if(!params.containsKey("userName") || !params.containsKey("password")){
			result.setSuccess(false);
			result.setMessage("传递参数有误");
		} else {
			MtUserInfo user = null;
			if(params.containsKey("isMobile") && Boolean.parseBoolean(params.get("isMobile").toString())){
				//user = userService.registerUserMobile(request.getParameter("userName"), params.get("password").toString());
			} else {
				user = new MtUserInfo();
				user.setUserName(params.get("userName").toString());
				user.setPassword(MD5Util.MD5(params.get("password").toString()));
				user.setPhoneNo(params.get("phoneNo").toString());
				user.setName(params.get("name").toString());
				userService.update(user);
			}
			result.setData(user);
			result.setSuccess(true);
		}
		return result;
	}
	
	/**
	 * 检查用户名是否存在
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkUserExists", method = RequestMethod.POST)
	private Result checkUserExists(HttpServletRequest request){
		Result result = new Result();
		Map<String, Object> params = RequestUtil.requestParamsToMap(request);
		if(!params.containsKey("userName")){
			result.setSuccess(false);
			result.setMessage("传递参数有误");
		} else {
			MtUserInfo user = userService.getUserByUserName(params.get("userName").toString());
			result.setData(user != null);
			result.setSuccess(true);
		}
		return result;
	}
	
	/**
	 * 退出
	 * @param id
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "logOut", method = RequestMethod.POST)
	private Result logOut(@RequestParam("userId")String id, HttpServletRequest request){
		Result result = new Result();
		try {
			MtUserInfo user = userService.get(id);
			user.setStatus(Constants.USER_STATUS_UNLOGIN);
			userService.update(user);
			result.setSuccess(true);
			request.getSession().removeAttribute("currentUser");
			request.getSession().removeAttribute("currentStaff");
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("操作失败");
			result.setError(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 登录操作
	 * @param userName
	 * @param password
	 * @param request
	 * @return
	 */
	private Result userLogin(String userName, String password, HttpServletRequest request){
		Result result = new Result();
		
		boolean isMobile = request.getParameterMap().containsKey("isMobile") && Boolean.parseBoolean(request.getParameter("isMobile").toString());
		
		MtUserInfo user = userService.getUserByUserName(userName, MD5Util.MD5(password), isMobile);
		if(user == null){
			result.setSuccess(false);
			result.setMessage("指定账号不存在或密码错误");
			logger.debug("-------->>" + result.getMessage()+ "<<--------");
		} else {
			
			switch(user.getStatus()){
				case Constants.USER_STATUS_UNLOGIN:
						result.setSuccess(true);
						
						user.setStatus(Constants.USER_STATUS_LOGINED);
						user.setLastLoginTime(new Date());
						user.setLastLoginIp(RequestUtil.getIpAddr(request));

						userService.update(user);
						
						//清空密码，存入session
						user.setPassword(null);
						user.setPayPwd(null);
						request.getSession().setAttribute("currentUser", user);
						
					break;
				case Constants.USER_STATUS_LOGINED:
						result.setSuccess(true);
						result.setMessage("-------->>" + user.getUserName() + "该用户已经登陆系统" + "<<--------");
						
						logger.debug(result.getMessage());
					break;
				case Constants.USER_STATUS_FORZENED:
						result.setSuccess(false);
						result.setMessage("-------->>" +"该用户已被冻结，请联系管理员" + "<<--------");
						logger.debug(result.getMessage());
					break;
			}
			user.setPassword(null);
			user.setPayPwd(null);
			result.setData(user);
			request.getSession().setAttribute("currentUser", user);
			
		}
		return result;
	}
}
