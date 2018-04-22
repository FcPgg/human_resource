package com.xt.ptus.helper;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 网易云短信发送工具类
 * @author Administrator
 *
 */
public class SMSHelper {
    private static final String SERVER_URL = "https://api.netease.im/sms/sendcode.action";//发送验证码的请求路径URL
    private static final String VERIFY_URL = "https://api.netease.im/sms/verifycode.action";//验证地址
    private static final String APP_KEY = "9955491bc03bbc66ff88dd32da12647c";//网易云信分配的账号
    private static final String APP_SECRET = "c873883fc860";//网易云信分配的密钥

    private static String NONCE = "";
    
    private static String currentTime = null;
    /**
     * 发送验证码短信
     * @param phone
     * @return Map<String,String> {code:状态码,成功为200, obj:验证码, msg:msg字段表示此次发送的sendid}
     * @throws IOException
     */
    public static Map<String, String> sendSMSIdentifyingCode(String phone) throws IOException {
    	Map<String,String> headers = new HashMap<String, String>();
    	headers.put("AppKey", APP_KEY);
    	
    	String nonce = getNonce();
    	
    	String curTime = String.valueOf((new Date().getTime()/1000L));
    	currentTime = curTime;
    	
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, String.valueOf(nonce), curTime);
        
        headers.put("Nonce", nonce);
    	headers.put("CurTime", curTime);
    	headers.put("CheckSum", checkSum);
    	headers.put("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
    	
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("mobile", phone);
    	params.put("codeLen", "6");
    	
    	String response = NetProxyHelper.sendPost(headers, SERVER_URL, params);
    	
    	return (new Gson()).fromJson(response, new TypeToken<HashMap<String, String>>(){}.getType());
    }
    
    public static Map<String, String> verifyIdentifyingCode(String phone, String code) throws IOException {
    	Map<String,String> headers = new HashMap<String, String>();
    	headers.put("AppKey", APP_KEY);
    	
    	headers.put("Nonce", NONCE);
    	
    	String curTime = String.valueOf((new Date().getTime()/1000L));
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, currentTime);
         
    	headers.put("CurTime", curTime);
    	headers.put("CheckSum", checkSum);
    	headers.put("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
    	
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("mobile", phone);
    	params.put("code", code);
    	
    	String response = NetProxyHelper.sendPost(headers, VERIFY_URL, params);
    	
    	return (new Gson()).fromJson(response, new TypeToken<HashMap<String, String>>(){}.getType());
    }
    
    private static String getNonce(){
    	int max=999999;
        int min=100000;
        Random random = new Random();

        int nonce = random.nextInt(max)%(max-min+1) + min;
        NONCE = String.valueOf(nonce);
        return  String.valueOf(nonce);
    }
}