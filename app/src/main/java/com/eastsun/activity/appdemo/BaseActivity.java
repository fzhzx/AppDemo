package com.eastsun.activity.appdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class BaseActivity extends Activity {
//	public AppApplication appContext;
//	private CustomLoadingDialog progressDialog = null;
	public TextView titleTv; // 标题
	public ImageButton titleLeftIb; // 左边按钮
	public TextView titleRightTv;
//	public MyPropertyUtil proUtil;
//	final OkHttpClient client = new OkHttpClient();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_header);
//		AppManagerUtil.getAppManagerUtil().addActivity(this);
//		appContext = (AppApplication) getApplication();
//		proUtil = MyPropertyUtil.getIstance();
//		proUtil.loadProperty(getApplicationContext());
	}

	/**
	 * 显示自定义
	 */
//	public void showDialog() {
//		if (progressDialog == null) {
//			progressDialog = CustomLoadingDialog.createDialog(this);
////			progressDialog.setMessage("正在加载中...");
//		}
//		progressDialog.setCanceledOnTouchOutside(false);
//		progressDialog.show();
//
//	}

	/**
	 * 判断progressDialog是否存在
	 * */
//	public Boolean isDialog() {
//		return progressDialog != null;
//	}

//	public void dismissDialog() {
//		if (progressDialog != null) {
//			progressDialog.dismiss();
//			progressDialog = null;
//		}
//	}
	
	/**
	 * 修改标题
	 * */
	public void setHeaderTitle(int title){
		titleTv = (TextView) findViewById(R.id.title_center);
		titleTv.setVisibility(View.VISIBLE);
		titleTv.setText(title);
	}
	

	public void getBackHeaderLeft() {
		titleLeftIb = (ImageButton) findViewById(R.id.title_left);
		titleLeftIb.setVisibility(View.VISIBLE);
		titleLeftIb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	public void getHeaderRight(int string) {
		titleRightTv = (TextView) findViewById(R.id.title_right);
		titleRightTv.setVisibility(View.VISIBLE);
		titleRightTv.setText(string);
	}

	public String intToString(int strInt) {
		return getResources().getString(strInt);
	}

	public String getBackString(String stBody) {
		String stPlit[] = stBody.split(",");
//        String sResMsg = stPlit[1];
		String st2Plit[] = stPlit[1].split(":");
		String string = st2Plit[1].substring(1,st2Plit[1].length()-1);
		System.out.println(string);
		return string;
	}
}