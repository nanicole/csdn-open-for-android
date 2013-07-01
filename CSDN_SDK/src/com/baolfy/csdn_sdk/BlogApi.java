package com.baolfy.csdn_sdk;

import android.os.Bundle;

import com.baolfy.csdn_sdk.model.Article;


public class BlogApi extends BaseApi{
	
	public BlogApi(String accessToken, String appKey){
		super(accessToken, appKey);
	}
	
	public void getBlogUserInfo(RequestCallback callBack){
		sendGetRequest("user/getinfo", null, callBack);
	}
	
	public void getBlogInfo(RequestCallback callBack){
		sendGetRequest("/blog/getinfo", null, callBack);
	}
	
	public void getBlogStats(RequestCallback callBack){
		sendGetRequest("blog/getstats", null, callBack);
	}
	
	public void getBlogMedal(RequestCallback callBack){
		sendGetRequest("blog/getmedal", null, callBack);
	}
	
	public void getBlogColumn(RequestCallback callBack){
		sendGetRequest("blog/getcolumn", null, callBack);
	}
	
	public void getBlogArticleList(int page,int pageSize,String status,RequestCallback callBack){
		Bundle params = new Bundle();
		boolean flag = false;
		if(page>0){
			flag = true;
			params.putString("page", Integer.toString(page));
		}
		if(pageSize>0){
			flag = true;
			params.putString("size", Integer.toString(pageSize));
		}
		if(null!=status&&status.trim().length()>0){
			flag = true;
			params.putString("status", status);
		}
		if(!flag){
			params = null;
		}
		sendGetRequest("blog/getarticlelist", params, callBack);
	}
	
	public void getBlogArticle(String id,RequestCallback callBack){
		if(null==id||id.trim().length()==0){
			return;
		}
		Bundle params = new Bundle();
		params.putString("id", id);
		sendGetRequest("blog/getarticle", params, callBack);
	}
	
	public void getBlogCategorylist(RequestCallback callBack){
		sendGetRequest("blog/getcategorylist", null, callBack);
	}
	
	public void getBlogTagList(RequestCallback callBack){
		sendGetRequest("blog/gettaglist", null, callBack);
	}
	
	public void getBlogCommentList(int page,int pageSize,RequestCallback callBack){
		Bundle params = new Bundle();
		boolean flag = false;
		if(page>0){
			flag = true;
			params.putString("page", Integer.toString(page));
		}
		if(pageSize>0){
			flag = true;
			params.putString("size", Integer.toString(pageSize));
		}
		if(!flag){
			params=null;
		}
		sendGetRequest("blog/getcommentlist", params, callBack);
	}
	
	public void getBlogMyCommentList(int page,int pageSize,RequestCallback callBack){
		Bundle params = new Bundle();
		boolean flag = false;
		if(page>0){
			flag = true;
			params.putString("page", Integer.toString(page));
		}
		if(pageSize>0){
			flag = true;
			params.putString("size", Integer.toString(pageSize));
		}
		if(!flag){
			params=null;
		}
		sendGetRequest("blog/getmycommentlist", params, callBack);
	}
	
	public void getBlogArticleComment(String articleId,int page,int pageSize,RequestCallback callBack){
		if(null==articleId){
			return;
		}
		Bundle params = new Bundle();
		params.putString("article", articleId);
		if(page>0){
			params.putString("page", Integer.toString(page));
		}
		if(pageSize>0){
			params.putString("size", Integer.toString(pageSize));
		}
		sendGetRequest("blog/getarticlecomment", params, callBack);
	}
	
	public void saveBlogInfo(String title,String subtitle,RequestCallback callBack){
		Bundle params = new Bundle();
		boolean flag = false;
		if(null!=title&&title.trim().length()>0){
			flag = true;
			params.putString("title", title);
		}
		if(null!=subtitle&&subtitle.trim().length()>0){
			flag = true;
			params.putString("subtitle", subtitle);
		}
		if(!flag){
			return;
		}
		sendGetRequest("blog/saveinfo", params, callBack);
	}
	
	public void saveBlogArticle(Article article,RequestCallback callBack){
		if(null==article){
			return;
		}
		Bundle params = null;
		try {
			params = article.getRequestParams();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(null==params){
			return;
		}
		sendGetRequest("blog/savearticle", params, callBack);
	}
	
	public void postBlogComment(String articleId,String content,String replyId,RequestCallback callBack){
		if(null==articleId||articleId.trim().length()==0||null==content||content.trim().length()==0){
			return;
		}
		Bundle params = new Bundle();
		params.putString("article", articleId);
		params.putString("content", content);
		if(null!=replyId){
			params.putString("reply_id", replyId);
		}
		sendGetRequest("blog/postcomment", params, callBack);
	}
	
	public void getNewestArticle(int page,int pageSize,RequestCallback callBack){
		Bundle params = new Bundle();
		boolean flag = false;
		if(page>0){
			flag = true;
			params.putString("page", Integer.toString(page));
		}
		if(pageSize>0){
			flag = true;
			params.putString("size", Integer.toString(pageSize));
		}
		if(!flag){
			params=null;
		}
		sendGetRequest("blog/getnewarticlelist", params, callBack);
	}
	
	public void getHomeNewestArticle(int page,int pageSize,int channel,RequestCallback callBack){
		Bundle params = new Bundle();
		if(page>0){
			params.putString("page", Integer.toString(page));
		}
		if(pageSize>0){
			params.putString("size", Integer.toString(pageSize));
		}
		params.putString("channel", Integer.toString(channel));
		sendGetRequest("blog/gethomenewest", params, callBack);
	}
	
	public void getExperList(int channel,RequestCallback callBack){
		Bundle params = new Bundle();
		params.putString("channel", Integer.toString(channel));
		sendGetRequest("blog/getexpertlist", params, callBack);
	}
	
	public void getColumnList(int page,int pageSize,int channel,RequestCallback callBack){
		Bundle params = new Bundle();
		if(page>0){
			params.putString("page", Integer.toString(page));
		}
		if(pageSize>0){
			params.putString("size",Integer.toString(pageSize));
		}
		params.putString("channel", Integer.toString(channel));
		sendGetRequest("blog/getcolumnlist", params, callBack);
	}
	
	public void getColumnDetail(String alias,RequestCallback callBack) {
		if(null==alias){
			return;
		}
		Bundle params = new Bundle();
		params.putString("alias", alias);
		sendGetRequest("blog/getcolumndetails", params, callBack);
	}
	
	public void getColumnArticles(String alias,int page,int pageSize,RequestCallback callBack){
		if(null==alias){
			return;
		}
		Bundle params = new Bundle();
		params.putString("alias", alias);
		if(page>0){
			params.putString("page", Integer.toString(page));
		}
		if(pageSize>0){
			params.putString("size", Integer.toString(pageSize));
		}
		sendGetRequest("blog/getcolumnarticles", params, callBack);
	}
	
	public void getChannels(RequestCallback callBack){
		sendGetRequest("blog/getchannel", null, callBack);
	}
}