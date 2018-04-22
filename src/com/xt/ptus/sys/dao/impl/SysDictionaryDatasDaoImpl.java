package com.xt.ptus.sys.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.impl.BaseDaoImpl;
import com.xt.ptus.sys.dao.SysDictionaryDatasDao;
import com.xt.ptus.sys.entity.SysDictionaryDatas;
import com.xt.ptus.sys.entity.SysDictionarys;
import com.xt.ptus.util.StringUtil;

@Repository
public class SysDictionaryDatasDaoImpl extends BaseDaoImpl<SysDictionaryDatas> implements SysDictionaryDatasDao {
	
	/**
	 * 根据字典编号查询字典数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SysDictionaryDatas> getDictionaryByDictId(String dictId) {
		Session session = this.getCurrentSession();
		Criteria cri = session.createCriteria(SysDictionaryDatas.class);
		cri.add(Restrictions.eq("dictionaryId", Integer.parseInt(dictId)));
		return cri.list();
	}

	/**
	 * 根据字典代码获取字典
	 */
	@Override
	public List<SysDictionaryDatas> getDictionaryByCode(String code, Map<String, Object> params) {
		List<SysDictionaryDatas> list = null;
		SysDictionarys dict = getDictionaryEntityByCode(code);
		if (dict != null) {
			if (!StringUtil.IsNullOrEmpty(dict.getExpression())) {
				list = getDictionaryByExpression(code, params);
			} else {
				list = getDictionaryByDictId(dict.getId());
			}
		}
		return list;
	}

	/**
	 * 根据代码获取字典实体
	 * 
	 * @param code
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public SysDictionarys getDictionaryEntityByCode(String code) {
		SysDictionarys dict = null;
		Session session = this.getCurrentSession();
		Criteria cri = session.createCriteria(SysDictionarys.class);
		cri.add(Restrictions.eq("code", code));
		List<SysDictionarys> resultList = cri.list();
		if (resultList != null && resultList.size() > 0)
			dict = (SysDictionarys) resultList.get(0);
		return dict;
	}
	

	/**
	 * 根据表达式获取字典，需要在字典实体的表达式字段中配置一个可执行的SQL语句 （参数方式查询） select id, name from
	 * sys_users where id = :id
	 */
	@SuppressWarnings("unchecked")
	public List<SysDictionaryDatas> getDictionaryByExpression(String code, Map<String, Object> params) {
		List<SysDictionaryDatas> result = new ArrayList<SysDictionaryDatas>();

		Session session = this.getCurrentSession();
		SysDictionarys dict = getDictionaryEntityByCode(code);

		SQLQuery query = session.createSQLQuery(dict.getExpression());
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		if (params != null) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}

		List<Map<String, Object>> list = query.list();

		for (Map<String, Object> map : list) {
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

	/**
	 * 获取快递公司代码编号
	 */
	@Override
	public String getStreamCompanyNo(String streamCompany) {
		Session session = this.getCurrentSession();
		Criteria criteria = session.createCriteria(SysDictionaryDatas.class);
		criteria.add(Restrictions.eq("description", streamCompany));
		criteria.setProjection(Projections.groupProperty("code"));
		return (String) criteria.uniqueResult();
	}

}
