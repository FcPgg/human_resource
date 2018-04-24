package com.xt.ptus.mt.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.mt.dao.MtGoodsDao;
import com.xt.ptus.mt.entity.MtGoods;
import com.xt.ptus.mt.service.MtGoodsService;

@Service
public class MtGoodsServiceImpl extends BaseServiceImpl<MtGoods> implements MtGoodsService{
	
	private static Logger logger = Logger.getLogger(MtGoodsServiceImpl.class);
	
	@Autowired
	private MtGoodsDao goodsDao;
	
	
	@Override
	public MtGoods getArchivesInfoById(int id) {
		return goodsDao.getArchivesInfoById(id);
	}
	
}
