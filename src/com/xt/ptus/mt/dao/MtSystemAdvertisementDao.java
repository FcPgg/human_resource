package com.xt.ptus.mt.dao;

import java.util.List;

import com.xt.ptus.base.BaseDao;
import com.xt.ptus.mt.entity.MtSystemAdvertisement;
import com.xt.ptus.obejcts.Pagination;

public interface MtSystemAdvertisementDao extends BaseDao<MtSystemAdvertisement>{

	List<MtSystemAdvertisement> getSystemAdvertisements();
}
