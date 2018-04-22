package  com.xt.ptus.mt.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.mt.entity.MtUserGroupMapping;
import com.xt.ptus.mt.dao.MtUserGroupMappingDao;

@Repository
public class MtUserGroupMappingDaoImpl extends BaseDaoImpl<MtUserGroupMapping> implements MtUserGroupMappingDao{

	@Override
	public List<MtUserGroupMapping> getPermission(String id) {

		Criteria criteria = getCurrentSession().createCriteria(MtUserGroupMapping.class);
		criteria.add(Property.forName("groupId").eq(Integer.parseInt(id)));
		List permission = criteria.list();
		return permission;
	}

	//通过分组
	@Override
	public List<MtUserGroupMapping> getPermissionByGroupId(int groupId) {
		Criteria criteria = getCurrentSession().createCriteria(MtUserGroupMapping.class);
		criteria.add(Property.forName("groupId").eq(groupId));
		List permission = criteria.list();
		return permission;
	}

}
