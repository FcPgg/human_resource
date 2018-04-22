package com.xt.ptus.mt.dao;

import java.util.List;

import com.xt.ptus.base.BaseDao;
import com.xt.ptus.mt.entity.MtGoodsGallery;

public interface MtGoodsGalleryDao extends BaseDao<MtGoodsGallery>{
	public List<MtGoodsGallery> getGalleryByGoodsId(String goodsId);
}
