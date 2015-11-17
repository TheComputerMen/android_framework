package com.jd.framework.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jd.framework.R;
import com.jd.framework.application.LocalApplication;

public class ToastMaker {
	// private final static Toast T = Toast.makeText(x.app(), "",
	// Toast.LENGTH_SHORT);
	//
	// public static void showShortToast(String msg) {
	// T.setDuration(Toast.LENGTH_SHORT);
	// T.setText(msg);
	// T.show();
	// }
	//
	// public static void showLongToast(String msg) {
	// T.setDuration(Toast.LENGTH_LONG);
	// T.setText(msg);
	// T.show();
	// }
	//
	// public static void cancelToast(){
	// T.cancel();
	// }

	public static void showShortToast(String msg) {
		showCustomTranslucentToast(LocalApplication.getInstance(), msg,
				Toast.LENGTH_SHORT);
	}

	public static void showShortToast(int msgId) {
		showCustomTranslucentToast(LocalApplication.getInstance(), msgId,
				Toast.LENGTH_SHORT);
	}

	public static void showLongToast(String msg) {
		showCustomTranslucentToast(LocalApplication.getInstance(), msg,
				Toast.LENGTH_LONG);
	}

	public static void showLongToast(int msgId) {
		showCustomTranslucentToast(LocalApplication.getInstance(), msgId,
				Toast.LENGTH_LONG);
	}

	public static void showToastInUiThread(final Activity activity,
			final String msg) {
		if (activity != null) {
			activity.runOnUiThread(new Runnable() {

				@Override
				public void run() {
					showCustomTranslucentToast(activity, msg);
				}
			});
		}
	}

	public static void showToastInUiThread(final Activity activity,
			final int msgId) {
		if (activity != null) {
			activity.runOnUiThread(new Runnable() {

				@Override
				public void run() {
					showCustomTranslucentToast(activity, msgId);
				}
			});
		}
	}

	public static void showCustomTranslucentToast(Context context, int msgId) {
		final String msg = context.getResources().getString(msgId);
		showCustomTranslucentToast(context, msg);
	}

	private static void showCustomTranslucentToast(Context context, String msg) {
		showCustomTranslucentToast(context, msg, Toast.LENGTH_SHORT);
	}

	private static void showCustomTranslucentToast(Context context, int msgId,
			int duration) {
		final String msg = context.getResources().getString(msgId);
		showCustomTranslucentToast(context, msg, duration);
	}

	private static void showCustomTranslucentToast(final Context context,
			final String msg, final int duration) {
		if (context == null) {
			return;
		}
		if (Looper.myLooper() == Looper.getMainLooper()) {
			showToast(context, msg, duration);
		} else {
			new Handler(Looper.getMainLooper()).post(new Runnable() {

				@Override
				public void run() {
					showToast(context, msg, duration);
				}
			});
		}
	}

	protected static void showToast(Context context, String msg, int duration) {
		if (null != context) {
			LayoutInflater inflater = LayoutInflater.from(context);
			View layout = inflater.inflate(R.layout.toast_common_layout, null);
			TextView content = (TextView) layout
					.findViewById(R.id.toast_content);
			content.setText(msg);

			Toast toast = new Toast(context);
			toast.setGravity(Gravity.CENTER, 0,
					LocalApplication.getInstance().screenH / 4);
			toast.setDuration(duration);
			toast.setView(layout);
			toast.show();
		}
	}
	
}
