package com.amtf.demo.agora;

import com.amtf.demo.agora.RtcTokenBuilder.Role;

public class RtcTokenBuilderSample {
	static String appId = "c5eeb7bb4b3e43a7a56f2df0b09f3b83";
	static String appCertificate = "60b5777d355a4a2987deddb6f0ac9027";
	static String channelName = "123";
	static int uid = 0;
	static int expirationTimeInSeconds = 3600;

	public String getToken() {
		RtcTokenBuilder token = new RtcTokenBuilder();
		int timestamp = (int) (System.currentTimeMillis() / 1000 + expirationTimeInSeconds);
		/*
		 * String result = token.buildTokenWithUserAccount(appId, appCertificate,
		 * channelName, userAccount, Role.Role_Publisher, timestamp);
		 */
		String result = "";

		result = token.buildTokenWithUid(appId, appCertificate, channelName, uid, Role.Role_Publisher, timestamp);
		System.out.println(result);
		return result;
	}
}