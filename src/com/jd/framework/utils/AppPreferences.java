package com.jd.framework.utils;

import android.content.SharedPreferences;

import com.alibaba.fastjson.JSON;
import com.jd.framework.application.LocalApplication;

public class AppPreferences {

	private static AppPreferences appPreferences;
	private SharedPreferences preferences;

	public static AppPreferences getInstance() {
		if (appPreferences == null) {
			appPreferences = new AppPreferences();
		}
		return appPreferences;
	}

	private AppPreferences() {
		preferences = LocalApplication.getInstance().sharedPreferences;
	}

	public void remove(String key) {
		preferences.edit().remove(key).commit();
	}

	public void clearAll() {
		preferences.edit().clear().commit();
	}

	/**
	 * 保存一个实体类，类名为key，实体类需包含一个参数为空的构造函数
	 * 
	 * @param obj
	 */
	public void putObject(Object obj) {
		putObject(obj.getClass().getName(), obj);
	}

	private void putObject(String name, Object obj) {
		putString(name, JSON.toJSONString(obj));
	}

	/**
	 * 获取一个存储实体
	 * 
	 * @param c
	 * @return
	 */
	public <T> T getObject(Class<T> c) {
		return getObject(c.getName(), c);
	}

	private <T> T getObject(String clsName, Class<T> c) {
		String jsonStr = getString(clsName, null);
		if (JStringUtil.isNotBlack(jsonStr)) {
			return JSON.parseObject(jsonStr, c);
		}
		return null;
	}

	public void putString(String key, String value) {
		preferences.edit().putString(key, value).commit();
	}

	public void putInt(String key, int value) {
		preferences.edit().putInt(key, value).commit();
	}

	public void putLong(String key, long value) {
		preferences.edit().putLong(key, value).commit();
	}

	public void putFloat(String key, float value) {
		preferences.edit().putFloat(key, value).commit();
	}

	public void putBoolean(String key, boolean value) {
		preferences.edit().putBoolean(key, value).commit();
	}

	public String getString(String key, String defValue) {
		return preferences.getString(key, defValue);
	}

	public int getInt(String key, int defValue) {
		return preferences.getInt(key, defValue);
	}

	public long getLong(String key, long defValue) {
		return preferences.getLong(key, defValue);
	}

	public float getFloat(String key, float defValue) {
		return preferences.getFloat(key, defValue);
	}

	public boolean getBoolean(String key, boolean defValue) {
		return preferences.getBoolean(key, defValue);
	}
}
