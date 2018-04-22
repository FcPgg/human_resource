package com.xt.ptus.mt.dao;

import java.util.List;

import com.xt.ptus.base.BaseDao;
import com.xt.ptus.mt.entity.MtGoodsValuationReply;

public interface MtGoodsValuationReplyDao extends BaseDao<MtGoodsValuationReply>{

	//通过评论编号获取回复
	List<MtGoodsValuationReply> getReplyByValuationId(int valuationId);

	//通过评论编号和商家ID获取商家回复
	List<MtGoodsValuationReply> getReplyByValuationIdAndSellerId(String id, String sellerId);

}
