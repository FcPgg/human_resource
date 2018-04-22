package  com.xt.ptus.mt.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.mt.entity.MtCreditOrderAttachements;
import com.xt.ptus.mt.entity.MtPermissions;
import com.xt.ptus.mt.dao.MtPermissionsDao;

@Repository
public class MtPermissionsDaoImpl extends BaseDaoImpl<MtPermissions> implements MtPermissionsDao{

	@Override
	public List<MtPermissions> getActionById(int permissionId) {
		Criteria criteria = getCurrentSession().createCriteria(MtPermissions.class);
		criteria.add(Property.forName("id").eq( String.valueOf(permissionId)));
		List attachements = criteria.list();
		return attachements;
	}

}
