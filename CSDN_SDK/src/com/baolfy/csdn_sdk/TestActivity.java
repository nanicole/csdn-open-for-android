package com.baolfy.csdn_sdk;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.baolfy.csdn_sdk.model.Article;
import com.baolfy.csdn_sdk.model.Channel;
import com.baolfy.csdn_sdk.util.Utils;

public class TestActivity extends Activity implements OnClickListener{
	
	private String app_key = "1100011";
    private String app_secret = "59c1558559764eb78847350ef95df5c8";
	
	private AccessToken token = null;
	
	private ArrayList<Article> articles = new ArrayList<Article>();
	private ArrayList<Channel> channels = new ArrayList<Channel>();
	private Handler handler = new Handler(new Handler.Callback() {
		@Override
		public boolean handleMessage(Message msg) {
			switch(msg.what){
			case 568:{
				test();
				break;
			}
			}
			return false;
		}
	});
	
	private TextView tvResult;
	private EditText etName;
	private EditText etPass;
	
	private ProgressDialog pd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_layout);
		tvResult = (TextView) findViewById(R.id.tv_result);
		tvResult.setMovementMethod(ScrollingMovementMethod.getInstance());
		
		findViewById(R.id.btn_submit).setOnClickListener(this);
		etName = (EditText) findViewById(R.id.et_user_name);
		etPass = (EditText) findViewById(R.id.et_user_password);
		
		pd = new ProgressDialog(this);
	}
	
	private void test(){
		if(null!=token){
			BlogApi ba = new BlogApi(token.getToken(), app_key);
			ba.getHomeNewestArticle(1, 100, 1, new RequestCallback() {
				@Override
				protected void requestCallback(String result) {
					try {
						JSONObject jobject = new JSONObject(result);
						JSONArray jarray = jobject.getJSONArray("list");
						int i = 0;
						int length = jarray.length();
						for(;i<length;i++){
							articles.add(new Article(jarray.getJSONObject(i)));
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			});
			tvResult.append("start send request to get channels....");
			tvResult.append("\n");
			ba.getChannels(new RequestCallback() {
				@Override
				protected void requestCallback(final String result) {
					try {
						JSONArray jarray = new JSONArray(result);
						int i = 0;
						int length = jarray.length();
						for(;i<length;i++){
							channels.add(new Channel(jarray.getJSONObject(i)));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							tvResult.append("request response:get "+channels.size()+" channels!");
							tvResult.append("\n");
							tvResult.append(result);
							tvResult.append("\n");
						}
					});
				}
			});
		}
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btn_submit:{
			if(!Utils.isNetworkAvailable(this)){
				showTextDialog("network unavailable!");
				return;
			}
			String name = etName.getText().toString().trim();
			String pass = etPass.getText().toString().trim();
			if(name.length()==0){
				showTextDialog("login name is null!");
				return;
			}
			if(pass.length()==0){
				showTextDialog("login password is null!");
				return;
			}
			pd.setMessage(getString(R.string.wait));
			if(!pd.isShowing()){
				pd.show();
			}
			OAuth.oauth(app_key, app_secret, name, pass, loginCallback);
			break;
		}
		}
	}
	
	private RequestCallback loginCallback = new RequestCallback() {
		@Override
		protected void requestCallback(final String result) {
			try {
				JSONObject jobject = new JSONObject(result);
				token = new AccessToken(jobject);//you can save the token ,login name and password
				handler.sendEmptyMessage(568);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					if(pd.isShowing()){
						pd.dismiss();
					}
					tvResult.append(result+"\n");
				}
			});
		}
	};
	
	private void showTextDialog(String msg){
		AlertDialog dialog = new AlertDialog.Builder(this).setTitle(R.string.err_title).setMessage(msg).setPositiveButton(android.R.string.ok, null).create();
		dialog.setCanceledOnTouchOutside(false);
		dialog.show();
	}

}
