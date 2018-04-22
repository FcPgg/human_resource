package com.xt.ptus.util;

import java.text.DecimalFormat;

import org.junit.Test;

public class DoubleUtil {
	
	@Test
	public void Test(){
		DecimalFormat df = new DecimalFormat("0.000");
//		String val = df.format(0.5069400000000001);
//		double value = Double.valueOf(df.format(0.5069400000000001));
		System.out.println( Math.round(0.407 * 100) * 0.01d);
		System.out.println(Double.parseDouble("5"));
	}
	
	public static double retainDecimal(double value, int figure){
		
		String[] array = String.valueOf(value).split(".");
		
		String before = "";
		for(int i = 0; i < array[0].length(); i++){
			before += "#";
		}
		
		String after = "";
		for(int i = 0; i < array[1].length(); i++){
			after += "0";
		}
		
		DecimalFormat  df   = new DecimalFormat(before + "0." + after);   

		return Double.valueOf(df.format(value));
	}
}
