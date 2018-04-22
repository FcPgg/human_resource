package  com.xt.ptus.mt.dao.impl;

import java.util.List;

import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.mt.dao.MtGoodsValuationAttachementsDao;
import com.xt.ptus.mt.entity.MtGoodsValuationAttachements;

@Repository
public class MtGoodsValuationAttachementsDaoImpl extends BaseDaoImpl<MtGoodsValuationAttachements> implements MtGoodsValuationAttachementsDao{

	@Override
	public List<MtGoodsValuationAttachements> getAttachements(String valuationId) {
		return getCurrentSession().createCriteria(MtGoodsValuationAttachements.class).add(Property.forName("valuationId").eq(Integer.parseInt(valuationId))).list();
	}
}
