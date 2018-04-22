package  com.xt.ptus.mt.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.mt.entity.MtCreditOrderAttachements;
import com.xt.ptus.mt.entity.MtGoodsValuationReply;
import com.xt.ptus.mt.dao.MtGoodsValuationReplyDao;

@Repository
public class MtGoodsValuationReplyDaoImpl extends BaseDaoImpl<MtGoodsValuationReply> implements MtGoodsValuationReplyDao{

	//通过评论编号获取回复
	@Override
	public List<MtGoodsValuationReply> getReplyByValuationId(int valuationId) {

		Criteria criteria = getCurrentSession().createCriteria(MtGoodsValuationReply.class);
		criteria.add(Property.forName("valuationId").eq(valuationId));
		List reply = criteria.list();
		return reply;
 
	}

	//通过评论编号和商家ID获取商家回复
	@Override
	public List<MtGoodsValuationReply> getReplyByValuationIdAndSellerId(String id, String sellerId) {
		Criteria criteria = getCurrentSession().createCriteria(MtGoodsValuationReply.class);
		criteria.add(Property.forName("valuationId").eq(Integer.parseInt(id)));
		criteria.add(Property.forName("replier").eq(Integer.parseInt(sellerId)));
		List reply = criteria.list();
		return reply;
	}

}
