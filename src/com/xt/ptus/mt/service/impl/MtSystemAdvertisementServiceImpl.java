package com.xt.ptus.mt.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.constants.SystemConstants;
import com.xt.ptus.mt.dao.MtSystemAdvertisementDao;
import com.xt.ptus.mt.entity.MtSystemAdvertisement;
import com.xt.ptus.mt.service.MtSystemAdvertisementService;
import com.xt.ptus.obejcts.Pagination;

@Service
public class MtSystemAdvertisementServiceImpl extends BaseServiceImpl<MtSystemAdvertisement> implements MtSystemAdvertisementService {

	@Autowired
	private MtSystemAdvertisementDao advertisementDao;

	@Override
	public MtSystemAdvertisement updateAdvertisement(int attId, String name, String programme, String symptom,int category) throws Exception {


		Map<String, Object> advertisements = new HashMap<String, Object>();
		MtSystemAdvertisement advertisement = new MtSystemAdvertisement();
		advertisement.setAttId(attId);
		advertisement.setAdName(name);
		advertisement.setProgramme(programme);
		advertisement.setSymptom(symptom);
		advertisement.setCategory(category);
		advertisement.setCreateTime(new Date());
		advertisementDao.save(advertisement);
		return advertisement;
	}

	@Override
	public List<MtSystemAdvertisement> getSystemAdvertisements() {
		return advertisementDao.getSystemAdvertisements();
	}

	@Override
	public MtSystemAdvertisement getContentById(String id) {
		MtSystemAdvertisement systemAdvertisement = advertisementDao.get(id, MtSystemAdvertisement.class);
		System.out.println("cs"+id);
		return systemAdvertisement;
	}



}
