package com.baolfy.csdn_sdk;

import org.json.JSONException;
import org.json.JSONObject;

public class AccessToken {
	
	private String token;
	private int expires;
	private String UID;
    
    public AccessToken(JSONObject jobject) throws JSONException{
    	token = jobject.getString("access_token");
    	expires = jobject.getInt("expires_in");
    	UID = jobject.getString("username");
    }

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @return the expires
	 */
	public int getExpires() {
		return expires;
	}

	/**
	 * @return the uID
	 */
	public String getUID() {
		return UID;
	}
	
}
