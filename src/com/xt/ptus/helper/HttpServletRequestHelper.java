package com.xt.ptus.helper;

import javax.servlet.http.HttpServletRequest;

import com.xt.ptus.mt.entity.MtUserInfo;

public class HttpServletRequestHelper {
	
	public static MtUserInfo getCurrentUser(HttpServletRequest request){
		if(request != null){
			return request.getSession().getAttribute("currentUser") != null ?  (MtUserInfo) request.getSession().getAttribute("currentUser") : null;
		} else {
			return null;
		}
	}
}
