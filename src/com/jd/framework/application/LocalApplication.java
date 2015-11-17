package com.jd.framework.application;

import java.io.File;

import org.xutils.DbManager;
import org.xutils.HttpManager;
import org.xutils.x;

import android.util.DisplayMetrics;

import com.jd.framework.exception.BaseExceptionHandler;
import com.jd.framework.exception.LocalFileHandler;
import com.jd.framework.utils.JFileKit;

public class LocalApplication extends BaseApplication {

	public static LocalApplication instance;

	private static DbManager.DaoConfig daoConfig = null;

	public DbManager dbUtils = null;

	public HttpManager httpUtils = null;

	// ��ǰ��Ļ���
	public int screenW = 0;
	public int screenH = 0;

	public static LocalApplication getInstance() {
		if (instance == null) {
			instance = new LocalApplication();
		}
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		// xUtils3��ʼ��
		x.Ext.init(this);
		x.Ext.setDebug(true);
		
		File appDbFolder = new File(JFileKit.getDiskCacheDir(this) + "/db");
		if (!appDbFolder.exists()) {
			appDbFolder.mkdirs();
		}
		
		daoConfig = new DbManager.DaoConfig()
		.setDbName("locDB").setDbDir(new File(JFileKit.getDiskCacheDir(this) + "/db")).setDbVersion(1)
		.setDbUpgradeListener(new DbManager.DbUpgradeListener() {
			@Override
			public void onUpgrade(DbManager db, int oldVersion,
					int newVersion) {
				// TODO: ...
				// db.addColumn(...);
				// db.dropTable(...);
				// ...
			}
		});

		// ��ʼ�����ݿ����ģ��
		dbUtils = x.getDb(daoConfig);

		// ��ʼ���������ģ��
		httpUtils = x.http();

		// ����APP������־Ŀ¼
		File appLogFolder = new File(JFileKit.getDiskCacheDir(this) + "/log");
		if (!appLogFolder.exists()) {
			appLogFolder.mkdirs();
		}

		instance = this;

		// �õ���ǰ��Ļ�Ŀ��
		DisplayMetrics dm = getResources().getDisplayMetrics();
		screenW = dm.widthPixels;
		screenH = dm.heightPixels;
	}

	@Override
	public BaseExceptionHandler getDefaultUncaughtExceptionHandler() {
		return new LocalFileHandler(applicationContext);
	}

}
