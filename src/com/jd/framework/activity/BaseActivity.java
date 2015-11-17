package com.jd.framework.activity;

import org.xutils.x;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.jd.framework.utils.ActivityStack;
import com.jd.framework.view.DialogMaker.DialogCallBack;

public abstract class BaseActivity extends FragmentActivity implements DialogCallBack {

	protected Dialog dialog;

	private boolean isCreate = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityStack.getInstance().addActivity(this);
		setContentView(getLayoutId());

		// xUtils3控件绑定
		x.view().inject(this);
		isCreate = true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (isCreate) {
			isCreate = false;
			initParams();
		}
	}

	/**
	 * 初始化布局
	 * 
	 * @return
	 */
	protected abstract int getLayoutId();

	/**
	 * 参数设置
	 * 
	 * @return
	 */
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

	@Override
	public void onButtonClicked(Dialog dialog, int position, Object tag) {

	}

	@Override
	public void onCancelDialog(Dialog dialog, Object tag) {

	}

	@Override
	protected synchronized void onDestroy() {
		dismissDialog();
		ActivityStack.getInstance().removeActivity(this);
		super.onDestroy();
	}

}
