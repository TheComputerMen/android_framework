package com.jd.framework.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import android.app.Activity;

public class ActivityStack {

	private static ActivityStack mSingleInstance;
	private Stack<Activity> mActivitityStack;

	private ActivityStack() {
		mActivitityStack = new Stack<Activity>();
	}

	public static ActivityStack getInstance() {
		if (null == mSingleInstance) {
			mSingleInstance = new ActivityStack();
		}
		return mSingleInstance;
	}

	public Stack<Activity> getStack() {
		return mActivitityStack;
	}

	public void addActivity(Activity activity) {
		mActivitityStack.push(activity);
	}

	public void removeActivity(Activity activity) {
		mActivitityStack.remove(activity);
	}

	/**
	 * 彻底退出
	 */
	public void finishAllActivity() {
		Activity act;
		while (!mActivitityStack.empty()) {
			act = mActivitityStack.pop();
			if (act != null) {
				act.finish();
			}
		}
	}

	/**
	 * finish指定的Activity
	 * 
	 * @param actCls
	 * @return
	 */
	public boolean finishActivity(Class<? extends Activity> actCls) {
		Activity act = findActivityByClass(actCls);
		if (null != act && !act.isFinishing()) {
			act.finish();
			return true;
		}
		return false;
	}

	private Activity findActivityByClass(Class<? extends Activity> actCls) {
		Activity act = null;
		Iterator<Activity> itr = mActivitityStack.iterator();
		while (itr.hasNext()) {
			act = itr.next();
			if (null != act
					&& act.getClass().getName().equals(actCls.getName())) {
				break;
			}
			act = null;
		}
		return act;
	}

	/**
	 * finish指定的Activity之上的所有Activity
	 * 
	 * @param actCls
	 * @param isIncludeSelf
	 * @return
	 */
	public boolean finishToActivity(Class<? extends Activity> actCls,
			boolean isIncludeSelf) {
		List<Activity> buf = new ArrayList<Activity>();
		int size = mActivitityStack.size();
		Activity act = null;
		for (int i = size - 1; i >= 0; i--) {
			act = mActivitityStack.get(i);
			if (act.getClass().isAssignableFrom(actCls)) {
				for (Activity a : buf) {
					a.finish();
				}
				return true;
			} else if (i == size - 1 && isIncludeSelf) {
				buf.add(act);
			} else if (i != size - 1) {
				buf.add(act);
			}
		}
		return false;
	}
}
