package com.xt.ptus.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.sys.dao.SysUsersDao;
import com.xt.ptus.sys.entity.SysUsers;
import com.xt.ptus.sys.service.SysUsersService;

@Service
public class SysUsersServiceImpl extends BaseServiceImpl<SysUsers> implements SysUsersService{

	@Autowired
	private SysUsersDao userDao;
	
	@Override
	public SysUsers getUserByUserName(String userName, String password){
		return userDao.getUserByUserName(userName, password);
	}

	@Override
	public SysUsers getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}
}
