package com.baolfy.csdn_sdk.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Category {
	
	private String id;
    private String name;
    private boolean hide;
    private int articleCount;
    
    public Category(JSONObject jobject) throws JSONException{
    	id = jobject.getString("id");
    	name = jobject.getString("name");
    	hide = Boolean.parseBoolean(jobject.getString("hide"));
    	articleCount = jobject.getInt("articleCount");
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
	 * @return the hide
	 */
	public boolean isHide() {
		return hide;
	}

	/**
	 * @return the articleCount
	 */
	public int getArticleCount() {
		return articleCount;
	}
	
}
