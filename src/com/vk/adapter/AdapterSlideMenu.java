package com.vk.adapter;

import java.util.List;

import com.vk.aazhushou.R;
import com.vk.adapter.base.AdapterBase;
import com.vk.controls.SlideMenuItem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AdapterSlideMenu extends AdapterBase{
	private Context mContext;
	private List mList;
	private class Holder{
		TextView tvMenuName;
	}
	
	public AdapterSlideMenu(Context pContext, List pList) {
		super(pContext, pList);
		// TODO Auto-generated constructor stub
		mContext = pContext;
		mList = pList;
	}
	
	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder _Holder; 
		if (convertView == null) {
//			convertView = getLayoutInflater().inflate(R.id.layBottomListViewBox, null);
			convertView = getLayoutInflater().inflate(R.layout.slidemenu_list_item, null);
			_Holder = new Holder();
			_Holder.tvMenuName = (TextView) convertView.findViewById(R.id.ivMenuName);
			
			convertView.setTag(_Holder);
		}
		else {
			_Holder = (Holder) convertView.getTag();
		}
		 
		SlideMenuItem _Item = (SlideMenuItem) getList().get(position) ;
		
		_Holder.tvMenuName.setText(_Item.getTitle());
		
		return convertView;
	}

}
