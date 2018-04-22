package com.xt.ptus.wechat.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wechat/token/")
public class TokenController {

	protected WxMpInMemoryConfigStorage config;
	protected WxMpService wxMpService;
	protected WxMpMessageRouter wxMpMessageRouter;

	public TokenController() throws IOException {
		InputStream is = this.getClass().getResourceAsStream("/wechat.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		
		config = new WxMpInMemoryConfigStorage();
		config.setAppId(prop.getProperty("wechat.AppId")); // 设置微信公众号的appid
		config.setSecret(prop.getProperty("wechat.AppSecret")); // 设置微信公众号的app corpSecret
		config.setToken(prop.getProperty("wechat.Token")); // 设置微信公众号的token
		config.setAesKey(prop.getProperty("wechat.AesKey")); // 设置微信公众号的EncodingAESKey

		wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(config);
		
	}

	@ResponseBody
	@RequestMapping("validateToken")
	private String validateToken(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);

		String signature = request.getParameter("signature");
		String nonce = request.getParameter("nonce");
		String timestamp = request.getParameter("timestamp");
		if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
			// 消息签名不正确，说明不是公众平台发过来的消息
			return "非法请求";
		}

		String echostr = request.getParameter("echostr");
		if (StringUtils.isNotBlank(echostr)) {
			// 说明是一个仅仅用来验证的请求，回显echostr
			return echostr;
		}

		return "";
	}
}
