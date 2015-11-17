package com.jd.framework.view;

import android.app.Dialog;

public class DialogMaker {
	public interface DialogCallBack {
		/**
		 * 对话框按钮点击回调
		 * 
		 * @param dialog
		 * @param position
		 *            点击button的索引
		 * @param tag
		 */
		public void onButtonClicked(Dialog dialog, int position, Object tag);

		/**
		 * 对话框消失时的回调
		 * 
		 * @param dialog
		 * @param tag
		 */
		public void onCancelDialog(Dialog dialog, Object tag);
	}

	public static final String BIRTHDAY_FORMAT = "%04d-%02d-%02d";

//	public static Dialog showCommonAlertDialog(final Context context, String title,
//			String msg, String[] btns, final DialogCallBack callback,
//			boolean isCanCancelable, final boolean isDismissAfterClickBtn, final Object tag) {
//		final Dialog dialog = new Dialog(context);
//		View contentView = LayoutInflater.from(context).inflate(, null);
//		TextView contentTv = (TextView) contentView.findViewById(id);
//		TextView titleTv = (TextView) contentView.findViewById(id);
//		OnClickListener lis = new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				if(null != callback){
//					callback.onButtonClicked(dialog, (Integer) v.getTag(), tag);
//				}
//				if(isDismissAfterClickBtn){
//					dialog.dismiss();
//				}
//			}
//		};
//		if(null != btns){
//			int len = btns.length;
//			if(len > 0){
//				LinearLayout btnLayout = (LinearLayout) contentView.findViewById(id);
//				Button btn;
//				View lineView;
//				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,DisplayUtil.dip2px(context, 40));
//				params.weight = 1.0f;
//				for(int i=0;i<len;i++){
//					btn = new Button(context);
//					btn.setText(btns[i]);
//					btn.setTag(i);
//					btn.setSingleLine(true);
//					btn.setEllipsize(TruncateAt.END);
//					btn.setOnClickListener(lis);
//					btn.setTextSize(TypedValue.COMPLEX_UNIT_PX, DisplayUtil.dip2px(context, 16));
//					btn.setTextColor(0xff007cff);
//					btn.setGravity(Gravity.CENTER);
//					if(0==i && isCanCancelable==len){
//						btn.setBackgroundResource(resid)
//					}else if (0==i) {
//						btn.setBackgroundResource(resid)
//					}else if (i>0 && len > 2) {
//						btn.setBackgroundResource(resid)
//					}else if (len - 1 == i) {
//						btn.setBackgroundResource(resid)
//					}
//					btn.setPadding(10, 10, 10, 10);
//					btnLayout.addView(btn,params);
//					lineView = new View(context);
//					lineView.setBackgroundColor(Color.parseColor("#b2b2b2"));
//					if(i < len-1 && len > 1){
//						btnLayout.addView(lineView,new LinearLayout.LayoutParams(1,LinearLayout.LayoutParams.MATCH_PARENT));
//					}
//				}
//			}
//		}
//		if( JStringKit.isNotBlack(title)){
//			
//		}
//	}
}
