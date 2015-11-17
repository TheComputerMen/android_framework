package com.jd.framework.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.jd.framework.exception.BaseExceptionHandler;
import com.jd.framework.exception.LocalFileHandler;

public abstract class BaseApplication extends Application {
	
	public static final String TAG = "Application";
	
	public static Context applicationContext;
	
	// 以键值对的形式存储用户名和密码
	public SharedPreferences sharedPreferences;

	@Override
	public void onCreate() {
		super.onCreate();
		applicationContext = getApplicationContext();
		if(getDefaultUncaughtExceptionHandler() == null){
			Thread.setDefaultUncaughtExceptionHandler(new LocalFileHandler(applicationContext));
		}else{
			Thread.setDefaultUncaughtExceptionHandler(getDefaultUncaughtExceptionHandler());
		}
		sharedPreferences = getSharedPreferences("local_kv", MODE_PRIVATE);
	}
	
	public abstract BaseExceptionHandler getDefaultUncaughtExceptionHandler();
	
	
}
