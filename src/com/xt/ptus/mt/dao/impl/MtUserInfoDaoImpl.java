package  com.xt.ptus.mt.dao.impl;


import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.constants.Constants;
import com.xt.ptus.mt.dao.MtUserInfoDao;
import com.xt.ptus.mt.entity.MtUserInfo;
import com.xt.ptus.util.MD5Util;

@Repository
public class MtUserInfoDaoImpl extends BaseDaoImpl<MtUserInfo> implements MtUserInfoDao{

	@Override
	public MtUserInfo getUserByUserName(String userName) {
		return (MtUserInfo) getCurrentSession().createCriteria(MtUserInfo.class).add(Property.forName("userName").eq(userName)).setMaxResults(1).uniqueResult();
	}

	@Override
	public MtUserInfo getUserByUserName(String userName, String password, boolean isMobile) {
		Criteria criteria = getCurrentSession().createCriteria(MtUserInfo.class);
		criteria.add(Property.forName("userName").eq(userName)).add(Property.forName("password").eq(password));
		
		if(isMobile){
			criteria.add(Property.forName("category").eq(Constants.USER_INFO_CATEGORY_APP_USER));
		} else {
			criteria.add(Restrictions.not(Restrictions.eq("category", Constants.USER_INFO_CATEGORY_APP_USER)));
		}
		
		return (MtUserInfo) criteria.uniqueResult();
	}

	@Override
	public boolean matchUserPwd(String userId, String pwd) {
		MtUserInfo user = this.get(userId, MtUserInfo.class);
		return user != null && MD5Util.MD5(pwd).equals(user.getPayPwd());
	}

	@Override
	public String getAlipayAccount(int sellerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserIdByAccountNumbers(String accountNumbers) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String getAlipayAccount(int sellerId) {
//		MtUserInfo seller = (MtUserInfo) getCurrentSession().createCriteria(MtUserInfo.class).add(Property.forName("sellerId").eq(sellerId)).uniqueResult();
//		return seller != null ? seller.getAlipayAccount() : null;
//	}
}
