package  com.xt.ptus.mt.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.mt.entity.MtGoodsSpec;
import com.xt.ptus.mt.dao.MtGoodsSpecDao;

@Repository
public class MtGoodsSpecDaoImpl extends BaseDaoImpl<MtGoodsSpec> implements MtGoodsSpecDao{

	@Override
	public List<MtGoodsSpec> getSpecsByGoodsId(String goodsId) {
		Session session = getCurrentSession();
		
		Criteria criteria = session.createCriteria(MtGoodsSpec.class);
		
		criteria.add(Property.forName("goodsId").eq(Integer.parseInt(goodsId)));
		
		return criteria.list();
	}

	/**
	 * 获取商品价格
	 */
	@Override
	public Map<String, Double> getGoodsPrice(String goodsId) {
		SQLQuery query = getCurrentSession().createSQLQuery("select MAX(price) as maxPrice, min(price) as minPrice from mt_goods_spec where goods_id = ?");
		query.setParameter(0, Integer.parseInt(goodsId));
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		Map<String, BigDecimal> result = (Map<String, BigDecimal>) query.uniqueResult();
		System.out.println("result:"+result);
		Map<String, Double> resultMap = new HashMap<String, Double>();
		
		if(result != null){
			for(String key : result.keySet()){
				resultMap.put(key, Double.valueOf(result.get(key).toString()));
			}
		}
		
		return resultMap;
	}
}
