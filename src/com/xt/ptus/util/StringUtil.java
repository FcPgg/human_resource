package com.xt.ptus.util;

public class StringUtil {
	
	/**
	 * 判断String是否为空
	 * @param str
	 * @return
	 */
	public static boolean IsNullOrEmpty(String str){
		return str == null || str.length() == 0;
	}
	
	public static String propNameParseFieldName(String propName){
		StringBuffer sb = new StringBuffer();
		if(!IsNullOrEmpty(propName)){
			String[] array = propName.split("");
			for(String s : array){
				if(!IsNullOrEmpty(s)){
					if(ifUpperCase(s)){
						sb.append("_").append(s.toLowerCase());
					} else {
						sb.append(s);
					}
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 检查是否为大写字母
	 * @param i
	 * @return
	 */
	private static boolean ifUpperCase(String i){
		return i.toUpperCase() == i;
	}
}
