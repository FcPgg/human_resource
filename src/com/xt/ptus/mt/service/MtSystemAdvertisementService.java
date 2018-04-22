package com.xt.ptus.mt.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xt.ptus.base.BaseService;
import com.xt.ptus.mt.entity.MtSystemAdvertisement;
import com.xt.ptus.obejcts.Pagination;

public interface MtSystemAdvertisementService extends BaseService<MtSystemAdvertisement>{

	/**
	 * 更新疾病治疗方案
	 * @param myphoto
	 * @param name
	 * @param symptom
	 * @param programme
	 * @return
	 * @throws Exception 

	 */
	public Object updateAdvertisement(int attId, String name, String symptom, String programme,int category) throws Exception;

	/**
	 * 获取有效广告
	 * @return
	 */
	public List<MtSystemAdvertisement> getSystemAdvertisements();

	/**
	 * 通过id获取治疗方案
	 * @param parameter
	 * @return
	 */
	public MtSystemAdvertisement getContentById(String id);
	


}
