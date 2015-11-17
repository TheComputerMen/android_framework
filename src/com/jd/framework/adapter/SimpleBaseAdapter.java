package com.jd.framework.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class SimpleBaseAdapter<T> extends BaseAdapter {

	protected Context c = null;

	protected LayoutInflater layoutInflater = null;

	protected List<T> datas = null;

	public SimpleBaseAdapter(Context c, List<T> datas) {
		this.c = c;
		this.datas = datas;
		layoutInflater = LayoutInflater.from(c);
	}

	public void refreshDatas(List<T> datas) {
		this.datas = datas;
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return datas != null ? datas.size() : 0;
	}

	@Override
	public T getItem(int position) {
		return datas != null ? datas.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	/**
	 * 这个方法getView()，是用来逐一绘制每一条item
	 * 
	 * setTaq()会把view与ViewHolder绑定，形成一一对应的关系，拖动listview的时候会重新绘制每一条item，
	 * 但是那些已经取得绑定的view，会调用getTag()方法
	 * 
	 * @param position
	 *            position 就是位置，从0开始
	 * @param convertView
	 *            convertView是Spinner，ListView中每一项要显示的view
	 * @param parent
	 *            parent就是父窗体，也就是Spinner，ListView，GridView
	 * @return 通常return的view就是convertView
	 */
	@Override
	public abstract View getView(int position, View convertView,
			ViewGroup parent);

}
