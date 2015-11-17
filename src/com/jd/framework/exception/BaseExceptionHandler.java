package com.jd.framework.exception;

import java.lang.Thread.UncaughtExceptionHandler;
import java.text.DateFormat;

public abstract class BaseExceptionHandler implements UncaughtExceptionHandler {

	public static final String TAG = "CrashHandler";

	protected static final DateFormat dateFormat = DateFormat
			.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);

	/**
	 * 未捕获异常跳转
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		if (handleException(ex)) {
			try {
				// 如果处理了，让程序继续运行3秒再退出，保证错误日志的保存
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 退出程序
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(1);
	}

	/**
	 * 自定义错误处理，收集错误信息发送错误报告等操作均在此完成，开发者可以根据自己的情况来自定义异常处理信息
	 * 
	 * @param ex
	 * @return
	 */
	public abstract boolean handleException(Throwable ex);
}
