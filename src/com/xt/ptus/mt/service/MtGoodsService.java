package com.xt.ptus.mt.service;

import java.util.List;
import java.util.Map;

import com.xt.ptus.base.BaseService;
import com.xt.ptus.mt.controller.params.MtOrderGoodsParam;
import com.xt.ptus.mt.entity.MtGoods;
import com.xt.ptus.mt.pojo.MtGoodsPojo;
import com.xt.ptus.obejcts.Pagination;

public interface MtGoodsService extends BaseService<MtGoods>{

	public void undercarriageGoods(String id, int undercarriageor);

	public Pagination<MtGoods> getGoodsBySellerId(String sellerId, int page, int ros);

	public List<MtGoodsPojo> getGoodsByIds(MtOrderGoodsParam[] array);

	public List<MtGoods> getUserAttenedGoods(String userId);

	public Pagination<MtGoods> getRecommendsGoods(int pageSize, int rows);

	public List<MtGoods> getGoodsName(String name);
	
	public MtGoods getComplexGoods(String id , String userId);

	public MtGoods getArchivesInfoById(int id);


}
