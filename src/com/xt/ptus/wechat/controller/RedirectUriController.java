package com.xt.ptus.wechat.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.ptus.util.RequestUtil;

@Controller
@RequestMapping("/wechat/redirectUri/")
public class RedirectUriController {
	
	@ResponseBody
	@RequestMapping("getWecharResponse")
	public String getWecharResponse(HttpServletRequest request){
		Map<String, Object> params = RequestUtil.requestParamsToMap(request);
		System.out.println(params);
		return "success";
	}
}
