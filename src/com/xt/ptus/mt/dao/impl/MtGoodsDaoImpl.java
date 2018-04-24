package com.xt.ptus.mt.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.mt.dao.MtGoodsDao;
import com.xt.ptus.mt.entity.MtGoods;

@Repository
public class MtGoodsDaoImpl extends BaseDaoImpl<MtGoods> implements MtGoodsDao {

	@Override
	public MtGoods getArchivesInfoById(int id) {
		Criteria criteria = getCurrentSession().createCriteria(MtGoods.class);
		criteria.add(Property.forName("id").eq(String.valueOf(id)));
		return (MtGoods) criteria.uniqueResult();
	}


}
