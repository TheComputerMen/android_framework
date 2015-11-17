package com.jd.framework.exception;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

import com.jd.framework.utils.JFileKit;

public class LocalFileHandler extends BaseExceptionHandler {

	private Context context;
	
	public LocalFileHandler(Context context) {
		this.context = context;
	}

	@Override
	public boolean handleException(Throwable ex) {
		if(ex == null){
			return false;
		}
		new Thread(){

			@Override
			public void run() {
				Looper.prepare();
				Toast.makeText(context, "很抱歉，程序出现异常，正在退出", Toast.LENGTH_LONG).show();
				Looper.loop();
			}
			
		}.start();
		
		saveLog(ex);
		return true;
	}

	public void saveLog(Throwable ex){
		try {
			File errFile = new File(JFileKit.getDiskCacheDir(context) + "/log/crash.log");
			if(!errFile.exists()){
				errFile.createNewFile();
			}
			
			OutputStream out = new FileOutputStream(errFile,true);
			out.write(("\n\n-------错误分割线 " + dateFormat.format(new Date()) + "-------\n\n").getBytes());
			PrintStream stream = new PrintStream(out);
			ex.printStackTrace(stream);
			stream.flush();
			out.flush();
			stream.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
