package com.xt.ptus.sys.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.sys.dao.SysUsersDao;
import com.xt.ptus.sys.entity.SysUsers;

@Repository
public class SysUsersDaoImpl extends BaseDaoImpl<SysUsers> implements SysUsersDao{
	
	/**
	 * 根据用户名获取用户信息
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public SysUsers getUserByUserName(String userName, String password){
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(SysUsers.class);
	
		@SuppressWarnings("unchecked")
		SysUsers user = (SysUsers) criteria.add(Property.forName("userName").eq(userName)).add(Property.forName("password").eq(password)).uniqueResult();
		
		return user;
	}
	
	public SysUsers getUserByUserName(String userName){
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(SysUsers.class);
	
		@SuppressWarnings("unchecked")
		SysUsers user = (SysUsers) criteria.add(Property.forName("userName").eq(userName)).uniqueResult();
		
		return user;
	}

}
