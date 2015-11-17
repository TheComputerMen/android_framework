package com.jd.framework.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;

/**
 * Android�ļ�����������
 * 
 * @author User
 * 
 */
public class JFileKit {

	/**
	 * ��� SD ���Ƿ��д
	 * 
	 * @return
	 */
	public static boolean sdcardIsReadyForWrite() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			return true;
		}
		return false;
	}

	/**
	 * ���ݴ����uniqueName��ȡӲ�̻����·����ַ
	 * 
	 * @param context
	 * @return
	 */
	@SuppressLint("NewApi")
	public static String getDiskCacheDir(Context context) {
		String cachePath;
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())
				|| !Environment.isExternalStorageRemovable()) {
			cachePath = context.getExternalCacheDir().getAbsolutePath();
		} else {
			cachePath = context.getCacheDir().getAbsolutePath();
		}
		return cachePath;
	}
}
