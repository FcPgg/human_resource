package  com.xt.ptus.mt.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.mt.dao.MtGoodsGalleryDao;
import com.xt.ptus.mt.entity.MtGoodsGallery;

@Repository
public class MtGoodsGalleryDaoImpl extends BaseDaoImpl<MtGoodsGallery> implements MtGoodsGalleryDao{

	@Override
	public List<MtGoodsGallery> getGalleryByGoodsId(String goodsId) {
		return getCurrentSession().createCriteria(MtGoodsGallery.class).add(Property.forName("goodsId").eq(Integer.parseInt(goodsId))).addOrder(Order.asc("sort")).list();
	}
}
