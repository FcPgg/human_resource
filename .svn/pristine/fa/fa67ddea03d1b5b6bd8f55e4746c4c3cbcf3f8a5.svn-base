package com.xt.ptus.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
	
	/**
	 * 将Map中的key中的属性名转换为字段名   userName ---> user_name
	 * @param src
	 * @return
	 */
	public static Map<String,String> formatKeyToFieldName(Map<String,String> src){
		Map<String,String> params = new HashMap<String,String>();
		if(src != null && src.size() > 0){
			for(String key : src.keySet()){
				params.put("key", StringUtil.propNameParseFieldName(key));
				params.put("value", src.get(key));
			}
		}
		return params;
	}
}
