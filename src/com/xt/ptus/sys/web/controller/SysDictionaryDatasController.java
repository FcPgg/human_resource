package com.xt.ptus.sys.web.controller;

import java.util.Map;

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
import com.xt.ptus.sys.entity.SysDictionaryDatas;
import com.xt.ptus.sys.service.SysDictionaryDatasService;
import com.xt.ptus.util.RequestUtil;

/**
 * 系统-数据字典数据
 * @author win7
 *
 */
@Controller
@RequestMapping(value = "/admin/sysDictionaryDatas/")
public class SysDictionaryDatasController extends BaseController<SysDictionaryDatas> {
	
	private static Logger logger = Logger.getLogger(SysDictionaryDatasController.class);
	
	@Resource
	private SysDictionaryDatasService service;
	
	/**
	 * 通过字典编号获取数据
	 * @param dictId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getDictionaryByDictId", method = RequestMethod.POST)
	private Result getDictionaryByDictId(@RequestParam("dictionaryId") String dictId){
		Result result = new Result();
		try {
			result.setData(service.getDictionaryByDictId(dictId));
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			logger.error(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 通过字典代码获取数据
	 * @param dictId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getDictionaryByCode", method = RequestMethod.GET)
	private Result getDictionaryByCode(@RequestParam("code") String code, HttpServletRequest request){
		Result result = new Result();
		try {
			Map<String,Object> params = RequestUtil.requestParamsToMap(request);
			if(params.containsKey("code")){
				params.remove("code");
			}
			result.setData(service.getDictionaryByCode(code, params));
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			logger.error(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 通过字典名获取数据
	 */
	@ResponseBody
	@RequestMapping(value="/getDictionaryByDictionary")
	private Result getDictionaryByDictionary(@RequestParam("dictionary")String dictionary,HttpServletRequest request){
		Result result = new Result();
		try {
			result.setData(service.getDictionaryByDictionary(dictionary));
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
