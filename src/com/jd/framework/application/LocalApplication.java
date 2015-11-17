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

	// 当前屏幕宽高
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

		// xUtils3初始化
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

		// 初始化数据库访问模块
		dbUtils = x.getDb(daoConfig);

		// 初始化网络访问模块
		httpUtils = x.http();

		// 创建APP崩溃日志目录
		File appLogFolder = new File(JFileKit.getDiskCacheDir(this) + "/log");
		if (!appLogFolder.exists()) {
			appLogFolder.mkdirs();
		}

		instance = this;

		// 得到当前屏幕的宽高
		DisplayMetrics dm = getResources().getDisplayMetrics();
		screenW = dm.widthPixels;
		screenH = dm.heightPixels;
	}

	@Override
	public BaseExceptionHandler getDefaultUncaughtExceptionHandler() {
		return new LocalFileHandler(applicationContext);
	}

}
