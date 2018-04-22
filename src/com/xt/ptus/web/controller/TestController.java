package com.xt.ptus.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class TestController {

	@ResponseBody
	@RequestMapping("token")
	public String testAjax(HttpServletRequest request, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		return "success";
	}
}
