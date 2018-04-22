package com.xt.ptus.wechat.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.ptus.obejcts.Result;

@Controller
@RequestMapping("/wechat/params/")
public class WeChatController {
	private static Logger log = Logger.getLogger(WeChatController.class);
	
	// 获取相关的参数,在application.properties文件中
	private String appId;
	
	private String appSecret;
	
	// 微信参数
	private String accessToken;
	
	// 获取参数的时刻
	private Long getTiketTime = 0L;
	private Long getTokenTime = 0L;
	
	// 参数的有效时间,单位是秒(s)
	private Long tokenExpireTime = 0L;
	private Long ticketExpireTime = 0L;

	protected WxMpInMemoryConfigStorage config;
	protected WxMpService wxMpService;
	
	public WeChatController() throws IOException {
		InputStream is = this.getClass().getResourceAsStream("/wechat.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		
		this.appId = prop.getProperty("wechat.AppId"); // 设置微信公众号的appid
		this.appSecret = prop.getProperty("wechat.AppSecret"); // 设置微信公众号的app corpSecret

		
		config = new WxMpInMemoryConfigStorage();
		config.setAppId(appId); // 设置微信公众号的appid
		config.setSecret(appSecret); // 设置微信公众号的app corpSecret
		config.setToken(prop.getProperty("wechat.Token")); // 设置微信公众号的token
		config.setAesKey(prop.getProperty("wechat.AesKey")); // 设置微信公众号的EncodingAESKey
		
		wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(config);
	}
	// 获取微信参数
	@ResponseBody
	@RequestMapping("/getWechatParam")
	public Result getWechatParam(String url) throws WxErrorException {
		Result result = new Result();

		try {
			String jsApiTicket = wxMpService.getJsapiTicket();
			log.debug("wecharParam--jsApiTicket:" + jsApiTicket);
			
			// 生成微信权限验证的参数
			Map<String, String> wechatParam = makeWXTicket(jsApiTicket, url);
			result.setData(wechatParam);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setError(e.getMessage());
			result.setMessage("操作失败");
			log.error(e);
		}
		return result;
		
	}

	// 生成微信权限验证的参数
	public Map<String, String> makeWXTicket(String jsApiTicket, String url) {
		Map<String, String> ret = new HashMap<String, String>();
		String nonceStr = createNonceStr();
		String timestamp = createTimestamp();
		String string1;
		String signature = "";

		// 注意这里参数名必须全部小写，且必须有序
		string1 = "jsapi_ticket=" + jsApiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;
		log.info("String1=====>" + string1);
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
			log.info("signature=====>" + signature);
		} catch (NoSuchAlgorithmException e) {
			log.error("WeChatController.makeWXTicket=====Start");
			log.error(e.getMessage(), e);
			log.error("WeChatController.makeWXTicket=====End");
		} catch (UnsupportedEncodingException e) {
			log.error("WeChatController.makeWXTicket=====Start");
			log.error(e.getMessage(), e);
			log.error("WeChatController.makeWXTicket=====End");
		}

		ret.put("url", url);
		ret.put("jsapi_ticket", jsApiTicket);
		ret.put("nonceStr", nonceStr);
		ret.put("timestamp", timestamp);
		ret.put("signature", signature);
		ret.put("appid", appId);

		return ret;
	}

	// 字节数组转换为十六进制字符串
	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	// 生成随机字符串
	private static String createNonceStr() {
		return UUID.randomUUID().toString();
	}

	// 生成时间戳
	private static String createTimestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}
}