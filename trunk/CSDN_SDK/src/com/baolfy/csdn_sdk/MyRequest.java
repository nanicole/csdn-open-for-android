package com.baolfy.csdn_sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.os.Bundle;
import android.util.Log;

public class MyRequest {

	public static String ERR_NETWORK_UNAVAILABLE = "networkunavailable";
	public static String ERR_RESPONSE = "error";

	public static final int TYPE_POST = 8;
	public static final int TYPE_GET = 6;

	private final ExecutorService executorService = Executors.newFixedThreadPool(2);

	private Bundle params;
	private String url;
	private int requestType;

	public MyRequest(Bundle params, String url, int requestType) {
		this.params = params;
		this.url = url;
		this.requestType = requestType;
	}

	public void send(RequestCallback callBack) {
		executorService.submit(new Task(callBack));
	}

	private class Task implements Runnable {
		private RequestCallback callBack;
		private HttpClient client;

		private Task(RequestCallback rc) {
			callBack = rc;
		}

		@Override
		public void run() {
			HttpUriRequest request = null;
			String result = ERR_RESPONSE;
			try {
				if (requestType == MyRequest.TYPE_GET) {
					Log.d("", url + parseGetParams(params));
					request = new HttpGet(url + parseGetParams(params));
				} else if (requestType == MyRequest.TYPE_POST) {
					request = new HttpPost(url);
					((HttpPost) request).setEntity(new UrlEncodedFormEntity(parsePostParams(params), HTTP.UTF_8));
				}
				client = new DefaultHttpClient();
				HttpResponse httpResponse = client.execute(request);
				int code = httpResponse.getStatusLine().getStatusCode();
				if (code == 200) {
					result = new String(EntityUtils.toByteArray(httpResponse.getEntity()), "UTF-8");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (null != client) {
					client.getConnectionManager().shutdown();
				}
				if (null != callBack) {
					callBack.requestCallback(result);
				}
			}
		}
	}

	private String parseGetParams(Bundle params) {
		if (null == params) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Set<String> keys = params.keySet();
		Iterator<String> it = keys.iterator();
		String key;
		Object value;
		while (it.hasNext()) {
			key = it.next();
			value = params.get(key);
			if (null != value) {
				sb.append(key + "=" + value.toString());
				if (it.hasNext()) {
					sb.append("&");
				}
			}
		}
		return "?" + sb.toString();
	}

	private ArrayList<NameValuePair> parsePostParams(Bundle params) {
		if (null == params) {
			return null;
		}
		Set<String> keys = params.keySet();
		Iterator<String> it = keys.iterator();
		ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
		String key;
		Object value;
		while (it.hasNext()) {
			key = it.next();
			value = params.get(key);
			if (null != value) {
				list.add(new BasicNameValuePair(key, value.toString()));
			}
		}
		return list;
	}
}
