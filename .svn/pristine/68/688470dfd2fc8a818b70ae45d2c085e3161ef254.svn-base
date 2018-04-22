package com.xt.ptus.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.sys.dao.SysDictionaryDatasDao;
import com.xt.ptus.sys.entity.SysDictionaryDatas;
import com.xt.ptus.sys.entity.SysDictionarys;
import com.xt.ptus.sys.service.SysDictionaryDatasService;

@Service
public class SysDictionaryDatasServiceImpl extends BaseServiceImpl<SysDictionaryDatas> implements SysDictionaryDatasService {

	private static Logger logger = Logger.getLogger(SysDictionaryDatasServiceImpl.class);
	
	@Autowired
	private SysDictionaryDatasDao dao;
	
	/**
	 * 根据字典编号查询字典数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SysDictionaryDatas> getDictionaryByDictId(String dictId) {
		return dao.getDictionaryByDictId(dictId);
	}
	
	/**
	 * 根据字典代码获取字典
	 */
	@Override
	public List<SysDictionaryDatas> getDictionaryByCode(String code, Map<String,Object> params) {
		return dao.getDictionaryByCode(code, params);
	}

	/**
	 * 根据表达式获取字典，需要在字典实体的表达式字段中配置一个可执行的SQL语句
	 * （参数方式查询）
	 * select id, name from sys_users where id = :id
	 */
	@SuppressWarnings("unchecked")
	public List<SysDictionaryDatas> getDictionaryByExpression(String code, Map<String,Object> params) {
		List<SysDictionaryDatas> result = new ArrayList<SysDictionaryDatas>();
		
		Session session = this.getCurrentSession();
		SysDictionarys dict = dao.getDictionaryEntityByCode(code);
		
		SQLQuery query = session.createSQLQuery(dict.getExpression());  
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		if(params != null){
			for (String key : params.keySet()) {  
				query.setParameter(key, params.get(key));  
	        }  
		}
		
		List<Map<String,Object>> list = query.list();
		
		for(Map<String,Object> map : list){
			SysDictionaryDatas data = new SysDictionaryDatas();
			data.setCode(map.get(dict.getValueField()).toString());
			data.setDescription(map.get(dict.getDisplayField()).toString());
			result.add(data);
		}
		
		return result;
	}

	/**
	 * 通过description获取字典
	 */
	@Override
	public List<SysDictionaryDatas> getDictionaryByDictionary(String dictionary) {
		Session session = this.getCurrentSession();
		Criteria cri = session.createCriteria(SysDictionaryDatas.class);
		cri.add(Restrictions.eq("description", dictionary));
		return cri.list();
	}
}
