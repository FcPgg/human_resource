package  com.xt.ptus.mt.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.constants.Constants;
import com.xt.ptus.mt.dao.MtUserInfoDao;
import com.xt.ptus.mt.entity.MtIntegrate;
import com.xt.ptus.mt.entity.MtUserInfo;
import com.xt.ptus.mt.service.MtUserInfoService;
import com.xt.ptus.util.MD5Util;

@Service
public class MtUserInfoServiceImpl extends BaseServiceImpl<MtUserInfo> implements MtUserInfoService{

	@Autowired
	private MtUserInfoDao dao;
	
	
	@Override
	public MtUserInfo getUserByUserName(String userName) {
		return dao.getUserByUserName(userName);
	}

	@Override
	public MtUserInfo getUserByUserName(String userName, String password,boolean isMobile) {
		return dao.getUserByUserName(userName, password, isMobile);
	}

	@Override
	public boolean matchUserPwd(String userId, String pwd) {
		return dao.matchUserPwd(userId, pwd);
	}

}
