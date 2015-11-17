package com.jd.framework.exception;

import java.lang.Thread.UncaughtExceptionHandler;
import java.text.DateFormat;

public abstract class BaseExceptionHandler implements UncaughtExceptionHandler {

	public static final String TAG = "CrashHandler";

	protected static final DateFormat dateFormat = DateFormat
			.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);

	/**
	 * δ�����쳣��ת
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		if (handleException(ex)) {
			try {
				// ��������ˣ��ó����������3�����˳�����֤������־�ı���
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// �˳�����
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(1);
	}

	/**
	 * �Զ���������ռ�������Ϣ���ʹ��󱨸�Ȳ������ڴ���ɣ������߿��Ը����Լ���������Զ����쳣������Ϣ
	 * 
	 * @param ex
	 * @return
	 */
	public abstract boolean handleException(Throwable ex);
}
