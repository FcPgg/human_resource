package  com.xt.ptus.mt.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.mt.entity.MtRecommendsData;
import com.xt.ptus.mt.dao.MtRecommendsDataDao;

@Repository
public class MtRecommendsDataDaoImpl extends BaseDaoImpl<MtRecommendsData> implements MtRecommendsDataDao{

	@Override
	public MtRecommendsData getTopGoodsByGoodsId(String id) {

		Criteria criteria = getCurrentSession().createCriteria(MtRecommendsData.class);
		criteria.add(Property.forName("goodsId").eq(Integer.parseInt(id)));
		//List list = criteria.list();
		return (MtRecommendsData) criteria.uniqueResult();
	}

}
