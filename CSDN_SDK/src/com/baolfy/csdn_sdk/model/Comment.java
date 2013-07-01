package com.baolfy.csdn_sdk.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Comment {
	
	private String id;
	private String parentId;
	private String articleId;
	private String articleTitle;
	private String blogger;
	private String userName;
	private String createAt;
	private String content;
    
    public Comment(JSONObject jobject) throws JSONException{
    	id = jobject.getString("id");
    	parentId = jobject.getString("parent_id");
    	articleId = jobject.getString("article_id");
    	articleTitle = jobject.getString("article_title");
    	blogger = jobject.getString("blogger");
    	userName = jobject.getString("username");
    	createAt = jobject.getString("create_at");
    	content = jobject.getString("content");
    }

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @return the articleId
	 */
	public String getArticleId() {
		return articleId;
	}

	/**
	 * @return the articleTitle
	 */
	public String getArticleTitle() {
		return articleTitle;
	}

	/**
	 * @return the blogger
	 */
	public String getBlogger() {
		return blogger;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the createAt
	 */
	public String getCreateAt() {
		return createAt;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	
}
