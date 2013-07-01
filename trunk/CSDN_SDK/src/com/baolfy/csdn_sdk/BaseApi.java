package com.baolfy.csdn_sdk;

import android.os.Bundle;

class BaseApi {

	protected static final String API_HOST = "http://api.csdn.net/";

	protected String access_token = null;
	protected String app_key = null;

	BaseApi(String accessToken, String appKey) {
		access_token = accessToken;
		app_key = appKey;
	}

	protected void sendGetRequest(String shortUri, Bundle params, RequestCallback callBack) {
		Bundle b = new Bundle();
		if(null!=params){
			b.putAll(params);
		}
		b.putString("access_token", access_token);
		b.putString("client_id", app_key);
		MyRequest mr = new MyRequest(b, API_HOST+shortUri, MyRequest.TYPE_GET);
		mr.send(callBack);
	}
	
	protected void sendPostRequest(String shortUri, Bundle params, RequestCallback callBack) {
		Bundle b = new Bundle();
		if(null!=params){
			b.putAll(params);
		}
		b.putString("access_token", access_token);
		b.putString("client_id", app_key);
		MyRequest mr = new MyRequest(b, API_HOST+shortUri, MyRequest.TYPE_POST);
		mr.send(callBack);
	}

}
