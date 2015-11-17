package com.jd.framework.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;

/**
 * Android文件操作工具类
 * 
 * @author User
 * 
 */
public class JFileKit {

	/**
	 * 检测 SD 卡是否可写
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
	 * 根据传入的uniqueName获取硬盘缓存的路径地址
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
