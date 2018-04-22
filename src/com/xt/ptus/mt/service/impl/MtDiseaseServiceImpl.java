package  com.xt.ptus.mt.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.mt.dao.MtDiseaseDao;
import com.xt.ptus.mt.dao.MtSystemAdvertisementDao;
import com.xt.ptus.mt.entity.MtDisease;
import com.xt.ptus.mt.entity.MtSystemAdvertisement;
import com.xt.ptus.mt.service.MtDiseaseService;

@Service
public class MtDiseaseServiceImpl extends BaseServiceImpl<MtDisease> implements MtDiseaseService{

	@Autowired
	private MtDiseaseDao diseaseDao;
	
	@Override
	public MtDisease updateDisease(int attId, String address, int categroy, String symptom, String season,
			String describe) {
         MtDisease disease = new MtDisease();
         disease.setAttId(attId);
         disease.setAddress(address);
         disease.setCategroy(categroy);
         disease.setSymptom(symptom);
         disease.setSeason(season);
         disease.setDescribe(describe);
         disease.setCreateTime(new Date());
         diseaseDao.save(disease);
         return disease;
	}

	@Override
	public MtDisease getTopTenDisease() {
		// TODO Auto-generated method stub
		return null;
	}

}
