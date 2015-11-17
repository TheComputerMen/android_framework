package com.jd.framework.fragment;

import org.xutils.x;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	
	private Context context;
	protected Dialog dialog;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(getLayoutId(), container, false);
		x.view().inject(this,view);
		initParams();
		return view;
	}
	
	protected abstract int getLayoutId();
	
	protected abstract void initParams();
	
	/**
	 * 弹出对话框
	 * 
	 * @param title
	 * @param msg
	 * @param btns
	 * @param isCanCancelable
	 * @param isDismissAfterClickBtn
	 * @param tag
	 * @return
	 */
	public Dialog showAlertDialog(String title, String msg, String[] btns,
			boolean isCanCancelable, final boolean isDismissAfterClickBtn,
			Object tag) {
		if (dialog == null || !dialog.isShowing()) {
//			 dialog = DialogMaker.showCommonAlertDialog(this,title,msg,btns,this,isCanCancelable,isDismissAfterClickBtn,tag);
		}
		return dialog;
	}

	/**
	 * 等待对话框
	 * 
	 * @param title
	 * @param msg
	 * @param btns
	 * @param isCanCancelable
	 * @param is
	 * @return
	 */
	public Dialog showWaitDialog(String title, String msg, String[] btns,
			boolean isCanCancelable, Object tag) {
		if (dialog == null || !dialog.isShowing()) {
			// dialog =
			// DialogMaker.showCommonWaitDialog(this,title,msg,btns,this,isCanCancelable,tag);
		}
		return dialog;
	}

	public void dismissDialog() {
		if (dialog != null && dialog.isShowing()) {
			dialog.dismiss();
		}
	}

}
