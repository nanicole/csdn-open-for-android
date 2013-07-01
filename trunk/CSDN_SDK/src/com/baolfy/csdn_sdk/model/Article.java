package com.baolfy.csdn_sdk.model;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;


public class Article{
	
	private String id;
	private String title;
	private String createAt;
	private int viewCount;
	private int commentCount;
	private boolean commentAllowed;
	private String type;
	private int channel;
	private int digg;
	private int bury;
	private String description;
	private String url;
    
    public String[] categories;
    public String[] tags;
    public String content;

	public Article(JSONObject jobject) throws JSONException{
		id = jobject.getString("id");
		title = jobject.getString("title");
		createAt = jobject.getString("create_at");
		viewCount = jobject.getInt("view_count");
		commentCount = jobject.getInt("comment_count");
		commentAllowed = Boolean.parseBoolean(jobject.getString("comment_allowed"));
		type = jobject.getString("type");
		channel = jobject.getInt("channel");
		digg = jobject.getInt("digg");
		bury = jobject.getInt("bury");
		description = jobject.getString("description");
		url = jobject.getString("url");
		if(jobject.has("categories")){
			String str = jobject.getString("categories");
			if(null!=str&&str.length()>0){
				categories = str.split(",");
			}
		}
		if(jobject.has("tags")){
			String str = jobject.getString("tags");
			if(null!=str&&str.length()>0){
				tags = str.split(",");
			}
		}
		if(jobject.has("content")){
			content = jobject.getString("categories");
		}
	}
	
	public Bundle getRequestParams(){
		Bundle params = new Bundle();
		if(null==title){
			throw new NullPointerException("title can't be null!");
		}
		if(null==content){
			throw new NullPointerException("content can't be null!");
		}
		params.putString("title", title);
		params.putString("content", content);
		if(null!=tags&&tags.length>0){
			params.putString("tags", getTagsString());
		}
		if(null!=type){
			params.putString("type", type);
		}
		if(null!=description){
			params.putString("description", description);
		}
		if(null!=categories&&categories.length>0){
			params.putString("categories", getCategoriesString());
		}
		return params;
	}
	
	private String getTagsString(){
		int i = 0;
		int length = tags.length;
		int pos = length-1;
		StringBuilder sb = new StringBuilder();
		for(;i<length;i++){
			sb.append(tags[i]);
			if(i>pos){
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	private String getCategoriesString(){
		int i = 0;
		int length = categories.length;
		int pos = length-1;
		StringBuilder sb = new StringBuilder();
		for(;i<length;i++){
			sb.append(categories[i]);
			if(i>pos){
				sb.append(",");
			}
		}
		return sb.toString();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the createAt
	 */
	public String getCreateAt() {
		return createAt;
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
	 * @return the commentAllowed
	 */
	public boolean isCommentAllowed() {
		return commentAllowed;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the channel
	 */
	public int getChannel() {
		return channel;
	}

	/**
	 * @return the digg
	 */
	public int getDigg() {
		return digg;
	}

	/**
	 * @return the bury
	 */
	public int getBury() {
		return bury;
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
	 * @return the categories
	 */
	public String[] getCategories() {
		return categories;
	}

	/**
	 * @return the tags
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	/**
	 * @param viewCount the viewCount to set
	 */
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	/**
	 * @param commentCount the commentCount to set
	 */
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	/**
	 * @param commentAllowed the commentAllowed to set
	 */
	public void setCommentAllowed(boolean commentAllowed) {
		this.commentAllowed = commentAllowed;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}

	/**
	 * @param digg the digg to set
	 */
	public void setDigg(int digg) {
		this.digg = digg;
	}

	/**
	 * @param bury the bury to set
	 */
	public void setBury(int bury) {
		this.bury = bury;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
