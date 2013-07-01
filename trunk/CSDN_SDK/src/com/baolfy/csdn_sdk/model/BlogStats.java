package com.baolfy.csdn_sdk.model;

import org.json.JSONException;
import org.json.JSONObject;

public class BlogStats {
	
	private int viewCount;
	private int commentCount;
	private int originalCount;
	private int repostCount;
	private int translatedCount;
	private int point;
	private int rank;
	
	public BlogStats(JSONObject jobject) throws JSONException{
		viewCount = jobject.getInt("view_count");
		commentCount = jobject.getInt("comment_count");
		originalCount = jobject.getInt("original_count");
		repostCount = jobject.getInt("repost_count");
		translatedCount = jobject.getInt("translated_count");
		point = jobject.getInt("point");
		rank = jobject.getInt("rank");
	}

	/**
	 * @return the viewCount
	 */
	public int getViewCount() {
		return viewCount;
	}

	/**
	 * @return the commentCount
	 */
	public int getCommentCount() {
		return commentCount;
	}

	/**
	 * @return the originalCount
	 */
	public int getOriginalCount() {
		return originalCount;
	}

	/**
	 * @return the repostCount
	 */
	public int getRepostCount() {
		return repostCount;
	}

	/**
	 * @return the translatedCount
	 */
	public int getTranslatedCount() {
		return translatedCount;
	}

	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}
	
}
