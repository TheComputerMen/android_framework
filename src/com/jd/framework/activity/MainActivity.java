package com.jd.framework.activity;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import com.jd.framework.R;
import com.jd.framework.view.ToastMaker;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
	
	@ViewInject(R.id.tv)
	TextView tv;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void initParams() {
		tv.setText("Android FrameWork");
	}
	
	/**
	 * 1. 方法必须私有限定,
	 * 2. 方法以Click或Event结尾, 方便配置混淆编译参数 :
	 * -keepattributes *Annotation*
	 * -keepclassmembers class * {
	 * void *(android.view.View);
	 * *** *Click(...);
	 * *** *Event(...);
	 * }
	 * 3. 方法参数形式必须和type对应的Listener接口一致.
	 * 4. 注解参数value支持数组: value={id1, id2, id3}
	 * 5. 其它参数说明见{@link org.xutils.event.annotation.Event}类的说明.
	 **/
	@Event({R.id.btn1,R.id.btn2})
	private void btnClick(View v){
		switch (v.getId()) {
		case R.id.btn1:
			ToastMaker.showShortToast("这是一个Toast示例");
			break;
		case R.id.btn2:
			ToastMaker.showShortToast("您点击了Button2");
			break;
		default:
			break;
		}
	}

}
