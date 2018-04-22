package com.xt.ptus.mt.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xt.ptus.base.BaseController;
import com.xt.ptus.constants.Constants;
import com.xt.ptus.mt.entity.MtIntegrate;
import com.xt.ptus.mt.entity.MtUserInfo;
import com.xt.ptus.mt.service.MtUserInfoService;
import com.xt.ptus.obejcts.Result;
import com.xt.ptus.util.MD5Util;
import com.xt.ptus.util.RequestUtil;
import com.xt.ptus.util.StringUtil;

@Controller
@RequestMapping(value = "/mt/mtUserInfo/")
public class MtUserInfoController extends BaseController<MtUserInfo> {

	private static Logger logger = Logger.getLogger(MtUserInfoController.class);
	
	@Resource
	private MtUserInfoService service;
	
	@RequestMapping("showEditor")
	private ModelAndView showEditor(HttpServletRequest request){
		ModelAndView mav = new ModelAndView(request.getParameter("editor"));
		MtUserInfo currentUser = (MtUserInfo) request.getSession().getAttribute("currentUser");
		if(currentUser != null){
			MtUserInfo user = service.get(currentUser.getId());
			mav.addObject("user", user);
		}
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("doPagination")
	public Result doPagination(@RequestParam("page")String page, 
			@RequestParam("rows")String rows, 
			@RequestParam("category") String category, 
			@RequestParam(name = "phoneNumber", required = false) String phoneNumber,
			@RequestParam(name = "name", required = false) String name) {
		Result result = new Result();
		
		int pager = 1;
		int limit = 10;
		try {
			pager = Integer.parseInt(page);
			limit = Integer.parseInt(rows);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			
			DetachedCriteria dc = DetachedCriteria.forClass(MtUserInfo.class);
			
			if("app".equals(category)){
				dc.add(Property.forName("category").eq(Constants.USER_INFO_CATEGORY_APP_USER));
			} else if("sys".equals(category)){
				dc.add(Property.forName("category").eq(Constants.USER_INFO_CATEGORY_SYSTEM_USER));
			} else if("proxy".equals(category)){
				dc.add(Property.forName("category").eq(Constants.USER_INFO_CATEGORY_PROXY_USER));
			} else if("seller".equals(category)){
				dc.add(Property.forName("category").eq(Constants.USER_INFO_CATEGORY_SELLER_USER));
			}
			if(!StringUtil.IsNullOrEmpty(phoneNumber)){
				dc.add(Property.forName("phoneNo").like("%" + phoneNumber + "%"));
			}
			if(!StringUtil.IsNullOrEmpty(name)){
				dc.add(Property.forName("name").like("%" + phoneNumber + "%"));
			}
			result.setData(service.getWithPagination(dc, pager, limit, "id"));
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
	 * 更新用户信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateUserInfo")
	private Result updateUserInfo(HttpServletRequest request){
		Result result = new Result();

		try {
			Map<String, Object> params = RequestUtil.requestParamsToMap(request); 
			MtUserInfo user = service.get(params.get("id").toString());
			if(user != null){
				if(params.get("name") != null)
					user.setName(params.get("name").toString());

				if(params.get("nickName") != null)
					user.setNickName(params.get("nickName").toString());
				
				if(params.get("phoneNo") != null)
					user.setPhoneNo(params.get("phoneNo").toString());
				
				if(params.get("sex") != null)
					user.setSex(Integer.parseInt(params.get("sex").toString()));
				
				if(params.get("idCardNo") != null)
					user.setIdCardNo(params.get("idCardNo").toString());
				if(params.get("password") != null)
					//给密码加密
					user.setPassword(MD5Util.MD5(params.get("password").toString()));
			}
			service.update(user);
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
	 * 冻结用户账号
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("doForzenUser")
	public Result doForzenUser(@RequestParam("userId") String userId, HttpServletRequest request){
		Result result = new Result();

		try {
			MtUserInfo user = service.get(userId);
			if(user != null){
				user.setStatus(Constants.USER_STATUS_FORZENED);
				MtUserInfo currentUser = (MtUserInfo) request.getSession().getAttribute("currentUser");
				if(currentUser != null){
					user.setUpdator(Integer.parseInt(currentUser.getId()));
					user.setUpdateTime(new Date());
				}
				service.update(user);
			}
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
	 * 解冻用户账号
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("doThawUser")
	public Result doThawUser(@RequestParam("userId") String userId, HttpServletRequest request){
		Result result = new Result();
		try {
			MtUserInfo user = service.get(userId);
			if(user != null){
				MtUserInfo currentUser = (MtUserInfo) request.getSession().getAttribute("currentUser");
				if(currentUser != null){
					user.setUpdator(Integer.parseInt(currentUser.getId()));
					user.setUpdateTime(new Date());
				}
				user.setStatus(Constants.USER_STATUS_UNLOGIN);
				service.update(user);
			}
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
	 * 重置用户密码
	 * @param id
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/resetPassword")
	public Result resetPassword(@RequestParam("id")String id, @RequestParam("password")String password){
		Result result = new Result();
		try {
			//给密码加密
			MtUserInfo user = service.get(id);
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
		return result;
	}
}
