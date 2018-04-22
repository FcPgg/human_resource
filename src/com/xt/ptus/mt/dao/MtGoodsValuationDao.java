package com.xt.ptus.mt.dao;

import java.util.List;

import com.xt.ptus.base.BaseDao;
import com.xt.ptus.mt.entity.MtGoodsValuation;

public interface MtGoodsValuationDao extends BaseDao<MtGoodsValuation>{

	List<MtGoodsValuation> getOneValuationByGoodsId(String id);

}
