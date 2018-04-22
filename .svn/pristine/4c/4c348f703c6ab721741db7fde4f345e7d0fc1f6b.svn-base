package com.xt.ptus.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.sys.entity.SysDictionaryDatas;
import com.xt.ptus.sys.entity.SysDictionarys;
import com.xt.ptus.sys.service.SysDictionaryDatasService;
import com.xt.ptus.sys.service.SysDictionarysService;

/**
 * SysDictionarysService - 实现类
 * @author john
 *
 */
@Service
public class SysDictionarysServiceImpl extends BaseServiceImpl<SysDictionarys> implements SysDictionarysService {

	@Autowired
	private SysDictionaryDatasService datasServcie;
	
	/**
	 * 删除字典后删除其包含的数据
	 */
	@Override
	public void afterRemove(SysDictionarys t) {
		List<SysDictionaryDatas> list = datasServcie.getDictionaryByDictId(t.getId());
		if(list != null){
			for(SysDictionaryDatas item : list){
				datasServcie.remove(item);
			}
		}
	}
}
