package  com.xt.ptus.mt.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.mt.dao.MtGoodsDao;
import com.xt.ptus.mt.dao.MtGoodsValuationAttachementsDao;
import com.xt.ptus.mt.dao.MtGoodsValuationDao;
import com.xt.ptus.mt.dao.MtGoodsValuationReplyDao;
import com.xt.ptus.mt.entity.MtGoods;
import com.xt.ptus.mt.entity.MtGoodsValuation;
import com.xt.ptus.mt.entity.MtGoodsValuationAttachements;
import com.xt.ptus.mt.entity.MtGoodsValuationReply;
import com.xt.ptus.mt.service.MtGoodsValuationService;
import com.xt.ptus.obejcts.Pagination;
import com.xt.ptus.util.StringUtil;

@Service
public class MtGoodsValuationServiceImpl extends BaseServiceImpl<MtGoodsValuation> implements MtGoodsValuationService{

	@Autowired
	private MtGoodsValuationDao dao;
	
	@Autowired 
	private MtGoodsDao goodsDao;
	
	@Autowired
	private MtGoodsValuationAttachementsDao attDao;
	
	@Autowired
	private MtGoodsValuationReplyDao replyDao;
	
	
	@Override
	public void beforeInsert(MtGoodsValuation t) {
		t.setValuationTime(new Date());
	}
	
	@Override
	public void afterUpdate(MtGoodsValuation t) {
		if(t.getAttachements() != null && t.getAttachements().size() > 0){
			for(MtGoodsValuationAttachements att : t.getAttachements()){
				if(!StringUtil.IsNullOrEmpty(att.getId()) && Integer.parseInt(att.getId()) > 0){
					attDao.update(att);
				} else {
					att.setValuationId(Integer.parseInt(t.getId()));
					attDao.save(att);
				}
			}
		}
	}

	@Override
	public Pagination<MtGoodsValuation> getValuationsByGoodsId(String goodsId, String page, String rows) {
		DetachedCriteria dc = DetachedCriteria.forClass(MtGoodsValuation.class);
		
		dc.add(Property.forName("goodsId").eq(Integer.parseInt(goodsId)));
		
		Pagination<MtGoodsValuation> pagination = dao.findByPagination(dc, Integer.parseInt(page), Integer.parseInt(rows), Order.desc("valuationTime")); 
		
		List<MtGoodsValuation> list = pagination.getData();
		if(list != null && list.size() > 0){
			for(MtGoodsValuation v : list){
				v.setAttachements(attDao.getAttachements(v.getId()));
			}
		}
		
		return pagination;
	}

	/**
	 * 通过商家获取评论列表
	 */
	@Override
	public List<MtGoodsValuation> getGoodsValuationBySellerId(String sellerId) {

		Session session = getCurrentSession();
		DetachedCriteria inGoodsIdCriteria = DetachedCriteria.forClass(MtGoods.class);
		inGoodsIdCriteria.setProjection(Property.forName("id"));
		inGoodsIdCriteria.add(Property.forName("sellerId").eq(Integer.parseInt(sellerId)));
		
		// 获取评论
		Criteria valuationCountCri = session.createCriteria(MtGoodsValuation.class);
		valuationCountCri.add(Property.forName("goodsId").in(inGoodsIdCriteria));
		List<MtGoodsValuation> goodsValuation = valuationCountCri.list();
		return goodsValuation;
	}

	/**
	 * 
	 */
	@Override
	public MtGoodsValuation getValuationReplyInfoById(String id , String sellerId) {
          MtGoodsValuation valuation = dao.get(id, MtGoodsValuation.class);
          List<MtGoodsValuationReply> reply = replyDao.getReplyByValuationIdAndSellerId(id,sellerId);
          valuation.setReply(reply);
		return valuation;
	}
}
