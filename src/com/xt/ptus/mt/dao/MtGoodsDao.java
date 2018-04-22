package com.xt.ptus.mt.dao;

import java.util.List;
import java.util.Map;

import com.xt.ptus.base.BaseDao;
import com.xt.ptus.mt.controller.params.MtOrderGoodsParam;
import com.xt.ptus.mt.entity.MtGoods;
import com.xt.ptus.mt.pojo.MtGoodsPojo;
import com.xt.ptus.obejcts.Pagination;

public interface MtGoodsDao  extends BaseDao<MtGoods>{

	Pagination<MtGoods> getGoodsBySellerId(String sellerId, int page, int rows);
  
	int getGoodsCountBySellerId(String sellerId);

	List<MtGoodsPojo> getGoodsByIds(MtOrderGoodsParam[] array);

	List<MtGoods> getUserAttendGoods(String userId);

	List<MtGoods> getGoodsList(int page, int rows, Map<String, Object> params);
	
	Pagination<MtGoods> getRecommendGoods(int page, int rows);

	List<MtGoods> getGoodsName(String name);

	List<MtGoods> getGoodsBySellerId(String sellerId);
}
