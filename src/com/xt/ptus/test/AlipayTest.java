package com.xt.ptus.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AlipayTest {

	@Test
	public void Test() {
		Map<String, String> params = new HashMap<String, String>();
		String str = "{\"buyer_id\":\"2088402375495340\",\"trade_no\":\"2017101721001004340291496265\",\"body\":\"41码\",\"use_coupon\":\"N\",\"notify_time\":\"2017-10-17 14:27:36\",\"subject\":\"支付测试\",\"sign_type\":\"RSA\",\"is_total_fee_adjust\":\"Y\",\"notify_type\":\"trade_status_sync\",\"out_trade_no\":\"153\",\"trade_status\":\"WAIT_BUYER_PAY\",\"discount\":\"0.00\",\"sign\":\"kyrYXT2qugcgUHJWhdFCx7DRsiIjqG0wGPKz5RYJY/gSFxo0eMK3Fv/bC6pFfE6xFVEB9gPR54LiF5EEe7ERzBTqAZ+SsoULdySrlwE9J9UGua2jMxrG4/aq6dA7MnaHpVIL2cZGwUhu3JjdPdgwt+j9n8KPKv1z24yRBDLFbG4\u003d\",\"buyer_email\":\"460***@qq.com\",\"gmt_create\":\"2017-10-17 14:27:36\",\"price\":\"0.01\",\"total_fee\":\"0.01\",\"quantity\":\"1\",\"seller_id\":\"2088821424705344\",\"notify_id\":\"1e39ec273d1b8521a472239b608d705imi\",\"seller_email\":\"ynyiwke@163.com\",\"payment_type\":\"1\"}";
		Gson gson = new Gson();
		
		params = (Map<String, String>)gson.fromJson(str, new TypeToken<Map<String, String>>(){}.getType());
		System.out.println(params);
		
		boolean verifyResult;
		try {
			verifyResult = AlipaySignature.rsaCheckV2(params, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB", "utf-8", "RSA");
			System.out.println(verifyResult);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}
}
