package com.vk.adapter;

import com.vk.aazhushou.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterAppGrid extends BaseAdapter {

	// 用来装item中的iv和tv
	private class Holder {
		ImageView ivIcon;
		TextView tvName;
	}

	// 图片资源id封装
	private Integer[] m_ImageInteger = { R.drawable.grid1, R.drawable.grid2,
			R.drawable.grid3, R.drawable.grid4, R.drawable.grid5,
			R.drawable.grid6, };
	private String[] m_ImageString = new String[6];
	private Context mContext;

	public AdapterAppGrid(Context pContext) {
		mContext = pContext;
		m_ImageString[0] = pContext.getString(R.string.appGridTextRecordConsume);
		m_ImageString[1] = pContext.getString(R.string.appGridTextQueryConsume);
		m_ImageString[2] = pContext.getString(R.string.appGridTextAccountManage);
		m_ImageString[3] = pContext.getString(R.string.appGridTextStatisticsManage);
		m_ImageString[4] = pContext.getString(R.string.appGridTextGategoryManage);
		m_ImageString[5] = pContext.getString(R.string.appGridTextUserManage);
	}

	@Override
	public int getCount() {
		return m_ImageInteger.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO 变成一个真正的item,这里的item只有一个string，应该包含iv和tv的item
		return m_ImageString[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//TODO 外面来的convertView应该是包含iv和tv的,可以在后期再封装。我们这用到的主要是getTag
		Holder _Holder;
		//create ivIcon and tvName's Object,then add resource to Object
		if (convertView == null) {//if the view you want to get is null,then create
			// 得到item的view:convertView
			LayoutInflater _layoutInflater = LayoutInflater.from(mContext);
			convertView = _layoutInflater .inflate(R.layout.main_body_item, null);
			// add item's view to convertView
			_Holder = new Holder();
			_Holder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
			_Holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
			// setTag for others to use the ItemObject.Here is the Holder class's function:to setTag
			convertView.setTag(_Holder);

		}
		else {
			//if convertView not null,then getTag
			_Holder = (Holder) convertView.getTag();
		}
		_Holder.ivIcon.setImageResource(m_ImageInteger[position]); 
		_Holder.tvName.setText(m_ImageString[position]);
		return convertView;//里面的iv和tv可以用(Holder)getTag来获取
	}
}
