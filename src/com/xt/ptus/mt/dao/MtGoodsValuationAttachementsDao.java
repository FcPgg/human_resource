package com.xt.ptus.mt.dao;

import java.util.List;

import com.xt.ptus.base.BaseDao;
import com.xt.ptus.mt.entity.MtGoodsValuationAttachements;

public interface MtGoodsValuationAttachementsDao extends BaseDao<MtGoodsValuationAttachements>{

	List<MtGoodsValuationAttachements> getAttachements(String valuationId);

}
