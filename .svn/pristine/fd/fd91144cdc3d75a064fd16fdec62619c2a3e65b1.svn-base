package com.xt.ptus.test;

import java.io.UnsupportedEncodingException;

import com.xt.ptus.helper.NetProxyHelper;

public class WecharLoginTest {
	
	static String string;
	
	//用户同意授权，获取code
    public static String Get_code(String RedirectUri)
    {

        String MyAppid = "wx8a4486eb2002d085";//微信应用Id
        String URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + MyAppid + "&redirect_uri=" + RedirectUri + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
        return URL;
    }
	//获得Token
    public static String Get_token(String Code) throws UnsupportedEncodingException
    {
        String Appid = "wx8a4486eb2002d085";
        String appsecret = "9e7ba025fd3d47a2c1f757c1cf092103";
        String Str = GetJson("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + Appid + "&secret=" + appsecret + "&code=" + Code + "&grant_type=authorization_code");
//        volume_OAuth_Token Oauth_Token_Model = Volume_JsonHelper.ParseFromJson<volume_OAuth_Token>(Str);
        return Str;
    }
    //下载数据
    public static String GetJson(String url) throws UnsupportedEncodingException
    {
        String res = "";
        String result =  NetProxyHelper.sendPost(null, url, null);
        System.out.println(new String(result.getBytes("utf-8")));
        return res;
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
		String url = Get_code("http%3a%2f%2fyiwke.ngrok.cc%2fWeb%2fwechat%2fredirectUri%2fgetWecharResponse");
		System.out.println(url);
		GetJson(url);
    }
}
