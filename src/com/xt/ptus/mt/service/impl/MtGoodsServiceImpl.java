package com.xt.ptus.mt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.constants.Constants;
import com.xt.ptus.mt.controller.params.MtOrderGoodsParam;
import com.xt.ptus.mt.dao.MtGoodsDao;
import com.xt.ptus.mt.dao.MtGoodsGalleryDao;
import com.xt.ptus.mt.dao.MtGoodsParamsDao;
import com.xt.ptus.mt.dao.MtGoodsSpecDao;
import com.xt.ptus.mt.dao.MtGoodsValuationDao;
import com.xt.ptus.mt.entity.MtGoods;
import com.xt.ptus.mt.entity.MtGoodsGallery;
import com.xt.ptus.mt.entity.MtGoodsParams;
import com.xt.ptus.mt.entity.MtGoodsSpec;
import com.xt.ptus.mt.entity.MtUserBrowseLog;
import com.xt.ptus.mt.pojo.MtGoodsPojo;
import com.xt.ptus.mt.service.MtGoodsService;
import com.xt.ptus.obejcts.Pagination;
import com.xt.ptus.util.StringUtil;

@Service
public class MtGoodsServiceImpl extends BaseServiceImpl<MtGoods> implements MtGoodsService{
	
	private static Logger logger = Logger.getLogger(MtGoodsServiceImpl.class);
	
	@Autowired
	private MtGoodsDao goodsDao;

	@Autowired
	private MtGoodsSpecDao specDao;
	
	@Autowired
	private MtGoodsParamsDao paramsDao;
	
	@Autowired
	private MtGoodsGalleryDao galleryDao;
	
	
	@Autowired
	private MtGoodsValuationDao valuationDao;
	
	
	/**
	 * 更新商品实体后更新商品规格
	 */
	@Override
	public void afterUpdate(MtGoods t) {
		if(t.getGoodsSpecs() != null && t.getGoodsSpecs().size() > 0){
			for(MtGoodsSpec spec : t.getGoodsSpecs()){
				if(!StringUtil.IsNullOrEmpty(spec.getId()) && Integer.parseInt(spec.getId()) > 0){
					specDao.update(spec);
				} else {
					spec.setGoodsId(Integer.parseInt(t.getId()));
					specDao.save(spec);
				}
			}
		}
		
		if(t.getGoodsParams() != null && t.getGoodsParams().size() > 0){
			for(MtGoodsParams param : t.getGoodsParams()){
				if(!StringUtil.IsNullOrEmpty(param.getId()) && Integer.parseInt(param.getId()) > 0 ){
					paramsDao.update(param);
				} else {
					param.setGoodsId(Integer.parseInt(t.getId()));
					paramsDao.save(param);
				}
			}
		}
		
		if(t.getGoodsGallery() != null && t.getGoodsGallery().size() > 0){
			for(MtGoodsGallery gallery : t.getGoodsGallery()){
				if(!StringUtil.IsNullOrEmpty(gallery.getId()) && Integer.parseInt(gallery.getId()) > 0){
					galleryDao.update(gallery);
				} else {
					gallery.setGoodsId(Integer.parseInt(t.getId()));
					galleryDao.save(gallery);
				}
			}
		}
	}

	@Override
	public MtGoods getComplexGoods(String id , String userId) {
		MtGoods good = goodsDao.get(id, MtGoods.class);
		
		if(good != null){
			good.setGoodsSpecs(specDao.getSpecsByGoodsId(id));
			
			List<MtGoodsGallery> galleries = galleryDao.getGalleryByGoodsId(id);
			if(galleries != null && galleries.size() > 0){
				good.setIndexResourceId(galleries.get(0).getResourceId());
			}
			good.setGoodsGallery(galleries);
			
			good.setGoodsParams(paramsDao.getParamsByGoodsId(id));
			
			good.setGoodsValuations(valuationDao.getOneValuationByGoodsId(good.getId()));
			
		}
		return good;
	}

	/**
	 * 商品下架
	 */
	@Override
	public void undercarriageGoods(String id, int undercarriageor) {
		MtGoods good = goodsDao.get(id, MtGoods.class);
		if(good != null){
			good.setStatus(Constants.GOODS_STATUS_UNDER_CARRIAGE);
			//good.setUndercarriageor(undercarriageor);
			good.setUndercarriageTime(new Date());
			goodsDao.update(good);
		}
	}

	@Override
	public Pagination<MtGoods> getGoodsBySellerId(String sellerId, int page, int rows) {
		return goodsDao.getGoodsBySellerId(sellerId, page, rows);
	}

	@Override
	public List<MtGoodsPojo> getGoodsByIds(MtOrderGoodsParam[] array) {
		return goodsDao.getGoodsByIds(array);
	}

	@Override
	public List<MtGoods> getUserAttenedGoods(String userId) {
		return goodsDao.getUserAttendGoods(userId);
	}


	@Override
	public Pagination<MtGoods> getRecommendsGoods(int page, int rows) {
		return goodsDao.getRecommendGoods(page, rows);
	}

	@Override
	public List<MtGoods> getGoodsName(String name) {
		return goodsDao.getGoodsName(name);
	}

	@Override
	public MtGoods getArchivesInfoById(int id) {
		return goodsDao.getArchivesInfoById(id);
	}
	
}
