package com.xt.ptus.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtil {

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 字符串的日期格式的计算
	 */
	public static int daysBetween(String smdate, String bdate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	public static String getWeekOfDate(Date dt) {
		String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	// 判断选择的日期是否是本周
	public static boolean isThisWeek(long time) {
		Calendar calendar = Calendar.getInstance();
		int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
		calendar.setTime(new Date(time));
		int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
		if (paramWeek == currentWeek) {
			return true;
		}
		return false;
	}

	// 判断选择的日期是否是今天
	public static boolean isToday(long time) {
		return isThisTime(time, "yyyy-MM-dd");
	}

	// 判断选择的日期是否是本月
	public static boolean isThisMonth(long time) {
		return isThisTime(time, "yyyy-MM");
	}

	private static boolean isThisTime(long time, String pattern) {
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String param = sdf.format(date);// 参数时间
		String now = sdf.format(new Date());// 当前时间
		if (param.equals(now)) {
			return true;
		}
		return false;
	}

	
	/**
	 * 获取X天后的时间
	 * @throws ParseException 
	 * x为正数，取x天后的时间（秒）
	 */
	 public static long getXdaysLater(int x) throws ParseException{
		 Calendar calendar2 = Calendar.getInstance();
		 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 calendar2.add(Calendar.DATE, x);
		 String days_after = sdf2.format(calendar2.getTime());
	     return sdf2.parse(days_after).getTime()/1000;
	    }
	
	@Test
	public void testTime() throws ParseException {
//		// System.out.println(isToday(new Date().getTime()));
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		System.out.println(String.format("%02d", cal.get(Calendar.DATE)));
		System.out.println(DateUtil.getXdaysLater(7));

	}
}
