package com.xt.ptus.mt.service;

import com.xt.ptus.base.BaseService;
import com.xt.ptus.mt.entity.MtGoodsValuationReply;

public interface MtGoodsValuationReplyService extends BaseService<MtGoodsValuationReply>{

	/**
	 * 回复
	 * @param valuationId
	 * @param replier
	 * @param contents
	 * @return
	 */
	public MtGoodsValuationReply valuationReply(int valuationId, int replier, String contents);

}
