package com.jd.framework.utils;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class TmpUtil {

	// �Խ�ʡ�ڴ�ķ�ʽ��ȡ������ԴͼƬ
	public static Bitmap readBitMap(Context context, int resId) {
		BitmapFactory.Options opt = new BitmapFactory.Options();
		opt.inPreferredConfig = Bitmap.Config.RGB_565;
		opt.inPurgeable = true;
		opt.inInputShareable = true;
		// ��ȡ��ԴͼƬ
		InputStream is = context.getResources().openRawResource(resId);
		// ע�⣺�� onDestory()ʱӦ������ bitmap.recycle() ������Դ
		return BitmapFactory.decodeStream(is, null, opt);
	}
}
