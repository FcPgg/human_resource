package com.xt.ptus.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericUtil {
	/**
	 * 获取参数真正类型
	 * 
	 * @return
	 */
	public static Class getActualClass(Class clazz, int index) {
		Type type = clazz.getGenericSuperclass();
		if (!(type instanceof ParameterizedType)) {
			return getActualClass(clazz.getSuperclass(), index);
		}
		Type[] types = ((ParameterizedType) type).getActualTypeArguments();
		if (index >= types.length || index < 0) {
			return Object.class;
		}
		if (types[index] instanceof Class) {
			return (Class) types[index];
		}
		return Object.class;
	}
	
	public static Class getGenericSuperClass(
            Class clazz) {
    
        Type type = clazz.getGenericSuperclass();
        if(!(type instanceof ParameterizedType)){
            throw new RuntimeException();
        }
        ParameterizedType parameterizedType=(ParameterizedType)type;
        Type [] types = parameterizedType.getActualTypeArguments();
        
        return (Class)types[0];
    }
}
