package com.xt.ptus.mt.service;

import com.xt.ptus.base.BaseService;
import com.xt.ptus.mt.entity.MtUserInfo;

public interface MtUserInfoService extends BaseService<MtUserInfo>{

	MtUserInfo getUserByUserName(String userName);

	MtUserInfo getUserByUserName(String userName, String password, boolean isMobile);

	boolean matchUserPwd(String userId, String pwd);

}
