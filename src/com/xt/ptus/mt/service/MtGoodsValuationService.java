package com.xt.ptus.mt.service;

import java.util.List;

import com.xt.ptus.base.BaseService;
import com.xt.ptus.mt.entity.MtGoodsValuation;
import com.xt.ptus.obejcts.Pagination;

public interface MtGoodsValuationService extends BaseService<MtGoodsValuation>{
	
	public Pagination<MtGoodsValuation> getValuationsByGoodsId(String goodsId, String page, String rows);

	//通过商家获取商品评论
	public List<MtGoodsValuation> getGoodsValuationBySellerId(String sellerId);

	//获取单条评论和管理员回复
	public MtGoodsValuation getValuationReplyInfoById(String id, String sellerId);
}
