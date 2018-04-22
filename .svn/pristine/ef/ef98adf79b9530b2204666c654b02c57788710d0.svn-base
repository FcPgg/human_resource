package com.xt.ptus.test;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import com.xt.ptus.helper.SMSHelper;

public class SMSTest {
	
	@Test
	public void testSMSMsg(){
		try {
			Map<String,String> map = SMSHelper.sendSMSIdentifyingCode("18787028470");
			System.out.println("get code: "+map);
			
			if(map.get("code") == "200"){
				Map<String,String> verify = SMSHelper.verifyIdentifyingCode("18787028470","389962");
				System.out.println("verify:" + verify);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
