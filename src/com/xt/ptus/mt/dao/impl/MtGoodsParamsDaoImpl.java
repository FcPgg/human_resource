package  com.xt.ptus.mt.dao.impl;

import java.util.List;

import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.mt.dao.MtGoodsParamsDao;
import com.xt.ptus.mt.entity.MtGoodsParams;

@Repository
public class MtGoodsParamsDaoImpl extends BaseDaoImpl<MtGoodsParams> implements MtGoodsParamsDao{

	@Override
	public List<MtGoodsParams> getParamsByGoodsId(String goodsId) {
		return getCurrentSession().createCriteria(MtGoodsParams.class).add(Property.forName("goodsId").eq(Integer.parseInt(goodsId))).list();
	}

}
