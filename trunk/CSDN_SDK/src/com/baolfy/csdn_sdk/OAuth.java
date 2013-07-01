package com.baolfy.csdn_sdk;

import android.os.Bundle;

public class OAuth {
	
    private static final String ACCESS_TOKEN_URL = "http://api.csdn.net/oauth2/access_token";

	public static void oauth(String app_key,String app_secret,String username, String password, RequestCallback callBack) {
		Bundle params = new Bundle();
		params.putString("client_id", app_key);
		params.putString("client_secret", app_secret);
		params.putString("grant_type", "password");
		params.putString("username", username);
		params.putString("password", password);
		MyRequest mr = new MyRequest(params, ACCESS_TOKEN_URL, MyRequest.TYPE_GET);
		mr.send(callBack);
	}
}
