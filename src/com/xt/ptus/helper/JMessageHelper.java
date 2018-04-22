package com.xt.ptus.helper;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.user.UserInfoResult;
import cn.jmessage.api.user.UserListResult;

/**
 * JAVA端发送客服消息
 * @author Administrator
 *
 */
public class JMessageHelper {
	public static void Test(){
		JMessageClient jMessageClient = new JMessageClient("f6ad14f134cddffa22da3079", "9e4516c9b6cce34d914609b6");
		
		try {
			
//			String message = jMessageClient.registerAdmins("admin", "admin123");
			jMessageClient.deleteUser("app_user_11");
//			System.out.println(message);
			UserListResult list = jMessageClient.getUserList(0, 100);
			UserInfoResult[] users = list.getUsers();
			for(UserInfoResult user : users){
				System.out.println(user.getUsername());
			}
		} catch (APIConnectionException ex){
			System.out.println(ex);
		} catch(APIRequestException e) {
			System.out.println(e);  
            System.out.println("Error response from JPush server. Should review and fix it. " + e);  
            System.out.println("HTTP Status: " + e.getStatus());  
            System.out.println("Error Code: " + e.getErrorCode());  
            System.out.println("Error Message: " + e.getErrorMessage());  
            System.out.println("Msg ID: " + e.getMsgId());  
		}
	}
	
	public static void main(String[] args) {
		Test();
	}
}
