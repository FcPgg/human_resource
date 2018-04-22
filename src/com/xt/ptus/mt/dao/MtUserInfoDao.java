package com.xt.ptus.mt.dao;

import com.xt.ptus.base.BaseDao;
import com.xt.ptus.mt.entity.MtUserInfo;

public interface MtUserInfoDao extends BaseDao<MtUserInfo>{

	MtUserInfo getUserByUserName(String userName);

	MtUserInfo getUserByUserName(String userName, String password, boolean isMobile);

	boolean matchUserPwd(String userId, String pwd);

	/**
	 * 获取商家alipay账户信息
	 * @param sellerId
	 * @return
	 */
	String getAlipayAccount(int sellerId);

	String getUserIdByAccountNumbers(String accountNumbers);

}
