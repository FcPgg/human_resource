package  com.xt.ptus.mt.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.mt.dao.MtGoodsValuationDao;
import com.xt.ptus.mt.entity.MtGoodsValuation;

@Repository
public class MtGoodsValuationDaoImpl extends BaseDaoImpl<MtGoodsValuation> implements MtGoodsValuationDao{

	@Override
	public List<MtGoodsValuation> getOneValuationByGoodsId(String goodsId) {
		Criteria criteria = getCurrentSession().createCriteria(MtGoodsValuation.class);
		criteria.add(Property.forName("goodsId").eq(Integer.parseInt(goodsId)));
		criteria.addOrder(Order.desc("valuationTime"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		return criteria.list();
	}


}
