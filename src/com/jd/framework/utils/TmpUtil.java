package com.jd.framework.utils;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class TmpUtil {

	// 以节省内存的方式读取本地资源图片
	public static Bitmap readBitMap(Context context, int resId) {
		BitmapFactory.Options opt = new BitmapFactory.Options();
		opt.inPreferredConfig = Bitmap.Config.RGB_565;
		opt.inPurgeable = true;
		opt.inInputShareable = true;
		// 获取资源图片
		InputStream is = context.getResources().openRawResource(resId);
		// 注意：在 onDestory()时应，调用 bitmap.recycle() 回收资源
		return BitmapFactory.decodeStream(is, null, opt);
	}
}
