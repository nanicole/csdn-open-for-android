package com.baolfy.csdn_sdk.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Channel {
	
	private String id;
    private String name;
    private String alias;
	
    public Channel(JSONObject jobject) throws JSONException{
    	id = jobject.getString("id");
    	name = jobject.getString("name");
    	alias = jobject.getString("alias");
    }

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}
}
