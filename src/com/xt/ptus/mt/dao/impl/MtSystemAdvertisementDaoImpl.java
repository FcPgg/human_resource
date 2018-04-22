package  com.xt.ptus.mt.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.constants.Constants;
import com.xt.ptus.mt.dao.MtSystemAdvertisementDao;
import com.xt.ptus.mt.entity.MtSystemAdvertisement;
import com.xt.ptus.obejcts.Pagination;

@Repository
public class MtSystemAdvertisementDaoImpl extends BaseDaoImpl<MtSystemAdvertisement> implements MtSystemAdvertisementDao{

	@Override
	public List<MtSystemAdvertisement> getSystemAdvertisements() {
		Date date = new Date();
		return getCurrentSession().createCriteria(MtSystemAdvertisement.class).add(Property.forName("startTime").le(date)).add(Property.forName("endTime").ge(date)).list();
	}

}
