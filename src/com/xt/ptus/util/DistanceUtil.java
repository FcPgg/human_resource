package com.xt.ptus.util;


public class DistanceUtil {
	// 地球平均半径
	private static final double EARTH_RADIUS = 6378137;

	// 把经纬度转为度（°）
	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
	 * 
	 * @param targetLng
	 * @param targetLat
	 * @param sourceLng
	 * @param sourceLat
	 * @return
	 */
	public static double getDistance(double targetLng, double targetLat, double sourceLng, double sourceLat) {
		double radLat1 = rad(targetLat);
		double radLat2 = rad(sourceLat);
		double a = radLat1 - radLat2;
		double b = rad(targetLng) - rad(sourceLng);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return Double.valueOf(String.format("%.2f", s));
	}

}
