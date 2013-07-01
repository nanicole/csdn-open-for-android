package com.baolfy.csdn_sdk.model;

import org.json.JSONException;
import org.json.JSONObject;

public class BlogInfo {
	
	private String title;
	private String subtitle;
	private String createAt;
	private boolean isExpert;
	
	public BlogInfo(JSONObject jobject) throws JSONException{
		title = jobject.getString("title");
		subtitle = jobject.getString("subtitle");
		createAt = jobject.getString("create_at");
		isExpert = Boolean.parseBoolean(jobject.getString("expert"));
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * @return the createAt
	 */
	public String getCreateAt() {
		return createAt;
	}

	/**
	 * @return the isExpert
	 */
	public boolean isExpert() {
		return isExpert;
	}
	
}
