package com.xt.ptus.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.Gson;
import com.xt.ptus.util.DateUtil;
import com.xt.ptus.util.MD5Util;

public class MyTest {

	@Test
	public void test() {
		// System.out.println(MD5Util.MD5("appkey=f6ad14f134cddffa22da3079&timestamp=1503374657000&random_str=022cd9fd995849b58b3ef0e943421ed9&key=11ba437558b7022fbba77f4ff89b2bd1"));
		 System.out.println("111 "+MD5Util.MD5("202cb962ac59075b964b07152d234b70"));
		// Map<String,Object> parameters = new HashMap<String, Object>();
		// parameters.put("showPage", "goodsPage");
		//
		// Map<String, String> param = new HashMap<String, String>();
		// param.put("sellerId", "1");
		// param.put("goodsId", "1");
		// parameters.put("params", param);
		//
		// Gson gson = new Gson();
		// System.out.println(gson.toJson(parameters));
	}

	@Ignore
	@org.junit.Test
	public void Test() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		Date s = calendar.getTime();

		calendar.setTime(new Date());
		Date e = calendar.getTime();

		System.out.println(DateUtil.daysBetween(s, e));
	}

	private static String firstDay;
	private static String lastDay;

	@Ignore
	@org.junit.Test
	public void Test1() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		// 获取上月的第一天
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		firstDay = format.format(cal_1.getTime());
		System.out.println("-----1------firstDay:" + firstDay);
		// 获取上月的最后一天
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.DAY_OF_MONTH, 0);// 设置为1号,当前日期既为本月第一天
		lastDay = format.format(cale.getTime());
		System.out.println("-----2------lastDay:" + lastDay);

		// 获取当前月第一天：
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		System.out.println("===============first:" + first);

		// 获取当前月最后一天
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		System.out.println("===============last:" + last);
	}
	
	@Ignore
	@Test
	public void Test2() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = sdf.parse("2017-09-10 11:10:58");
		
		Date now = new Date();
		System.out.println(DateUtil.daysBetween(date1, now));
	}
	
	@Ignore
	@Test
	public void generateParams(){
		Map<String, Object> params = new HashMap<String ,Object>();
		params.put("showPage", "goodsDetail");//page route key
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("sellerId", "1");
		param.put("goodsId", "1");
		params.put("params", param);
		Gson gson = new Gson();
		System.out.println(gson.toJson(params));
	}
	
	@Test
	public void testWecharLogin(){
		String url = getRequestCodeUrl("http%3a%2f%2fyiwke.ngrok.cc%2fWeb%2fwechat%2fredirectUri%2fgetWecharResponse");
		System.out.println(url);
	}
	/**
	 * 生成用于获取access_token的Code的Url
	 *
	 * @param redirectUrl
	 * @return
	 */
	public String getRequestCodeUrl(String redirectUrl) {
		return String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect",
				"wx8a4486eb2002d085", redirectUrl, "snsapi_userinfo", "xxxx_state");
	}
}
