package com.xt.ptus.mt.dao;

import com.xt.ptus.base.BaseDao;
import com.xt.ptus.mt.entity.MtGoods;

public interface MtGoodsDao  extends BaseDao<MtGoods>{

	MtGoods getArchivesInfoById(int id);
}
