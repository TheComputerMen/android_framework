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
	 * 1. ��������˽���޶�,
	 * 2. ������Click��Event��β, �������û���������� :
	 * -keepattributes *Annotation*
	 * -keepclassmembers class * {
	 * void *(android.view.View);
	 * *** *Click(...);
	 * *** *Event(...);
	 * }
	 * 3. ����������ʽ�����type��Ӧ��Listener�ӿ�һ��.
	 * 4. ע�����value֧������: value={id1, id2, id3}
	 * 5. ��������˵����{@link org.xutils.event.annotation.Event}���˵��.
	 **/
	@Event({R.id.btn1,R.id.btn2})
	private void btnClick(View v){
		switch (v.getId()) {
		case R.id.btn1:
			ToastMaker.showShortToast("����һ��Toastʾ��");
			break;
		case R.id.btn2:
			ToastMaker.showShortToast("�������Button2");
			break;
		default:
			break;
		}
	}

}
