package com.xt.ptus.sys.dao;

import java.util.List;
import java.util.Map;

import com.xt.ptus.base.BaseDao;
import com.xt.ptus.sys.entity.SysDictionaryDatas;
import com.xt.ptus.sys.entity.SysDictionarys;

public interface SysDictionaryDatasDao extends BaseDao<SysDictionaryDatas>{
	/**
	 * 根据字典编号获取字典
	 * @param dictId
	 * @return
	 */
	List<SysDictionaryDatas> getDictionaryByDictId(String dictId);
	
	/**
	 * 根据代码获取字典
	 * @param code
	 * @return
	 */
	List<SysDictionaryDatas> getDictionaryByCode(String code, Map<String,Object> params);

	/**
	 * 根据字典名获取字典
	 * @param dictionary
	 * @return
	 */
	List<SysDictionaryDatas> getDictionaryByDictionary(String dictionary);
	
	/**
	 * 根据代码获取字典实体
	 * @param code
	 * @return
	 */
	SysDictionarys getDictionaryEntityByCode(String code);

	/**
	 * 获取物流公司编号
	 * @param streamCompany
	 * @return
	 */
	String getStreamCompanyNo(String streamCompany);
}
