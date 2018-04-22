package com.xt.ptus.mt.controller.mobile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.ptus.base.BaseController;
import com.xt.ptus.mt.entity.MtSystemAdvertisement;
import com.xt.ptus.mt.service.MtSystemAdvertisementService;
import com.xt.ptus.obejcts.Result;

@Controller
@RequestMapping(value = "mt/mobile/systemAd")
public class MtSystemAdvertisementControllerMobile extends BaseController<MtSystemAdvertisement> {
	
	@Resource
	private MtSystemAdvertisementService service;
	private static Logger logger = Logger.getLogger(MtSystemAdvertisementControllerMobile.class);
	
	
	/**
	 * 获取正常广告数据
	 */
	@ResponseBody
	@RequestMapping("getSystemAdvertisements")
	public Result listNormalAdvertisement(HttpServletRequest request){
		Result result = new Result();
		
		try {
			
			result.setData(service.getSystemAdvertisements());
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
	 * 通过id获取诊断内容
	 */
	@RequestMapping("getContentById")
	@ResponseBody
	public Result getContentById(@RequestParam("id")String id,HttpServletRequest request){
		Result result = new Result();
		try {
			result.setData(service.getContentById(id));
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
