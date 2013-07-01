package com.baolfy.csdn_sdk.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Medal {
	
	private String icon;
	private String title;
	private String desciption;
	private String reason;
	private int count;
	
	public Medal(JSONObject jobject) throws JSONException{
		icon = jobject.getString("icon");
		title = jobject.getString("title");
		desciption = jobject.getString("desciption");
		reason = jobject.getString("reason");
		count = jobject.getInt("count");
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the desciption
	 */
	public String getDesciption() {
		return desciption;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
}
