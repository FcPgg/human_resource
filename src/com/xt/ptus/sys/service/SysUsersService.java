package com.xt.ptus.sys.service;

import javax.annotation.Resource;

import com.xt.ptus.base.BaseService;
import com.xt.ptus.sys.entity.SysUsers;

@Resource
public interface SysUsersService extends BaseService<SysUsers>{
	
	public SysUsers getUserByUserName(String userName, String password);
	
	public SysUsers getUserByUserName(String userName);

}
