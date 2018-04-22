package com.xt.ptus.mt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/mt/mtOpenEditor/")
public class MtOpenEditorController {
	
	@RequestMapping("showResetPasswordEditor")
	private ModelAndView showEditor(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("admin/editors/reset-password-editor");
		return mav;
	}
	
	//添加用户
	@RequestMapping("showSysUserEditor")
	private ModelAndView showSysUserEditor(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("admin/userInfo/sys-user-editor");
		return mav;
	}
	
	//选择分组
	@RequestMapping("showchoiceGroup")
	private ModelAndView showChoiceGroup(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/editors/sys-user-choiceGroup");
		return mv;
	}
	

}
