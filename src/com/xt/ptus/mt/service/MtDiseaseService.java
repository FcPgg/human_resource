package com.xt.ptus.mt.service;

import com.xt.ptus.base.BaseService;
import com.xt.ptus.mt.entity.MtDisease;

public interface MtDiseaseService extends BaseService<MtDisease>{

	public MtDisease updateDisease(int attId, String address, int categroy, String symptom, String season, String describe);

	public MtDisease getTopTenDisease();

}
