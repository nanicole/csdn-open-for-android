package com.baolfy.csdn_sdk.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Column {

	private String alias;
	private int channel;
	private String title;
	private String description;
	private String url;
	private String logo;
	private int viewCount;

	public Column(JSONObject jobject) throws JSONException {
		alias = jobject.getString("alias");
		channel = jobject.getInt("channel");
		title = jobject.getString("title");
		description = jobject.getString("description");
		url = jobject.getString("url");
		logo = jobject.getString("logo");
		viewCount = jobject.getInt("viewCount");
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @return the channel
	 */
	public int getChannel() {
		return channel;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @return the viewCount
	 */
	public int getViewCount() {
		return viewCount;
	}
}
