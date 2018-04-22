package  com.xt.ptus.mt.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.mt.entity.MtChoiceGroup;
import com.xt.ptus.mt.entity.MtPermissions;
import com.xt.ptus.mt.dao.MtChoiceGroupDao;

@Repository
public class MtChoiceGroupDaoImpl extends BaseDaoImpl<MtChoiceGroup> implements MtChoiceGroupDao{

	//通过user获取选择的分组
	@Override
	public List<MtChoiceGroup> getGroupByUserId(String userId) {
		Criteria criteria = getCurrentSession().createCriteria(MtChoiceGroup.class);
		criteria.add(Property.forName("userId").eq(Integer.parseInt(userId)));
		List group = criteria.list();
		return group;
	}

}
